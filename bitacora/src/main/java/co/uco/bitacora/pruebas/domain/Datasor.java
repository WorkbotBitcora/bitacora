package co.uco.bitacora.pruebas.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "datas")
public class Datasor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String nombre;
    @ManyToOne
    private sucursal sucursa;

    public Datasor(sucursal sucursa) {
        this.sucursa = sucursa;
    }

    public Datasor() {
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

    public sucursal getSucursa() {
        return sucursa;
    }

    public void setSucursa(sucursal sucursa) {
        this.sucursa = sucursa;
    }
}
