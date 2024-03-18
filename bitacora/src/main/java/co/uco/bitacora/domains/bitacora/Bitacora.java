package co.uco.bitacora.domains.bitacora;

import co.uco.bitacora.domains.usuario.Usuario;
import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "Bitacoras")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    @ManyToOne
    private Usuario usuario;

    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;

    @ManyToOne
    private Descripcion descripcion;

    @ManyToOne
    private co.uco.bitacora.domains.revision.Revision Revision;

    @ManyToOne
    private Estado Estado;

    @PrePersist
    protected void onCreate(){
        fechaEntrada = new Date();
    }

    public Bitacora() {
    }


    public Bitacora(Usuario usuario, Descripcion descripcion , co.uco.bitacora.domains.revision.Revision revision , Estado estado ) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.Revision=revision;
        this.Estado=estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuarioID) {
        this.usuario = usuarioID;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Descripcion getDescription() {
        return descripcion;
    }

    public void setDescripcion(Descripcion descriptionID) {
        this.descripcion = descriptionID;
    }

    public co.uco.bitacora.domains.revision.Revision getRevision() {
        return Revision;
    }

    public void setRevision(co.uco.bitacora.domains.revision.Revision revisionID) {
        this.Revision = revisionID;
    }

    public Estado getEstado() {
        return Estado;
    }

    public void setEstado(Estado Estado) {
        this.Estado = Estado;
    }



}
