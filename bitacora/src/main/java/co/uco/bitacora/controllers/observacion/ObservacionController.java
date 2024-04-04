package co.uco.bitacora.controllers.observacion;

import co.uco.bitacora.domains.objetosAuxiliares.ObservacionData;
import co.uco.bitacora.services.observacion.ObservacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procesador/bitacora/v1/observacion")
public class ObservacionController {

    @Autowired
    private ObservacionesService observacionesService = new ObservacionesService();

    @PatchMapping("/observacion")
    @ResponseStatus(HttpStatus.CREATED)
    public String actualizarObservaciones(@RequestBody ObservacionData dato){
        return observacionesService.actualizarObservacion(dato);
    }




}
