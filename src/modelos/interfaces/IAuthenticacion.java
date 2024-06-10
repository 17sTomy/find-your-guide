package modelos.interfaces;

import modelos.clases.Usuario;
import modelos.dtos.UsuarioDTO;

public interface IAuthenticacion {
    public boolean register(Usuario usuario);
    public UsuarioDTO login(String email, String password);
}
