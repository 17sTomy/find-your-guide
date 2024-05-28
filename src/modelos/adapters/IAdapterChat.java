package modelos.adapters;

public interface IAdapterChat {
    public void enviarMensaje(Usuario emisor, Usuario receptor, String contenido);
}
