package modelos.dtos;

import enums.Auth;
import enums.Sexo;

import java.util.stream.Stream;

public class UsuarioDTO {
    private String nombre;
    private String apellido;
    private String dni;
    private Sexo sexo;
    private String email;
    private String numTelefono;
    private String fotoPerfil;
    private String auth;

    public UsuarioDTO(String nombre, String apellido, String dni, Sexo sexo, String email, String numTelefono, String fotoPerfil, String auth) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
        this.email = email;
        this.numTelefono = numTelefono;
        this.fotoPerfil = fotoPerfil;
        this.auth = auth;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public String getFotoPerfil() {
        //Esto regresa la ruta, no una imagen
        return fotoPerfil;
    }

    public String getAuth() {
        return auth;
    }

    public String toString() {
        return "UsuarioDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", sexo=" + sexo +
                ", email='" + email + '\'' +
                ", numTelefono='" + numTelefono + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }
}

