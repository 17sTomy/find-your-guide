package controladores;

import enums.Auth;
import enums.Ciudad;
import enums.Pais;
import modelos.DataBase;
import modelos.clases.*;
import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;
import modelos.dtos.UsuarioDTO;
import modelos.interfaces.IAuthenticacion;

import java.time.LocalDate;
import java.util.List;

public class TuristaController {
    private static Turista turista;

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

    public boolean loginTurista(String email, String password, Auth modoLogin){
        IAuthenticacion autenticacion = this.convertAuth(modoLogin);

        UsuarioDTO infoTurista =  Usuario.login(email, password, autenticacion);
        if (infoTurista != null) {
            DataBase db = DataBase.getInstance();
            Usuario turista = db.getUsuarioByEmail(email);
            this.turista = (Turista)turista;
            return true;
        };
        return false;
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

    public GuiaDTO getGuiaByEmail(String email) {
        DataBase db = DataBase.getInstance();
        Guia guia = (Guia) db.getUsuarioByEmail(email);
        return new GuiaDTO(guia);
    }

    public List<GuiaDTO> buscarGuias(String nombre, String apellido, String idioma, String servicio, Double puntuacion, Pais pais, Ciudad ciudad) {
        return Guia.buscarGuias(nombre, apellido, idioma, servicio, puntuacion, pais, ciudad);
    }

    public void calificarGuia(String emailGuia, String emailTurista, Double puntuacion, String comentario) {
        Guia guia = DataBase.getInstance().getGuiaPorEmail(emailGuia);
        Turista turista = DataBase.getInstance().getTuristaPorEmail(emailTurista);

        Reseña reseña = new Reseña(
                guia,
                turista,
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

    public boolean verificarDisponibilidadGuia(String email, LocalDate fechaInicio, LocalDate fechaFin) {
        List<Viaje> viajes = DataBase.getInstance().getViajesPorEmail(email);
        if (fechaInicio.isBefore(fechaFin)){
            return (viajes.stream().filter(viaje -> fechaFin.isBefore(viaje.getFechaInicio()) || fechaInicio.isAfter(viaje.getFechaFin())).count()) == 0;
        }
        return false;
    }

    public TuristaDTO getTuristaDTO() {
        return new TuristaDTO(this.turista);
    }

}
