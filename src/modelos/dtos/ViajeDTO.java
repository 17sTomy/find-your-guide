package modelos.dtos;

import enums.Ciudad;
import enums.Pais;
import modelos.clases.Factura;
import modelos.clases.Reserva;

import java.time.LocalDate;

public class ViajeDTO {
// TODO quiza hay que eliminar guiaDTO y turistaDTO
    private Ciudad ciudadDestino;
    private int idViaje;
    private  String factura;
    private ReservaDTO reserva;
    private Pais paisDestino;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private GuiaDTO guiaDTO;
    private TuristaDTO turistaDTO;

    public ViajeDTO(Ciudad ciudadDestino, Pais paisDestino, LocalDate fechaInicio, LocalDate fechaFin) {
        this.ciudadDestino = ciudadDestino;
        this.paisDestino = paisDestino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public ViajeDTO(Ciudad ciudadDestino, Pais paisDestino, LocalDate fechaInicio, LocalDate fechaFin, int idViaje, ReservaDTO reserva, String factura){
        this.ciudadDestino = ciudadDestino;
        this.paisDestino = paisDestino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.factura = factura;
        this.reserva = reserva;
        this.idViaje = idViaje;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public String getFactura() {
        return factura;
    }

    public ReservaDTO getReserva() {
        return reserva;
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

    public GuiaDTO getGuiaDTO() {
        return guiaDTO;
    }

    public void setGuiaDTO(GuiaDTO guiaDTO) {
        this.guiaDTO = guiaDTO;
    }

    public TuristaDTO getTuristaDTO() {
        return turistaDTO;
    }

    public void setTuristaDTO(TuristaDTO turistaDTO) {
        this.turistaDTO = turistaDTO;
    }
}
