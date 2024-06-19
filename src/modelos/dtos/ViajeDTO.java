package modelos.dtos;

import enums.Ciudad;
import enums.Pais;

import java.time.LocalDate;

public class ViajeDTO {

    private Ciudad ciudadDestino;
    private Pais paisDestino;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private GuiaDTO guia;
    private TuristaDTO turista;

    public ViajeDTO(Ciudad ciudadDestino, Pais paisDestino, LocalDate fechaInicio, LocalDate fechaFin) {
        this.ciudadDestino = ciudadDestino;
        this.paisDestino = paisDestino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
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
