package co.uco.bitacora.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity)throws Exception
    {
        return httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests(dato ->
            dato.requestMatchers("/procesador/bitacora/v2/login/prueba").permitAll().anyRequest().authenticated()
        ).formLogin(Customizer.withDefaults()).build();
    }


}
