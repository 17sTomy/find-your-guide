package modelos.clases;

import java.util.ArrayList;
import java.util.List;

public class Reseña {
    private Guia guia;
    private Turista turista;
    private Double puntuacion;
    private String comentario;
    private List<Trofeo> tObservables;

    public Reseña(Guia guia, Turista turista, Double puntuacion, String comentario) {
        this.guia = guia;
        this.turista = turista;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.tObservables = new ArrayList<>();
    }


    public void addObservable(Trofeo trofeo) {
        tObservables.add(trofeo);
    }

    public void removeObservable(Trofeo trofeo) {
        tObservables.remove(trofeo);
    }

    public void notificarObservadores() {
        if (tObservables != null) {
            for (Trofeo trofeo: tObservables) {
                trofeo.darTrofeo(this);
            }
        }
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

    public String getComentario() {
        return comentario;
    }
}