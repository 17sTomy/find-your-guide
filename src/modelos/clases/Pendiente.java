package modelos.clases;

import modelos.interfaces.IEstadoReserva;

public class Pendiente implements IEstadoReserva {

    public void aceptarReserva(Reserva reserva) {
        System.out.println("Reserva aceptada");
        reserva.cambiarEstado(new Aceptada());
    }


    public void cancelarReserva(Reserva reserva) {
        System.out.println("Reserva cancelada");
        reserva.cambiarEstado(new Cancelada());
    }

    public String estado(Reserva reserva){
        return "Pendiente";
    }
}
