package controladores;

import modelos.clases.Viaje;
import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;

import java.time.LocalDate;

public class ViajeController {

    private Viaje viaje;

    public ViajeController(Viaje viaje) {
        this.viaje = viaje;
    }

    public void reservarViaje(LocalDate fechaInicio, LocalDate fechaFin, GuiaDTO guia, TuristaDTO turista){
        // Implementacion

        return;
    }

    public void aceptarViaje(){
        // Implementacion

        return;
    }

    public void cancelarViaje(){
        // Implementacion
        // notificar()

        return;
    }


}
