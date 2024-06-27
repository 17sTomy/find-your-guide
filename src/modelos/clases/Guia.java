package modelos.clases;

import enums.Ciudad;
import enums.Idioma;
import enums.Pais;
import enums.Sexo;
import modelos.DataBase;
import modelos.dtos.CredencialDTO;
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

    public static List<GuiaDTO> buscarGuias(String nombre, String apellido, String idioma, String servicio, Double puntuacion, Pais pais, Ciudad ciudad) {
        List<Guia> guias = DataBase.getInstance().getGuias();
        return guias.stream()
                .filter(guia ->
                        (nombre == null || guia.getNombre().equalsIgnoreCase(nombre)) &&
                                (apellido == null || guia.getApellido().equalsIgnoreCase(apellido)) &&
                                (idioma == null || guia.getIdiomas().stream().anyMatch(i -> i.name().equalsIgnoreCase(idioma))) &&
                                (servicio == null || guia.getServicios().stream().anyMatch(s -> s.getNombre().equalsIgnoreCase(servicio))) &&
                                (puntuacion == null || guia.getPuntuacion() >= puntuacion) &&
                                (pais == null || guia.getPais() == pais) &&
                                (ciudad == null || guia.getCiudad() == ciudad)
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


    public static List<String> getReseñas(String email) {
        List<Reseña> listadoReseñas = DataBase.getInstance().getReseñasPorEmail(email);
        List<String> reseñas = listadoReseñas.stream()
                .map(reseña -> {
                    Turista turista = reseña.getTurista();
                    Guia guia = reseña.getGuia();
                    return String.format("El turista %s %s realizó una reseña sobre el guía %s %s:\nPuntuación: %.1f\nComentario: %s",
                            turista.getNombre(),
                            turista.getApellido(),
                            guia.getNombre(),
                            guia.getApellido(),
                            reseña.getPuntuacion(),
                            reseña.getComentario());
                })
                .collect(Collectors.toList());
        return reseñas;
    }
}