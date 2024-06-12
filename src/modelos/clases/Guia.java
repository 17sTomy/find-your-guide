package modelos.clases;

import enums.*;
import modelos.dtos.*;
import modelos.interfaces.IAuthenticacion;

import java.util.Date;
import java.util.List;

public class Guia extends Usuario {
    private List<Servicio> servicios;
    private Pais pais;
    private Ciudad ciudad;
    private Credencial credencial;
    private boolean trofeoAlExito;
    private List<Reseña> reseñas;
    private List<Idioma> idiomas; //agregar atributo y enum en el diagrama

    public Guia(String nombre, String apellido, Sexo sexo, String dni, String email, String password, String numTelefono, String fotoPerfil, IAuthenticacion auth) {
        super(nombre, apellido, sexo, dni, email, password, numTelefono, fotoPerfil, auth);
    }

    public void setInfoExtra(List<Servicio> servicios, Pais pais, Ciudad ciudad, Credencial credencial, boolean trofeoAlExito, List<Reseña> reseñas, List<Idioma> idiomas) {
        this.servicios = servicios;
        this.pais = pais;
        this.ciudad = ciudad;
        this.credencial = credencial;
        this.trofeoAlExito = trofeoAlExito;
        this.reseñas = reseñas;
        this.idiomas = idiomas;
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


    public Pais getPais() {
        return pais;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public Double getPuntuacion() {
        return reseñas.stream()
                .mapToDouble(Reseña::getPuntuacion)
                .average()
                .orElse(0.0);
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