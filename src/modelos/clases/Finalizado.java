package modelos.clases;

import modelos.interfaces.IEstadoViaje;

/**
 * 
 */
public class Finalizado implements IEstadoViaje {


    public void cancelarViaje(Viaje viaje) {
        this.mostrarMensajeFinalizado();
    }

    public void iniciarViaje(Viaje viaje) {
        this.mostrarMensajeFinalizado();
    }

    public void finalizarViaje(Viaje viaje) {
        this.mostrarMensajeFinalizado();
    }

    public void aceptarViaje(Viaje viaje) {
        this.mostrarMensajeFinalizado();
    }

    private void mostrarMensajeFinalizado(){
        System.out.println("El viaje ya fue finalizado");
    }

}