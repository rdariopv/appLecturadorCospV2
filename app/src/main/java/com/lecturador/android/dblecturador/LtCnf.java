package com.lecturador.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import org.ksoap2.samples.amazon.search.messages.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dario Pardo on 4/9/2017.
 */
public class LtCnf {
    private int CnfNitm;
    private String CnfwUrl;
    private int CnfOnly;
    private int CnPrint;
    private boolean CnfGpsA;
    private int CnfNpri;


    public LtCnf() {
        CnfNitm = 0;
        CnfwUrl = "";
        CnfOnly = 0;
        this.CnfGpsA=false;
        this.CnfNpri=0;
    }


    public int getCnfNitm() {
        return CnfNitm;
    }

    public void setCnfNitm(int CnfNitm) {
        this.CnfNitm = CnfNitm;
    }

    public String getCnfwUrl() {
        return CnfwUrl;
    }

    public void setCnfwUrl(String ltCnfwUrl) {
        this.CnfwUrl = ltCnfwUrl;
    }

    public boolean isCnfOnly() {
        return CnfOnly>0;
    }

    public void setCnfOnly(int cnfOnly) {
        CnfOnly = cnfOnly;
    }

    public boolean isPrintOnline() {
        return CnPrint>0;
    }

    public void setCnfPrint(int cnPrint) {
        CnPrint = cnPrint;
    }

    public boolean isCnfGpsA() {
        return CnfGpsA;
    }

    public void setCnfGpsA(boolean cnfGpsA) {
        CnfGpsA = cnfGpsA;
    }


    public int getCnfNpri() {
        return CnfNpri;
    }

    public void setCnfNpri(int cnfNpri) {
        CnfNpri = cnfNpri;
    }

    @Override
    public String toString() {
        return "LtCnf{" +
                "CnfGpsA=" + CnfGpsA +
                ", CnfNitm=" + CnfNitm +
                ", CnfwUrl='" + CnfwUrl + '\'' +
                ", CnfOnly=" + CnfOnly +
                ", CnPrint=" + CnPrint +
                ", CnfNpri=" + CnfNpri +
                '}';
    }

    public void insertarCnf(int Nitm, String urlWs, int SyncOnLine, int printOnline, boolean GpsA , int Nropri) {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(Nitm);
        datos.add(urlWs);
        datos.add(SyncOnLine);
        datos.add(printOnline);
        datos.add(GpsA);
        datos.add(Nropri);
        DBmanager.insertarTupla(DBhelper.NOMTACNF, DBhelper.COLSCNF, datos);
        DBmanager.CerrarBD();
    }

    public void registrar(int Nitm, String urlWebService, int SyncOnline, int printOnline, boolean GpsA, int Nropri) {
        boolean exite = obtenerCnf(Nitm);
        if (exite) {
            String[] columnas = { DBhelper.COLCNFWURL,DBhelper.COLCNFONLY , DBhelper.COLCNFPRIN,DBhelper.COLCNFGPSA, DBhelper.COLCNFNPRI};
            List datos = new ArrayList();
            datos.add(urlWebService);
            datos.add(SyncOnline);
            datos.add(printOnline);
            datos.add(GpsA);
            datos.add(Nropri);
            String condicion = DBhelper.COLCNFNITM + "=" + Nitm;
            DBmanager.AbrirBD();
            DBmanager.modificarTupla(DBhelper.NOMTACNF, columnas, datos, condicion);
            DBmanager.CerrarBD();
            Log.e("NLtCnf", "Modificar Configuracion  =" + this.toString());
        } else {
            insertarCnf(Nitm, urlWebService, SyncOnline,printOnline, GpsA , Nropri);
            Log.e("NLtCnf", "insertar Configuracion  =" + this.toString());
        }

    }

    public boolean obtenerCnf(int id) {

        String lsConsulta = DBhelper.COLCNFNITM + "=" + id;
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTACNF, DBhelper.COLSCNF, lsConsulta, null);
        boolean existe = false;
        if (cursor.moveToNext()) {

            this.setCnfNitm(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLCNFNITM))));
            this.setCnfwUrl(String.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLCNFWURL))));
            this.setCnfOnly(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLCNFONLY))));
            this.setCnfPrint(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLCNFPRIN))));
            this.setCnfGpsA(Boolean.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLCNFGPSA))));
            this.setCnfNpri(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLCNFNPRI))));
            Log.e("NLtCnf", "obtenerCnf se obtiene una Configuracion  =" + this.toString());
            existe = true;
        }
        DBmanager.CerrarBD();
        return existe;
    }

    public int countRegister(){
        int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTACNF);
        return cant;
    }

}
