package modelos.clases;

import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;
import modelos.dtos.UsuarioDTO;

public class UsuarioDTOFactory {
    public static UsuarioDTO createUsuarioDTO(Usuario usuario) {
        if (usuario instanceof Guia) {
            Guia guia = (Guia) usuario;
            return new GuiaDTO(guia.getNombre(), guia.getApellido(), guia.getDni(), guia.getSexo(), guia.getEmail(), guia.getNumTelefono(), guia.getFotoPerfil(), guia.getAuth(), guia.getServicio(), guia.getPais(), guia.getCiudad(), guia.getCredencial(), guia.getIdiomas(), guia.getPuntuacion());
        } else if (usuario instanceof Turista) {
            Turista turista = (Turista) usuario;
            return new TuristaDTO(turista.getNombre(), turista.getApellido(), turista.getDni(), turista.getSexo(), turista.getEmail(), turista.getNumTelefono(), turista.getFotoPerfil(), turista.getAuth(), turista.getCantViajes());
        } else {
            throw new IllegalArgumentException("Tipo de usuario no soportado para crear DTO.");
        }
    }
}

