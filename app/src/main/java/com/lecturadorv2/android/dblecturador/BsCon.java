package com.lecturadorv2.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BsCon {
    private int Pref;
    private int Codo;
    private String Desc;

    public BsCon() {
        this.Pref=0;
        this.Codo=0;
        this.Desc="";
    }

    public BsCon(String desc, int codo) {
        Desc = desc;
        Codo = codo;
    }

    public int getPref() {
        return Pref;
    }

    public void setPref(int pref) {
        Pref = pref;
    }
    public int getCodo() {
        return Codo;
    }

    public void setCodo(int codo) {
        Codo = codo;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void insertarBsCon() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Pref);
        datos.add(this.Codo);
        datos.add(this.Desc);
        DBmanager.insertarTupla(DBhelper.NOMTABSCON, DBhelper.COLSBSCON, datos);
        DBmanager.CerrarBD();
    }

    public LinkedList<BsCon> listarBsCon() {
        LinkedList<BsCon> listObservaciones = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTABSCON, DBhelper.COLSBSCON);

        while (cursor.moveToNext()) {
            BsCon obs = new BsCon();
            obs.setPref(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSCONPREF))));
            obs.setCodo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSCONCODO))));
            obs.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSCONDESC)));

            listObservaciones.add(obs);
            Log.e("BSCON","listConceptos se anhadio un concepto a la lista ="+listObservaciones.size());

        }
        DBmanager.CerrarBD();
        return listObservaciones;
    }


    public boolean obtenerBsCon(int npref, int codo) {
        DBmanager.AbrirBD();
        boolean result = false;
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTABSCON, DBhelper.COLSBSCON, DBhelper.COLBSCONPREF + " = " + npref +
                " and "+DBhelper.COLBSCONCODO +"="+codo, DBhelper.COLBSCONPREF+ ", "+DBhelper.COLBSCONCODO);
        new BsCon();
        if (cursor.moveToNext()) {
            setPref(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSCONPREF))).intValue());
            setCodo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSCONCODO))).intValue());
            setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSCONDESC)));
            result= true;
            Log.e("BSCON", "obtenerBsCon se obtiene el Header con el codo= " + codo);
        }
        return result;
    }


    @Override
    public String toString() {
        return " " + Pref +" | " + Codo +" | "+ Desc + " ";
    }

    public int countRegister(){
        int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTABSCON);
        return cant;
    }

}
