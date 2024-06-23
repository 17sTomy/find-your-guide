package modelos.clases;

import controladores.ViajeController;
import enums.Ciudad;
import enums.Pais;
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
    public Viaje(ViajeDTO viajeDTO, Turista turista, Guia guia) {
        fechaInicio = viajeDTO.getFechaInicio();
        fechaFin = viajeDTO.getFechaFin();
        ciudadDestino = viajeDTO.getCiudadDestino();
        paisDestino = viajeDTO.getPaisDestino();
        estadoViaje = new Activo(this);
        reserva = new Reserva();
        this.turista = turista;
        this.guia = guia;
        this.setAnticipo();
        this.notificarReservaRealizada();
    }

    public void notificarReservaRealizada() {
        Notificacion notificacion = new Notificacion(
                "Reserva realizada",
                "Reserva nro: " + reserva.getIdReserva() + "\\n" +
                "Fecha: " + fechaInicio + " - " + fechaFin + "\\n" +
                "Destino: " + paisDestino + ", " + ciudadDestino + "\\n" +
                "Turista: " + turista.getNombre() + " " + turista.getApellido() + "\\n" +
                "Telefono: " + turista.getNumTelefono(),
                guia
        );

        notificador = new Notificador();
        notificador.cambiarEstrategia(new Push());
        notificador.enviar(notificacion);
    }

    public void notificarResenia() {
        Notificacion notificacion = new Notificacion(
                "¿Como fue su viaje?",
                "Cuentenos que le pareció el guía " + guia.getNombre() + " " + guia.getApellido(),
                turista
        );

        notificador = new Notificador();
        notificador.cambiarEstrategia(new Push());
        notificador.enviar(notificacion);
        notificador.cambiarEstrategia(new Mail(new JavaMail()));
        notificador.enviar(notificacion);
    }


    public Factura getFactura() {
        return factura;
    }

    public void cobrarAnticipo(Double anticipo, Turista turista) {
        // To Do. Hay que ver si en realidad no va en la clase reserva
    }

    public void aceptarViaje() {
        this.estadoViaje.aceptarViaje(this);
    }

    public void iniciarViaje() {
        this.estadoViaje.iniciarViaje(this);
    }

    public void cancelarViaje() {
        this.estadoViaje.cancelarViaje(this);
        this.reserva.cancelarReserva();
    }

    public void finalizarViaje() {
        this.estadoViaje.finalizarViaje(this);
        turista.setCantViajes(turista.getCantViajes() + 1);
    }

    public void cambiarEstado(IEstadoViaje nuevoEstado) {
        this.estadoViaje = nuevoEstado;
    }

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
    }

    public Turista getTurista() {
        return turista;
    }

    public Guia getGuia() {
        return guia;
    }

    public Double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo() {
        this.anticipo = 50.00;
    }

    public String toString() {
        return "--- DETALLE VIAJE ---" + " \n" +
                "Fecha Inicio:  " + fechaInicio + " \n" +
                "Fecha Fin: " + fechaFin + " \n" +
                "Anticipo: " + anticipo + " \n" +
                "Pais de Destino: " + paisDestino + " \n" +
                "Ciudad de Destino: " + ciudadDestino;
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
}