package co.uco.bitacora.services;

import co.uco.bitacora.domains.objetosAuxiliares.DatoChek;
import co.uco.bitacora.domains.revision.Chek;
import co.uco.bitacora.repository.IChekRepository;
import co.uco.bitacora.repository.IRevisionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ChekService {
    @Autowired
    private  IChekRepository iChekRepository;
    @Autowired
    private RecomendacionesService servicioRecomendaciones = new RecomendacionesService();
    @Autowired
    private IRevisionRepository iRevisionRepository;


    // Método para obtener los checks de un portátil
    @Transactional
    public String CargarChek(){
       try {
           servicioRecomendaciones.CargarRecomendaciones();
           //estos son los de portatil
           iChekRepository.save(new Chek(1, "Batería",3,  true, servicioRecomendaciones.listarRecomendacionesPorID(1)));
           iChekRepository.save(new Chek(2, "Pantalla",3, true, servicioRecomendaciones.listarRecomendacionesPorID(2)));
           iChekRepository.save(new Chek(3, "Sistema Operativo", 3,true, servicioRecomendaciones.listarRecomendacionesPorID(3)));
           iChekRepository.save(new Chek(4, "Controladores",3, true, servicioRecomendaciones.listarRecomendacionesPorID(4)));
           iChekRepository.save(new Chek(5, "Programas",3, true, servicioRecomendaciones.listarRecomendacionesPorID(5)));
           iChekRepository.save(new Chek(6, "Seguridad",3, true, servicioRecomendaciones.listarRecomendacionesPorID(6)));
           iChekRepository.save(new Chek(7, "Pruebas de rendimiento",3, true, servicioRecomendaciones.listarRecomendacionesPorID(7)));
           iChekRepository.save(new Chek(8, "Temperatura",3, true, servicioRecomendaciones.listarRecomendacionesPorID(8)));
           iChekRepository.save(new Chek(9, "Cámaras y sensores",3, true, servicioRecomendaciones.listarRecomendacionesPorID(9)));
           iChekRepository.save(new Chek(10, "Teclado y touchpad",3, true, servicioRecomendaciones.listarRecomendacionesPorID(10)));
           iChekRepository.save(new Chek(11, "Conexiones",3, true, servicioRecomendaciones.listarRecomendacionesPorID(11)));



           //estos son los de mesa
           iChekRepository.save(new Chek(12, "Memoria RAM",4, true, servicioRecomendaciones.listarRecomendacionesPorID(12)));
           iChekRepository.save(new Chek(13, "Disco Duro/SSD",4, true, servicioRecomendaciones.listarRecomendacionesPorID(13)));
           iChekRepository.save(new Chek(14, "Tarjeta gráfica (GPU)",4, true, servicioRecomendaciones.listarRecomendacionesPorID(14)));
           iChekRepository.save(new Chek(15, "Ventilación y refrigeración",4, true, servicioRecomendaciones.listarRecomendacionesPorID(15)));
           iChekRepository.save(new Chek(16, "Monitor",4, true, servicioRecomendaciones.listarRecomendacionesPorID(16)));
           iChekRepository.save(new Chek(17, "Sistema Operativo",4, true, servicioRecomendaciones.listarRecomendacionesPorID(17)));
           iChekRepository.save(new Chek(18, "Controladores de dispositivos",4, true, servicioRecomendaciones.listarRecomendacionesPorID(18)));
           iChekRepository.save(new Chek(19, "Puertos USB",4, true, servicioRecomendaciones.listarRecomendacionesPorID(19)));
           iChekRepository.save(new Chek(20, "Pruebas de rendimiento (benchmarking)",4, true, servicioRecomendaciones.listarRecomendacionesPorID(20)));
           iChekRepository.save(new Chek(21, "Temperatura del sistema",4, true, servicioRecomendaciones.listarRecomendacionesPorID(21)));
           iChekRepository.save(new Chek(22, "Actualizaciones de software y controladores",4, true, servicioRecomendaciones.listarRecomendacionesPorID(22)));
           // estos son los de celular
           iChekRepository.save(new Chek(23, "Estado exterior",2, true, servicioRecomendaciones.listarRecomendacionesPorID(23)));
           iChekRepository.save(new Chek(24, "Pantalla",2, true, servicioRecomendaciones.listarRecomendacionesPorID(24)));
           iChekRepository.save(new Chek(25, "Botones y puertos",2, true, servicioRecomendaciones.listarRecomendacionesPorID(25)));
           iChekRepository.save(new Chek(26, "Cámaras",2, true, servicioRecomendaciones.listarRecomendacionesPorID(26)));
           iChekRepository.save(new Chek(27, "Altavoces y micrófono",2, true, servicioRecomendaciones.listarRecomendacionesPorID(27)));
           iChekRepository.save(new Chek(28, "Sensores y funciones especiales",2, true, servicioRecomendaciones.listarRecomendacionesPorID(28)));
           iChekRepository.save(new Chek(29, "Condiciones de la batería",2, true, servicioRecomendaciones.listarRecomendacionesPorID(29)));
           iChekRepository.save(new Chek(30, "Software",2, true, servicioRecomendaciones.listarRecomendacionesPorID(30)));

           //este es el nulo
           iChekRepository.save(new Chek(31,"No hay Cheks",1,true,servicioRecomendaciones.listarRecomendacionesPorID(31)));
           return "Datos Agregados Con Exito ";
       }catch (Exception e){
           return e.getMessage();
       }
    }

    @Transactional
    public List<Chek> obtenerChecksPorId(long id) {
        return iChekRepository.mostrarChekPorIdEquipo(id);
    }

    @Transactional
    public String crearChekRevisadosConIdEquipoYIdRevision(long idRevision, List<DatoChek> listRespuesta){

        try {
            List<Chek> listaDeCheksAGuradarFinal = new ArrayList<>();
            List<Chek> listaDeCheksAGuradar = new ArrayList<>();
            Chek chekDeLista;
            if ( !listRespuesta.isEmpty() ){
                for (int i = 0; i < listRespuesta.size() ; i++) {

                    iChekRepository.findById(listRespuesta.get(i).getIdChek()).ifPresent(dato -> {
                        listaDeCheksAGuradar.add(dato);
                    });
                    chekDeLista = listaDeCheksAGuradar.get(i);

                    chekDeLista.setEstado(listRespuesta.get(i).getEstado());

                    iChekRepository.save(new Chek(chekDeLista.getNombre(),chekDeLista.getIdTipoEquipo(), chekDeLista.isEstado(), servicioRecomendaciones.listarRecomendacionesPorID(chekDeLista.getId())));

                    listaDeCheksAGuradarFinal.add(chekDeLista);
                }

                for (int i = 0; i < listRespuesta.size(); i++) {
                }

                iRevisionRepository.findById(idRevision).ifPresent(dato -> {
                    dato.setChekList(listaDeCheksAGuradar);

                    for (int i = 0; i < dato.getChekList().size(); i++) {
                    }
                    iRevisionRepository.save(dato);
                });



                return "se guardo con Exito los cheks";
            }else {
                return "la lista De Cheks esta nula o vacia";
            }

        }catch (Exception e){
            return "Ocurrio Un Error Inesperado: " + e.getMessage();
        }
    }
}
