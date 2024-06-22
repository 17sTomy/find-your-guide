package modelos.clases;

import modelos.interfaces.IEstadoReserva;

public class Aceptada implements IEstadoReserva {


    public void aceptarReserva(Reserva reserva) {
        System.out.println("La Reserva ya fue Aceptada");
    }

    public void cancelarReserva(Reserva reserva) {
        System.out.println("Reserva cancelada");
        reserva.cambiarEstado(new Cancelada());
    }

}