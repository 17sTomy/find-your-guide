package modelos.DTOs;

import enumeraciones.Sexo;

public class GuiaDTO {
    private String nombre;
    private String apellido;
    private Sexo sexo;
    private String dni;
    private String email;
    private String numTelefono;
    private String fotoPerfil;
    private Enum pais;
    private CredencialDTO credencial;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Enum getPais() {
        return pais;
    }

    public void setPais(Enum pais) {
        this.pais = pais;
    }

    public CredencialDTO getCredencial() {
        return credencial;
    }

    public void setCredencial(CredencialDTO credencial) {
        this.credencial = credencial;
    }
}
