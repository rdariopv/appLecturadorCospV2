package com.lecturador.android.negocio;

import android.database.Cursor;
import android.util.Log;

import com.lecturador.android.dblecturador.DBhelper;
import com.lecturador.android.dblecturador.DBmanager;
import com.lecturador.android.dblecturador.LtCnf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dario Pardo on 4/9/2017.
 */
public class NLtCnf {
    private LtCnf cnf;
    public void insertarCnf(int Nitm ,String descripcion, String urlWs ) {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(Nitm);
        datos.add(descripcion);
        datos.add(urlWs);
        DBmanager.insertarTupla(DBhelper.NOMTACNF, DBhelper.COLSCNF , datos);
        DBmanager.CerrarBD();

    }

    public LtCnf obtenerCnf(int id) {

        LtCnf loCnf= new LtCnf();
        String lsConsulta = DBhelper.COLCNFNITM+ "=" + id;
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTACNF, DBhelper.COLSCNF, lsConsulta, null);

        if (cursor.moveToNext()) {

            loCnf.setCnfNitm(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLCNFNITM))));
            loCnf.setCnfwUrl(cursor.getString(cursor.getColumnIndex(DBhelper.COLCNFWURL)));
            loCnf.setCnfOnly(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLCNFONLY))));
            loCnf.setCnfPrint(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLCNFPRIN))));
            Log.e("NLtCnf", "obtenerCnf se obtiene una Configuracion  =" + loCnf.toString());
        }
        DBmanager.CerrarBD();
        return loCnf;
    }
}
