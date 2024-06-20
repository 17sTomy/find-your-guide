package modelos.clases;

import modelos.interfaces.IAdapterCredencial;

import java.util.stream.Stream;

public class Credencial {
    private String idCredencial;
    private Stream fotoCredencial;
    private IAdapterCredencial adapter;
    private Notificador notificador;


    public boolean verificarCredencial(Stream credencial) {
        return false;
    }

    public String getIdCredencial() {
        return idCredencial;
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