package co.uco.bitacora.controller.recomendacion;


import co.uco.bitacora.service.recomendacion.RecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procesador/bitacora/v1/recomendacion")
public class RecomendacionController {

    @Autowired
    private RecomendacionService recomendacionService = new RecomendacionService();


    @GetMapping("/rec/{tipo}")//ok paso pruebas
    public List<String> recomendacionesPorIdRevision(@PathVariable long tipo) {
        return recomendacionService.traerRecomendacionesPorIdRevision(tipo);
    }


}
