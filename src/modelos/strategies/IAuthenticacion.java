package modelos.strategies;

import clases.Usuario;

public interface IAuthenticacion {
    public void registrarUsuario(Usuario usuario);
    public void loguearUsuario(Usuario usuario);
}
