package clases;

import Interfaces.IRol;
import controladores.TuristaController;
import enumeraciones.ModoAuth;
import modelos.DTOs.UsuarioDTO;

import java.util.List;

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
    private List<Reseña> reseñas;

    /**
     * 
     */
    private TuristaController turistaController;

    /**
     * @param reserva
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

}