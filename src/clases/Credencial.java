package clases;

import modelos.adapters.IAdapterCredencial;

/**
 * 
 */
public class Credencial extends IAdapterCredencial {

    /**
     * Default constructor
     */
    public Credencial() {
    }

    /**
     *
     */
    private Stream fotoCredencial;

    /**
     * 
     */
    private IAdapterCredencial adapter;

    /**
     * 
     */
    private Notificador notificador;

    /**
     * @param credencial 
     * @return
     */
    public boolean verificarCredencial(Stream credencial) {
        // TODO implement here
        return false;
    }

}