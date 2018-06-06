package com.canaveral.ies.lendurcash.Entities;

public class Deuditas {
    private String concepto;
    private double importe;
    private boolean favor;

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Deuditas(String concepto, double importe, boolean favor) {

        this.concepto = concepto;
        this.importe = importe;
        this.favor = favor;
    }

    public boolean isFavor() {
        return favor;
    }

    public void setFavor(boolean favor) {
        this.favor = favor;
    }
}
