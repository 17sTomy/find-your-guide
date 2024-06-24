import controladores.GuiaController;
import controladores.ViajeController;
import enums.*;
import modelos.clases.*;
import modelos.dtos.GuiaDTO;
import modelos.dtos.ViajeDTO;
import modelos.interfaces.IAdapterCredencial;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        // Datos del nuevo turista
        RegistroBasico autenticacion = new RegistroBasico();
        Turista turista = new Turista(
                "Juan",
                "Pérez",
                Sexo.MASCULINO,
                "12345678",
                "juan@example.com",
                "password123",
                "123456789",
                "ruta/a/la/foto.jpg",
                autenticacion
        );/*

        TuristaDTO nuevoTuristaDTO = new TuristaDTO(turista);

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
        turistaController.loginTurista(email, password, modoLogin);*/


        //////////////////
        // PRUEBA GUIA //
        //////////////////

        // Crear GuiaDTO
        IAdapterCredencial adapCreden = new SistemaVerificacionIA();
        Servicio servicios = new Servicio("trabajador", "pala", 5.5);
        Credencial credencial = new Credencial("a", "a", adapCreden);
        RegistroBasico autenticacionGuia = new RegistroBasico();
        Guia guia = new Guia(
                "Jose",
                "Pérez",
                Sexo.MASCULINO,
                "dni:4324324",
                "jose@example.com",
                "123",
                "123456789",
                "ruta/a/la/foto.jpg",
                autenticacionGuia,
                List.of(servicios),
                Pais.ARGENTINA,
                Ciudad.BUENOS_AIRES,
                credencial,
                List.of(Idioma.ESPAÑOL)
        );
        GuiaDTO guiaDTO = new GuiaDTO(guia);


        // Crear instancia de GuiaController
        GuiaController guiaController = new GuiaController();

        //Acciones
        guiaController.registrarGuia(guiaDTO, "123", Auth.BASICO);
        guiaController.loginGuia("jose@example.com", "123", Auth.BASICO);


        //////////////////
        // PRUEBA VIAJE //
        //////////////////
        ViajeController viajeController = new ViajeController();

        ViajeDTO viajeDTO = new ViajeDTO(
                Ciudad.ABU_DABI, Pais.ALBANIA,
                LocalDate.of(2024, 6, 20),
                LocalDate.of(2024, 7, 5)
        );

        viajeController.crearViaje(viajeDTO, "juan@example.com", "jose@example.com");






    }

}
