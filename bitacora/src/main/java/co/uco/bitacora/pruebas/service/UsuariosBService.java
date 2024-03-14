package co.uco.bitacora.pruebas.service;

import co.uco.bitacora.pruebas.domain.*;
import co.uco.bitacora.pruebas.repository.IBancoPRepository;
import co.uco.bitacora.pruebas.repository.IDarasorPRepository;
import co.uco.bitacora.pruebas.repository.ISucursalPRepository;
import co.uco.bitacora.pruebas.repository.IUsuariosPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuariosBService {

    @Autowired
    private IUsuariosPRepository iUsuariosPRepository;
    @Autowired
    private IBancoPRepository iBancoPRepository;
    @Autowired
    private ISucursalPRepository iSucursalPRepository;
    @Autowired
    private SucursalesService sucursalesService;
    @Autowired
    private IDarasorPRepository iDarasorPRepository;

    private banco banco = new banco();

    public List<usuariosb> mostrarUsuarios(){
        return iUsuariosPRepository.findAll();
    }

    public String crearUsuario(usuarioData data){

        usuariosb usuarioData = new usuariosb();

        sucursal sucursal = new sucursal();

        List<banco> listaBanco = new ArrayList<>();
        Datasor datasor = new Datasor(sucursal);
        try {
            iSucursalPRepository.save(sucursal);
            iDarasorPRepository.save(datasor);
            usuarioData.setNombre(data.getNombre());
            usuarioData.setApellido(data.getApellido());
            usuarioData.setData(datasor);
            usuarioData.setSuc(sucursal);

            listaBanco = listarBancosPorID(data.getIdBanco());
            usuarioData.setBancos(listaBanco);
            iUsuariosPRepository.save(usuarioData);

            return  "se guardo con exito el usuario";
        }catch (Exception e ){
            System.out.println("entra a crear el usuario");
            System.out.println(e.getMessage());
            return "no se guardo el usuario";
        }
    }

    public List<banco> listarBancosPorID(long id){
        List<banco> listaBanco = new ArrayList<>();
        try {
            for (int i = 0 ; i < iBancoPRepository.findAll().size() ; i++){
                if (i <= id ){
                    listaBanco.add(iBancoPRepository.findAll().get(i));
                }
            }
            return listaBanco;
        }catch (Exception e){
            System.out.println("entra a filtrar banco");
            System.out.println(e.getMessage());
            return listaBanco;
        }

    }

    public   String CargarDAta(){
        try {
            sucursalesService.cargarDB();
            banco banco1 = new banco("banco1","dic1",sucursalesService.SucursalesPorBanco(1));
            iBancoPRepository.save(banco1);
            banco1 = new banco("banco2","dic2", sucursalesService.SucursalesPorBanco(2));
            iBancoPRepository.save(banco1);
            banco1 = new banco("banco3","dic3",sucursalesService.SucursalesPorBanco(3));
            iBancoPRepository.save(banco1);
            banco1 = new banco("banco4","dic4",sucursalesService.SucursalesPorBanco(4));
            iBancoPRepository.save(banco1);
            banco1 = new banco("banco5","dic5",sucursalesService.SucursalesPorBanco(5));
            iBancoPRepository.save(banco1);

            return "Registro Exitoso";
        }catch (Exception e){
            return "No se pudo registrar Los Datos";
        }
    }


    public void limpiarDatos(){
        iSucursalPRepository.deleteAll();
        iBancoPRepository.deleteAll();
    }

}
