package modelos.clases;

import modelos.interfaces.IAdapterCredencial;

import java.util.stream.Stream;

/**
 * 
 */
public class Credencial {

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