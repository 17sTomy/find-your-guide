package modelos.states;

public interface IEstadoViaje {
    public void reservarViaje(Viaje viaje);
    public void cancelarViaje(Viaje viaje);
    public void iniciarViaje(Viaje viaje);
    public void finalizarViaje(Viaje viaje);
    public void aceptarViaje(Viaje viaje);
}
