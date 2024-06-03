package clases;

import controladores.FacturaController;
import modelos.adapters.IAdapterPago;
import modelos.states.IEstadoFactura;

/**
 * 
 */
public class Factura {

    /**
     * Default constructor
     */
    public Factura() {
    }

    /**
     * 
     */
    private Double montoTotal;

    /**
     * 
     */
    private Double comision;

    /**
     * 
     */
    private boolean pagada;

    /**
     * 
     */
    private IAdapterPago adapterPago;

    /**
     * 
     */
    private FacturaController facturaController;

    /**
     * @return
     */
    public void abonarFactura() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Double calcularMontoTotal() {
        // TODO implement here
        return null;
    }

    /**
     * @param estado 
     * @return
     */
    public void cambiarEstadoFactura(IEstadoFactura estado) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void verDetallesFactura() {
        // TODO implement here
    }

}