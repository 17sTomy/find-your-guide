package modelos.clases;

import enums.Auth;
import enums.Sexo;
import modelos.dtos.UsuarioDTO;
import modelos.interfaces.IAuthenticacion;

import java.util.stream.Stream;

public abstract class Usuario {
    private String nombre;
    private String apellido;
    private Sexo sexo;
    private String dni;
    private String email;
    private String password;
    private String numTelefono;
    private String fotoPerfil;
    private IAuthenticacion auth;
    private Trofeo trofeo;

    public Usuario(String nombre, String apellido, Sexo sexo, String dni, String email, String password, String numTelefono, String fotoPerfil, IAuthenticacion auth) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.numTelefono = numTelefono;
        this.fotoPerfil = fotoPerfil;
        this.auth = auth;
        this.trofeo = null;
    }

    public void setAutenticacion(IAuthenticacion selectedAuth) {
        this.auth = selectedAuth;
    }

    public boolean register() {
        return auth.register(this);
    }

    public static UsuarioDTO login(String email, String password, IAuthenticacion modoLogin) {
        return modoLogin.login(email, password);
    }

    public void actualizarPerfil(String nombre, String apellido, Sexo sexo, String numTelefono, String fotoPerfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.numTelefono = numTelefono;
        this.fotoPerfil = fotoPerfil;
    }

    public void cargarFotoPerfil(String image) {
        this.fotoPerfil = image;
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

    public String getPassword() {
        return password;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public String getAuth() {
        return auth.toString();
    }

    public void setTrofeo(Trofeo trofeo) {
        this.trofeo = trofeo;
    }
}