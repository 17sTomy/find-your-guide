package modelos.clases;

import modelos.interfaces.IAdapterEnvioEmail;
import modelos.interfaces.IAuthenticacion;

/**
 * 
 */
public class RegistroBasico implements IAuthenticacion {

    /**
     * Default constructor
     */
    public RegistroBasico() {
    }

    /**
     * 
     */
    private IAdapterEnvioEmail adapter;

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
     * @param email 
     * @return
     */
    public void enviarEmail(String email) {
        // TODO implement here
    }

}