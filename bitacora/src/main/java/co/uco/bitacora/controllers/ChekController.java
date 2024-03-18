package co.uco.bitacora.controllers;


import co.uco.bitacora.services.ChekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procesador/bitacora/v1/chek")
public class ChekController {
    @Autowired
    private ChekService chekService = new ChekService();

    @PostMapping("/chek")
    public String llenaData(){
        return chekService.CargarChek();
    }

    @GetMapping("/cheks/{tipo}")// no funciona
    public List<?> obtenerChecksPorTipo(@PathVariable long tipo) {
        return chekService.obtenerChecksPorId(tipo);
    }

}
