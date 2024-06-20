package modelos.clases;

/**
 * 
 */
public class Notificacion {
    private String titulo;
    private String mensaje;
    private Usuario destinatario;

    public Notificacion(String titulo, String mensaje, Usuario destinatario) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }
}