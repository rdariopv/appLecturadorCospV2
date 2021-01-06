package com.lecturador.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 2/23/2018.
 */
public class BsDhw {
    private int Nhpf;
    private int Orde;
    private String Peri;
    private int Cons;
    private double Impt;
    private String Stad;
    public double getImpt() {
        return Impt;
    }

    public void setImpt(double impt) {
        Impt = impt;
    }

    public int getCons() {
        return Cons;
    }

    public void setCons(int cons) {
        Cons = cons;
    }

    public int getNhpf() {
        return Nhpf;
    }

    public void setNhpf(int nhpf) {
        Nhpf = nhpf;
    }

    public int getOrde() {
        return Orde;
    }

    public void setOrde(int orde) {
        Orde = orde;
    }

    public String getPeri() {
        return Peri;
    }

    public void setPeri(String peri) {
        Peri = peri;
    }

    public String getStad() {
        return Stad;
    }

    public void setStad(String stad) {
        Stad = stad;
    }



    public void insertarBsDhw() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Nhpf);
        datos.add(this.Orde);
        datos.add(this.Peri);
        datos.add(this.Cons);
        datos.add(this.Impt);
        datos.add(this.Stad);
        DBmanager.insertarTupla(DBhelper.NOMTABSDHW , DBhelper.COLSBSDHW, datos);
        DBmanager.CerrarBD();
    }

    public LinkedList<BsDhw> listarBsDhw( int nhpf) {
        LinkedList<BsDhw> listHist = new LinkedList<>();
        DBmanager.AbrirBD();
        String condicion = DBhelper.COLBSDHWNHPF +" = "+ nhpf +"  ";
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTABSDHW, DBhelper.COLSBSDHW,condicion, null);

        while (cursor.moveToNext()) {
            BsDhw dhw = new BsDhw();
            dhw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWNHPF))));
            dhw.setOrde(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWORDE))));
            dhw.setPeri(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWPERI)));
            dhw.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWCONS))));
            dhw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWIMPT))));
            dhw.setStad(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWSTAD)));


            listHist.add(dhw);
            Log.e("BSDHW","listarHistorico se anhadio un zona a la lista ="+listHist.size());

        }
        DBmanager.CerrarBD();
        return listHist;
    }

    public int countRegister(){
        int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTABSDHW);
        return cant;
    }

}
