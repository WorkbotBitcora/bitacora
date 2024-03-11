package co.uco.bitacora.controllers;

import co.uco.bitacora.domains.equipo.editableEquipo;
import co.uco.bitacora.domains.usuario.userDescription;
import co.uco.bitacora.services.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procesador/bitacora/v2/bitacora")
public class BitacoraController {

    @Autowired
    private BitacoraService ServiciosDeBitacora = new BitacoraService();



    @PostMapping("/cargarDB")// paso pruebas
    public void llenardata(){
        ServiciosDeBitacora.actualizarDatosBasicos();
    }

    @DeleteMapping("/")//paso pruebas
    public void limpiarDB(){
        ServiciosDeBitacora.limpiarDB();
    }


    @GetMapping("/")//ok a medias
    public ResponseEntity<?> mostrarAgenda() {
        return ResponseEntity.ok(ServiciosDeBitacora.mostrarAgenda());
    }

    @PatchMapping( value = "/equipo/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void actualizarEquipo (@PathVariable long id , @RequestBody editableEquipo dato){
        ServiciosDeBitacora.editarEquipo(id,dato);
    }

    @PostMapping("/agenda")
    @ResponseStatus(HttpStatus.CREATED)
    public String ingresarRegistro(@RequestBody userDescription usde){
        return ServiciosDeBitacora.AgregarBitacoraAlaAgenda(usde);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> mostarPorUsuario(@PathVariable long id) {
        return ResponseEntity.ok(ServiciosDeBitacora.mostrarPorUsuario(id));
    }

    @DeleteMapping("/usuario/{id}")
    public void calcelarSolicitud(@PathVariable long id){
        ServiciosDeBitacora.cancelarSolicitid(id);
    }

}
