package modelos.clases;

import enums.Rol;
import enums.Sexo;
import modelos.interfaces.IAuthenticacion;

import java.util.stream.Stream;

public class UsuarioFactory {
    public static Usuario createUsuario(Rol tipo, String nombre, String apellido, Sexo sexo, String dni, String email, String password, String numTelefono, String fotoPerfil, IAuthenticacion auth) {
        switch (tipo) {
            case TURISTA:
                return new Turista(nombre, apellido, sexo, dni, email, password, numTelefono, fotoPerfil, auth);
            case GUIA:
                return new Guia(nombre, apellido, sexo, dni, email, password, numTelefono, fotoPerfil, auth);
            default:
                throw new IllegalArgumentException("Tipo de usuario desconocido");
        }
    }
}

