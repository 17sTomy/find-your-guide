package modelos.interfaces;

import modelos.clases.Reserva;
import modelos.clases.Turista;

public interface IEstadoReserva {
    public void aceptarReserva(Reserva reserva);
    public void cancelarReserva(Reserva reserva);
}
