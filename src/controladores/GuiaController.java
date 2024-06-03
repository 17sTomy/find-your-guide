package controladores;

import clases.Guia;
import enumeraciones.ModoAuth;
import modelos.DTOs.GuiaDTO;

import java.util.List;

public class GuiaController {

    private Guia guia;

    public GuiaController(Guia guia) {
        this.guia = guia;
    }

    public void registrarGuia(GuiaDTO usuarioDTO, ModoAuth modoRegistro){
        // Implementacion
        return;
    }

    public void loginGuia(GuiaDTO usuarioDTO, ModoAuth modoLogin){
        // Implementacion
        return;
    }

    public List<GuiaDTO> buscarGuias(GuiaDTO guiaDTO){
        // Implementacion
        return null;
    }


}
