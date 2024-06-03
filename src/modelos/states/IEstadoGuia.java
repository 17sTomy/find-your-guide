package modelos.states;

import clases.Guia;

public interface IEstadoGuia {
    public void reservar(Guia guia);
    public void cancelar(Guia guia);
}
