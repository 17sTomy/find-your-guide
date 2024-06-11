package modelos.dtos;

import enums.Ciudad;
import enums.Pais;
import enums.Sexo;

import java.util.stream.Stream;

public class GuiaDTO extends UsuarioDTO {
    private String servicio;
    private Pais pais;
    private Ciudad ciudad;
    private String credencial;

    public GuiaDTO(String nombre, String apellido, String dni, Sexo sexo, String email, String numTelefono, String fotoPerfil, String auth, String servicio, Pais pais, Ciudad ciudad, String credencial) {
        super(nombre, apellido, dni, sexo, email, numTelefono, fotoPerfil, auth);
        this.servicio = servicio;
        this.pais = pais;
        this.ciudad = ciudad;
        this.credencial = credencial;
    }

    public String getServicio() {
        return servicio;
    }

    public Pais getPais() {
        return pais;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public String getCredencial() {
        return credencial;
    }
}

