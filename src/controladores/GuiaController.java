package controladores;

import enums.Auth;
import modelos.DataBase;
import modelos.clases.*;
import modelos.dtos.GuiaDTO;
import modelos.dtos.UsuarioDTO;
import modelos.interfaces.IAuthenticacion;

import java.util.List;

public class GuiaController {
    private static Guia guia;


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
                guiaDTO.convertirCredencial(new SistemaVerificacionIA()),
                guiaDTO.getIdiomas()
        );

        nuevoGuia.getCredencial().verificarCredencial();
        nuevoGuia.getCredencial().notificar(nuevoGuia);
        nuevoGuia.register();
    }

    public boolean loginGuia(String email, String password, Auth modoLogin){
        IAuthenticacion autenticacion = this.convertAuth(modoLogin);

        UsuarioDTO infoGuia =  Usuario.login(email, password, autenticacion);
        if (infoGuia != null) {
            DataBase db = DataBase.getInstance();
            Usuario guia = db.getUsuarioByEmail(email);
            this.guia = (Guia)guia;
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

    public void agregarServicio(String nombre, String descripcion, Double precio) {
        guia.setServicio(nombre, descripcion, precio);
    }

    public String getEmailGuia() {
        return guia.getEmail();
    }

    public void eliminarServicio(String nombre) {
        guia.removeServicio(nombre);
    }

    public List<String> getReseñas(String email) {
        return Guia.getReseñas(email);
    }
}
