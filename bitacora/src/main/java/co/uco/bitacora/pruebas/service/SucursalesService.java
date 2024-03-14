package co.uco.bitacora.pruebas.service;

import co.uco.bitacora.pruebas.domain.sucursal;
import co.uco.bitacora.pruebas.repository.ISucursalPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SucursalesService {

    @Autowired
    private ISucursalPRepository iSucursalPRepository;

    public void cargarDB(){
        sucursal suc1 = new sucursal("suc1","dic1");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc2","dic2");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc3","dic3");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc4","dic4");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc5","dic5");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc6","dic6");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc7","dic7");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc8","dic7");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc9","dic3");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc10","dic4");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc11","dic5");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc12","dic6");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc13","dic7");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc14","dic7");
        iSucursalPRepository.save(suc1);
        suc1= new sucursal("suc15","dic3");
        iSucursalPRepository.save(suc1);

    }

    public List<sucursal> SucursalesPorBanco(int id){
        List<sucursal> respuesta = new ArrayList<>();
        List<sucursal> listaDb = iSucursalPRepository.findAll();
        switch (id){
            case 1:
                respuesta.add(listaDb.get(0));
                respuesta.add(listaDb.get(1));
                respuesta.add(listaDb.get(2));
                break;
            case 2:
                respuesta.add(listaDb.get(3));
                respuesta.add(listaDb.get(4));
                respuesta.add(listaDb.get(5));
                break;
            case 3:
                respuesta.add(listaDb.get(6));
                respuesta.add(listaDb.get(7));
                respuesta.add(listaDb.get(8));
                break;
            case 4:
                respuesta.add(listaDb.get(9));
                respuesta.add(listaDb.get(10));
                respuesta.add(listaDb.get(11));
                break;
            case 5:
                respuesta.add(listaDb.get(12));
                respuesta.add(listaDb.get(13));
                respuesta.add(listaDb.get(14));
                break;
        }
        return respuesta;
    }



}
