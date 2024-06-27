import controladores.GuiaController;
import controladores.TuristaController;
import controladores.ViajeController;
import enums.*;
import modelos.clases.*;
import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;
import modelos.dtos.ViajeDTO;
import modelos.interfaces.IAdapterCredencial;
import vistas.turista.TuristaLandingPage;

import javax.swing.*;
import java.util.List;
import java.time.LocalDate;

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
        );

        TuristaDTO nuevoTuristaDTO = new TuristaDTO(turista);

        RegistroBasico autenticacion1 = new RegistroBasico();
        Turista turista1 = new Turista(
                "Maria",
                "Gomez",
                Sexo.FEMENINO,
                "87654321",
                "maria@example.com",
                "password456",
                "987654321",
                "ruta/a/la/foto1.jpg",
                autenticacion1
        );
        TuristaDTO nuevoTuristaDTO1 = new TuristaDTO(turista1);

        RegistroBasico autenticacion2 = new RegistroBasico();
        Turista turista2 = new Turista(
                "Carlos",
                "Lopez",
                Sexo.MASCULINO,
                "56781234",
                "carlos@example.com",
                "password789",
                "456789123",
                "ruta/a/la/foto2.jpg",
                autenticacion2
        );
        TuristaDTO nuevoTuristaDTO2 = new TuristaDTO(turista2);

        RegistroBasico autenticacion3 = new RegistroBasico();
        Turista turista3 = new Turista(
                "Ana",
                "Martinez",
                Sexo.FEMENINO,
                "43218765",
                "ana@example.com",
                "password012",
                "321654987",
                "ruta/a/la/foto3.jpg",
                autenticacion3
        );
        TuristaDTO nuevoTuristaDTO3 = new TuristaDTO(turista3);


        // Modo de registro (por ejemplo, registro básico)
        Auth modoRegistro = Auth.BASICO;

        // Modo de inicio de sesión (por ejemplo, autenticación básica)
        Auth modoLogin = Auth.BASICO;

        // Crear instancia de turistaController
        TuristaController turistaController = new TuristaController();


        //Registrar al nuevo turista
        turistaController.registrarTurista(nuevoTuristaDTO, "password123", modoRegistro);

        // Datos de inicio de sesión
        String email = "juan@example.com";
        String password = "password123";

        // Iniciar sesión del turista
        turistaController.loginTurista(email, password, modoLogin);


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


        IAdapterCredencial adapCreden1 = new SistemaVerificacionIA();
        Servicio servicios1 = new Servicio("guía turístico", "guía en tours históricos", 10.0);
        Credencial credencial1 = new Credencial("b", "fotoB.jpg", adapCreden1);
        RegistroBasico autenticacionGuia1 = new RegistroBasico();
        Guia guia1 = new Guia(
                "Maria",
                "Gonzalez",
                Sexo.FEMENINO,
                "dni:1234567",
                "maria@example.com",
                "password123",
                "987654321",
                "ruta/a/la/foto1.jpg",
                autenticacionGuia1,
                List.of(servicios1),
                Pais.BRASIL,
                Ciudad.RIO_DE_JANEIRO,
                credencial1,
                List.of(Idioma.PORTUGUES)
        );
        GuiaDTO guiaDTO1 = new GuiaDTO(guia1);


        IAdapterCredencial adapCreden2 = new SistemaVerificacionIA();
        Servicio servicios2 = new Servicio("fotógrafo", "fotografía en tours", 15.0);
        Credencial credencial2 = new Credencial("c", "fotoC.jpg", adapCreden2);
        RegistroBasico autenticacionGuia2 = new RegistroBasico();
        Guia guia2 = new Guia(
                "Luis",
                "Martinez",
                Sexo.MASCULINO,
                "dni:9876543",
                "luis@example.com",
                "password456",
                "123123123",
                "ruta/a/la/foto2.jpg",
                autenticacionGuia2,
                List.of(servicios2),
                Pais.MEXICO,
                Ciudad.CIUDAD_DE_MEXICO,
                credencial2,
                List.of(Idioma.ESPAÑOL)
        );
        GuiaDTO guiaDTO2 = new GuiaDTO(guia2);


        IAdapterCredencial adapCreden3 = new SistemaVerificacionIA();
        Servicio servicios3 = new Servicio("conductor", "conductor de vehículos turísticos", 20.0);
        Credencial credencial3 = new Credencial("d", "fotoD.jpg", adapCreden3);
        RegistroBasico autenticacionGuia3 = new RegistroBasico();
        Guia guia3 = new Guia(
                "Ana",
                "Lopez",
                Sexo.FEMENINO,
                "dni:7654321",
                "ana@example.com",
                "password789",
                "456456456",
                "ruta/a/la/foto3.jpg",
                autenticacionGuia3,
                List.of(servicios3),
                Pais.ESPAÑA,
                Ciudad.MADRID,
                credencial3,
                List.of(Idioma.ESPAÑOL, Idioma.INGLES)
        );
        GuiaDTO guiaDTO3 = new GuiaDTO(guia3);

        ViajeDTO viajeDTO1 = new ViajeDTO(
                Ciudad.MADRID,
                Pais.ESPAÑA,
                LocalDate.of(2024, 7, 1),
                LocalDate.of(2024, 7, 15)
        );

        ViajeDTO viajeDTO2 = new ViajeDTO(
                Ciudad.PARIS,
                Pais.FRANCIA,
                LocalDate.of(2024, 8, 1),
                LocalDate.of(2024, 8, 15)
        );

        Viaje viaje = new Viaje(
                viajeDTO1,
                turista1,
                guia1
        );

        Viaje viaje2 = new Viaje(
                viajeDTO2,
                turista2,
                guia2
        );

        Reseña reseña = new Reseña (
                guia1,
                turista1,
                5.0,
                "bueno"
        );

        Reseña reseña2 = new Reseña (
                guia1,
                turista2,
                2.0,
                "malo"
        );


        // Crear instancia de GuiaController
        GuiaController guiaController = new GuiaController();



        //Acciones
        guiaController.registrarGuia(guiaDTO, "123", Auth.BASICO);
        guiaController.loginGuia("jose@example.com", "123", Auth.BASICO);

        // Crear instancia de GuiaController
        ViajeController viajecontroller = new ViajeController();


        SwingUtilities.invokeLater(() -> {
            new TuristaLandingPage(turistaController, guiaController, viajecontroller);
        });

        //////////////////
        // PRUEBA VIAJE //
        //////////////////
        //ViajeController viajeController = new ViajeController();

        //ViajeDTO viajeDTO = new ViajeDTO(
        //        Ciudad.ABU_DABI, Pais.ALBANIA,
        //        LocalDate.of(2024, 6, 20),
        //        LocalDate.of(2024, 7, 5)
        //);

        //viajeController.crearViaje(viajeDTO, "juan@example.com", "jose@example.com");






    }

}