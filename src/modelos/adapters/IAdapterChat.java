package modelos.adapters;

import clases.Usuario;

public interface IAdapterChat {
    public void enviarMensaje(Usuario emisor, Usuario receptor, String contenido);
}
