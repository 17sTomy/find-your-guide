package clases;

import Interfaces.ILogin;
import controladores.TuristaController;
import enumeraciones.Sexo;
import modelos.strategies.IAuthenticacion;

import java.util.stream.Stream;

/**
 * 
 */
public abstract class Usuario {

    /**
     * Default constructor
     */
    public Usuario() {
    }

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String apellido;

    /**
     * 
     */
    private Sexo sexo;

    /**
     * 
     */
    private IAuthenticacion auth;

    /**
     * 
     */
    private TuristaController turistaController;

    /**
     * 
     */
    private String dni;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String numTelefono;

    /**
     * 
     */
    private Stream fotoPerfil;

    /**
     * @param usuario 
     * @return
     */
    public void asignarRol(Usuario usuario) {
        // TODO implement here
    }

    /**
     * @param registro 
     * @return
     */
    public void setAutenticacion(IAuthenticacion registro) {
        // TODO implement here
    }

    /**
     * @param usuario 
     * @return
     */
    public void registrarUsuario(Usuario usuario) {
        // TODO implement here
    }

    /**
     * @param usuario 
     * @return
     */
    public void loguearUsuario(Usuario usuario) {
        // TODO implement here
    }

    /**
     * @param login 
     * @return
     */
    public void setLogin(ILogin login) {
        // TODO implement here
    }

    /**
     * @param nombre 
     * @param apellido 
     * @param sexo 
     * @param dni 
     * @param email 
     * @param numTelefono 
     * @return
     */
    public void actualizarPerfil(String nombre, String apellido, Enum sexo, String dni, String email, String numTelefono) {
        // TODO implement here
    }

    /**
     * @param Image 
     * @return
     */
    public void cargarFotoPerfil(Stream Image) {
        // TODO implement here
    }

}