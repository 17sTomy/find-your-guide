package modelos.clases;

import modelos.DataBase;

public class TrofeoExito extends Trofeo {
    public void darTrofeo(Reseña reseña) {
        Guia guia = reseña.getGuia();
        int cantReseñas = DataBase.getInstance().getReseñasPorGuia(guia).size();
        Double puntuacion = guia.getPuntuacion();

        if(cantReseñas >= 10 && puntuacion >= 4.5) {
            guia.setTrofeo(this);
        }
    }
}
