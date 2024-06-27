package modelos.clases;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    private Turista turista;
    private Guia guia;
    private List<Mensaje> mensajes;

    public Chat(Turista turista, Guia guia) {
        this.turista = turista;
        this.guia = guia;
        this.mensajes = new ArrayList<>();
    }

    public Turista getTurista() {
        return turista;
    }

    public Guia getGuia() {
        return guia;
    }

    private void addMensaje(Mensaje mensaje){
        mensajes.add(mensaje);
    }

    public void abrirChat(){
        if (!mensajes.isEmpty()) {
            for (Mensaje mensaje : mensajes) {
                mensaje.mostrarMensaje();
            }
        }
    }
    public void enviarMensaje(Usuario emisor, String contenido) {
        Mensaje mensaje = new Mensaje(emisor, contenido);
        addMensaje(mensaje);
        mensaje.mostrarMensaje();
    }

}