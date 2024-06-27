package modelos.clases;

import modelos.interfaces.IEstadoViaje;

/**
 * 
 */
public class Cancelado implements IEstadoViaje {


    public void aceptarViaje(Viaje viaje) {

    }

    public void cancelarViaje(Viaje viaje) {
        System.out.println("El viaje ya se encuentra cancelado.");
    }

    public String toString(){
        return "Cancelado";
    }

    public void iniciarViaje(Viaje viaje) {
        System.out.println("No se puede iniciar el viaje. El mismo fue cancelado");
    }
    public void finalizarViaje(Viaje viaje) {
        System.out.println("El viaje no puede finalizarse. Fue cancelado");
    }



}