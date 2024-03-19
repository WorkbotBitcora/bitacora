package co.uco.bitacora.controllers;


import co.uco.bitacora.domains.objetosAuxiliares.DatoChek;
import co.uco.bitacora.domains.revision.Chek;
import co.uco.bitacora.services.ChekService;
import co.uco.bitacora.services.RecomendacionesService;
import org.hibernate.annotations.DialectOverride;
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
