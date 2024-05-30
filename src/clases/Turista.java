package clases;

import enumeraciones.ModoAuth;

import java.util.*;

/**
 * 
 */
public class Turista extends Usuario implements IRol {

    /**
     * Default constructor
     */
    public Turista() {
    }

    /**
     * 
     */
    private List<Viaje> viajes;

    /**
     * 
     */
    private boolean trofeoALaReseña;

    /**
     * 
     */
    private List<Reseñas> reseñas;

    /**
     * 
     */
    private TuristaController turistaController;

    /**
     * @param Reserva 
     * @return
     */
    public Void cancelarReserva(Reserva reserva) {
        // TODO implement here
        return null;
    }

    /**
     * @param usuario 
     * @return
     */
    public void asignarRol(UsuarioDTO usuario) {
        // TODO implement here
    }

    /**
     * @param usuario 
     * @param modoRegistro 
     * @return
     */
    public Turista registrarTurista(Turista usuario, ModoAuth modoRegistro) {
        // TODO implement here
        return null;
    }

    /**
     * @param usuario 
     * @param modoLogin 
     * @return
     */
    public void loginTurista(Turista usuario, ModoAuth modoLogin) {
        // TODO implement here
    }

    /**
     * @param usuario 
     * @return
     */
    public void asignarRol(UsuarioDTO usuario) {
        // TODO implement IRol.asignarRol() here
    }

}