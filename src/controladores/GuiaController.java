package controladores;

import modelos.clases.Guia;
import enums.Auth;
import modelos.dtos.GuiaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuiaController {
    private ArrayList<Guia> guias; //cambiar a listado en el diagrama

    public GuiaController(ArrayList<Guia> guias) {
        this.guias = guias;
    }

    public void registrarGuia(GuiaDTO usuarioDTO, Auth modoRegistro){
        // Implementacion
        return;
    }

    public void loginGuia(GuiaDTO usuarioDTO, Auth modoLogin){
        // Implementacion
        return;
    }

    public List<GuiaDTO> buscarGuias(GuiaDTO guiaDTO) {
        return guias.stream()
                .filter(guia ->
                        (guiaDTO.getNombre() == null || guia.getNombre().equalsIgnoreCase(guiaDTO.getNombre())) &&
                        (guiaDTO.getApellido() == null || guia.getApellido().equalsIgnoreCase(guiaDTO.getApellido())) &&
                                (guiaDTO.getIdiomas() == null || guiaDTO.getIdiomas().stream().anyMatch(idioma -> guia.getIdiomas().contains(idioma))) &&
                                (guiaDTO.getServicios() == null || guiaDTO.getServicios().stream().anyMatch(servicioDTO ->
                                        guia.getServicios().stream().anyMatch(servicio ->
                                                (servicioDTO.getNombre() == null || servicio.getNombre().equalsIgnoreCase(servicioDTO.getNombre())) &&
                                                        (servicioDTO.getDescripcion() == null || servicio.getDescripcion().equalsIgnoreCase(servicioDTO.getDescripcion())) &&
                                                        (servicioDTO.getPrecio() == null || servicio.getPrecio().equals(servicioDTO.getPrecio()))
                                        )
                                )) &&
                        (guiaDTO.getPuntuacion() == 0.0 || guia.getPuntuacion() >= guiaDTO.getPuntuacion()) &&
                        (guiaDTO.getPais() == null || guia.getPais() == guiaDTO.getPais()) &&
                        (guiaDTO.getCiudad() == null || guia.getCiudad() == guiaDTO.getCiudad())
                )
                .map(GuiaDTO::new)
                .collect(Collectors.toList());
    }
}
