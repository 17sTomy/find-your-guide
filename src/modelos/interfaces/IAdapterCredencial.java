package modelos.interfaces;

import modelos.clases.Credencial;

import java.util.stream.Stream;

public interface IAdapterCredencial {
    public boolean verificarCredencial(Credencial credencial);
}
