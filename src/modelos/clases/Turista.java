package modelos.clases;

import enums.Sexo;
import modelos.interfaces.IAuthenticacion;

import java.util.List;

public class Turista extends Usuario {
    public Turista(String nombre, String apellido, Sexo sexo, String dni, String email, String password, String numTelefono, String fotoPerfil, IAuthenticacion auth) {
        super(nombre, apellido, sexo, dni, email, password, numTelefono, fotoPerfil, auth);
    }
}