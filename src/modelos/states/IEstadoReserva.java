package modelos.states;

import clases.Reserva;

public interface IEstadoReserva {
    public void aceptarReserva(Reserva reserva);
    public void cancelarReserva(Reserva reserva);
}
