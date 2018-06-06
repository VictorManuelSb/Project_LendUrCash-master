package com.canaveral.ies.lendurcash.Entities;

import java.util.ArrayList;

public class Deuda {
    private String username;
    private Double dineroTotal;
    private ArrayList<Deuditas> deuditas;

    public Deuda(String username, Double dineroTotal, ArrayList<Deuditas> deuditas) {
        this.username = username;
        this.dineroTotal = dineroTotal;
        this.deuditas = deuditas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getDineroTotal() {
        return dineroTotal;
    }

    public void setDineroTotal(Double dineroTotal) {
        this.dineroTotal = dineroTotal;
    }

    public ArrayList<Deuditas> getDeuditas() {
        return deuditas;
    }

    public void setDeuditas(ArrayList<Deuditas> deuditas) {
        this.deuditas = deuditas;
    }
}
