package clases;

import enumeraciones.ModoAuth;

import java.util.*;

/**
 * 
 */
public class TuristaController {

    /**
     * Default constructor
     */
    public TuristaController() {
    }

    /**
     * 
     */
    private Turista turista;

    /**
     * @param usuarioDTO 
     * @param modoRegistro 
     * @return
     */
    public void registrarTurista(TuristaDTO usuarioDTO, ModoAuth modoRegistro) {
        // TODO implement here
    }

    /**
     * @param usuarioDTO 
     * @param modoRegistro 
     * @return
     */
    public void registrarGuia(GuiaDTO usuarioDTO, ModoRegistro modoRegistro) {
        // TODO implement here
    }

    /**
     * @param usuarioDTO 
     * @param modoLogin 
     * @return
     */
    public void loginTurista(TuristaDTO usuarioDTO, ModoAuth modoLogin) {
        // TODO implement here
    }

    /**
     * @param guiaDTO 
     * @return
     */
    public List<GuiaDTO> buscarGuias(GuiaDTO guiaDTO) {
        // TODO implement here
        return null;
    }

    /**
     * @param turistaDTO 
     * @param guiaDTO 
     * @param puntuacion 
     * @param comentario 
     * @return
     */
    public void calificarGuia(TuristaDTO turistaDTO, GuiaDTO guiaDTO, Double puntuacion, String comentario) {
        // TODO implement here
    }

    /**
     * @param emisor 
     * @param receptor 
     * @param mensaje 
     * @return
     */
    public void enviarMensaje(Usuario emisor, Usuario receptor, String mensaje) {
        // TODO implement here
    }

}