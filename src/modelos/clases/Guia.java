package modelos.clases;

import enums.Ciudad;
import enums.Idioma;
import enums.Pais;
import enums.Sexo;
import modelos.DataBase;
import modelos.interfaces.IAuthenticacion;

import java.util.Date;
import java.util.List;

public class Guia extends Usuario {
    private Servicio servicio;
    private Pais pais;
    private Ciudad ciudad;
    private Credencial credencial;
    private List<Idioma> idiomas; //agregar atributo y enum en el diagrama

    public Guia(String nombre, String apellido, Sexo sexo, String dni, String email, String password, String numTelefono, String fotoPerfil, IAuthenticacion auth) {
        super(nombre, apellido, sexo, dni, email, password, numTelefono, fotoPerfil, auth);
    }

    public void setInfoExtra(Servicio servicio, Pais pais, Ciudad ciudad, Credencial credencial, List<Idioma> idiomas) {
        this.servicio = servicio;
        this.pais = pais;
        this.ciudad = ciudad;
        this.credencial = credencial;
        this.idiomas = idiomas;
    }
/* REHACER EL METODO PORQUE NO FUNCIONA CON EL NUEVO CONTRUCTOR DE GuiaDTO, ya que necesitaba que le pasen el un Guia como parametro en el contructor
    public List<GuiaDTO> buscarGuias(GuiaDTO guiaDTO) {
        List<Guia> guias = DataBase.getInstance().getGuias();
        return guias.stream()
                .filter(guia ->
                        (guiaDTO.getNombre() == null || guia.getNombre().equalsIgnoreCase(guiaDTO.getNombre())) &&
                                (guiaDTO.getApellido() == null || guia.getApellido().equalsIgnoreCase(guiaDTO.getApellido())) &&
                                (guiaDTO.getIdiomas() == null || guiaDTO.getIdiomas().stream().anyMatch(idioma -> guia.getIdiomas().contains(idioma))) &&
                                (guiaDTO.getServicio() == null || guia.getServicio() == guiaDTO.getServicio()) &&
                                (guiaDTO.getPuntuacion() == 0.0 || guia.getPuntuacion() >= guiaDTO.getPuntuacion()) &&
                                (guiaDTO.getPais() == null || guia.getPais() == guiaDTO.getPais()) &&
                                (guiaDTO.getCiudad() == null || guia.getCiudad() == guiaDTO.getCiudad())
                )
                .map(GuiaDTO::new)
                .collect(Collectors.toList());
    }
*/
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

    public Servicio getServicio() {
        return servicio;
    }

    public Double getPuntuacion() {
        DataBase db = DataBase.getInstance();
        List<Reseña> resenias = db.getResenias();
        Double puntuacion = 0.0;
        Integer contador = 0;
        for (Reseña resenia : resenias) {
            if (resenia.getGuia().getEmail().equals(this.getEmail())) {
                puntuacion += resenia.getPuntuacion();
                contador += 1;
            }
        }
        if (contador == 0) {
            return 0.0;
        }
        return puntuacion / contador;
    }



    public Credencial getCredencial() {
        return credencial;
    }

}