package co.uco.bitacora.domains.revision;

import co.uco.bitacora.domains.bitacora.observacion.Observacion;
import co.uco.bitacora.domains.equipo.Equipo;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comprobaciones")
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date fechaFinal;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Observacion observacion;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Equipo equipo;

    @ManyToMany (cascade = CascadeType.PERSIST)
    private List<Chek> chekList;

    @PrePersist
    protected void onCreate(){
        fechaFinal = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        fechaFinal = new Date();
    }



    public Revision() {
    }

    public Revision(Observacion observacion, Equipo equipo , List<Chek> chekList) {
        this.observacion = observacion;
        this.equipo = equipo;
        this.chekList = chekList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public void setObservacion(Observacion observacion) {
        this.observacion = observacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Chek> getChekList() {
        return chekList;
    }

    public void setChekList(List<Chek> chekList) {
        this.chekList = chekList;
    }
}
