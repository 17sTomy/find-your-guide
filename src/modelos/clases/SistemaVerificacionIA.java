package modelos.clases;

import modelos.interfaces.IAdapterCredencial;

import java.util.stream.Stream;

/**
 * 
 */
public class SistemaVerificacionIA implements IAdapterCredencial {

    /**
     * Default constructor
     */
    public SistemaVerificacionIA() {
    }

    /**
     * @param credencial 
     * @return
     */
    public boolean verificarCredencial(Stream credencial) {
        // TODO implement here
        return false;
    }

}