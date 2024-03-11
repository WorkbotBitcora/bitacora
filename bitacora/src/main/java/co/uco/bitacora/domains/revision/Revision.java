package co.uco.bitacora.domains.revision;

import co.uco.bitacora.domains.bitacora.Observacion;
import co.uco.bitacora.domains.equipo.Equipo;
import co.uco.bitacora.services.ChekService;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Revisiones")
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @OneToMany
    private List<Chek> cheks = new ArrayList<>();

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

    public Revision(Observacion observacion, Equipo equipo, List<Chek> listaDeChek) {
        this.observacion = observacion;
        Equipo = equipo;
        this.cheks = listaDeChek;
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

    public List<Chek> getCheks() {
        return cheks;
    }

    public void setCheks(List<Chek> cheks) {
        this.cheks = cheks;
    }
}
