package modelos;

import modelos.clases.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataBase {
    private static DataBase instance;
    private List<Usuario> usuarios;
    private List<Reseña> reseñas;
    private List<Viaje> viajes;

    private DataBase() {
        usuarios = new ArrayList<>();
        reseñas = new ArrayList<>();
        viajes = new ArrayList<>();
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

    public List<Reseña> getReseñas(){
        return reseñas;
    }

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

    public List<Reseña> getReseñasPorEmail(String email) {
        if (reseñas != null) {
            return reseñas.stream()
                    .filter(reseña -> reseña.getGuia().getEmail().equals(email))
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

    public void addViaje(Viaje viaje) {
        viajes.add(viaje);
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public List<Viaje> getViajesPorTurista(Turista turista){
        if (viajes != null) {
            return viajes.stream()
                    .filter(viaje -> viaje.getTurista().equals(turista))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();

    }

    public Viaje getViajeById(int id){
        for (Viaje viaje : viajes) {
            if (viaje.getId() == (id)) {
                return viaje;
            }
        }
        return null;
    }

    public List<Viaje> getViajesPorEmail(String email){
        if (viajes != null) {
            return viajes.stream()
                    .filter(viaje -> viaje.getTurista().getEmail().equals(email))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();

    }

    public List<Viaje> getViajesPorGuia(Guia guia){
        if (viajes != null) {
            return viajes.stream()
                    .filter(viaje -> viaje.getGuia().equals(guia))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
