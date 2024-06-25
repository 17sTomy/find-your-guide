package modelos.clases;

import enums.Ciudad;
import enums.Idioma;
import enums.Pais;
import enums.Sexo;
import modelos.DataBase;
import modelos.dtos.GuiaDTO;
import modelos.interfaces.IAuthenticacion;

import java.util.List;
import java.util.stream.Collectors;

public class Guia extends Usuario {
    private List<Servicio> servicios;
    private Pais pais;
    private Ciudad ciudad;
    private Credencial credencial;
    private List<Idioma> idiomas;

    public Guia(String nombre, String apellido, Sexo sexo, String dni, String email, String password, String numTelefono, String fotoPerfil, IAuthenticacion auth, List<Servicio> servicios, Pais pais, Ciudad ciudad, Credencial credencial, List<Idioma> idiomas) {
        super(nombre, apellido, sexo, dni, email, password, numTelefono, fotoPerfil, auth);
        this.servicios = servicios;
        this.pais = pais;
        this.ciudad = ciudad;
        this.credencial = credencial;
        this.idiomas = idiomas;
    }

    public static List<GuiaDTO> buscarGuias(GuiaDTO guiaDTO) {
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

    public Double getPuntuacion() {
        List<Reseña> resenias = DataBase.getInstance().getReseñasPorGuia(this);
        return resenias.stream()
                .mapToDouble(Reseña::getPuntuacion)
                .average()
                .orElse(0.0);
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

    public void setServicio(String nombre, String descripcion, Double precio) {
        Servicio servicio = new Servicio(nombre, descripcion, precio);
        this.servicios.add(servicio);
    }

    public void removeServicio(String nombre) {
        if (this.servicios != null) {
            this.servicios.removeIf(servicio -> servicio.getNombre().equalsIgnoreCase(nombre));
        }
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public List<Reseña> getReseñas(String email) {
        List<Reseña> reseñas = DataBase.getInstance().getViajesPorTurista();
        return reseñas;
    }
}