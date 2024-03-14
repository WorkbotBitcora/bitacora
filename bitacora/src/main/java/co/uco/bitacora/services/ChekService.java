package co.uco.bitacora.services;

import co.uco.bitacora.domains.revision.Chek;
import co.uco.bitacora.repository.IChekRepository;
import co.uco.bitacora.repository.IDescripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChekService {
    @Autowired
    private  IChekRepository iChekRepository;

    @Autowired
    private static IChekRepository iChekRepository1;

    @Autowired
    private RecomendacionesService iDescripcionRepository;


    private Chek chek= new Chek();

    private static Chek chek1= new Chek();


    // aqui va el tema de los cheks

    // Método para obtener los checks de un portátil
    public String CargarChek(){
       try {
           iDescripcionRepository.CargarRecomendaciones();
           //estos son los de portatil
           iChekRepository.save(new Chek(1, "Batería", true,iDescripcionRepository.listarRecomendacionesPorID(1)));
           iChekRepository.save(new Chek(2, "Pantalla", true,iDescripcionRepository.listarRecomendacionesPorID(2)));
           iChekRepository.save(new Chek(3, "Sistema Operativo", true,iDescripcionRepository.listarRecomendacionesPorID(3)));
           iChekRepository.save(new Chek(4, "Controladores", true,iDescripcionRepository.listarRecomendacionesPorID(4)));
           iChekRepository.save(new Chek(5, "Programas", true,iDescripcionRepository.listarRecomendacionesPorID(5)));
           iChekRepository.save(new Chek(6, "Seguridad", true,iDescripcionRepository.listarRecomendacionesPorID(6)));
           iChekRepository.save(new Chek(7, "Pruebas de rendimiento", true,iDescripcionRepository.listarRecomendacionesPorID(7)));
           iChekRepository.save(new Chek(8, "Temperatura", true,iDescripcionRepository.listarRecomendacionesPorID(8)));
           iChekRepository.save(new Chek(9, "Cámaras y sensores", true,iDescripcionRepository.listarRecomendacionesPorID(9)));
           iChekRepository.save(new Chek(10, "Teclado y touchpad", true,iDescripcionRepository.listarRecomendacionesPorID(10)));
           iChekRepository.save(new Chek(11, "Conexiones", true,iDescripcionRepository.listarRecomendacionesPorID(11)));



           //estos son los de mesa
           iChekRepository.save(new Chek(12, "Memoria RAM", true,iDescripcionRepository.listarRecomendacionesPorID(12)));
           iChekRepository.save(new Chek(13, "Disco Duro/SSD", true,iDescripcionRepository.listarRecomendacionesPorID(13)));
           iChekRepository.save(new Chek(14, "Tarjeta gráfica (GPU)", true,iDescripcionRepository.listarRecomendacionesPorID(14)));
           iChekRepository.save(new Chek(15, "Ventilación y refrigeración", true,iDescripcionRepository.listarRecomendacionesPorID(15)));
           iChekRepository.save(new Chek(16, "Monitor", true,iDescripcionRepository.listarRecomendacionesPorID(16)));
           iChekRepository.save(new Chek(17, "Sistema Operativo", true,iDescripcionRepository.listarRecomendacionesPorID(17)));
           iChekRepository.save(new Chek(18, "Controladores de dispositivos", true,iDescripcionRepository.listarRecomendacionesPorID(18)));
           iChekRepository.save(new Chek(19, "Puertos USB", true,iDescripcionRepository.listarRecomendacionesPorID(19)));
           iChekRepository.save(new Chek(20, "Pruebas de rendimiento (benchmarking)", true,iDescripcionRepository.listarRecomendacionesPorID(20)));
           iChekRepository.save(new Chek(21, "Temperatura del sistema", true,iDescripcionRepository.listarRecomendacionesPorID(21)));
           iChekRepository.save(new Chek(22, "Actualizaciones de software y controladores", true,iDescripcionRepository.listarRecomendacionesPorID(22)));
           // estos son los de celular
           iChekRepository.save(new Chek(23, "Estado exterior", true,iDescripcionRepository.listarRecomendacionesPorID(23)));
           iChekRepository.save(new Chek(24, "Pantalla", true,iDescripcionRepository.listarRecomendacionesPorID(24)));
           iChekRepository.save(new Chek(25, "Botones y puertos", true,iDescripcionRepository.listarRecomendacionesPorID(25)));
           iChekRepository.save(new Chek(26, "Cámaras", true,iDescripcionRepository.listarRecomendacionesPorID(26)));
           iChekRepository.save(new Chek(27, "Altavoces y micrófono", true,iDescripcionRepository.listarRecomendacionesPorID(27)));
           iChekRepository.save(new Chek(28, "Sensores y funciones especiales", true,iDescripcionRepository.listarRecomendacionesPorID(28)));
           iChekRepository.save(new Chek(29, "Condiciones de la batería", true,iDescripcionRepository.listarRecomendacionesPorID(29)));
           iChekRepository.save(new Chek(30, "Software", true,iDescripcionRepository.listarRecomendacionesPorID(30)));

           return "Datos Agregados Con Exito ";
       }catch (Exception e){
           return e.getMessage();
       }
    }

    public List<Chek> obtenerChecksPorId(long id) {
        List<Chek> checks = new ArrayList<>();
        return switch ((int) id) {
            case 2 -> {
                for (int i = 23; i < 31; i++) {
                    iChekRepository.findById((long) i).ifPresent(dato -> {
                        chek.setId(dato.getId());
                        chek.setNombre(dato.getNombre());
                        chek.setEstado(dato.isEstado());
                        chek.setRecomendacionList(dato.getRecomendacionList());
                    });
                    checks.add(chek);
                }
                yield checks;
            }
            case 3 -> {
                for (int i = 1; i < 12; i++) {
                    iChekRepository.findById((long) i).ifPresent(dato -> {
                        chek.setId(dato.getId());
                        chek.setNombre(dato.getNombre());
                        chek.setEstado(dato.isEstado());
                        chek.setRecomendacionList(dato.getRecomendacionList());
                    });
                    checks.add(chek);
                }
                yield checks;
            }
            case 4 -> {
                for (int i = 12; i < 23; i++) {
                    iChekRepository.findById((long) i).ifPresent(dato -> {
                        chek.setId(dato.getId());
                        chek.setNombre(dato.getNombre());
                        chek.setEstado(dato.isEstado());
                        chek.setRecomendacionList(dato.getRecomendacionList());
                    });
                    checks.add(chek);
                }
                yield checks;
            }
            default -> {
                chek = new Chek();
                checks.add(chek);
                yield checks;
            }

        };
    }

    public static List<Chek> obtenerChecksPorStaticId(long id) {
        List<Chek> checks = new ArrayList<>();
        return switch ((int) id) {
            case 2 -> {
                for (int i = 23; i < 31; i++) {

                    iChekRepository1.findById((long) i).ifPresent(dato -> {
                        chek1.setId(dato.getId());
                        chek1.setNombre(dato.getNombre());
                        chek1.setEstado(dato.isEstado());
                        chek1.setRecomendacionList(dato.getRecomendacionList());
                    });
                    checks.add(chek1);
                }
                yield checks;
            }
            case 3 -> {
                for (int i = 1; i < 13; i++) {
                    iChekRepository1.findById((long) i).ifPresent(dato -> {
                        chek1.setId(dato.getId());
                        chek1.setNombre(dato.getNombre());
                        chek1.setEstado(dato.isEstado());
                        chek1.setRecomendacionList(dato.getRecomendacionList());
                    });
                    checks.add(chek1);
                }
                yield checks;
            }
            case 4 -> {
                for (int i = 13; i < 23; i++) {
                    iChekRepository1.findById((long) i).ifPresent(dato -> {
                        chek1.setId(dato.getId());
                        chek1.setNombre(dato.getNombre());
                        chek1.setEstado(dato.isEstado());
                        chek1.setRecomendacionList(dato.getRecomendacionList());
                    });
                    checks.add(chek1);
                }
                yield checks;
            }
            default -> checks;
        };
    }
}
