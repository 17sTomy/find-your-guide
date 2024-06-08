package modelos.interfaces;

import modelos.dtos.UsuarioDTO;

/**
 * 
 */
public interface IRol {

    /**
     * @param usuario 
     * @return
     */
    public void asignarRol(UsuarioDTO usuario);

}