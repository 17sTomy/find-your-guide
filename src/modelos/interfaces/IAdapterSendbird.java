package modelos.interfaces;

import modelos.clases.Usuario;

public interface IAdapterSendbird {
    public void enviarMensaje(Usuario emisor, Usuario receptor, String contenido);
}
