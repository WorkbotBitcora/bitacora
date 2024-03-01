package co.uco.bitacora.domains.bitacora;

import co.uco.bitacora.domains.equipo.Equipo;

public class Revicion {

    private long id;
    private Observacion observacion;

    private String fecha;

    private Equipo Equipo;

    public Revicion() {
        this.id=1;
        this.fecha ="01/01/2020";
        this.observacion = new Observacion();
        this.Equipo = new Equipo();
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Equipo getEquipo() {
        return Equipo;
    }

    public void setEquipo(Equipo Equipo) {
        this.Equipo = Equipo;
    }
}
