package modelos;

import modelos.clases.Guia;
import modelos.clases.Reseña;
import modelos.clases.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataBase {
    private static DataBase instance;
    private List<Usuario> usuarios;
    private List<Reseña> resenias;
    private DataBase() {
        usuarios = new ArrayList<>();
        //reseñas = new ArrayList<>();
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

    public List<Guia> getGuias() {
        return usuarios.stream()
                .filter(usuario -> usuario instanceof Guia)
                .map(usuario -> (Guia) usuario)
                .collect(Collectors.toList());
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

    public List<Reseña> getResenias(){
        return resenias;
    }
    /*
    public void setReseñas(Reseña reseña) {
        reseñas.add(reseña);
    }

    public List<Reseña> getReseñasPorGuia(Guia guia) {
        if (reseñas != null) {
            return reseñas.stream()
                    .filter(reseña -> reseña.getGuia().equals(guia))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Reseña> getReseñasPorTurista(Turista turista) {
        if (reseñas != null) {
            return reseñas.stream()
                    .filter(reseña -> reseña.getTurista().equals(turista))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
     */
}
