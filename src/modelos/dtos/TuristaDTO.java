package modelos.dtos;

import enums.Auth;
import enums.Sexo;

import java.util.stream.Stream;

public class TuristaDTO extends UsuarioDTO {
    private int cantViajes;

    public TuristaDTO(String nombre, String apellido, String dni, Sexo sexo, String email, String numTelefono, String fotoPerfil, String auth, int cantViajes) {
        super(nombre, apellido, dni, sexo, email, numTelefono, fotoPerfil, auth);
        this.cantViajes = cantViajes;
    }
}
