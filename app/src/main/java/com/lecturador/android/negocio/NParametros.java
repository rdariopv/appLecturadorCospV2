package com.lecturador.android.negocio;

import android.database.Cursor;

import com.lecturador.android.dblecturador.DBhelper;
import com.lecturador.android.dblecturador.DBmanager;
import com.lecturador.android.dblecturador.Parametros;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dario Pardo on 6/7/2015.
 */
public class NParametros {


    public void insertarParametros(int codZona, int idEmpleado, int cantMedidores , int cantSocios ) {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(codZona);
        datos.add(idEmpleado);
        datos.add(cantMedidores);
        datos.add(cantSocios);
        DBmanager.insertarTupla(DBhelper.NOMTAPARAMETROS, DBhelper.COLSPARAMETROS, datos);

        DBmanager.CerrarBD();
        //Log.e("NUsuario", "se inserto un usuario correctamente");
    }

   public void insertarParametros(Parametros parametros)
   {
      insertarParametros(parametros.getCodZona(),parametros.getIdEmpleado(),parametros.getCantMedidores(),parametros.getCantSocios());
   }

    public Parametros getParametros(int idEmpleado){

        Parametros loParametros=new Parametros();
        String lsConsulta= DBhelper.COLPAIDEMPLEADO+"="+idEmpleado;
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAPARAMETROS, DBhelper.COLSPARAMETROS, lsConsulta, null);

        if (cursor.moveToNext())
        {
            loParametros.setIdEmpleado(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLPAIDEMPLEADO))));
            loParametros.setCodZona(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLPACODZONA))));
            loParametros.setCantMedidores(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLPACANTMEDIDORES))));
            loParametros.setCantSocios(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLPACANTSOCIOS))));
        }
        DBmanager.CerrarBD();
        return loParametros;
    }

}
