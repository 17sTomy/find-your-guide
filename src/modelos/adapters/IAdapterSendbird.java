package modelos.adapters;

import clases.Usuario;

public interface IAdapterSendbird {
    public void enviarMensaje(Usuario emisor, Usuario receptor, String contenido);
}
