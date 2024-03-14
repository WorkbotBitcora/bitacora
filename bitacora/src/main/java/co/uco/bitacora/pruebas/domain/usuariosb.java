package co.uco.bitacora.pruebas.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USUARIOSP")
public class usuariosb {

    @Id
    private long id;
    private String nombre;
    private String apellido;

    @ManyToOne
    private sucursal sucursal;
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

    public co.uco.bitacora.pruebas.domain.sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(co.uco.bitacora.pruebas.domain.sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<banco> getBancos() {
        return bancos;
    }

    public void setBancos(List<banco> bancos) {
        this.bancos = bancos;
    }
}
