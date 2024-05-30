package clases;

import enumeraciones.Sexo;

/**
 * 
 */
public class Perfil {

    /**
     * Default constructor
     */
    public Perfil() {
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