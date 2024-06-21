package modelos.clases;

import modelos.interfaces.IAdapterCredencial;

import java.util.stream.Stream;

public class Credencial {
    private String idCredencial;
    private String fotoCredencial;
    private IAdapterCredencial adapter;
    private Notificador notificador;
    private Boolean habilitado;

    public Credencial(String idCredencial, String fotoCredencial, IAdapterCredencial adapter) {
        this.idCredencial = idCredencial;
        this.fotoCredencial = fotoCredencial;
        this.adapter = adapter;
        this.habilitado = false;
    }

    public void verificarCredencial() {
        if (adapter.verificarCredencial(this)) {
            this.habilitado = true;
        }
    }

    public String getIdCredencial() {
        return idCredencial;
    }

    public String getFotoCredencial() {
        return fotoCredencial;
    }

    public void notificar(Guia guia) {
        Notificacion notificacion = new Notificacion(
                "Credencial Validada",
                "Se ha validado su credencial con satisfacción. Ya puede ofrecer sus servicios!",
                guia
        );

        notificador = new Notificador();
        notificador.cambiarEstrategia(new Push());
        notificador.enviar(notificacion);
    }
}