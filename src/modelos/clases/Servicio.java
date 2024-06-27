package modelos.clases;

public class Servicio {
    private String nombre;
    private String descripcion;
    private Double precio;

    public Servicio(String nombre, String descripcion, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public String toString() {
        return this.nombre;
    }

}