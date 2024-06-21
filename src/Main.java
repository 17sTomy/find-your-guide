import controladores.GuiaController;
import enums.*;
import modelos.clases.Credencial;
import modelos.clases.Servicio;
import modelos.clases.SistemaVerificacionIA;
import modelos.dtos.GuiaDTO;
import modelos.interfaces.IAdapterCredencial;

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
        Servicio servicio = new Servicio("trabajador", "pala", 5.5);
        Credencial credencial = new Credencial("a", "a", adapCreden);

        GuiaDTO guiaDTO = new GuiaDTO(
                "Jose",
                "Pérez",
                "12345678",
                Sexo.MASCULINO,
                "jose@example.com",
                "123456789",
                "ruta/a/la/foto.jpg",
                "BASICO",
                servicio,
                Pais.ARGENTINA,
                Ciudad.BUENOS_AIRES,
                credencial,
                List.of(Idioma.ESPAÑOL),
                4.5
        );

        // Crear instancia de GuiaController
        GuiaController guiaController = new GuiaController();

        guiaController.registrarGuia(guiaDTO, "123", Auth.BASICO);

        // Iniciar sesión del guia
        guiaController.loginGuia("jose@example.com", "123", Auth.BASICO);
    }
}
