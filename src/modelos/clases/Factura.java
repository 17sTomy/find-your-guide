package modelos.clases;

import modelos.interfaces.IAdapterPago;

public class Factura {
    private Double montoTotal;
    private Double comision;
    private Double anticipo;
    private boolean totalPago;
    private boolean anticipoPago;
    private IAdapterPago adapterPago;

    public Factura(double montoTotal) {
        this.montoTotal = montoTotal;
        comision = this.calcularComision();
        anticipo = this.calcularAnticipo();
        totalPago = false;
        anticipoPago = false;
    }

    public Double calcularComision() {
        return montoTotal * 0.1;
    }
    public Double calcularAnticipo() {
        return montoTotal * 0.2;
    }
    public Double getMontoTotal() {
        return montoTotal;
    }
    public Double getComision() {
        return comision;
    }

    public Double getAnticipo() {
        return anticipo;
    }

    public boolean isTotalPago() {
        return totalPago;
    }
    public void pagarTotalFactura() {
        this.totalPago = true;
    }
    public boolean isAnticipoPago() {
        return anticipoPago;
    }
    public void pagarAnticipoFactura() {
        this.anticipoPago = true;
        this.montoTotal -= this.anticipo;
    }

    public void verDetallesFactura() {
        System.out.println("--- DETALLE FACTURA ---" + " \n" +
                "Monto Total: " + getMontoTotal() + " \n" +
                "Comision: " + getComision() + "\n" +
                "Anticipo: " + getAnticipo() + "\n" +
                "Pagada: " + (this.isTotalPago() ? "Si" : "No")
        );
    }
}