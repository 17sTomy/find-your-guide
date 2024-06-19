package modelos.clases;

import modelos.DataBase;

import javax.xml.crypto.Data;

public class TrofeoReseña extends Trofeo {
    public void darTrofeo(Reseña reseña) {
        Turista turista = reseña.getTurista();
        int cantReseñas = DataBase.getInstance().getReseñasPorTurista(turista).size();

        if(cantReseñas >= 10) {
            turista.setTrofeo(this);
        }
    }
}
