package modelos.dtos;

import enums.Ciudad;
import enums.Idioma;
import enums.Pais;
import modelos.clases.Credencial;
import modelos.clases.Guia;
import modelos.clases.Servicio;

import java.util.List;

public class GuiaDTO extends UsuarioDTO {
    private Servicio servicio;
    private Pais pais;
    private Ciudad ciudad;
    private Credencial credencial;
    private List<Idioma> idiomas;
    private Double puntuacion;


    public GuiaDTO(Guia guia) {
        super(guia.getNombre(), guia.getApellido(), guia.getDni(), guia.getSexo(), guia.getEmail(), guia.getNumTelefono(), guia.getFotoPerfil(), guia.getAuth());
        this.servicio = guia.getServicio();
        this.pais = guia.getPais();
        this.ciudad = guia.getCiudad();
        this.credencial = guia.getCredencial();
        this.idiomas = guia.getIdiomas();
        this.puntuacion = guia.getPuntuacion();
    }


    public Pais getPais() {
        return pais;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public Servicio getServicio() {
        return servicio;
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

