import controladores.*;
import enums.*;
import modelos.DataBase;
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

        // Crear instancia de GuiaController
        GuiaController guiaController = new GuiaController();
    }
}
