package co.uco.bitacora.domains.bitacora;

import java.util.ArrayList;
import java.util.List;

public class Observacion {
    private long id;
    private String descripcion;

    private List<Recomendacion> recomendacionList = new ArrayList<>();

    private String mejora;

    public Observacion() {
        this.id=1;
        this.descripcion = "vacio";
        this.mejora="vacio";
        this.recomendacionList.add(new Recomendacion());
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

    public List<Recomendacion> getRecomendacionesList() {
        return recomendacionList;
    }

    public void setRecomendacionesList(List<Recomendacion> recomendacionList) {
        this.recomendacionList = recomendacionList;
    }

    public String getMejora() {
        return mejora;
    }

    public void setMejora(String mejora) {
        this.mejora = mejora;
    }
}
