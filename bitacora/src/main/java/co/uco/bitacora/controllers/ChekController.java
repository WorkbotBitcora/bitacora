package co.uco.bitacora.controllers;


import co.uco.bitacora.domains.objetosAuxiliares.DatoChek;
import co.uco.bitacora.domains.revision.Chek;
import co.uco.bitacora.services.ChekService;
import org.hibernate.annotations.DialectOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procesador/bitacora/v1/chek")
public class ChekController {
    @Autowired
    private ChekService chekService = new ChekService();

    @PostMapping("/chek")//ok paso pruebas
    public String llenaData(){
        return chekService.CargarChek();
    }

    @GetMapping("/cheks/{tipo}")//ok paso pruebas
    public List<Chek> obtenerChecksPorTipo(@PathVariable long tipo) {
        return chekService.obtenerChecksPorId(tipo);
    }

    @PostMapping("/chekfinal/{idRevision}")
    public String llenarChecksActualizados(@PathVariable long idRevision ,@RequestBody List<DatoChek> listaRespuesta){
        return chekService.crearChekRevisadosConIdEquipoYIdRevision(idRevision, listaRespuesta);
    }


}
