package modelos;

public class ViajeDTO {

    private Ciudad ciudadDestino;
    private Pais paisDestino;
    private Date fechaInicio;
    private Date fechaFin;
    private GuiaDTO guia;
    private TuristaDTO turista;

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Pais getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(Pais paisDestino) {
        this.paisDestino = paisDestino;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public GuiaDTO getGuia() {
        return guia;
    }

    public void setGuia(GuiaDTO guia) {
        this.guia = guia;
    }

    public TuristaDTO getTurista() {
        return turista;
    }

    public void setTurista(TuristaDTO turista) {
        this.turista = turista;
    }
}
