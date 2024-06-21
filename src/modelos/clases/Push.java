package modelos.clases;

import modelos.interfaces.IEstrategiaNotif;

public class Push implements IEstrategiaNotif {
    public void enviar(Notificacion notificacion) {
        System.out.println("Enviando Push a " +
                notificacion.getDestinatario().getNombre() + " " + notificacion.getDestinatario().getApellido() + ":" +
                "\\n" +
                "Titulo: " + notificacion.getTitulo() + "\\n" + "Mensaje: " + notificacion.getMensaje()
        );
    }

}