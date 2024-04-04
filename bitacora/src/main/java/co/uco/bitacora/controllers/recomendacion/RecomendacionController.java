package co.uco.bitacora.controllers.recomendacion;


import co.uco.bitacora.services.recomendacion.RecomendacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procesador/bitacora/v1/rec")
public class RecomendacionController {

    @Autowired
    private RecomendacionesService recomendacionesService = new RecomendacionesService();


    @GetMapping("/rec/{tipo}")//ok paso pruebas
    public List<String> recomendacionesPorIdRevision(@PathVariable long tipo) {
        return recomendacionesService.traerRecomendacionesPorIdRevision(tipo);
    }


}
