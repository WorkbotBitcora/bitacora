package co.uco.bitacora.controllers.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Authentication")
@RequiredArgsConstructor
public class JwtAuthenticationController {

    @PostMapping(value ="/log")
    public boolean login (){
        return true;
    }

    @PostMapping(value = "/reg")
    public String registrar (){
        return null;
    }
}
