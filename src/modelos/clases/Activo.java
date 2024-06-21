package modelos.clases;

import modelos.interfaces.IEstadoViaje;

public class Activo implements IEstadoViaje {

    public Activo(Viaje viaje) {
        viaje.crearFactura();
    }

    public void aceptarViaje(Viaje viaje) {
        System.out.println("Viaje aceptado");
    }

    public void iniciarViaje(Viaje viaje) {
        System.out.println("Viaje iniciado");
        viaje.cambiarEstado(new Iniciado());
    }
    public void cancelarViaje(Viaje viaje) {
        System.out.println("Viaje cancelado");
        viaje.cambiarEstado(new Cancelado());
    }

    public void finalizarViaje(Viaje viaje) {
        System.out.println("El viaje nunca fue iniciado");;
    }



}