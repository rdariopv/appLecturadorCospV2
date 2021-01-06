package com.lecturador.android.negocio;

import android.database.Cursor;
import android.util.Log;

import com.lecturador.android.dblecturador.DBhelper;
import com.lecturador.android.dblecturador.DBmanager;
import com.lecturador.android.dblecturador.Lecturacion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 6/8/2015.
 */
public class NLecturacion {
    public void insertarLecturacion(Lecturacion lecturacion) {
        insertarLecturacion(lecturacion.getId(), lecturacion.getLectura(), lecturacion.getIdtipo(),
                lecturacion.getConsumo(), lecturacion.getObservacion(),lecturacion.getIdPeriodo(),lecturacion.getIdmedidor());
    }

    public void insertarLecturacion(int id, int lectura, int idtipo, int consumo, String observacion, int idPeriodo, int idmedidor) {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(id);
        datos.add(lectura);
        datos.add(idtipo);
        datos.add(consumo);
        datos.add(observacion);
        datos.add(idPeriodo);
        datos.add(idmedidor);
        DBmanager.insertarTupla(DBhelper.NOMTALECTURACION, DBhelper.COLSLECTURACION, datos);

        DBmanager.CerrarBD();

        //Log.e("NUsuario", "se inserto un usuario correctamente");
    }

    public Lecturacion ObtenerLecturacion(int idMedidor)
    {
        Lecturacion loLecturacion=new Lecturacion();
        String lsConsulta= DBhelper.COLLEIDMEDIDOR+" = "+idMedidor+" ";
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTALECTURACION, DBhelper.COLSLECTURACION, lsConsulta, null);

        if (cursor.moveToNext())
        {
            loLecturacion.setId(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLEID))));
            loLecturacion.setLectura(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLELCTURA))));
            loLecturacion.setIdtipo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLEIDTIPO))));
            loLecturacion.setConsumo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLECONSUMO))));
            loLecturacion.setObservacion(cursor.getString(cursor.getColumnIndex(DBhelper.COLLEOBSERVACION)));
            loLecturacion.setIdPeriodo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLEIDPERIODO))));
            loLecturacion.setIdmedidor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLEIDMEDIDOR))));
            Log.e("NLecturacion", "ObtenerLecturacion se obtiene una Lecturacion =" + loLecturacion.toString());
        }
        DBmanager.CerrarBD();


        return loLecturacion;
    }

    public void ModificarLecturacion(Lecturacion loLecturacion)
    {
        String lsConsulta= DBhelper.COLLEID+" = "+loLecturacion.getId()+" ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(loLecturacion.getId());
        datos.add(loLecturacion.getLectura());
        datos.add(loLecturacion.getIdtipo());
        datos.add(loLecturacion.getConsumo());
        datos.add(loLecturacion.getObservacion());
        datos.add(loLecturacion.getIdPeriodo());
        datos.add(loLecturacion.getIdmedidor());
        DBmanager.modificarTupla(DBhelper.NOMTALECTURACION,DBhelper.COLSLECTURACION,datos,lsConsulta);
        DBmanager.CerrarBD();


    }

    public LinkedList<Lecturacion> listarLecturacion() {
        LinkedList<Lecturacion> lecturacions = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTALECTURACION, DBhelper.COLSLECTURACION);

        while (cursor.moveToNext()) {
            Lecturacion loLecturacion = new Lecturacion();
            loLecturacion.setId(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLEID))));
            loLecturacion.setLectura(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLELCTURA))));
            loLecturacion.setIdtipo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLEIDTIPO))));
            loLecturacion.setConsumo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLECONSUMO))));
            loLecturacion.setObservacion(cursor.getString(cursor.getColumnIndex(DBhelper.COLLEOBSERVACION)));
            loLecturacion.setIdPeriodo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLEIDPERIODO))));
            loLecturacion.setIdmedidor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLLEIDMEDIDOR))));
            Log.e("NMedidor","listarMedidores se anhadio un medidor a la lista ="+loLecturacion.toString());

            if(loLecturacion.getId()!=0){

                lecturacions.add(loLecturacion);
            }



        }

        return lecturacions;
    }

}
