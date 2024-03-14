package co.uco.bitacora.domains.usuario;

public class editableUsuario {
    private String nombre;

    private String apellido;

    private String usuario;
    private String contrasena;
    private long idTipoUsuario;

    public editableUsuario(String nombre, long idTipoUsuario) {
        this.nombre = nombre;
        this.idTipoUsuario = idTipoUsuario;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
