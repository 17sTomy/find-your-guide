package modelos.clases;

import modelos.interfaces.IEstadoReserva;

public class Aceptada implements IEstadoReserva {


    public void aceptarReserva(Reserva reserva) {
        System.out.println("La Reserva ya está Aceptada");
    }

    public String estado(Reserva reserva){
        return "Aceptada";
    }

    public void cancelarReserva(Reserva reserva) {
        System.out.println("Reserva cancelada");
        reserva.cambiarEstado(new Cancelada());
    }

}