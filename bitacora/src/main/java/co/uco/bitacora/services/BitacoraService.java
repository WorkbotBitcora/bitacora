package co.uco.bitacora.services;

import co.uco.bitacora.domains.bitacora.*;
import co.uco.bitacora.domains.equipo.Equipo;
import co.uco.bitacora.domains.equipo.TipoEquipo;
import co.uco.bitacora.domains.equipo.editableEquipo;
import co.uco.bitacora.domains.usuario.TipoUsuario;
import co.uco.bitacora.domains.usuario.Usuario;
import co.uco.bitacora.domains.usuario.editableUsuario;
import co.uco.bitacora.domains.usuario.userDescription;
import co.uco.bitacora.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BitacoraService {

    @Autowired
    private IBitacoraRepository iBitacoraRepository;
    @Autowired
    private IDescripcionRepository iDescripcionRepository;
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Autowired
    private ITipoUsuarioRepository iTipoUsuarioRepository;
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


    private Bitacora bitacoraAUX;
    private Usuario usuarioAux;
    private Descripcion descripcionAux;
    private TipoUsuario tipoUsuarioAux;
    private Revision revisionAux;
    private Estado estadoAux;
    private Observacion observacionAux;
    private Equipo equipoAux;
    private TipoEquipo tipoEquipoAux;
    private Recomendacion recomendacionAux;




    //posiblemente no lo use pero es la base de todo
    public void AgregarBitacoraAlaAgenda(userDescription usde){

        //Aqui se Crea El Tipo de Usuario
        tipoUsuarioAux = new TipoUsuario(usde.getIdTipouser());

        //Aqui se Crea el usuario
        usuarioAux = new Usuario(usde.getIdUser(),usde.getNombre(),tipoUsuarioAux);
        iUsuarioRepository.save(usuarioAux);

        //aqui se crea la descripcion
        descripcionAux = new Descripcion(usde.getIdDesc(),usde.getDesc());
        iDescripcionRepository.save(descripcionAux);


        //aqui se crea una observacion debe llevar la lista de recomendaciones
        observacionAux =new Observacion();
        iObservacionRepository.save(observacionAux);

        //aqui se crea un equipo
        equipoAux=new Equipo();
        iEquipoRepository.save(equipoAux);

        //aqui se crea la revisiones
        revisionAux = new Revision(observacionAux,equipoAux);
        iRevisionRepository.save(revisionAux);


        //Aqui se Crea el Estado
        estadoAux = new Estado();

        //Aqui SE crea una bitacora Con el tipo usuario usuario y el id de la descripcion tipo long;
        bitacoraAUX = new Bitacora(usuarioAux,descripcionAux,revisionAux ,estadoAux);
        iBitacoraRepository.save(bitacoraAUX);
    }

    private void actualizarDatosBasicos(){
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
}
