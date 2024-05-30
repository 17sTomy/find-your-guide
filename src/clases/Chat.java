package clases;

import java.util.List;

/**
 * 
 */
public class Chat {

    /**
     * Default constructor
     */
    public Chat() {
    }

    private Turista turista;

    private Guia guia;

    private List<Mensaje> mensajes;

    private IAdapterChat adapter;

    private ChatController chatController;

    /**
     * @param emisor 
     * @param receptor 
     * @param contenido 
     * @return
     */
    public void enviarMensaje(Usuario emisor, Usuario receptor, String contenido) {
        // TODO implement here
    }

}