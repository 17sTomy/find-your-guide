package modelos.clases;

import controladores.ViajeController;
import enums.Ciudad;
import enums.Pais;
import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;
import modelos.dtos.ViajeDTO;
import modelos.interfaces.IEstadoViaje;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 
 */
public class Viaje {

    private ViajeController viajeController;
    private Factura factura;
    private Reserva reserva;
    private Guia guia;
    private Turista turista;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double anticipo;
    private Pais paisDestino;
    private Ciudad ciudadDestino;
    private IEstadoViaje estadoViaje;
    private Notificador notificador;

    /**
     * Default constructor
     */
    public Viaje(ViajeDTO viajeDTO) {
        fechaInicio = viajeDTO.getFechaInicio();
        fechaFin = viajeDTO.getFechaFin();
        ciudadDestino = viajeDTO.getCiudadDestino();
        paisDestino = viajeDTO.getPaisDestino();
        estadoViaje = new Activo(this);
        this.setAnticipo();
    }

    public Factura getFactura() {
        return factura;
    }

    public void cobrarAnticipo(Double anticipo, Turista turista) {
        // To Do. Hay que ver si en realidad no va en la clase reserva
    };

    public void aceptarViaje() {
        this.estadoViaje.aceptarViaje(this);
    };

    public void iniciarViaje() {
        this.estadoViaje.iniciarViaje(this);
    };

    public void cancelarViaje() {
        this.estadoViaje.cancelarViaje(this);
    };

    public void finalizarViaje() {
        this.estadoViaje.finalizarViaje(this);
    };

    public void cambiarEstado(IEstadoViaje nuevoEstado) {
        this.estadoViaje = nuevoEstado;
    };

    public void crearFactura(){
        double montoTotal = this.calcularMontoTotal();

        this.factura = new Factura(montoTotal);
    }

    private double calcularMontoTotal(){
        int cantidadDias;
        double montoTotal;

        // Calcular la diferencia en días
        cantidadDias = (int)ChronoUnit.DAYS.between(fechaInicio, fechaFin);

        montoTotal = cantidadDias * 100;

        return montoTotal;
    };

    public Double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo() {
        // Se debe calcular con el monto total de la factura
    }

    @Override
    public String toString() {
        return "--- DETALLE VIAJE ---" + " \n" +
                "Fecha Inicio:  " + fechaInicio + " \n" +
                "Fecha Fin: " + fechaFin + " \n" +
                "Anticipo: " + anticipo + " \n" +
                "Pais de Destino: " + paisDestino + " \n" +
                "Ciudad de Destino: " + ciudadDestino;
    }
}