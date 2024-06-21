package modelos.clases;

import modelos.interfaces.IAdapterPago;

public class Factura {
    private Double montoTotal;
    private Double comision;
    private boolean pagada;
    private IAdapterPago adapterPago;

    public Factura(double montoTotal) {
        this.montoTotal = montoTotal;
        comision = this.calcularComision();
        pagada = false;
    }

    public void abonarFactura() {
        pagada = true;
    }
    public Double calcularComision() {
        return montoTotal * 0.1;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public Double getComision() {
        return comision;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public void verDetallesFactura() {
        System.out.println("--- DETALLE FACTURA ---" + " \n" +
                "Monto Total: " + getMontoTotal() + " \n" +
                "Comision: " + getComision() + "\n" +
                "Pagada: " + (this.isPagada() ? "Si" : "No")
        );
    }
}