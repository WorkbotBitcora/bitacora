package co.uco.bitacora.domains.revision;

import co.uco.bitacora.domains.bitacora.Observacion;
import co.uco.bitacora.domains.equipo.Equipo;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Revisiones")
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



    @OneToOne
    private Observacion observacion;

    @Temporal(TemporalType.DATE)
    private Date fechaFinal;

    @OneToOne
    private Equipo Equipo;



    @PrePersist
    protected void onCreate(){
        fechaFinal = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        fechaFinal = new Date();
    }

    public Revision() {
        this.id=1;
        this.observacion = new Observacion();
        this.Equipo = new Equipo();
    }

    public Revision(Observacion observacion, Equipo equipo) {
        this.observacion = observacion;
        Equipo = equipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public void setObservacion(Observacion observacion) {
        this.observacion = observacion;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fecha) {
        this.fechaFinal = fecha;
    }

    public Equipo getEquipo() {
        return Equipo;
    }

    public void setEquipo(Equipo Equipo) {
        this.Equipo = Equipo;
    }
}
