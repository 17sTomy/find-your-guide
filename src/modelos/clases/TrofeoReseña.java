package modelos.clases;

public class TrofeoReseña extends Trofeo {
    public void darTrofeo(Reseña reseña) {
        Turista turista = reseña.getTurista();
        int cantReseñas = turista.getCantReseñas();

        if(cantReseñas > 10) {
            turista.setTrofeo(this);
        }
    }
}
