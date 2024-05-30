package clases;

import enumeraciones.Ciudad;
import enumeraciones.ModoAuth;
import enumeraciones.Pais;

import java.util.*;

/**
 * 
 */
public class Guia extends Usuario implements IRol {

    /**
     * Default constructor
     */
    public Guia() {
    }

    /**
     * 
     */
    private Servicio servicio;

    /**
     * 
     */
    private Pais pais;

    /**
     * 
     */
    private Ciudad ciudad;

    /**
     * 
     */
    private Double puntuacion;

    /**
     * 
     */
    private IEstadoGuia estadoGuia;

    /**
     * 
     */
    private List<Viaje> viajes;

    /**
     * 
     */
    private Credencial credencial;

    /**
     * 
     */
    private List<Viaje> viajes;

    /**
     * 
     */
    private boolean trofeoAlExito;

    /**
     * 
     */
    private List<Reseñas> reseñas;

    /**
     * 
     */
    private GuiaController guiaController;

    /**
     * @param usuario 
     * @return
     */
    public void asignarRol(UsuarioDTO usuario) {
        // TODO implement here
    }

    /**
     * @param nuevoEstado 
     * @return
     */
    public void setEstado(IEstadoGuia nuevoEstado) {
        // TODO implement here
    }

    /**
     * @param servicio 
     * @return
     */
    public void agregarServicio(Servicio servicio) {
        // TODO implement here
    }

    /**
     * @param servicio 
     * @return
     */
    public void eliminarServicio(Servicio servicio) {
        // TODO implement here
    }

    /**
     * @param estado 
     * @return
     */
    public void cambiarEstadoGuia(IEstadoGuia estado) {
        // TODO implement here
    }

    /**
     * @param guiaDTO
     * @return
     */
    public List<Guia> buscarGuia(GuiaDTO guiaDTO) { // poner en el diagrama nombre de la variable
        // TODO implement here
        return null;
    }

    /**
     * @param guia
     * @param fechaInicio 
     * @param fechaFin 
     * @return
     */
    public Void contratarGuia(Guia guia, Date fechaInicio, Date fechaFin) { // poner en el diagrama nombre de la variable
        // TODO implement here
        return null;
    }

    /**
     * @param turista 
     * @param guia 
     * @param puntuacion 
     * @return
     */
    public void calificarGuia(Turista turista, Guia guia, Double puntuacion) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Double calcularPuntuacion() {
        // TODO implement here
        return null;
    }

    /**
     * @param fechaInicio 
     * @param fechaFin 
     * @return
     */
    public boolean verificarDisponibilidad(Date fechaInicio, Date fechaFin) {
        // TODO implement here
        return false;
    }

    /**
     * @param usuario 
     * @param modoRegistro 
     * @return
     */
    public Guia registrarGuia(Guia usuario, ModoAuth modoRegistro) {
        // TODO implement here
        return null;
    }

    /**
     * @param usuario 
     * @param modoLogin 
     * @return
     */
    public void loginGuia(Guia usuario, ModoAuth modoLogin) {
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