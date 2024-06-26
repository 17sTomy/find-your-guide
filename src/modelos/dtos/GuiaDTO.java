package modelos.dtos;

import enums.Ciudad;
import enums.Idioma;
import enums.Pais;
import enums.Sexo;
import modelos.clases.*;
import modelos.interfaces.IAdapterCredencial;

import java.util.ArrayList;
import java.util.List;

public class GuiaDTO extends UsuarioDTO {
    private List<Servicio> servicios;
    private Pais pais;
    private Ciudad ciudad;
    private CredencialDTO credencialDTO;
    private List<Idioma> idiomas;
    private Double puntuacion;


    public GuiaDTO(Guia guia) {
        super(guia.getNombre(), guia.getApellido(), guia.getDni(), guia.getSexo(), guia.getEmail(), guia.getNumTelefono(), guia.getFotoPerfil(), guia.getAuth());
        this.servicios = guia.getServicios();
        this.pais = guia.getPais();
        this.ciudad = guia.getCiudad();
        this.credencialDTO = convertirCredencialDTO(guia.getCredencial());
        this.idiomas = guia.getIdiomas();
        this.puntuacion = guia.getPuntuacion();
    }

    public GuiaDTO(String nombre, String apellido, String dni, Sexo sexo, String email, String numTelefono, String fotoPerfil, String auth, List<Servicio> servicios, Pais pais, Ciudad ciudad, CredencialDTO credencial, List<Idioma> idiomas, Double puntuacion) {
        super(nombre, apellido, dni, sexo, email, numTelefono, fotoPerfil, auth);
        if(servicios == null){
            this.servicios = new ArrayList<>();
        }else{
            this.servicios = servicios;
        }
        this.pais = pais;
        this.ciudad = ciudad;
        this.credencialDTO = credencial;
        this.idiomas = idiomas;
        this.puntuacion = puntuacion;
    }

    public CredencialDTO getCredencialDTO() {
        return credencialDTO;
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

    public Credencial convertirCredencial(IAdapterCredencial adapter) {
        return CredencialFactory.createCredencial(credencialDTO, adapter);
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    private CredencialDTO convertirCredencialDTO(Credencial credencial) {
        if (credencial == null) {
            return null;
        }
        return new CredencialDTO(
                credencial.getIdCredencial(),
                credencial.getFotoCredencial()
        );
    }
}

