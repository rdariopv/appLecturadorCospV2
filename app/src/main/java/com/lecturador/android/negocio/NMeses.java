package com.lecturador.android.negocio;

/**
 * Created by Dario Pardo on 5/17/2017.
 */
public class NMeses {
    private int id;
    private String Mes;

    public NMeses(int id, String mes) {
        this.id = id;
        this.Mes = mes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String mes) {
        Mes = mes;
    }

    @Override
    public String toString() {
        return Mes;
    }
}
