package modelos.clases;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {

    private String emisor;
    private String contenido;
    private String hora;
    private Usuario receptor; // TODO eliminar

    public Mensaje(Usuario emisor, String contenido) {
        this.emisor = emisor.getNombre()+" "+emisor.getApellido();
        this.contenido = contenido;
        this.hora =  LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));;
    }

    public void mostrarMensaje(){
        System.out.println(emisor+" "+hora+"\n"+contenido);
    }

}