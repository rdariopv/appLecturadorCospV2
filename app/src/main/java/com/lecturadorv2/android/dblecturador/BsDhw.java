package com.lecturadorv2.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public  class BsDhw {
    private int Cobs;
    private int Cons;
    private double Impt;
    private int Ncnt;
    private int Nhpf;
    private String Peri;
    private String Stad;
    private int Orde;

    public int getNcnt() {
        return Ncnt;
    }

    public void setNcnt(int ncnt) {
        Ncnt = ncnt;
    }

    public int getCobs() {
        return Cobs;
    }

    public void setCobs(int cobs) {
        Cobs = cobs;
    }

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
        List<Object> datos = new ArrayList<>();
        datos.add(Integer.valueOf(this.Ncnt));
        datos.add(this.Peri);
        datos.add(Integer.valueOf(this.Cons));
        datos.add(Double.valueOf(this.Impt));
        datos.add(this.Stad);
        datos.add(Integer.valueOf(this.Cobs));
        DBmanager.insertarTupla(DBhelper.NOMTABSDHW, DBhelper.COLSBSDHW, datos);
        DBmanager.CerrarBD();
    }

    public LinkedList<BsDhw> listarBsDhw(int ncnt) {
        LinkedList<BsDhw> listHist = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTABSDHW, DBhelper.COLSBSDHW, DBhelper.COLBSDHWNCNT + " = " + ncnt + "  ", (String) null);
        while (cursor.moveToNext()) {
            BsDhw dhw = new BsDhw();
            dhw.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWNCNT))).intValue());
            dhw.setPeri(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWPERI)));
            dhw.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWCONS))).intValue());
            dhw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWIMPT))).doubleValue());
            dhw.setStad(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWSTAD)));
            dhw.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDHWCOBS))).intValue());
            listHist.add(dhw);
            Log.e("BSDHW", "listarHistorico se anhadio un zona a la lista =" + listHist.size());
        }
        DBmanager.CerrarBD();
        return listHist;
    }

    public int countRegister(){
        int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTABSDHW);
        return cant;
    }

    public void eliminarHistorico(int NCNT) {
        DBmanager.AbrirBD();
        DBmanager.eliminarTupla(DBhelper.NOMTABSDHW, DBhelper.COLBSDHWNCNT + " = " + NCNT + " ");
        DBmanager.CerrarBD();
    }

}