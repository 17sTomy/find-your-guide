package modelos.clases;

import modelos.DataBase;
import modelos.dtos.UsuarioDTO;
import modelos.interfaces.IAuthenticacion;

public class RegistroFacebook implements IAuthenticacion {
    DataBase db = DataBase.getInstance();

    public boolean register(Usuario usuario) {
        if(!db.usuarioExiste(usuario.getDni(), usuario.getEmail())) {
            db.addUsuario(usuario);
            return true;
        };
        return false;
    }

    public UsuarioDTO login(String email, String password) {
        Usuario usuario = db.getUsuarioByEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return UsuarioDTOFactory.createUsuarioDTO(usuario);
        }
        return null;
    }

    public String toString() {
        return "Facebook";
    }
}