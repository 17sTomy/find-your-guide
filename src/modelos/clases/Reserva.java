package modelos.clases;
import modelos.interfaces.IEstadoReserva;
import java.util.Random;


public class Reserva {
    private int idReserva;
    private IEstadoReserva estadoReserva;


    public Reserva() {
        Random random = new Random();
        idReserva = random.nextInt();

        this.estadoReserva = new Aceptada();
    }

    public int getIdReserva() {
        return idReserva;
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