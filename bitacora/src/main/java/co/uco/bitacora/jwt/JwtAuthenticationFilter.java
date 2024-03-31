package co.uco.bitacora.jwt;

import co.uco.bitacora.config.SecurityConfig;
import co.uco.bitacora.services.jwt.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String token = getToken(request);
        final String nombreUsuario;

        if (token == null){
            filterChain.doFilter(request,response);
            System.out.println("ENTRO CON EL TOKEN NULO ");
            return;
        }

        nombreUsuario = jwtService.optenerNombreUsuarioPorToken(token);
        System.out.println("ENTRO CON EL TOKEN INYECTADO ");
        if(nombreUsuario != null && SecurityContextHolder.getContext().getAuthentication() == null){
            System.out.println("AQUI CAPTURA EL USUARIO DEL TOKEN ");
            UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);

            if (jwtService.isTokenValid(token,userDetails)) {
                System.out.println("CONFIRMA QUE EL TOKEN ES VALIDO ");
                UsernamePasswordAuthenticationToken tokenIngreso = new UsernamePasswordAuthenticationToken(
                  userDetails, null,userDetails.getAuthorities());

                tokenIngreso.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(tokenIngreso);
                System.out.println("CONFIRMA EL PROCESO ");
            }
        }
        filterChain.doFilter(request,response);
    }

    private String getToken(HttpServletRequest request) {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(header) && header.startsWith("Bearer "))
        {
            return header.substring(7);
        }
        return null;
    }
}