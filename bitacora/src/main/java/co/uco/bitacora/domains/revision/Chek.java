package co.uco.bitacora.domains.revision;

import co.uco.bitacora.domains.recomendacion.Recomendacion;
import co.uco.bitacora.services.RecomendacionesService;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Cheks")
public class Chek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private boolean estado;

    @ManyToMany
    private List<Recomendacion> recomendacionList;

    public Chek(long id, String nombre, boolean estado, List<Recomendacion> RecomendacionesRespectivas) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        //aqui traigo los datos de cada id
        this.recomendacionList = RecomendacionesRespectivas;
    }

    public Chek() {
        this.nombre = "vacio";
        this.estado = true;
        //this.recomendacionList.add(new Recomendacion());
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public List<Recomendacion> getRecomendacionList() {
        return recomendacionList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setRecomendacionList(List<Recomendacion> recomendacionList) {
        this.recomendacionList = recomendacionList;
    }


}


