package modelos.interfaces;

import modelos.clases.Viaje;

public interface IEstadoViaje {
    public void cancelarViaje(Viaje viaje);
    public void iniciarViaje(Viaje viaje);
    public void finalizarViaje(Viaje viaje);
    public void aceptarViaje(Viaje viaje);
}
