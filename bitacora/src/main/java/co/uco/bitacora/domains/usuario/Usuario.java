package co.uco.bitacora.domains.usuario;

public class Usuario {
    private long id;
    private String nombre;

    private TipoUsuario tipoUsuario;

    public Usuario(long id, String nombre, long idTipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.tipoUsuario = new TipoUsuario(idTipoUsuario);
    }

    public Usuario(String nombre, TipoUsuario tipoUsuario) {
        this.id = 1;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
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
