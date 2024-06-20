package modelos.clases;

import modelos.DataBase;

public class TrofeoExito extends Trofeo {
    public void darTrofeo(Reseña reseña) {
        Guia guia = reseña.getGuia();
        int cantReseñas = DataBase.getInstance().getReseñasPorGuia(guia).size();
        Double puntuacion = guia.getPuntuacion();

        if(cantReseñas >= 10 && puntuacion >= 4.5) {
            guia.setTrofeo(this);
            notificar(guia);
        }
    }

    public void notificar(Usuario guia) {
        Notificacion notificacion = new Notificacion(
                "Has ganado un Trofeo",
                "Ganaste un Trofeo al Éxito por Obtener una puntuación promedio mayor a 4.5 en mas de 10 Reseñas",
                guia
        );

        this.notificador = new Notificador(new Push());

        this.notificador.enviar(notificacion);
    }
}
