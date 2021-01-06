package com.lecturador.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/4/2017.
 */
public class LtZon {
    private int Nzon;
    private String Dzon;
    private int Rngo;
    private int CreH;
    private int CreD;
    private int Crhi;

    public LtZon() {
    }

    public int getNzon() {
        return Nzon;
    }

    public void setNzon(int nzon) {
        Nzon = nzon;
    }

    public String getDzon() {
        return Dzon;
    }

    public void setDzon(String dzon) {
        Dzon = dzon;
    }

    public int getRngo() {
        return Rngo;
    }

    public void setRngo(int rngo) {
        Rngo = rngo;
    }

    public int getCreh() {
        return CreH;
    }

    public void setCreH(int creh) {
        CreH = creh;
    }

    public int getCreD() {
        return CreD;
    }

    public void setCreD(int cred) {
        CreD = cred;
    }


    public int getCrhi() {
        return Crhi;
    }

    public void setCrhi(int crhi) {
        Crhi = crhi;
    }

    public String toString1() {
        return "LtZon{" +
                "Nzon=" + Nzon +
                ", Dzon='" + Dzon + '\'' +
                ", Rngo=" + Rngo +
                ", CreH=" + CreH +
                ", CreD=" + CreD +
                ", Crhi=" + Crhi +
                '}';
    }


    @Override
    public String toString() {
        return "LtZon{" +
                "CreD=" + CreD +
                ", Nzon=" + Nzon +
                ", Dzon='" + Dzon + '\'' +
                ", Rngo=" + Rngo +
                ", CreH=" + CreH +
                ", Crhi=" + Crhi +
                '}';
    }

    public void insertarLtZon() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Nzon);
        datos.add(this.Dzon);
        datos.add(this.Rngo);
        datos.add(this.CreH);
        datos.add(this.CreD);
        datos.add(this.Crhi);
        DBmanager.insertarTupla(DBhelper.NOMTALTZON, DBhelper.COLSLTZON, datos);
        DBmanager.CerrarBD();
    }


    public LinkedList<LtZon> listarLtZon() {
        LinkedList<LtZon> listZonas = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTALTZON, DBhelper.COLSLTZON);

        while (cursor.moveToNext()) {
            LtZon zona = new LtZon();
            zona.setNzon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLTZONNZON))));
            zona.setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLLTZONDZON)));
            zona.setRngo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLTZONRNGO))));
            zona.setCreH(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLTZONCREH))));
            zona.setCreD(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLTZONCRED))));
            zona.setCrhi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLTZONCRHI))));
            listZonas.add(zona);
            Log.e("LTZON", "listarLTZON se anhadio un zona a la lista =" + listZonas.size());

        }

        return listZonas;
    }

    public int countRegister(){
        int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTALTZON);
        return cant;
    }

}
