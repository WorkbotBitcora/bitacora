package co.uco.bitacora.controllers;
import co.uco.bitacora.domains.objetosAuxiliares.Login;
import co.uco.bitacora.domains.usuario.Usuario;
import co.uco.bitacora.domains.objetosAuxiliares.EditableUsuario;
import co.uco.bitacora.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procesador/bitacora/v2/login")
public class LoginController {

    @Autowired
    private LoginService loginService=new LoginService();

    @PostMapping ("/cargarDB")
    public String  llenardata(){
        loginService.actualizarDatosBasicos();
        return  null;
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> mostrarUsuario() {
        return ResponseEntity.ok(loginService.mostrarUsuario());
    }

    @PatchMapping( value = "/usuario")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void actualizarUsuario (@RequestBody EditableUsuario dato){
        loginService.editarUsuario(dato);
    }


    @PostMapping("/login")
    public boolean login (Login login){
        return loginService.login(login);
    }

    @PostMapping("/prueba")
    public String plogin (){
        return "Ingreso exitoso";
    }


    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public String ingresarUsuario(@RequestBody EditableUsuario usde){
        return loginService.agregarUsuario(usde);
    }


    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Usuario>> mostarPorUsuario(@PathVariable long id) {
        return ResponseEntity.ok(loginService.mostrarPorUsuario(id));
    }

    @DeleteMapping("/usuario/{id}")
    public void calcelarSolicitud(@PathVariable long id){
        loginService.cancelarSolicitid(id);
    }
}