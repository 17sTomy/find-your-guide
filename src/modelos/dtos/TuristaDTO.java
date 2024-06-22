package modelos.dtos;

import modelos.clases.Turista;

public class TuristaDTO extends UsuarioDTO {
    private int cantViajes;

    public TuristaDTO(Turista turista) {
        super(turista.getNombre(), turista.getApellido(), turista.getDni(), turista.getSexo(), turista.getEmail(), turista.getNumTelefono(), turista.getFotoPerfil(), turista.getAuth());
        this.cantViajes = turista.getCantViajes();
    }

    public int getCantViajes() {
        return cantViajes;
    }
}
