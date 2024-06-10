package modelos.clases;

import modelos.interfaces.IAdapterCredencial;

import java.util.stream.Stream;

public class Credencial {
    private String idCredencial;
    private Stream fotoCredencial;
    private IAdapterCredencial adapter;
    private Notificador notificador;

    public Credencial() {
    }

    public boolean verificarCredencial(Stream credencial) {
        // TODO implement here
        return false;
    }

    public String getIdCredencial() {
        return idCredencial;
    }
}