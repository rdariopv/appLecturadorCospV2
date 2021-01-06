package com.lecturador.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/4/2017.
 */
public class BsTaw {
    private int anio;
    private int mesf;
    private int nser;
    private String nose;
    private int nhpc;
    private String noco;
    private int ncat;
    private String noca;
    private String fiva;
    private String vafa;
    private int desd;
    private int hast;
    private int cmon;
    private double val1;
    private double val2;
    private int stat;

    public BsTaw() {
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMesf() {
        return mesf;
    }

    public void setMesf(int mesf) {
        this.mesf = mesf;
    }

    public int getNser() {
        return nser;
    }

    public void setNser(int nser) {
        this.nser = nser;
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose;
    }

    public int getNhpc() {
        return nhpc;
    }

    public void setNhpc(int nhpc) {
        this.nhpc = nhpc;
    }

    public String getNoco() {
        return noco;
    }

    public void setNoco(String noco) {
        this.noco = noco;
    }

    public int getNcat() {
        return ncat;
    }

    public void setNcat(int ncat) {
        this.ncat = ncat;
    }

    public String getNoca() {
        return noca;
    }

    public void setNoca(String noca) {
        this.noca = noca;
    }

    public String getFiva() {
        return fiva;
    }

    public void setFiva(String fiva) {
        this.fiva = fiva;
    }

    public String getVafa() {
        return vafa;
    }

    public void setVafa(String vafa) {
        this.vafa = vafa;
    }

    public int getDesd() {
        return desd;
    }

    public void setDesd(int desd) {
        this.desd = desd;
    }

    public int getHast() {
        return hast;
    }

    public void setHast(int hast) {
        this.hast = hast;
    }

    public int getCmon() {
        return cmon;
    }

    public void setCmon(int cmon) {
        this.cmon = cmon;
    }

    public double getVal1() {
        return val1;
    }

    public void setVal1(double val1) {
        this.val1 = val1;
    }

    public double getVal2() {
        return val2;
    }

    public void setVal2(double val2) {
        this.val2 = val2;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public void insertarBsTaw() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.anio);
        datos.add(this.mesf);
        datos.add(this.nser);
        datos.add(this.nose);
        datos.add(this.nhpc);
        datos.add(this.noco);
        datos.add(this.ncat);
        datos.add(this.noca);
        datos.add(this.fiva);
        datos.add(this.vafa);
        datos.add(this.desd);
        datos.add(this.hast);
        datos.add(this.cmon);
        datos.add(this.val1);
        datos.add(this.val2);
        datos.add(this.stat);

        DBmanager.insertarTupla(DBhelper.NOMTATAW, DBhelper.COLSBSTAW, datos);
        DBmanager.CerrarBD();
    }

    public LinkedList<BsTaw> obtenerTarifa(int anio, int mesf, int nhpc, int nrocat){

            LinkedList<BsTaw> listTaw = new LinkedList<>();
            DBmanager.AbrirBD();
            // Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);
            String condicion = DBhelper.COLBSTAWANIO + " = " + anio +" and "+ DBhelper.COLBSTAWMESF +" = " +mesf;
            condicion= condicion+ " and "+ DBhelper.COLBSTAWNHPC + " = "+ nhpc + " and " + DBhelper.COLBSTAWNCAT+"="+nrocat;

            String orderBy= DBhelper.COLBSTAWDESD +" ASC";
            Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTATAW, DBhelper.COLSBSTAW, condicion , orderBy);
            while (cursor.moveToNext()) {
                BsTaw taw = new BsTaw();
                taw.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWANIO))));
                taw.setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWMESF))));
                taw.setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNSER))));
                taw.setNose(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNOSE)));
                taw.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNHPC))));
                taw.setNoco(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNOCO)));
                taw.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNCAT)).trim()));
                taw.setNoca(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNOCA)));
                taw.setFiva(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWFIVA)));
                taw.setVafa(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWVAFA)));
                taw.setDesd(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWDESD))));
                taw.setHast(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWHAST))));
                taw.setCmon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWCMON))));
                taw.setVal1(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWVAL1))));
                taw.setVal2(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWVAL2))));
                taw.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWSTAT))));

                Log.e("BSTAW", "obtenerTarifa se anhadio una tarifa  a la lista ");
                listTaw.add(taw);


            }

            return listTaw;


    }

    public BsTaw obtenerTarifaDesde(int anio, int mesf, int nhpc,int ncat,  int desde){

        DBmanager.AbrirBD();
        // Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);
        String condicion = DBhelper.COLBSTAWANIO + " = " + anio +" and "+ DBhelper.COLBSTAWMESF +" = " +mesf;
        condicion= condicion+ " and "+ DBhelper.COLBSTAWNHPC + " = "+ nhpc + " ";
        condicion= condicion+ " and "+ DBhelper.COLBSTAWDESD + " = "+ desde  +" and " + DBhelper.COLBSTAWNCAT+ "= "+ ncat;
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTATAW, DBhelper.COLSBSTAW, condicion, null);
        BsTaw taw = new BsTaw();
        if (cursor.moveToNext()) {
            taw.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWANIO))));
            taw.setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWMESF))));
            taw.setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNSER))));
            taw.setNose(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNOSE)));
            taw.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNHPC))));
            taw.setNoco(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNOCO)));
            taw.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNCAT)).trim()));
            taw.setNoca(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWNOCA)));
            taw.setFiva(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWFIVA)));
            taw.setVafa(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWVAFA)));
            taw.setDesd(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWDESD))));
            taw.setHast(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWHAST))));
            taw.setCmon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWCMON))));
            taw.setVal1(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWVAL1))));
            taw.setVal2(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWVAL2))));
            taw.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSTAWSTAT))));

            Log.e("BSTAW", "obtenerTarifaDesde se anhadio una tarifa  a la lista ");
        }

        return taw;


    }

    public int countRegister(){
        int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTATAW);
        return cant;
    }

}
