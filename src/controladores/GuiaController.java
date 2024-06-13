package controladores;

import modelos.clases.Guia;
import enums.Auth;
import modelos.dtos.GuiaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuiaController {
    private Guia guia;


    public void registrarGuia(GuiaDTO usuarioDTO, Auth modoRegistro){
        // Implementacion
        return;
    }

    public void loginGuia(GuiaDTO usuarioDTO, Auth modoLogin){
        // Implementacion
        return;
    }

    public List<GuiaDTO> buscarGuias(GuiaDTO guiaDTO) {
        return guia.buscarGuias(guiaDTO);
    }
}
