package controladores;

import modelos.clases.*;
import enums.Auth;
import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;
import modelos.dtos.UsuarioDTO;
import modelos.interfaces.IAuthenticacion;

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

    public void calificarGuia(TuristaDTO turistaDTO, GuiaDTO guiaDTO, double puntuacion, String comentario){
        // Implementacion
        return;
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


}
