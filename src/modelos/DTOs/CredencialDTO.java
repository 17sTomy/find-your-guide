package modelos.DTOs;

import java.util.stream.Stream;

public class CredencialDTO {

    private Stream fotoCredencial;
    private String acreditacion;

    public Stream getFotoCredencial() {
        return fotoCredencial;
    }

    public void setFotoCredencial(Stream fotoCredencial) {
        this.fotoCredencial = fotoCredencial;
    }

    public String getAcreditacion() {
        return acreditacion;
    }

    public void setAcreditacion(String acreditacion) {
        this.acreditacion = acreditacion;
    }
}
