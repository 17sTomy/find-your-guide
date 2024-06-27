package modelos.dtos;

import enums.Auth;
import enums.Sexo;
import modelos.clases.Turista;

public class TuristaDTO extends UsuarioDTO {
    private int cantViajes;

    public TuristaDTO(Turista turista) {
        super(turista.getNombre(), turista.getApellido(), turista.getDni(), turista.getSexo(), turista.getEmail(), turista.getNumTelefono(), turista.getFotoPerfil(), turista.getAuth());
        this.cantViajes = turista.getCantViajes();
    }

    public TuristaDTO(String nombre, String apellido, String dni, Sexo sexo, String email, String numTelefono, String fotoPerfil, String auth, int cantViajes) {
        super(nombre, apellido, dni, sexo, email, numTelefono, fotoPerfil, auth);
        this.cantViajes = cantViajes;
    }

    public int getCantViajes() {
        return cantViajes;
    }
}
