package co.uco.bitacora.pruebas.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BANCOSP")
public class banco {
    @Id
    private long id;
    private String nombre;

    // esta escala a una lista de direcciones
    private String direccion;

}
