package co.uco.bitacora.services;

import co.uco.bitacora.domains.revision.Chek;
import co.uco.bitacora.repository.IChekRepository;
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
    private RecomendacionesService servicioRecomendaciones;


    private Chek chek= new Chek();

    private static Chek chek1= new Chek();


    // aqui va el tema de los cheks

    // Método para obtener los checks de un portátil
    public String CargarChek(){
       try {
           servicioRecomendaciones.CargarRecomendaciones();
           //estos son los de portatil
           iChekRepository.save(new Chek(1, "Batería", true, servicioRecomendaciones.listarRecomendacionesPorID(1)));
           iChekRepository.save(new Chek(2, "Pantalla", true, servicioRecomendaciones.listarRecomendacionesPorID(2)));
           iChekRepository.save(new Chek(3, "Sistema Operativo", true, servicioRecomendaciones.listarRecomendacionesPorID(3)));
           iChekRepository.save(new Chek(4, "Controladores", true, servicioRecomendaciones.listarRecomendacionesPorID(4)));
           iChekRepository.save(new Chek(5, "Programas", true, servicioRecomendaciones.listarRecomendacionesPorID(5)));
           iChekRepository.save(new Chek(6, "Seguridad", true, servicioRecomendaciones.listarRecomendacionesPorID(6)));
           iChekRepository.save(new Chek(7, "Pruebas de rendimiento", true, servicioRecomendaciones.listarRecomendacionesPorID(7)));
           iChekRepository.save(new Chek(8, "Temperatura", true, servicioRecomendaciones.listarRecomendacionesPorID(8)));
           iChekRepository.save(new Chek(9, "Cámaras y sensores", true, servicioRecomendaciones.listarRecomendacionesPorID(9)));
           iChekRepository.save(new Chek(10, "Teclado y touchpad", true, servicioRecomendaciones.listarRecomendacionesPorID(10)));
           iChekRepository.save(new Chek(11, "Conexiones", true, servicioRecomendaciones.listarRecomendacionesPorID(11)));



           //estos son los de mesa
           iChekRepository.save(new Chek(12, "Memoria RAM", true, servicioRecomendaciones.listarRecomendacionesPorID(12)));
           iChekRepository.save(new Chek(13, "Disco Duro/SSD", true, servicioRecomendaciones.listarRecomendacionesPorID(13)));
           iChekRepository.save(new Chek(14, "Tarjeta gráfica (GPU)", true, servicioRecomendaciones.listarRecomendacionesPorID(14)));
           iChekRepository.save(new Chek(15, "Ventilación y refrigeración", true, servicioRecomendaciones.listarRecomendacionesPorID(15)));
           iChekRepository.save(new Chek(16, "Monitor", true, servicioRecomendaciones.listarRecomendacionesPorID(16)));
           iChekRepository.save(new Chek(17, "Sistema Operativo", true, servicioRecomendaciones.listarRecomendacionesPorID(17)));
           iChekRepository.save(new Chek(18, "Controladores de dispositivos", true, servicioRecomendaciones.listarRecomendacionesPorID(18)));
           iChekRepository.save(new Chek(19, "Puertos USB", true, servicioRecomendaciones.listarRecomendacionesPorID(19)));
           iChekRepository.save(new Chek(20, "Pruebas de rendimiento (benchmarking)", true, servicioRecomendaciones.listarRecomendacionesPorID(20)));
           iChekRepository.save(new Chek(21, "Temperatura del sistema", true, servicioRecomendaciones.listarRecomendacionesPorID(21)));
           iChekRepository.save(new Chek(22, "Actualizaciones de software y controladores", true, servicioRecomendaciones.listarRecomendacionesPorID(22)));
           // estos son los de celular
           iChekRepository.save(new Chek(23, "Estado exterior", true, servicioRecomendaciones.listarRecomendacionesPorID(23)));
           iChekRepository.save(new Chek(24, "Pantalla", true, servicioRecomendaciones.listarRecomendacionesPorID(24)));
           iChekRepository.save(new Chek(25, "Botones y puertos", true, servicioRecomendaciones.listarRecomendacionesPorID(25)));
           iChekRepository.save(new Chek(26, "Cámaras", true, servicioRecomendaciones.listarRecomendacionesPorID(26)));
           iChekRepository.save(new Chek(27, "Altavoces y micrófono", true, servicioRecomendaciones.listarRecomendacionesPorID(27)));
           iChekRepository.save(new Chek(28, "Sensores y funciones especiales", true, servicioRecomendaciones.listarRecomendacionesPorID(28)));
           iChekRepository.save(new Chek(29, "Condiciones de la batería", true, servicioRecomendaciones.listarRecomendacionesPorID(29)));
           iChekRepository.save(new Chek(30, "Software", true, servicioRecomendaciones.listarRecomendacionesPorID(30)));

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
