package co.uco.bitacora.domains.bitacora;

import co.uco.bitacora.domains.usuario.Usuario;

public class Bitacora {

    private  long id;

    private Usuario usuario;

    private String fecha;

    private Descripcion descripcion;

    private Revicion Revicion;

    private Estado Estado;

    public Bitacora(Usuario usuario, Descripcion descripcion) {
        this.id=1;
        this.usuario = usuario;
        this.fecha = "01/01/2020";
        this.descripcion = descripcion;
        this.Revicion = new Revicion();
        this.Estado = new Estado();
    }

    public Bitacora() {
    }

    public Bitacora(long id, Usuario usuario, String fecha, Descripcion descripcion, Revicion Revicion, Estado Estado) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.Revicion = Revicion;
        this.Estado = Estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuarioID) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Descripcion getDescription() {
        return descripcion;
    }

    public void setDescripcion(long descriptionID) {
        this.descripcion = descripcion;
    }

    public Revicion getRevision() {
        return Revicion;
    }

    public void setRevision(Revicion revicionID) {
        this.Revicion = Revicion;
    }

    public Estado getEstado() {
        return Estado;
    }

    public void setEstado(Estado Estado) {
        this.Estado = Estado;
    }
}
