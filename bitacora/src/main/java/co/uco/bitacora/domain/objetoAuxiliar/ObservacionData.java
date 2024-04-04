package co.uco.bitacora.domain.objetoAuxiliar;

public class ObservacionData {

    private long idObservacion;
    private String mejora;
    private String descripcion;


    public long getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(long idObservacion) {
        this.idObservacion = idObservacion;
    }

    public String getMejora() {
        return mejora;
    }

    public void setMejora(String mejora) {
        this.mejora = mejora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
