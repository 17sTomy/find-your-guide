package modelos.dtos;

import modelos.clases.Factura;

public class FacturaDTO {
    private Double montoTotal;
    private Double anticipo;
    private boolean totalPago;
    private boolean anticipoPago;

    public FacturaDTO(Factura factura){
        this.montoTotal = factura.getMontoTotal();
        this.anticipo = factura.getAnticipo();
        this.totalPago = factura.isTotalPago();
        this.anticipoPago = factura.isAnticipoPago();
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public Double getAnticipo() {
        return anticipo;
    }

    public boolean isTotalPago() {
        return totalPago;
    }

    public boolean isAnticipoPago() {
        return anticipoPago;
    }
}
