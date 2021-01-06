package com.lecturador.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/5/2017.
 */
public class BsEnw {
    private int Impr;
    private String Nomb;
    private String Sigl;
    private String Nnit;
    private String Dire;
    private String Telf;
    private int Anio;
    private int Mesf;
    private String Dmes;
    private int Nhpc;

    public BsEnw() {
    }

    public int getImpr() {
        return Impr;
    }

    public void setImpr(int impr) {
        Impr = impr;
    }

    public int getNhpc() {
        return Nhpc;
    }

    public void setNhpc(int nhpc) {
        Nhpc = nhpc;
    }

    public String getNomb() {
        return Nomb;
    }

    public void setNomb(String nomb) {
        Nomb = nomb;
    }

    public String getSigl() {
        return Sigl;
    }

    public void setSigl(String sigl) {
        Sigl = sigl;
    }

    public String getNnit() {
        return Nnit;
    }

    public void setNnit(String nnit) {
        Nnit = nnit;
    }

    public String getDire() {
        return Dire;
    }

    public void setDire(String dire) {
        Dire = dire;
    }

    public String getTelf() {
        return Telf;
    }

    public void setTelf(String telf) {
        Telf = telf;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int anio) {
        Anio = anio;
    }

    public int getMesf() {
        return Mesf;
    }

    public void setMesf(int mesf) {
        Mesf = mesf;
    }

    public String getDmes() {
        return Dmes;
    }

    public void setDmes(String dmes) {
        Dmes = dmes;
    }

    @Override
    public String toString() {
        return "BsEnw{" +
                "Impr=" + Impr +
                ", Nomb='" + Nomb + '\'' +
                ", Sigl='" + Sigl + '\'' +
                ", Nnit='" + Nnit + '\'' +
                ", Dire='" + Dire + '\'' +
                ", Telf='" + Telf + '\'' +
                ", Anio=" + Anio +
                ", Mesf=" + Mesf +
                ", Dmes='" + Dmes + '\'' +
                ", Nhpc=" + Nhpc +
                '}';
    }

    public void insertarBsEnw() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Impr);
        datos.add(this.Nomb);
        datos.add(this.Sigl);
        datos.add(this.Nnit);
        datos.add(this.Dire);
        datos.add(this.Telf);
        datos.add(this.Anio);
        datos.add(this.Mesf);
        datos.add(this.Dmes);
        datos.add(this.Nhpc);
        DBmanager.insertarTupla(DBhelper.NOMTAENW, DBhelper.COLSBSENW, datos);
        DBmanager.CerrarBD();
    }

    public void ObtenerBsEnw()
    {


        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAENW, DBhelper.COLSBSENW);

        if (cursor.moveToNext())
        {
            this.setImpr(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSENWIMPR))));
            this.setNomb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSENWNOMB)));
            this.setSigl(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSENWSIGL)));
            this.setNnit(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSENWNNIT)));
            this.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSENWDIRE)));
            this.setTelf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSENWTELF)));
            this.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSENWANIO))));
            this.setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSENWMESF))));
            this.setDmes(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSENWDMES)));
            this.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSENWNHPC))));
            Log.e("BSENW","obtenerBSENW se obtuvo un BSENW   = "+this.toString());

        }
        DBmanager.CerrarBD();

    }

    public int countRegister(){
       int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTAENW);
        return cant;
    }

}
