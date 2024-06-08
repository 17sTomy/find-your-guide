package modelos.interfaces;

import modelos.clases.Notificacion;

public interface IAdapterMail {
    public void enviar(Notificacion notificacion);
}
