package modelos.clases;

import java.util.List;

/**
 * 
 */
public class Paquete extends Servicio {
    private List<Servicio> servicios;

    public Paquete(String nombre, String descripcion, Double precio, List<Servicio> servicios) {
        super(nombre, descripcion, precio);
        this.servicios = servicios;
    }

    public Double getPrecio() {
        // TODO implement here
        return null;
    }

    public void agregarServicio(Servicio servicio) {
        // TODO implement here
    }

    public void eliminarServicio(Servicio servicio) {
        // TODO implement here
    }

}