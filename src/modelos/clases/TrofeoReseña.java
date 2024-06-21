package modelos.clases;

import modelos.DataBase;

import javax.xml.crypto.Data;

public class TrofeoReseña extends Trofeo {
    public void darTrofeo(Reseña reseña) {
        Turista turista = reseña.getTurista();
        int cantReseñas = DataBase.getInstance().getReseñasPorTurista(turista).size();

        if(cantReseñas >= 10) {
            turista.setTrofeo(this);
            notificar(turista);
        }
    }

    public void notificar(Usuario turista) {
        Notificacion notificacion = new Notificacion(
                "Has ganado un Trofeo",
                "Ganaste un Trofeo a la Reseña por Realizar mas de 10 Reseñas",
                turista
        );

        this.notificador = new Notificador(new Push());

        this.notificador.enviar(notificacion);
    }
}
