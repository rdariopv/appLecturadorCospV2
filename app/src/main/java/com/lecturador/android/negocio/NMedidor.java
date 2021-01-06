package com.lecturador.android.negocio;

import android.database.Cursor;
import android.util.Log;

import com.lecturador.android.dblecturador.DBhelper;
import com.lecturador.android.dblecturador.DBmanager;
import com.lecturador.android.dblecturador.Medidor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 6/4/2015.
 */
public class NMedidor {
    public void insertarMedidor(Medidor medidor) {
        insertarMedidor(medidor.getid(), medidor.getmarcador(), medidor.getidcategoria(), medidor.getidzona(), medidor.getcodsocio());
    }

    public void insertarMedidor(int id, int marcador, int idCategoria, int idZona, int codSocio) {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(id);
        datos.add(marcador);
        datos.add(idCategoria);
        datos.add(idZona);
        datos.add(codSocio);
        DBmanager.insertarTupla(DBhelper.NOMTAMEDIDOR, DBhelper.COLSMEDIDOR, datos);

        DBmanager.CerrarBD();

        Log.e("NMedidor", "se inserto un medidor correctamente");


    }

    public Medidor getMedidor(int idMedidor) {

        Medidor loMedidor = new Medidor();
        String lsConsulta = DBhelper.COLMEID + "=" + idMedidor;
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAMEDIDOR, DBhelper.COLSMEDIDOR, lsConsulta, null);

        if (cursor.moveToNext()) {
            loMedidor.setid(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEID))));
            loMedidor.setmarcador(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEMARCADOR))));
            loMedidor.setidcategoria(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEIDCATEGORIA))));
            loMedidor.setidzona(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEIDZONA))));
            loMedidor.setcodsocio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMECODSOCIO))));

        }
        DBmanager.CerrarBD();
        return loMedidor;
    }

    public int contarMedidores() {
        return DBmanager.Cantidad_de_Registros(DBhelper.NOMTAMEDIDOR);
    }


    public Medidor ObtenerMedidor(int idMedidor)
    {
        Medidor loMedidor=new Medidor();
        String lsConsulta= DBhelper.COLLEIDMEDIDOR+" = "+idMedidor+" ";
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAMEDIDOR, DBhelper.COLSMEDIDOR, lsConsulta, null);

        if (cursor.moveToNext())
        {
            loMedidor.setid(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEID))));
            loMedidor.setmarcador(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEMARCADOR))));
            loMedidor.setidcategoria(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEIDCATEGORIA))));
            loMedidor.setidzona(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEIDZONA))));
            loMedidor.setcodsocio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMECODSOCIO))));
            Log.e("NMedidor","listarMedidores se anhadio un medidor a la lista ="+loMedidor.toString());

        }
        DBmanager.CerrarBD();


        return loMedidor;
    }

    public LinkedList<Medidor> listarMedidores() {
        LinkedList<Medidor> medidores = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAMEDIDOR, DBhelper.COLSMEDIDOR);

        while (cursor.moveToNext()) {
            Medidor loMedidor = new Medidor();
            loMedidor.setid(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEID))));
            loMedidor.setmarcador(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEMARCADOR))));
            loMedidor.setidcategoria(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEIDCATEGORIA))));
            loMedidor.setidzona(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMEIDZONA))));
            loMedidor.setcodsocio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLMECODSOCIO))));
            Log.e("NMedidor","listarMedidores se anhadio un medidor a la lista ="+loMedidor.toString());


                medidores.add(loMedidor);


        }

        return medidores;
    }
}
