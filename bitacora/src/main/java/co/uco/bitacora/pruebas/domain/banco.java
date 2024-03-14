package co.uco.bitacora.pruebas.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "BANCOSP")
public class banco {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;

    // esta escala a una lista de direcciones
    private String direccion;


    @OneToMany
    private List<sucursal> sucursales;

    public banco() {
    }


    public banco(String nombre, String direccion , List<sucursal> sucursales) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.sucursales = sucursales;
    }

    public List<sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<sucursal> sucursales) {
        this.sucursales = sucursales;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
