package modelos.clases;

import modelos.interfaces.IEstadoViaje;

/**
 * 
 */
public class Iniciado implements IEstadoViaje {

    public void aceptarViaje(Viaje viaje) {
    }

    public void iniciarViaje(Viaje viaje) {
        System.out.println("El viaje ya fue iniciado");

    }

    public void cancelarViaje(Viaje viaje) {
        System.out.println("Viaje cancelado");
        viaje.cambiarEstado(new Cancelado());
    }

    public void finalizarViaje(Viaje viaje) {
        System.out.println("Viaje finalizado");
        viaje.cambiarEstado(new Finalizado());
    }



}