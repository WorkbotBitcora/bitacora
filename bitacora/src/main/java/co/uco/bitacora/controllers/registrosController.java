package co.uco.bitacora.controllers;

import co.uco.bitacora.domains.equipo.editableEquipo;
import co.uco.bitacora.domains.usuario.userDescription;
import co.uco.bitacora.services.registrosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/procesador/bitacora/v1/registros")
public class registrosController {


    private registrosService servicio = new registrosService();

    @GetMapping("/llenar")
    public ResponseEntity<?>llenardatos() {
        return ResponseEntity.ok(servicio.llenarDatos());
    }
    @GetMapping("/")
    public ResponseEntity<?> mostrarAgenda() {
        return ResponseEntity.ok(servicio.mostrarAgenda());
    }

    @GetMapping("/completado")
    public ResponseEntity<?> mostarCompleados() {
        return ResponseEntity.ok(servicio.mostrarCompletados());
    }

    @PatchMapping( value = "/equipo/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void actualizarEquipo (@PathVariable long id , @RequestBody editableEquipo dato){
        servicio.editarEquipo(id,dato);
    }

   /*
    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public void ingreasarRegistro(@RequestBody userDescription usde){
        servicio.crearResgistro(usde);
    }
    */


    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> mostarPorUsuario(@PathVariable long id) {
        return ResponseEntity.ok(servicio.mostrarPorUsuario(id));
    }

    @DeleteMapping("/usuario/{id}")
    public void calcelarSolicitud(@PathVariable long id){
        servicio.cancelarRegistro(id);
    }
}
