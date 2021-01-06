package com.lecturador.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/24/2017.
 */
public class BsObw {
    private int Codo;
    private String Desc;

    public BsObw() {
        this.Codo=0;
        this.Desc="";
    }

    public BsObw(String desc, int codo) {
        Desc = desc;
        Codo = codo;
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

    public void insertarBsObw() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Codo);
        datos.add(this.Desc);
        DBmanager.insertarTupla(DBhelper.NOMTAOBW, DBhelper.COLSBSOBW, datos);
        DBmanager.CerrarBD();
    }

    public LinkedList<BsObw> listarBsObw() {
        LinkedList<BsObw> listObservaciones = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAOBW, DBhelper.COLSBSOBW);

        while (cursor.moveToNext()) {
            BsObw obs = new BsObw();
            obs.setCodo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSOBWCODO))));
            obs.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSOBWDESC)));

            listObservaciones.add(obs);
            Log.e("BSOWB","listObservaciones se anhadio un zona a la lista ="+listObservaciones.size());

        }
        DBmanager.CerrarBD();
        return listObservaciones;
    }

    @Override
    public String toString() {
        return " " + Codo +" | "+ Desc + " ";
    }

    public int countRegister(){
        int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTAOBW);
        return cant;
    }
}




