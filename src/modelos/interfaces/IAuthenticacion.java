package modelos.interfaces;

import modelos.clases.Usuario;

public interface IAuthenticacion {
    public void registrarUsuario(Usuario usuario);
    public void loguearUsuario(Usuario usuario);
}
