package modelos.dtos;

import modelos.clases.Reserva;

public class ReservaDTO {
    private int id;
    private String estado;

    public ReservaDTO(Reserva reserva) {
        this.id = reserva.getId();
        this.estado = reserva.estado();
    }

    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }
}
