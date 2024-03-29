package co.uco.bitacora.services.jwt;

import co.uco.bitacora.domains.jwt.JwtResponse;
import co.uco.bitacora.domains.objetosAuxiliares.EditableUsuario;
import co.uco.bitacora.domains.objetosAuxiliares.Login;
import co.uco.bitacora.domains.usuario.Usuario;
import co.uco.bitacora.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private  JwtService jwtService;

    public JwtResponse login(Login login) {
        try {
            System.out.println("usuario: " + login.getNombreUsuario());
            System.out.println("contrasena: " + login.getPassword() );
            System.out.println( "ENTRA A LOGIN");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getNombreUsuario(),login.getPassword()));
            System.out.println("paso la autenticacion ");
            Usuario  userDetails = iUsuarioRepository.traerUsuarioPorNombreUsuario(login.getNombreUsuario());
            String token = jwtService.optenertoken(userDetails);
            return new JwtResponse(token);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }


    }

    public JwtResponse registrar(EditableUsuario editableUsuario) {
        //Aqui se Crea el usuario
        Usuario usuarioAux = new Usuario(editableUsuario.getNombre(), editableUsuario.getApellido(), editableUsuario.getUsuario(), editableUsuario.getContrasena(), editableUsuario.getIdTipoUsuario());
        iUsuarioRepository.save(usuarioAux);
        JwtResponse jwtResponse = new JwtResponse(jwtService.optenertoken(usuarioAux));
        return jwtResponse;
    }
}
