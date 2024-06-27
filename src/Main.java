import controladores.GuiaController;
import controladores.TuristaController;

import controladores.ViajeController;
import enums.*;
import modelos.clases.*;
import modelos.dtos.CredencialDTO;
import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;
import modelos.dtos.ViajeDTO;
import modelos.interfaces.IAdapterCredencial;
import vistas.guia.GuiaLandingPage;
import vistas.logueo.SeleccionRol;
import vistas.turista.TuristaLandingPage;

import javax.swing.*;
import java.util.List;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Creacion Turistas
        TuristaController turistaController = new TuristaController();
        GuiaController guiaController = new GuiaController();
        ViajeController viajeController = new ViajeController();


        TuristaDTO turista1 = new TuristaDTO(
                "Pepe",
                "Pérez",
                "1234",
                Sexo.MASCULINO,
                "pepe@example.com",
                "123456789",
                "ruta/a/la/foto.jpg",
                "BASICO",
                0
        );
        turistaController.registrarTurista(turista1, "pass1", Auth.BASICO);


        TuristaDTO turista2 = new TuristaDTO(
                "Juana",
                "Gómez",
                "5678",
                Sexo.FEMENINO,
                "juana@example.com",
                "987654321",
                "ruta/a/la/foto2.jpg",
                "BASICO",
                0
        );
        turistaController.registrarTurista(turista2, "pass2", Auth.BASICO);


        TuristaDTO turista3 = new TuristaDTO(
                "Juan",
                "Rodríguez",
                "91011",
                Sexo.MASCULINO,
                "juan@example.com",
                "123123123",
                "ruta/a/la/foto3.jpg",
                "APPLEID",
                0
        );
        turistaController.registrarTurista(turista3, "pass3", Auth.APPLEID);


        TuristaDTO turista4 = new TuristaDTO(
                "Silvina",
                "Fernández",
                "1213",
                Sexo.FEMENINO,
                "silvina@example.com",
                "456456456",
                "ruta/a/la/foto4.jpg",
                "GOOGLE",
                0
        );
        turistaController.registrarTurista(turista4, "google", Auth.GOOGLE);


        TuristaDTO turista5 = new TuristaDTO(
                "Marcos",
                "Torres",
                "1415",
                Sexo.MASCULINO,
                "marcos@example.com",
                "789789789",
                "ruta/a/la/foto5.jpg",
                "FACEBOOK",
                0
        );
        turistaController.registrarTurista(turista5, "facebook", Auth.FACEBOOK);


        // Creacion Guias
        CredencialDTO credencial1 = new CredencialDTO("123", "ruta/a/la/foto1.jpg");
        GuiaDTO guia1 = new GuiaDTO(
                "Jose",
                "Pérez",
                "12345678",
                Sexo.MASCULINO,
                "jose@example.com",
                "123",
                "ruta/a/la/foto.jpg",
                "BASICO",
                List.of(new Servicio("Tour por la ciudad", "Un tour guiado por la ciudad", 50.0)),
                Pais.ARGENTINA,
                Ciudad.BUENOS_AIRES,
                credencial1,
                List.of(Idioma.ESPAÑOL),
                6.5
        );
        guiaController.registrarGuia(guia1, "pass1", Auth.BASICO);


        CredencialDTO credencial2 = new CredencialDTO("124", "ruta/a/la/foto2.jpg");
        GuiaDTO guia2 = new GuiaDTO(
                "Ana",
                "González",
                "23456789",
                Sexo.FEMENINO,
                "ana@example.com",
                "124",
                "ruta/a/la/foto2.jpg",
                "FACEBOOK",
                List.of(new Servicio("Excursión a la montaña", "Una excursión guiada a la montaña", 70.0)),
                Pais.CHILE,
                Ciudad.SANTIAGO,
                credencial2,
                List.of(Idioma.INGLES, Idioma.ESPAÑOL),
                2.4
        );
        guiaController.registrarGuia(guia2, "facebook", Auth.FACEBOOK);


        CredencialDTO credencial3 = new CredencialDTO("125", "ruta/a/la/foto3.jpg");
        GuiaDTO guia3 = new GuiaDTO(
                "Carlos",
                "Martínez",
                "34567890",
                Sexo.MASCULINO,
                "carlos@example.com",
                "125",
                "ruta/a/la/foto3.jpg",
                "GOOGLE",
                List.of(new Servicio("Visita al museo", "Una visita guiada al museo", 30.0)),
                Pais.ESPAÑA,
                Ciudad.MADRID,
                credencial3,
                List.of(Idioma.ESPAÑOL, Idioma.FRANCES),
                4.8
        );
        guiaController.registrarGuia(guia3, "pass3", Auth.GOOGLE);


        CredencialDTO credencial4 = new CredencialDTO("126", "ruta/a/la/foto4.jpg");
        GuiaDTO guia4 = new GuiaDTO(
                "Laura",
                "Rodríguez",
                "45678901",
                Sexo.FEMENINO,
                "laura@example.com",
                "126",
                "ruta/a/la/foto4.jpg",
                "APPLEID",
                List.of(new Servicio("Recorrido histórico", "Un recorrido histórico por la ciudad", 40.0)),
                Pais.COLOMBIA,
                Ciudad.BOGOTA,
                credencial4,
                List.of(Idioma.ESPAÑOL, Idioma.PORTUGUES),
                8.0
        );
        guiaController.registrarGuia(guia4, "pass4", Auth.APPLEID);


        CredencialDTO credencial5 = new CredencialDTO("127", "ruta/a/la/foto5.jpg");
        GuiaDTO guia5 = new GuiaDTO(
                "Miguel",
                "Fernández",
                "56789012",
                Sexo.MASCULINO,
                "miguel@example.com",
                "127",
                "ruta/a/la/foto5.jpg",
                "BASICO",
                List.of(new Servicio("Tour gastronómico", "Un tour guiado de gastronomía", 60.0)),
                Pais.MEXICO,
                Ciudad.CIUDAD_DE_MEXICO,
                credencial5,
                List.of(Idioma.ESPAÑOL, Idioma.INGLES),
                0.0
        );
        guiaController.registrarGuia(guia5, "pass5", Auth.BASICO);


        ViajeDTO viajeDTO1 = new ViajeDTO(
                Ciudad.MADRID,
                Pais.ESPAÑA,
                LocalDate.of(2024, 7, 1),
                LocalDate.of(2024, 7, 15)
        );

        ViajeDTO viajeDTO2 = new ViajeDTO(
                Ciudad.PARIS,
                Pais.FRANCIA,
                LocalDate.of(2025, 8, 15),
                LocalDate.of(2025, 8, 20)
        );

        viajeController.crearViaje(viajeDTO1, "silvina@example.com", "laura@example.com");
        viajeController.crearViaje(viajeDTO1, "pepe@example.com", "laura@example.com");
        viajeController.crearViaje(viajeDTO1, "juan@example.com", "miguel@example.com");
        viajeController.crearViaje(viajeDTO1, "marcos@example.com", "carlos@example.com");
        viajeController.crearViaje(viajeDTO1, "marcos@example.com", "ana@example.com");

        turistaController.calificarGuia("laura@example.com", "silvina@example.com", 5.7, "Muy bueno");
        turistaController.calificarGuia("laura@example.com", "pepe@example.com",3.2, "Malo");
        turistaController.calificarGuia("miguel@example.com", "juan@example.com",2.3, "Muy malo");
        turistaController.calificarGuia("carlos@example.com", "marcos@example.com",8.0, "Buenisimo");
        turistaController.calificarGuia("ana@example.com", "marcos@example.com",9.4, "Muy bueno");


        turistaController.loginTurista("pepe@example.com", "pass1", Auth.BASICO);



        SwingUtilities.invokeLater(() -> {
            new SeleccionRol(turistaController, guiaController, viajeController);
            //new GuiaLandingPage (turistaController, guiaController, viajeController);
        });
    }

}