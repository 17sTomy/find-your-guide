package modelos.clases;

import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;
import modelos.dtos.UsuarioDTO;

public class UsuarioDTOFactory {
    public static UsuarioDTO createUsuarioDTO(Usuario usuario) {
        if (usuario instanceof Guia) {
            Guia guia = (Guia) usuario;
            return new GuiaDTO(guia);
        } else if (usuario instanceof Turista) {
            Turista turista = (Turista) usuario;
            return new TuristaDTO(turista.getNombre(), turista.getApellido(), turista.getDni(), turista.getSexo(), turista.getEmail(), turista.getNumTelefono(), turista.getFotoPerfil(), turista.getAuth());
        } else {
            throw new IllegalArgumentException("Tipo de usuario no soportado para crear DTO.");
        }
    }
}

