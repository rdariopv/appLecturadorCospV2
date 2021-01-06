package com.lecturador.android.negocio;

import android.database.Cursor;
import android.util.Log;

import com.lecturador.android.dblecturador.DBhelper;
import com.lecturador.android.dblecturador.DBmanager;
import com.lecturador.android.dblecturador.Socio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dario Pardo on 6/7/2015.
 */
public class NSocio {

    public void insertarSocio(Socio socio) {
        insertarSocio(socio.getCodigo(),socio.getCi(),socio.getNombre(),socio.getDireccion());
    }

    public void insertarSocio(int codigo, int ci, String nombre, String direccion) {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(codigo);
        datos.add(ci);
        datos.add(nombre);
        datos.add(direccion);
        DBmanager.insertarTupla(DBhelper.NOMTASOCIO, DBhelper.COLSSOCIO, datos);

        DBmanager.CerrarBD();

    }


    public Socio getSocio(int codSocio) {

        Socio loSocio = new Socio();
        String lsConsulta = DBhelper.COLSOCODIGO + "=" + codSocio;
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTASOCIO, DBhelper.COLSSOCIO, lsConsulta, null);

        if (cursor.moveToNext()) {
            loSocio.setCodigo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLSOCODIGO))));
            loSocio.setCi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLSOCI))));
            loSocio.setNombre(cursor.getString(cursor.getColumnIndex(DBhelper.COLSONOMBRE)));
            loSocio.setDireccion(cursor.getString(cursor.getColumnIndex(DBhelper.COLSODIRECCION)));
            Log.e("NSocio", "getSocio se obtiene un SOCIO  =" + loSocio.toString());
        }
        DBmanager.CerrarBD();
        return loSocio;
    }

    public int contarSocios() {
        return DBmanager.Cantidad_de_Registros(DBhelper.NOMTASOCIO);
    }
}
