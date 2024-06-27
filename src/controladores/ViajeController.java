package controladores;

import enums.EstadoViaje;
import modelos.DataBase;
import modelos.clases.Chat;
import modelos.clases.Guia;
import modelos.clases.Turista;
import modelos.clases.Viaje;
import modelos.dtos.ViajeDTO;

import java.util.List;

public class ViajeController {


    public int crearViaje(ViajeDTO viajeDTO, String emailTurista, String emailGuia){
        DataBase db = DataBase.getInstance();

        Turista turista = (Turista) db.getUsuarioByEmail(emailTurista);
        Guia guia = (Guia) db.getUsuarioByEmail(emailGuia);

        Viaje nuevoViaje = new Viaje(viajeDTO, turista, guia);
        db.addViaje(nuevoViaje);

        return nuevoViaje.getId();
    }

    public void pagarTotalFactura(int idViaje){
        DataBase db = DataBase.getInstance();
        Viaje viaje = db.getViajeById(idViaje);
        viaje.getFactura().pagarTotalFactura();
        System.out.println("Total de la factura pago");
    }

    public void pagarAnticipoFactura(int idViaje){
        DataBase db = DataBase.getInstance();
        Viaje viaje = db.getViajeById(idViaje);
        viaje.getFactura().pagarAnticipoFactura();
        System.out.println("Anticipo pagado");
    }

    public void aceptarReserva(int idViaje){
        DataBase db = DataBase.getInstance();
        Viaje viaje = db.getViajeById(idViaje);
        viaje.getReserva().aceptarReserva();
        System.out.println("Reserva Aceptada");
        db.addChat(new Chat(viaje.getTurista(), viaje.getGuia()));
        System.out.println("Se ha creado un Chat");
    }
    public void rechazarReserva(int idViaje){
        DataBase db = DataBase.getInstance();
        Viaje viaje = db.getViajeById(idViaje);
        viaje.getReserva().cancelarReserva();
        viaje.cancelarViaje();
        System.out.println("Reserva cancelada");
    }

    public List<ViajeDTO> getViajes(String email) {
        return Viaje.getViajesDTO(email);
    }

    public void cambiarEstadoViaje(int idViaje, EstadoViaje estado){
        DataBase db = DataBase.getInstance();
        Viaje viaje = db.getViajeById(idViaje);
        
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
