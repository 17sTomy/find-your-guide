package modelos;

import modelos.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static DataBase instance;
    private List<Usuario> usuarios;

    private DataBase() {
        usuarios = new ArrayList<>();
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean usuarioExiste(String dni, String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni) || usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuarioByEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }
}
