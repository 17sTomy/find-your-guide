package controladores;

import enums.Auth;
import enums.Ciudad;
import enums.Pais;
import modelos.DataBase;
import modelos.clases.*;
import modelos.dtos.TuristaDTO;
import modelos.dtos.UsuarioDTO;
import modelos.dtos.ViajeDTO;
import modelos.interfaces.IAuthenticacion;

import java.time.LocalDate;
import java.util.List;

public class TuristaController {
    private Turista turista;

    public void registrarTurista(TuristaDTO turistaDTO, String password, Auth modoRegistro){
        IAuthenticacion autenticacion = this.convertAuth(modoRegistro);

        Turista nuevoTurista = new Turista(
                turistaDTO.getNombre(),
                turistaDTO.getApellido(),
                turistaDTO.getSexo(),
                turistaDTO.getDni(),
                turistaDTO.getEmail(),
                password,
                turistaDTO.getNumTelefono(),
                turistaDTO.getFotoPerfil(),
                autenticacion
        );

        boolean registroExitoso = nuevoTurista.register();
        System.out.println(registroExitoso);
    }

    public void loginTurista(String email, String password, Auth modoLogin){
        IAuthenticacion autenticacion = this.convertAuth(modoLogin);

        UsuarioDTO infoTurista =  Usuario.login(email, password, autenticacion);
        System.out.println(infoTurista);
    }

    public IAuthenticacion convertAuth(Auth modo) {
        return switch (modo) {
            case APPLEID -> new RegistroAppleId();
            case GOOGLE -> new RegistroGoogle();
            case BASICO -> new RegistroBasico();
            case FACEBOOK -> new RegistroFacebook();
            default -> null;
        };
    }

    public void calificarGuia(Guia guia, Double puntuacion, String comentario) {
        Reseña reseña = new Reseña(
                guia,
                this.turista,
                puntuacion,
                comentario
        );

        TrofeoExito trofeoExito = new TrofeoExito();
        TrofeoReseña trofeoReseña = new TrofeoReseña();

        reseña.addObservable(trofeoExito);
        reseña.addObservable(trofeoReseña);
        reseña.notificarObservadores();

        DataBase.getInstance().setReseñas(reseña);
    }

    public void contratarGuia(Ciudad ciudadDestino, Pais paisDestino, LocalDate fechaInicio, LocalDate fechaFin, Guia guia) {
        List<Viaje> viajesDelGuia = DataBase.getInstance().getViajesPorGuia(guia);
        if (verificarDisponibilidadGuia(viajesDelGuia, fechaInicio, fechaFin)) {
            DataBase.getInstance().addViaje(new Viaje(new ViajeDTO(ciudadDestino,paisDestino,fechaInicio,fechaFin), this.turista, guia));
        }
    }

    public boolean verificarDisponibilidadGuia(List<Viaje> viajes, LocalDate fechaInicio, LocalDate fechaFin) {
        if (fechaInicio.isBefore(fechaFin) || fechaInicio.isEqual(fechaFin)){
            return viajes.stream()
                        .filter(viaje -> fechaFin.isBefore(viaje.getFechaInicio()) || fechaInicio.isAfter(viaje.getFechaFin()))
                    .count() == 0;
        }
        return false;
    }
}
