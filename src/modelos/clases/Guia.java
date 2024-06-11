package modelos.clases;

import enums.Ciudad;
import enums.Pais;
import enums.Sexo;
import modelos.dtos.GuiaDTO;
import modelos.interfaces.IAuthenticacion;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Guia extends Usuario {
    private Servicio servicio;
    private Pais pais;
    private Ciudad ciudad;
    private Double puntuacion;
    private Credencial credencial;
    private boolean trofeoAlExito;
    private List<Reseña> reseñas;

    public Guia(String nombre, String apellido, Sexo sexo, String dni, String email, String password, String numTelefono, String fotoPerfil, IAuthenticacion auth) {
        super(nombre, apellido, sexo, dni, email, password, numTelefono, fotoPerfil, auth);
    }

    public void setInfoExtra(Servicio servicio, Pais pais, Ciudad ciudad, Credencial credencial) {
        this.servicio = servicio;
        this.pais = pais;
        this.ciudad = ciudad;
        this.credencial = credencial;
    }

    public List<Guia> buscarGuia(GuiaDTO guiaDTO) { // poner en el diagrama nombre de la variable
        // TODO implement here
        return null;
    }

    public Void contratarGuia(Guia guia, Date fechaInicio, Date fechaFin) { // poner en el diagrama nombre de la variable
        // TODO implement here
        return null;
    }

    public void calificarGuia(Turista turista, Guia guia, Double puntuacion) {
        // TODO implement here
    }

    public Double calcularPuntuacion() {
        // TODO implement here
        return null;
    }

    public boolean verificarDisponibilidad(Date fechaInicio, Date fechaFin) {
        // TODO implement here
        return false;
    }

    public String getServicio() {
        return servicio.toString();
    }

    public Pais getPais() {
        return pais;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public boolean isTrofeoAlExito() {
        return trofeoAlExito;
    }

    public List<Reseña> getReseñas() {
        return reseñas;
    }
}