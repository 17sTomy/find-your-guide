package modelos.clases;

public abstract class Trofeo {
    protected Notificador notificador;

    public abstract void darTrofeo(Reseña reseña);

    public abstract void notificar(Usuario usuaio);
}
