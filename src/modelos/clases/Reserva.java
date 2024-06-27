package modelos.clases;
import modelos.interfaces.IEstadoReserva;
import java.util.Random;


public class Reserva {
    private IEstadoReserva estadoReserva;
    private int id;
    private static int contadorID = 0;

    private static int generarID(){
        return contadorID++;
    }


    public Reserva() {
        this.estadoReserva = new Pendiente();
        this.id = generarID();
    }

    public String estado() {
        return this.estadoReserva.estado(this);
    }

    public int getId() {
        return id;
    }

    public boolean estaAceptada(){
        return (estadoReserva instanceof Aceptada);
    }

    public void cambiarEstado(IEstadoReserva nuevoEstado) {
        this.estadoReserva = nuevoEstado;
    }

    public void aceptarReserva() {
        this.estadoReserva.aceptarReserva(this);
    }

    public void cancelarReserva() {
        this.estadoReserva.cancelarReserva(this);
    }

}