package controladores;

import enums.Auth;
import modelos.clases.*;
import modelos.dtos.GuiaDTO;
import modelos.dtos.UsuarioDTO;
import modelos.interfaces.IAuthenticacion;

import java.util.List;

public class GuiaController {
    private Guia guia;

    public void registrarGuia(GuiaDTO guiaDTO, String password, Auth modoRegistro){
        
        IAuthenticacion autenticacion = this.convertAuth(modoRegistro);

        Guia nuevoGuia = new Guia(
                guiaDTO.getNombre(),
                guiaDTO.getApellido(),
                guiaDTO.getSexo(),
                guiaDTO.getDni(),
                guiaDTO.getEmail(),
                password,
                guiaDTO.getNumTelefono(),
                guiaDTO.getFotoPerfil(),
                autenticacion,
                guiaDTO.getServicios(),
                guiaDTO.getPais(),
                guiaDTO.getCiudad(),
                guiaDTO.getCredencial(),
                guiaDTO.getIdiomas()
        );

        nuevoGuia.getCredencial().verificarCredencial();
        nuevoGuia.getCredencial().notificar(nuevoGuia);
        nuevoGuia.register();
    }

    public void loginGuia(String email, String password, Auth modoLogin){
        IAuthenticacion autenticacion = this.convertAuth(modoLogin);

        UsuarioDTO infoGuia =  Usuario.login(email, password, autenticacion);
        System.out.println(infoGuia);
    }


    public List<GuiaDTO> buscarGuias(GuiaDTO guiaDTO) {
        return guia.buscarGuias(guiaDTO);
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

    public void agregarServicio(Servicio servicio) {
        guia.setServicio(servicio);
    }

    public void eliminarServicio(Servicio servicio) {
        guia.removeServicio(servicio);
    }
}
