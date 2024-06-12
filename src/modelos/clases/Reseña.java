package modelos.clases;

/**
 * 
 */
public class Reseña {
    private Guia guia;
    private Turista turista;
    private Double puntuacion;

    public Reseña(Guia guia, Turista turista, Double puntuacion) {
        this.guia = guia;
        this.turista = turista;
        this.puntuacion = puntuacion;
    }


    public Guia getGuia() {
        return guia;
    }

    public Turista getTurista() {
        return turista;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }
}