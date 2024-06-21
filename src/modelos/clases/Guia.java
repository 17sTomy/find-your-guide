package modelos.clases;

import enums.*;
import modelos.DataBase;
import modelos.dtos.*;
import modelos.interfaces.IAuthenticacion;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Guia extends Usuario {
    private List<Servicio> servicios; //cambiar a lista en el diagrama
    private Pais pais;
    private Ciudad ciudad;
    private Credencial credencial;
    private List<Idioma> idiomas; //agregar atributo y enum en el diagrama

    public Guia(String nombre, String apellido, Sexo sexo, String dni, String email, String password, String numTelefono, String fotoPerfil, IAuthenticacion auth) {
        super(nombre, apellido, sexo, dni, email, password, numTelefono, fotoPerfil, auth);
    }

    public void setInfoExtra(List<Servicio> servicios, Pais pais, Ciudad ciudad, Credencial credencial, List<Idioma> idiomas) {
        this.servicios = servicios;
        this.pais = pais;
        this.ciudad = ciudad;
        this.credencial = credencial;
        this.idiomas = idiomas;
    }

    public List<GuiaDTO> buscarGuias(GuiaDTO guiaDTO) {
        List<Guia> guias = DataBase.getInstance().getGuias();
        return guias.stream()
                .filter(guia ->
                        (guiaDTO.getNombre() == null || guia.getNombre().equalsIgnoreCase(guiaDTO.getNombre())) &&
                        (guiaDTO.getApellido() == null || guia.getApellido().equalsIgnoreCase(guiaDTO.getApellido())) &&
                        (guiaDTO.getIdiomas() == null || guiaDTO.getIdiomas().stream().anyMatch(idioma -> guia.getIdiomas().contains(idioma))) &&
                        (guiaDTO.getServicios() == null || guiaDTO.getServicios().stream().anyMatch(servicioDTO ->
                                guia.getServicios().stream().anyMatch(servicio ->
                                        (servicioDTO.getNombre() == null || servicio.getNombre().equalsIgnoreCase(servicioDTO.getNombre())) &&
                                        (servicioDTO.getDescripcion() == null || servicio.getDescripcion().equalsIgnoreCase(servicioDTO.getDescripcion())) &&
                                        (servicioDTO.getPrecio() == null || servicio.getPrecio().equals(servicioDTO.getPrecio()))
                                )
                        )) &&
                        (guiaDTO.getPuntuacion() == 0.0 || guia.getPuntuacion() >= guiaDTO.getPuntuacion()) &&
                        (guiaDTO.getPais() == null || guia.getPais() == guiaDTO.getPais()) &&
                        (guiaDTO.getCiudad() == null || guia.getCiudad() == guiaDTO.getCiudad())
                )
                .map(GuiaDTO::new)
                .collect(Collectors.toList());
    }

    public Void contratarGuia(Guia guia, Date fechaInicio, Date fechaFin) { // poner en el diagrama nombre de la variable
        // TODO implement here
        //se puede contratar si el guia tiene la credencial hanilitada
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

    public void setServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }

    public void removeServicio(Servicio servicio) {
        this.servicios.remove(servicio);
    }

    public Double getPuntuacion() {
        List<Reseña> reseñas = DataBase.getInstance().getReseñasPorGuia(this);
        return reseñas.stream()
                .mapToDouble(Reseña::getPuntuacion)
                .average()
                .orElse(0.0);
    }

    public Credencial getCredencial() {
        return credencial;
    }
}