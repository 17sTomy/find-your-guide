package modelos.clases;

import modelos.interfaces.IEstadoReserva;

/**
 * 
 */
public class Cancelada implements IEstadoReserva {
    private Notificador notificador;

    public Cancelada(){

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
    public void aceptarReserva(Reserva reserva) {
        System.out.println("La reserva está cancelada. No puede volver a aceptarse");
    }

    public String estado(Reserva reserva){
        return "Cancelada";
    }

    public void cancelarReserva(Reserva reserva) {
        System.out.println("La reserva ya fue cancelada");
    }

}