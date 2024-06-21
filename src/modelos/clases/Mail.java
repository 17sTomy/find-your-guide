package modelos.clases;

import modelos.interfaces.IAdapterMail;
import modelos.interfaces.IEstrategiaNotif;


public class Mail implements IEstrategiaNotif {
    private IAdapterMail adapter;

    public void setAdapter(IAdapterMail adapter) {
        this.adapter = adapter;
    }

    public Mail(IAdapterMail adapter) {
        super();
        this.adapter = adapter;
    }

    public void enviar(Notificacion notificacion) {
        this.adapter.enviar(notificacion);
    }
}