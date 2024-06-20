package modelos.clases;

import controladores.ViajeController;
import enums.Ciudad;
import enums.Pais;
import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;
import modelos.dtos.ViajeDTO;
import modelos.interfaces.IEstadoViaje;

import java.time.LocalDate;

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
        estadoViaje = new Activo();
        ciudadDestino = viajeDTO.getCiudadDestino();
        paisDestino = viajeDTO.getPaisDestino();
        fechaInicio = viajeDTO.getFechaInicio();
        fechaFin = viajeDTO.getFechaFin();
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

    public void notificarReseña() {
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

    public Double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo() {
        // Se debe calcular con el monto total de la factura
    }
}