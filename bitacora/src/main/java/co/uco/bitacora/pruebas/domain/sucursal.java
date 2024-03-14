package co.uco.bitacora.pruebas.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "SucursalesP")
public class sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre ;
    private String direccion;

    public sucursal() {
        this.nombre="emilio";
        this.direccion="ni idea";
    }

    public sucursal(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
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
