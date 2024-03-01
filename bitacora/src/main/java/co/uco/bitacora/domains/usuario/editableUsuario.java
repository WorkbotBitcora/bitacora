package co.uco.bitacora.domains.usuario;

public class editableUsuario {
    private long id;
    private String nombre;
    private long idTipoUsuario;

    public editableUsuario(long id, String nombre, long idTipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.idTipoUsuario = idTipoUsuario;
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

    public long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
}
