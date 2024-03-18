package co.uco.bitacora.domains.bitacora;

import co.uco.bitacora.domains.recomendacion.Recomendacion;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Observaciones")
public class Observacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String descripcion;

    // hacer revision par

    private String mejora;

    public Observacion() {
        this.id= 1;
        this.descripcion = "vacio";
        this.mejora="vacio";
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

    public String getMejora() {
        return mejora;
    }

    public void setMejora(String mejora) {
        this.mejora = mejora;
    }
}
