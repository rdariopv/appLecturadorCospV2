package com.lecturador.android.negocio;

import android.database.Cursor;

import com.lecturador.android.dblecturador.DBhelper;
import com.lecturador.android.dblecturador.DBmanager;
import com.lecturador.android.dblecturador.Empleado;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dario Pardo on 6/4/2015.
 */
public class NEmpleado {
    private Empleado empleado;

    public NEmpleado()
    {
        empleado= new Empleado();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void InsertarEmpleado(Empleado loEmpleado)
    {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(loEmpleado.getcodigo());
        datos.add(loEmpleado.getci());
        datos.add(loEmpleado.getnombre());
        datos.add(loEmpleado.gettelefono());
        datos.add(loEmpleado.getdireccion());
        datos.add(loEmpleado.getidzona());

        DBmanager.insertarTupla(DBhelper.NOMTAEMPLEADO, DBhelper.COLSEMPLEADO, datos);

        DBmanager.CerrarBD();
    }

    public Empleado ObtenerEmpleado(int codigo)
    {
        Empleado loEmpleado=new Empleado();
        String lsConsulta= DBhelper.COLEMCODIGO+" = "+codigo+" ";
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAEMPLEADO, DBhelper.COLSEMPLEADO, lsConsulta, null);

        if (cursor.moveToNext())
        {
            loEmpleado.setcodigo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLEMCODIGO))));
            loEmpleado.setci(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLEMCI))));
            loEmpleado.setnombre(cursor.getString(cursor.getColumnIndex(DBhelper.COLEMNOMBRE)));
            loEmpleado.settelefono(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLEMTELEFONO))));
            loEmpleado.setdireccion(cursor.getString(cursor.getColumnIndex(DBhelper.COLEMDIRECCION)));
            loEmpleado.setidzona(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLEMIDZONA))));
        }
        DBmanager.CerrarBD();
        return loEmpleado;
    }
}
