package com.lecturador.android.dblecturador;

/**
 * Created by Dario Pardo on 6/7/2015.
 */
public class Parametros {
    private int codZona;
    private int idEmpleado;
    private int cantMedidores;
    private int cantSocios;
    private  int cantLecturaciones;

    public Parametros() {
        this.cantMedidores = 0;
        this.idEmpleado = 0;
        this.codZona = 0;
        this.cantSocios = 0;
        this.cantLecturaciones=0;
    }

    public int getCodZona() {
        return codZona;
    }

    public void setCodZona(int codZona) {
        this.codZona = codZona;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getCantMedidores() {
        return cantMedidores;
    }

    public void setCantMedidores(int cantMedidores) {
        this.cantMedidores = cantMedidores;
    }

    public int getCantSocios() {
        return cantSocios;
    }

    public void setCantSocios(int cantSocios) {
        this.cantSocios = cantSocios;
    }

    public int getCantLecturaciones() {
        return cantLecturaciones;
    }

    public void setCantLecturaciones(int cantLecturaciones) {
        this.cantLecturaciones = cantLecturaciones;
    }
}
