package modelos.dtos;

import enums.Auth;
import enums.Sexo;

import java.util.stream.Stream;

public class TuristaDTO extends UsuarioDTO {

    public TuristaDTO(String nombre, String apellido, String dni, Sexo sexo, String email, String numTelefono, Stream fotoPerfil, String auth) {
        super(nombre, apellido, dni, sexo, email, numTelefono, fotoPerfil, auth);
    }
}
