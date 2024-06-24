package modelos.clases;
import modelos.interfaces.IEstadoReserva;
import java.util.Random;


public class Reserva {
    private IEstadoReserva estadoReserva;


    public Reserva() {
        this.estadoReserva = new Pendiente();
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