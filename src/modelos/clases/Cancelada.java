package modelos.clases;

import modelos.interfaces.IEstadoReserva;

/**
 * 
 */
public class Cancelada implements IEstadoReserva {
    private Notificador notificador;

    public void cancelarReserva(Reserva reserva, Turista turista) {
        this.notificar(turista);
    }

    public void notificar(Turista turista) {
        Notificacion notificacion = new Notificacion(
                "Reserva cancelada",
                "El guia ha cancelado tu reserva",
                turista
        );

        notificador = new Notificador();
        notificador.cambiarEstrategia(new Push());
        notificador.enviar(notificacion);
    }

    /**
     * @param reserva 
     * @return
     */
    public void aceptarReserva(Reserva reserva) {
        // TODO implement here
    }



}