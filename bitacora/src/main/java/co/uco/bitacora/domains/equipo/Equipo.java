package co.uco.bitacora.domains.equipo;

import jakarta.persistence.*;

@Entity
@Table(name = "Equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private TipoEquipo tipoEquipo;

    private String marca;

    public Equipo() {
        this.id=1;
        this.marca="No Hay Marca";
        this.tipoEquipo = new TipoEquipo();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(long tipoEquipo) {
        this.tipoEquipo = new TipoEquipo(tipoEquipo);
    }
}
