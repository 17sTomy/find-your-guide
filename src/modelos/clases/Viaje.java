package modelos.clases;

import controladores.ViajeController;
import enums.Ciudad;
import enums.Pais;
import modelos.DataBase;
import modelos.dtos.ReservaDTO;
import modelos.dtos.ViajeDTO;
import modelos.interfaces.IEstadoViaje;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Viaje {

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
    private int id;
    private static int contadorID = 0;

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
        this.id = generarID();
        this.turista = turista;
        this.guia = guia;
        this.crearFactura();
        this.setAnticipo();
        this.notificarReservaRealizada();
    }

    public void notificarReservaRealizada() {
        Notificacion notificacion = new Notificacion(
                "Reserva realizada",
                "\n" + "Reserva nro: " + reserva.getId() + "\n" +
                "Fecha: " + fechaInicio + " - " + fechaFin + "\n" +
                "Destino: " + paisDestino + ", " + ciudadDestino + "\n" +
                "Turista: " + turista.getNombre() + " " + turista.getApellido() + "\n" +
                "Telefono: " + turista.getNumTelefono(),
                guia
        );

        notificador = new Notificador();
        notificador.cambiarEstrategia(new Push());
        notificador.enviar(notificacion);
    }

    private static int generarID(){
        return contadorID++;
    }

    public int getId() {
        return id;
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

    public String getEstado(){
        return this.estadoViaje.toString();
    }

    public Factura getFactura() {
        return factura;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void aceptarViaje() {
        this.estadoViaje.aceptarViaje(this);
    }

    public void iniciarViaje() {

        if(this.reserva.estaAceptada()){
            this.estadoViaje.iniciarViaje(this);
        }else {
            System.out.println("No se puede inicar el viaje, la reserva no fue confirmada por el guía.");
        }
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

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public Pais getPaisDestino() {
        return paisDestino;
    }

    public static List<ViajeDTO> getViajesDTO(String email) {
        List<Viaje> viajes = DataBase.getInstance().getViajesPorEmail(email);

        List<ViajeDTO> viajesDTO = new ArrayList<>();

        for (Viaje viaje : viajes) {
            ReservaDTO reservaDTO = new ReservaDTO(viaje.getReserva());
            String informacionFactura = viaje.getFactura().toString();

            ViajeDTO viajeDTO = new ViajeDTO(
                    viaje.getCiudadDestino(),
                    viaje.getPaisDestino(),
                    viaje.getFechaInicio(),
                    viaje.getFechaFin(),
                    viaje.getId(),
                    reservaDTO,
                    informacionFactura,
                    viaje.getEstado(),
                    viaje.getFactura().isTotalPago()
            );

            viajesDTO.add(viajeDTO);
        }

        return viajesDTO;
    }
}