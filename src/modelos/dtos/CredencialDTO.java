package modelos.dtos;

public class CredencialDTO {
    private String idCredencial;
    private String fotoCredencial;
    private Boolean habilitado;

    public CredencialDTO(String idCredencial, String fotoCredencial) {
        this.idCredencial = idCredencial;
        this.fotoCredencial = fotoCredencial;
        this.habilitado = false;
    }

    public String getIdCredencial() {
        return idCredencial;
    }

    public void setIdCredencial(String idCredencial) {
        this.idCredencial = idCredencial;
    }

    public String getFotoCredencial() {
        return fotoCredencial;
    }

    public void setFotoCredencial(String fotoCredencial) {
        this.fotoCredencial = fotoCredencial;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }
}
