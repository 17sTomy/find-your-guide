import controladores.GuiaController;
import controladores.TuristaController;
import enums.*;
import modelos.DataBase;
import modelos.clases.*;
import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;
import modelos.dtos.UsuarioDTO;
import modelos.interfaces.IAuthenticacion;

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
                Sexo.MASCULINO,
                "juan@example.com",
                "123456789",
                "ruta/a/la/foto.jpg",
                "BASICO"
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
    }
}
