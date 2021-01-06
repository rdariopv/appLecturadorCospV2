package com.lecturador.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 2/21/2018.
 */
public class BsCcw {
    private int Codo;
    private String Desc;

    public BsCcw() {
        this.Codo=0;
        this.Desc="";
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

    @Override
    public String toString() {
        return "BsCcw{" +
                "Codo=" + Codo +
                ", Desc='" + Desc + '\'' +
                '}';
    }

    public void insertarBsCcw() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Codo);
        datos.add(this.Desc);
        DBmanager.insertarTupla(DBhelper.NOMTABSCCW, DBhelper.COLSBSCCW, datos);
        DBmanager.CerrarBD();
    }

    public LinkedList<BsCcw> listarBsCcw() {
        LinkedList<BsCcw> listCcostos = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTABSCCW, DBhelper.COLSBSCCW);

        while (cursor.moveToNext()) {
            BsCcw ccw = new BsCcw();
            ccw.setCodo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSCCWCODO))));
            ccw.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSCCWDESC)));

            listCcostos.add(ccw);
            Log.e("BSCCW","listCentrosCobranzas se anhadio un centroCobranza a la lista ="+listCcostos.size());

        }
        DBmanager.CerrarBD();
        return listCcostos;
    }

    public int countRegister(){
        int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTABSCCW);
        return cant;
    }



}
