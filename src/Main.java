import controladores.*;
import enums.*;
import modelos.clases.*;
import modelos.dtos.TuristaDTO;
import modelos.dtos.GuiaDTO;
import modelos.dtos.UsuarioDTO;
import modelos.interfaces.IAuthenticacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear instancia de TuristaController
        TuristaController turistaController = new TuristaController();

        // Datos del nuevo turista
        TuristaDTO nuevoTuristaDTO = new TuristaDTO(
                "Juan",
                "Pérez",
                "12345678",
                Sexo.Masculino,
                "juan@example.com",
                "123456789",
                "ruta/a/la/foto.jpg",
                "BASICO"
        );

        // Modo de registro (por ejemplo, registro básico)
        Auth modoRegistro = Auth.BASICO;

        // Registrar al nuevo turista
        turistaController.registrarTurista(nuevoTuristaDTO, "password123", modoRegistro);

        // Datos de inicio de sesión
        String email = "juan@example.com";
        String password = "password123";

        // Modo de inicio de sesión (por ejemplo, autenticación básica)
        Auth modoLogin = Auth.BASICO;

        // Iniciar sesión del turista
        turistaController.loginTurista(email, password, modoLogin);

        //Crear Guias
        ArrayList<Guia> guias = new ArrayList<Guia>();

        Guia guia1 = new Guia(
                "Juan",
                "Perez",
                Sexo.MASCULINO,
                "12345678A",
                "juan.perez@example.com",
                "password123",
                "123456789",
                "foto.jpg",
                new IAuthenticacion() {
                    @Override
                    public boolean register(Usuario usuario) {
                        return false;
                    }

                    @Override
                    public UsuarioDTO login(String email, String password) {
                        return null;
                    }
                }
        );


        guia1.setInfoExtra(
                List.of(new Servicio("Tour individual","Tour en Buenos Aires", 200.0), new Servicio("Traducciones", "Traducciones Ingles", 300.0)),
                Pais.ARGENTINA,
                Ciudad.BUENOS_AIRES,
                new Credencial(),
                true,
                List.of(new Reseña(null, null, 5.0), new Reseña(null, null, 8.0)),
                List.of(Idioma.ESPAÑOL, Idioma.INGLES)
        );

        Guia guia2 = new Guia(
                "Ana",
                "Gomez",
                Sexo.FEMENINO,
                "87654321B",
                "ana.gomez@example.com",
                "password",
                "987654321",
                "foto2.jpg",
                new IAuthenticacion() {
                    @Override
                    public boolean register(Usuario usuario) {
                        return false;
                    }

                    @Override
                    public UsuarioDTO login(String email, String password) {
                        return null;
                    }
                }
        );

        guia2.setInfoExtra(
                List.of(new Servicio("Tour grupal","Tour en Paris", 100.0), new Servicio("Tour individual","Tour en Paris", 200.0)),
                Pais.FRANCIA,
                Ciudad.PARIS,
                new Credencial(),
                true,
                List.of(new Reseña(null, null, 2.5), new Reseña(null, null, 6.2)),
                List.of(Idioma.FRANCES, Idioma.INGLES)
        );

        guias.add(guia1);
        guias.add(guia2);

        // Crear instancia de GuiaController
        GuiaController guiaController = new GuiaController(guias);

        Guia guiaBusqueda = new Guia(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                new IAuthenticacion() {
                    @Override
                    public boolean register(Usuario usuario) {
                        return false;
                    }

                    @Override
                    public UsuarioDTO login(String email, String password) {
                        return null;
                    }
                }
        );

        guiaBusqueda.setInfoExtra(
                List.of(new Servicio(null, null, 0.0)),
                Pais.ARGENTINA,
                Ciudad.BUENOS_AIRES,
                null,
                false,
                List.of(new Reseña(null, null, 4.0)),
                List.of(Idioma.INGLES)
        );

        // Buscar Guia
        GuiaDTO criteriosBusqueda = new GuiaDTO(
            guiaBusqueda
        );

        List<GuiaDTO> guiasEncontrados = guiaController.buscarGuias(criteriosBusqueda);

        System.out.println("Guías encontrados: " + guiasEncontrados);
    }
}
