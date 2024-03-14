package co.uco.bitacora.pruebas.controller;

import co.uco.bitacora.pruebas.domain.usuarioData;
import co.uco.bitacora.pruebas.domain.usuariosb;
import co.uco.bitacora.pruebas.service.UsuariosBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pruebas")
public class usuariosbCrontroller {

    @Autowired
    private UsuariosBService servicio;

    @PostMapping("/cargarDB")
    public String  llenardata(){
        return servicio.CargarDAta();
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<usuariosb>> mostrarUsuario() {
        return ResponseEntity.ok(servicio.mostrarUsuarios());
    }


    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public String ingresarUsuario(@RequestBody usuarioData usde){

        return servicio.crearUsuario(usde);
    }

    @DeleteMapping("/usuario")
    public void calcelarSolicitud(){
        servicio.limpiarDatos();
    }

}
