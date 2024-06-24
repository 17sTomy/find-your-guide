package modelos.dtos;

import enums.Ciudad;
import enums.Idioma;
import enums.Pais;
import enums.Sexo;
import modelos.clases.Credencial;
import modelos.clases.Guia;
import modelos.clases.Servicio;

import java.util.List;

public class GuiaDTO extends UsuarioDTO {
    private List<Servicio> servicios;
    private Pais pais;
    private Ciudad ciudad;
    private Credencial credencial;
    private List<Idioma> idiomas;
    private Double puntuacion;


    public GuiaDTO(Guia guia) {
        super(guia.getNombre(), guia.getApellido(), guia.getDni(), guia.getSexo(), guia.getEmail(), guia.getNumTelefono(), guia.getFotoPerfil(), guia.getAuth());
        this.servicios = guia.getServicios();
        this.pais = guia.getPais();
        this.ciudad = guia.getCiudad();
        this.credencial = guia.getCredencial();
        this.idiomas = guia.getIdiomas();
        this.puntuacion = guia.getPuntuacion();
    }

    public GuiaDTO(String nombre, String apellido, String dni, Sexo sexo, String email, String numTelefono, String fotoPerfil, String auth, List<Servicio> servicios, Pais pais, Ciudad ciudad, Credencial credencial, List<Idioma> idiomas, Double puntuacion) {
        super(nombre, apellido, dni, sexo, email, numTelefono, fotoPerfil, auth);
        this.servicios = servicios;
        this.pais = pais;
        this.ciudad = ciudad;
        this.credencial = credencial;
        this.idiomas = idiomas;
        this.puntuacion = puntuacion;
    }



    public Pais getPais() {
        return pais;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }
}

