package co.uco.bitacora.domains.usuario;

public class userDescription {
    private long idUser;
    private String nombre;
    private long idTipouser;
    private long  idDesc;
    private String desc;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdTipouser() {
        return idTipouser;
    }

    public void setIdTipouser(long idTipouser) {
        this.idTipouser = idTipouser;
    }

    public long getIdDesc() {
        return idDesc;
    }

    public void setIdDesc(long idDesc) {
        this.idDesc = idDesc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
