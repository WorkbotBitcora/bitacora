package co.uco.bitacora.pruebas.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USUARIOSP")
public class usuariosb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String apellido;

    @OneToOne
    private Datasor Datasor;

    @OneToOne
    private sucursal suc;

    @OneToMany
    private List<banco> bancos;


    public usuariosb() {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<banco> getBancos() {
        return bancos;
    }

    public void setBancos(List<banco> bancos) {
        this.bancos = bancos;
    }

    public Datasor getData() {
        return Datasor;
    }

    public void setData(Datasor Datasor) {
        this.Datasor = Datasor;
    }

    public sucursal getSuc() {
        return suc;
    }

    public void setSuc(sucursal suc) {
        this.suc = suc;
    }
}
