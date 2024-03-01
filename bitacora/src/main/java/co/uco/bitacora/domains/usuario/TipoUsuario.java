package co.uco.bitacora.domains.usuario;

public class TipoUsuario {

    private long id;
    private String descripcion;

    public TipoUsuario() {
        this.id = 1;
        this.descripcion="Cliente";
    }

    public TipoUsuario(long id) {
        switch ((int)id){
            case 1:
                this.id=id;
                this.descripcion = "Cliente";
                break;
            case 2:
                this.id=id;
                this.descripcion = "Tecnico";
                break;
            default:
                this.id = id;
                this.descripcion ="no existe tipo usuario";
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
