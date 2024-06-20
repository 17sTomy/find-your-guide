package modelos.clases;

import modelos.interfaces.IEstadoReserva;

/**
 * 
 */
public class Reserva {
    private int idReserva;
    private IEstadoReserva estadoReserva;
    private Turista turista;

    public Reserva(int idReserva, IEstadoReserva estadoReserva, Turista turista) {
        this.idReserva = idReserva;
        this.estadoReserva = estadoReserva;
        this.turista = turista;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void cambiarEstado(IEstadoReserva estadoReserva) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void aceptarReserva() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void cancelarReserva() {
        // TODO implement here
    }

}