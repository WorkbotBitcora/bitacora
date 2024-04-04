package co.uco.bitacora.controllers.usuario;
import co.uco.bitacora.domains.usuario.Usuario;
import co.uco.bitacora.domains.objetosAuxiliares.EditableUsuario;
import co.uco.bitacora.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procesador/bitacora/v2/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService =new UsuarioService();

    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> mostrarUsuario() {
        return ResponseEntity.ok(usuarioService.mostrarUsuario());
    }

    @PatchMapping( value = "/usuario")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void actualizarUsuario (@RequestBody EditableUsuario dato){
        usuarioService.editarUsuario(dato);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Usuario>> mostarPorUsuario(@PathVariable long id) {
        return ResponseEntity.ok(usuarioService.mostrarPorUsuario(id));
    }

}