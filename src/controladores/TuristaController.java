package controladores;

import clases.Turista;
import enumeraciones.ModoAuth;
import modelos.DTOs.GuiaDTO;
import modelos.DTOs.TuristaDTO;

public class TuristaController {
    private Turista turista;

    public TuristaController(Turista turista) {
        this.turista = turista;
    }

    public void registrarTurista(TuristaDTO usuarioDTO, ModoAuth modoRegistro){
        // Implementacion
        return;
    }

    public void loginTurista(TuristaDTO usuarioDTO, ModoAuth modoLogin){
        // Implementacion
        return;
    }

    public void calificarGuia(TuristaDTO turistaDTO, GuiaDTO guiaDTO, double puntuacion, String comentario){
        // Implementacion
        return;
    }


}
