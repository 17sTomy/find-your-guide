package modelos.clases;

import modelos.dtos.CredencialDTO;
import modelos.interfaces.IAdapterCredencial;

public class CredencialFactory {
    public static Credencial createCredencial(CredencialDTO credencialDTO, IAdapterCredencial adapter) {
        return new Credencial(
                credencialDTO.getIdCredencial(),
                credencialDTO.getFotoCredencial(),
                adapter
        );
    }
}
