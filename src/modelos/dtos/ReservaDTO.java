package modelos.dtos;

import modelos.clases.Reserva;

public class ReservaDTO {
    private int id;
    private boolean aceptada;

    public ReservaDTO(Reserva reserva) {
        this.id = reserva.getId();
        this.aceptada = reserva.estaAceptada();
    }

    public int getId() {
        return id;
    }

    public boolean isAceptada() {
        return aceptada;
    }
}
