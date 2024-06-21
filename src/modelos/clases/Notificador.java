package modelos.clases;

import modelos.interfaces.IEstrategiaNotif;

public class Notificador {
    private IEstrategiaNotif estrategiaNotificacion;

    public void enviar(Notificacion notificacion) {
        estrategiaNotificacion.enviar(notificacion);
    }

    public void cambiarEstrategia(IEstrategiaNotif estrategiaNotificacion) {
        this.estrategiaNotificacion = estrategiaNotificacion;
    }
}