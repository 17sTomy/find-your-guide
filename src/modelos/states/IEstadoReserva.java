package modelos.states;

public interface IEstadoReserva {
    public void aceptarReserva(Reserva reserva);
    public void cancelarReserva(Reserva reserva);
}
