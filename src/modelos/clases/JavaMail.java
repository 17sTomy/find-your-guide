package modelos.clases;

import modelos.interfaces.IAdapterMail;

public class JavaMail implements IAdapterMail {
    public void enviar(Notificacion notificacion) {
        System.out.println("Enviando Email a " +
                notificacion.getDestinatario().getEmail() + " por JavaMail: \\n" +
                "Titulo: " + notificacion.getTitulo() + "\\n" + "Mensaje: " + notificacion.getMensaje()
        );
    }

}