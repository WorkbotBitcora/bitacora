package co.uco.bitacora.domains.usuario;

import co.uco.bitacora.repository.ITipoUsuarioRepository;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    private long id;


    private String nombre;
    @OneToOne
    private TipoUsuario tipoUsuario;



    public Usuario(long id, String nombre, TipoUsuario idTipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.tipoUsuario = idTipoUsuario;

    }

    public Usuario(String nombre, TipoUsuario tipoUsuario) {
        this.id = 1;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
