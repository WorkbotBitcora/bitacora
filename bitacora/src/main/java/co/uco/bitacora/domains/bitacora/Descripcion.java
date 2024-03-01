package co.uco.bitacora.domains.bitacora;

public class Descripcion {
    private long id;
    private  String descripcion;


    public Descripcion(String descripcion) {
        this.id=1;
        this.descripcion = descripcion;
    }

    public Descripcion(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
