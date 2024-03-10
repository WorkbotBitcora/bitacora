package co.uco.bitacora.domains.recomendacion;


import jakarta.persistence.*;

@Entity
@Table(name = "Recomendaciones")
public class Recomendacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String recomendacion;

    public Recomendacion() {
        this.id =1;
        this.recomendacion = "ninguna recomendacion";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
}
