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
    private String estado;
    private boolean facturaPaga;

    public ViajeDTO(Ciudad ciudadDestino, Pais paisDestino, LocalDate fechaInicio, LocalDate fechaFin) {
        this.ciudadDestino = ciudadDestino;
        this.paisDestino = paisDestino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public ViajeDTO(Ciudad ciudadDestino, Pais paisDestino, LocalDate fechaInicio, LocalDate fechaFin, int idViaje, ReservaDTO reserva, String factura, String estado, boolean facturaPaga){
        this.ciudadDestino = ciudadDestino;
        this.paisDestino = paisDestino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.factura = factura;
        this.reserva = reserva;
        this.idViaje = idViaje;
        this.estado = estado;
        this.facturaPaga = facturaPaga;
    }

    public boolean getFacturaPaga() {
        return this.facturaPaga;
    }

    public String getEstado() {
        return this.estado;
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

}
