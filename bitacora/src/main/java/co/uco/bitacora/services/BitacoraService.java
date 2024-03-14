package co.uco.bitacora.services;

import co.uco.bitacora.domains.bitacora.*;
import co.uco.bitacora.domains.equipo.Equipo;
import co.uco.bitacora.domains.equipo.TipoEquipo;
import co.uco.bitacora.domains.equipo.editableEquipo;
import co.uco.bitacora.domains.recomendacion.Recomendacion;
import co.uco.bitacora.domains.revision.Chek;
import co.uco.bitacora.domains.revision.Revision;
import co.uco.bitacora.domains.usuario.TipoUsuario;
import co.uco.bitacora.domains.usuario.Usuario;
import co.uco.bitacora.domains.usuario.userDescription;
import co.uco.bitacora.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BitacoraService {


    @Autowired
    private ITipoUsuarioRepository iTipoUsuarioRepository;
    @Autowired
    private IBitacoraRepository iBitacoraRepository;
    @Autowired
    private IDescripcionRepository iDescripcionRepository;
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Autowired
    private IRevisionRepository iRevisionRepository;
    @Autowired
    private IEquipoRepository iEquipoRepository;
    @Autowired
    private IObservacionRepository iObservacionRepository ;
    @Autowired
    private ITipoEquipoRepository iTipoEquipoRepository;
    @Autowired
    private IRecomendacionRepository iRecomendacionRepository;
    @Autowired
    private IEstadoRepository iEstadoRepository;
    @Autowired
    private ChekService chekService;
    @Autowired
    private RevisionService revisionService = new RevisionService() ;

    private Bitacora bitacoraAUX = new Bitacora();
    private Usuario usuarioAux = new Usuario();
    private Descripcion descripcionAux =new Descripcion();
    private TipoUsuario tipoUsuarioAux = new TipoUsuario();
    private Revision revisionAux = new Revision();
    private Estado estadoAux = new Estado();
    private Observacion observacionAux = new Observacion();
    private Equipo equipoAux = new Equipo();
    private TipoEquipo tipoEquipoAux = new TipoEquipo();
    private Recomendacion recomendacionAux = new Recomendacion();




    //posiblemente no lo use pero es la base de todo

    public String AgregarBitacoraAlaAgenda(userDescription usde){
        if (iUsuarioRepository.findById(usde.getIdUser()).isEmpty()){
            return "No existe el usuario";
        }else {

            try {
                //Aqui se Crea el usuario
                iUsuarioRepository.findById(usde.getIdUser()).ifPresent(dato -> {
                    usuarioAux = dato;
                });

                //aqui se crea la descripcion
                descripcionAux = new Descripcion(usde.getDesc());
                iDescripcionRepository.save(descripcionAux);
                System.out.println("Se creo la descripcion ");

                //aqui se crea una observacion
                observacionAux =new Observacion();
                System.out.println("id Observacion : " + observacionAux.getId());
                System.out.println("descripcion Observacion : " + observacionAux.getDescripcion());
                System.out.println("mejora Observacion : " + observacionAux.getMejora());
                iObservacionRepository.save(observacionAux);
                System.out.println("Se creo la observacion ");

                //aqui se crea un equipo
                equipoAux=new Equipo();
                System.out.println("id Equipo: " + equipoAux.getId());
                System.out.println("marca Equipo: " + equipoAux.getMarca());
                System.out.println("tipo Equipo: " + equipoAux.getTipoEquipo().getNombre());
                iEquipoRepository.save(equipoAux);
                System.out.println("se creo el equipo");




                //aqui se crea la revisiones
                revisionAux = new Revision(observacionAux,equipoAux,chekService.obtenerChecksPorId(equipoAux.getTipoEquipo().getId()));

                System.out.println("id : " + revisionAux.getId());
                System.out.println("lista contiene algo : " + revisionAux.getCheks().isEmpty());
                System.out.println("equipo marca desde revision : " + revisionAux.getEquipo().getMarca());
                System.out.println("id observacion  : " + revisionAux.getObservacion().getId());
                System.out.println("chek :" + revisionAux.getCheks().get(0).getNombre());
                System.out.println("chek :" + revisionAux.getCheks().get(0).isEstado());
                //System.out.println("chek rec :" + revisionAux.getCheks().get(0).getRecomendacionList().get(0).getRecomendacion() );

                //Aqui se Crea el Estado
                estadoAux = new Estado();
                System.out.println(estadoAux.getNombre());
                System.out.println("se creo el estado ");

                revisionService.guardarRevision(revisionAux);
                System.out.println("se creo la revision");




                //Aqui SE crea una bitacora Con el tipo usuario usuario y el id de la descripcion tipo long;
                bitacoraAUX = new Bitacora(usuarioAux,descripcionAux,revisionAux ,estadoAux);
                System.out.println(" id Bitacora :" + bitacoraAUX.getId());
               // SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                //String fechaFormateada = formatoFecha.format(bitacoraAUX.getFechaEntrada());
                //System.out.println("fecha entrada: " +  fechaFormateada);
                System.out.println("descripcion del usuario : " + bitacoraAUX.getDescription().getDescripcion());
                System.out.println("ID Revision : " + bitacoraAUX.getRevision().getId());
                System.out.println("estado : " + bitacoraAUX.getEstado().getNombre());

                iBitacoraRepository.save(bitacoraAUX);

                return  "La agenda Se A Guardado Con Exito ";

            }catch (Exception e ){
                return e.getMessage();
            }
        }
    }

    public void actualizarDatosBasicos(){
        /* aqui se crea los datos estaticos de
        * tipo usuario ( 1 ó 2 y 3) ok
        * tipo equipo (1 ó 2 ó 3) ok
        * recomendaciones (arranca en 1 con el default) ok
        * estado (1 ó 2 ó 3 arranca en default con 1)
        * */


        //llenamos los tipo usuario
        tipoUsuarioAux = new TipoUsuario(1);
        iTipoUsuarioRepository.save(tipoUsuarioAux);

        tipoUsuarioAux = new TipoUsuario(2);
        iTipoUsuarioRepository.save(tipoUsuarioAux);

        tipoUsuarioAux = new TipoUsuario(3);
        iTipoUsuarioRepository.save(tipoUsuarioAux);

        // llenamos los tipo equipo
        tipoEquipoAux = new TipoEquipo(1);
        iTipoEquipoRepository.save(tipoEquipoAux);

        tipoEquipoAux = new TipoEquipo(2);
        iTipoEquipoRepository.save(tipoEquipoAux);

        tipoEquipoAux = new TipoEquipo(3);
        iTipoEquipoRepository.save(tipoEquipoAux);

        tipoEquipoAux = new TipoEquipo(4);
        iTipoEquipoRepository.save(tipoEquipoAux);

        //aqui creamos la recomendacion por defecto
        recomendacionAux = new Recomendacion();
        iRecomendacionRepository.save(recomendacionAux);

        //aqui creamos los estados posibles
        estadoAux=new Estado(1);
        iEstadoRepository.save(estadoAux);

        estadoAux=new Estado(2);
        iEstadoRepository.save(estadoAux);

        estadoAux=new Estado(3);
        iEstadoRepository.save(estadoAux);

        estadoAux=new Estado(4);
        iEstadoRepository.save(estadoAux);

    }

    public List<Bitacora> mostrarAgenda(){
        return iBitacoraRepository.findAll();
    }


    public void editarEquipo(long id , editableEquipo dato){
        Equipo equ = new Equipo();
        equ.setId(id);
        equ.setMarca(dato.getMarca());
        equ.setTipoEquipo(dato.getTipoEquipo());
        iEquipoRepository.save(equ);
    }


    public List<Bitacora> mostrarPorUsuario(long id){
        List<Bitacora> bitacorasPorUsuario = new ArrayList<>();
        for (int i = 0 ; i<iBitacoraRepository.findAll().size(); i++ ){
            iBitacoraRepository.findById((long)i).ifPresent(dato -> {
                if (dato.getUsuario().getId() == id){
                    bitacorasPorUsuario.add(dato);
                }
            });
        }
        return bitacorasPorUsuario;
    }


    public Bitacora traerBitacoraPorID(long id){
        iBitacoraRepository.findById(id).ifPresent(dato -> {
            bitacoraAUX= dato;
        });
        return bitacoraAUX;
    }

    public void cancelarSolicitid(long id){
        iBitacoraRepository.deleteById(id);
    }

    public void limpiarDB(){
        iTipoUsuarioRepository.deleteAll();
        iTipoEquipoRepository.deleteAll();
        iRecomendacionRepository.deleteAll();
        iEstadoRepository.deleteAll();
    }


}
