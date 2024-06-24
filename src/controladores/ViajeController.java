package controladores;

import enums.EstadoViaje;
import modelos.DataBase;
import modelos.clases.Guia;
import modelos.clases.Turista;
import modelos.clases.Usuario;
import modelos.clases.Viaje;
import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;
import modelos.dtos.ViajeDTO;

import java.time.LocalDate;
import java.util.List;

public class ViajeController {


    public void crearViaje(ViajeDTO viajeDTO, String emailTurista, String emailGuia){
        DataBase db = DataBase.getInstance();

        Turista turista = (Turista) db.getUsuarioByEmail(emailTurista);
        Guia guia = (Guia) db.getUsuarioByEmail(emailGuia);

        Viaje nuevoViaje = new Viaje(viajeDTO, turista, guia);
        db.addViaje(nuevoViaje);
    }

    public void pagarFactura(Viaje viaje){
        viaje.getFactura().pagarFactura();
    }

    public void aceptarReserva(Viaje viaje){
        viaje.getReserva().aceptarReserva();
    }
    public void rechazarReserva(Viaje viaje){
        viaje.cancelarViaje();
    }

    public List<Viaje> buscarViajesPorGuia(Guia guia){
        return DataBase.getInstance().getViajesPorGuia(guia);
    }

    public void cambiarEstadoViaje(Viaje viaje, EstadoViaje estado){
        switch (estado) {
            case Iniciado:
                viaje.iniciarViaje();
                break;
            case Cancelado:
                viaje.cancelarViaje();
                break;
            case Finalizado:
                viaje.finalizarViaje();
                break;
            default:
                break;
        }
    }




}
