package co.uco.bitacora.repository;

import co.uco.bitacora.domains.bitacora.*;
import co.uco.bitacora.domains.equipo.editableEquipo;
import co.uco.bitacora.domains.revision.Revision;
import co.uco.bitacora.domains.usuario.editableUsuario;
import co.uco.bitacora.domains.usuario.TipoUsuario;
import co.uco.bitacora.domains.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class registroRepository {
    private Revision revision;
    private Estado estado;

    public  List<Bitacora> getRegistros() {
        return Bitacora;
    }

    public List<Bitacora> getRegistrosCompletados() {
        return bitacoraCompletados;
    }

    public List<Bitacora> getRegistrosPorUsuario(long id) {
        for (int i = 0; i< Bitacora.size(); i++ ){

            if (Bitacora.get(i).getUsuario().getId() == id ){
                bitacoraPorUsuario.add(Bitacora.get(i));
            }
        }
        return bitacoraPorUsuario;
    }

    public  void modificarEquipoPorId(long id , editableEquipo dato){
        System.out.println("id : " + id );
        System.out.println("marca : " + dato.getMarca());
        System.out.println("idTipoEquipo : "+dato.getTipoEquipo());

        for (int i = 0; i< Bitacora.size(); i++ ){
            if (Bitacora.get(i).getRevision().getEquipo().getId() == id ){
                Bitacora.get(i).getRevision().getEquipo().setMarca(dato.getMarca());
                Bitacora.get(i).getRevision().getEquipo().setTipoEquipo(dato.getTipoEquipo());
            }
        }
    }
    public void crearRegistro(editableUsuario user, Descripcion descripcion ){
        estado = new Estado(1);
        revision = new Revision();
        Bitacora.add(new Bitacora(new Usuario(user.getNombre(), new TipoUsuario(user.getIdTipoUsuario())),descripcion,revision ,estado));
    }

    public void eliminarRegistro(long id){
        for (int i = 0; i< Bitacora.size(); i++ ){
            if (Bitacora.get(i).getUsuario().getId() == id && Bitacora.get(i).getEstado().getId()!=3){
                Bitacora.remove(i);
            }
        }
    }

    // simula la base de datos

    private  List<Bitacora> bitacoraPorUsuario = new ArrayList<>();
    private  List<Bitacora> Bitacora = new ArrayList<>();
    private  List<Bitacora> bitacoraCompletados = new ArrayList<>();
    private Bitacora reg1;
    private Usuario usuario1;
    private TipoUsuario tipoUsuario1;
    private Descripcion descripcion1;


    private Bitacora reg2 ;
    private Usuario usuario2;
    private TipoUsuario tipoUsuario2;
    private Descripcion descripcion2;


    private Bitacora reg3;
    private Usuario usuario3;
    private TipoUsuario tipoUsuario3;
    private Descripcion descripcion3;


    private Bitacora reg4;
    private Usuario usuario4;
    private TipoUsuario tipoUsuario4;
    private Descripcion descripcion4;


    public void llenarDatos(){

        /*tipoUsuario1 = new TipoUsuario();
        usuario1 = new Usuario("Alucard",tipoUsuario1);
        descripcion1 = new Descripcion("esta es la descripcion que pone el usuario 1");
        reg1 =new Bitacora(usuario1,descripcion1);

        tipoUsuario2 = new TipoUsuario();
        usuario2 = new Usuario("Javier",tipoUsuario2);
        descripcion2 = new Descripcion("esta es la descripcion que pone el usuario 2");
        reg2 =new Bitacora(usuario2,descripcion2);

        tipoUsuario3 = new TipoUsuario();
        usuario3 = new Usuario("Oscar",tipoUsuario3);
        descripcion3 = new Descripcion("esta es la descripcion que pone el usuario 3");
        reg3 =new Bitacora(usuario3,descripcion3);

        tipoUsuario4 = new TipoUsuario();
        usuario4 = new Usuario("Lucia",tipoUsuario4);
        descripcion4 = new Descripcion("esta es la descripcion que pone el usuario 4");
        reg4 =new Bitacora(usuario4,descripcion4);


        Bitacora.add(reg1);
        Bitacora.add(reg2);
        Bitacora.add(reg3);
        Bitacora.add(reg4);

        reg1.setEstado(new Estado(3));
        bitacoraCompletados.add(reg1);
        reg4.setEstado(new Estado(3));
        bitacoraCompletados.add(reg4);*/

    }

    private void imprimirReviciones(Revision rev ){
        System.out.println("id Revicion: " + rev.getId());
        System.out.println(" Observaciones: ");
        imprimirObservaciones(rev.getObservacion());
        System.out.println(" Fecha: " + rev.getFechaFinal());
        System.out.println(" equipo: id: " + rev.getEquipo().getId() + ", Marca: " + rev.getEquipo().getMarca() + ", Tipo de Equipo: " + rev.getEquipo().getTipoEquipo().getNombre());
    }
    private void  imprimirObservaciones (Observacion obs){
        System.out.println("id Observacion: " + obs.getId());
        System.out.println("descripcion : " + obs.getDescripcion());
        System.out.println("mejoras hechas: " + obs.getMejora());
    }
    private void imprimirDatoPorConsola(Bitacora reg){
        System.out.println("id: " + reg.getId());
        System.out.println("fecha: " + reg.getFechaEntrada());
        System.out.println("descripcion: " + reg.getDescription().getDescripcion());
        System.out.println("Nombre de Usuario: " + reg.getUsuario().getNombre());
        System.out.println("reviciones: ");
        imprimirReviciones(reg.getRevision());
        System.out.println("Estado: " + reg.getEstado().getNombre());
    }

    private void imprimirDatoPorConsolalista (List lreg){
        for (int i=0; i < lreg.size() ; i++){
            imprimirDatoPorConsola((Bitacora) lreg.get(i));
        }
    }
}
