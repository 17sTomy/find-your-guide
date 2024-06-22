import controladores.GuiaController;
import enums.*;
import modelos.clases.*;
import modelos.dtos.GuiaDTO;
import modelos.dtos.UsuarioDTO;
import modelos.interfaces.IAdapterCredencial;
import modelos.interfaces.IAuthenticacion;

import java.util.List;

public class Main {
    public static void main(String[] args) {
/*
        // Crear instancia de TuristaController
        TuristaController turistaController = new TuristaController();

        // Datos del nuevo turista
        TuristaDTO nuevoTuristaDTO = new TuristaDTO(
                "Juan",
                "Pérez",
                "12345678",
                Sexo.MASCULINO,
                "juan@example.com",
                "123456789",
                "ruta/a/la/foto.jpg",
                "BASICO",
                0
        );

        // Modo de registro (por ejemplo, registro básico)
        Auth modoRegistro = Auth.BASICO;

        // Modo de inicio de sesión (por ejemplo, autenticación básica)
        Auth modoLogin = Auth.BASICO;

        // Registrar al nuevo turista
        turistaController.registrarTurista(nuevoTuristaDTO, "password123", modoRegistro);

        // Datos de inicio de sesión
        String email = "juan@example.com";
        String password = "password123";

        // Iniciar sesión del turista
        turistaController.loginTurista(email, password, modoLogin);

*/
        //////////////////
        // PRUEBA GUIA //
        //////////////////

        // Crear GuiaDTO
        IAdapterCredencial adapCreden = new SistemaVerificacionIA();
        Servicio servicios = new Servicio("trabajador", "pala", 5.5);
        Credencial credencial = new Credencial("a", "a", adapCreden);
        Guia guia = new Guia(
                "Jose",
                "Pérez",
                Sexo.MASCULINO,
                "dni:4324324",
                "jose@example.com",
                "123",
                "123456789",
                "ruta/a/la/foto.jpg",
                new IAuthenticacion() {
                    @Override
                    public boolean register(Usuario usuario) {
                        return false;
                    }

                    @Override
                    public UsuarioDTO login(String email, String password) {
                        return null;
                    }
                },
                List.of(servicios),
                Pais.ARGENTINA,
                Ciudad.BUENOS_AIRES,
                credencial,
                List.of(Idioma.ESPAÑOL)
        );

        GuiaDTO guiaDTO = new GuiaDTO(guia);

        // Crear instancia de GuiaController
        GuiaController guiaController = new GuiaController();

        guiaController.registrarGuia(guiaDTO, "123", Auth.BASICO);

        // Iniciar sesión del guia
        guiaController.loginGuia("jose@example.com", "123", Auth.BASICO);
    }
}
