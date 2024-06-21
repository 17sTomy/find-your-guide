package modelos.clases;

import modelos.interfaces.IAdapterCredencial;

import java.util.stream.Stream;


public class SistemaVerificacionIA implements IAdapterCredencial {

    public boolean verificarCredencial(Credencial credencial) {
        if (credencial.getIdCredencial() != "" && credencial.getFotoCredencial() != "") {
            return true;
        }
        return false;
    }

}