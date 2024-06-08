package modelos.interfaces;

import modelos.clases.Usuario;

public interface IAdapterChat {
    public void enviarMensaje(Usuario emisor, Usuario receptor, String contenido);
}
