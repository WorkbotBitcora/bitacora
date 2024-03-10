package co.uco.bitacora.controllers;

import co.uco.bitacora.domains.equipo.editableEquipo;
import co.uco.bitacora.domains.usuario.userDescription;
import co.uco.bitacora.services.BitacoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procesador/bitacora/v2/login")
public class LoginController {
    private LoginService loginService=new LoginService();

    @GetMapping("/cargarDB")
    public void llenardata(){
        loginService.actualizarDatosBasicos();
    }

    public ResponseEntity<?> mostrarUsuario() {
        return ResponseEntity.ok(loginService.mostrarUsuario());
    }

    @PatchMapping( value = "/usuario/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void actualizarUsuario (@PathVariable long id , @RequestBody Usuario dato){
        loginService.editarUsuario(id,dato);
    }
    @PostMapping("/nuevoUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public void ingresarUsuario(@RequestBody Usuario usde){
        loginService.AgregarUsuario(usde);
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> mostarPorUsuario(@PathVariable long id) {
        return ResponseEntity.ok(loginService.mostrarPorUsuario(id));
    }

    @DeleteMapping("/usuario/{id}")
    public void calcelarSolicitud(@PathVariable long id){
        loginService.cancelarSolicitid(id);
    }
}