package com.lecturador.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 4/19/2017.
 */
public class BsDpw {
    private int Nhpf;
    private int Orde;
    private int Nhpc;
    private String Dhpc;
    private int Ncat;
    private String Dcat;
    private String Ncta;
    private int Cmon;
    private double Tcam;
    private double Cant;
    private double Puni;
    private double Impt;
    private String Cref;
    private double Faci;
    private String Inex;
    private int Cprd;
    private int Ntpo;
    private int Ntpc;
    private int Stad;
    private int Stat;
    private int Ride;

    public BsDpw() {
        this.Nhpf=0;
        this.Orde=0;
        this.Nhpc=0;
        this.Dhpc="";
        this.Ncat=0;
        this.Dcat="";
        this.Ncta="";
        this.Cmon=0;
        this.Tcam=0;
        this.Cant=0;
        this.Puni=0;
        this.Impt=0;
        this.Cref="";
        this.Faci=0;
        this.Inex="";
        this.Cprd=0;
        this.Ntpo=0;
        this.Ntpc=0;
        this.Stad=0;
        this.Stat=0;
        this.Ride=0;
    }

    public int getNhpf() {
        return Nhpf;
    }

    public void setNhpf(int nhpf) {
        Nhpf = nhpf;
    }

    public int getOrde() {
        return Orde;
    }

    public void setOrde(int orde) {
        Orde = orde;
    }

    public int getNhpc() {
        return Nhpc;
    }

    public void setNhpc(int nhpc) {
        Nhpc = nhpc;
    }

    public String getDhpc() {
        return Dhpc;
    }

    public void setDhpc(String dhpc) {
        Dhpc = dhpc;
    }

    public int getNcat() {
        return Ncat;
    }

    public void setNcat(int ncat) {
        Ncat = ncat;
    }

    public String getDcat() {
        return Dcat;
    }

    public void setDcat(String dcat) {
        Dcat = dcat;
    }

    public String getNcta() {
        return Ncta;
    }

    public void setNcta(String ncta) {
        Ncta = ncta;
    }

    public int getCmon() {
        return Cmon;
    }

    public void setCmon(int cmon) {
        Cmon = cmon;
    }

    public double getTcam() {
        return Tcam;
    }

    public void setTcam(double tcam) {
        Tcam = tcam;
    }

    public double getCant() {
        return Cant;
    }

    public void setCant(double cant) {
        Cant = cant;
    }

    public double getPuni() {
        return Puni;
    }

    public void setPuni(double puni) {
        Puni = puni;
    }

    public double getImpt() {
        return Impt;
    }

    public void setImpt(double impt) {
        Impt = impt;
    }

    public String getCref() {
        return Cref;
    }

    public void setCref(String cref) {
        Cref = cref;
    }

    public double getFaci() {
        return Faci;
    }

    public void setFaci(double faci) {
        Faci = faci;
    }

    public String getInex() {
        return Inex;
    }

    public void setInex(String inex) {
        Inex = inex;
    }

    public int getCprd() {
        return Cprd;
    }

    public void setCprd(int cprd) {
        Cprd = cprd;
    }

    public int getNtpo() {
        return Ntpo;
    }

    public void setNtpo(int ntpo) {
        Ntpo = ntpo;
    }

    public int getNtpc() {
        return Ntpc;
    }

    public void setNtpc(int ntpc) {
        Ntpc = ntpc;
    }

    public int getStad() {
        return Stad;
    }

    public void setStad(int stad) {
        Stad = stad;
    }

    public int getStat() {
        return Stat;
    }

    public void setStat(int stat) {
        Stat = stat;
    }

    public int getRide() {
        return Ride;
    }

    public void setRide(int ride) {
        Ride = ride;
    }

    public void insertarBsDpw() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Nhpf);
        datos.add(this.Orde);
        datos.add(this.Nhpc);
        datos.add(this.Dhpc);
        datos.add(this.Ncat);
        datos.add(this.Dcat);
        datos.add(this.Ncta);
        datos.add(this.Cmon);
        datos.add(this.Tcam);
        datos.add(this.Cant);
        datos.add(this.Puni);
        datos.add(this.Impt);
        datos.add(this.Cref);
        datos.add(this.Faci);
        datos.add(this.Inex);
        datos.add(this.Cprd);
        datos.add(this.Ntpo);
        datos.add(this.Ntpc);
        datos.add(this.Stad);
        datos.add(this.Stat);
        datos.add(this.Ride);
        DBmanager.insertarTupla(DBhelper.NOMTADPW, DBhelper.COLSBSDPW, datos);
        DBmanager.CerrarBD();
    }


    public void obtenerDpw(int nhpf, int nhpc ){


        DBmanager.AbrirBD();
        String condicion = DBhelper.COLBSDPWNHPF +" = "+ nhpf +" and "+ DBhelper.COLBSDPWNHPC +" = "+ nhpc + "";

        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTADPW, DBhelper.COLSBSDPW, condicion, null);
        if (cursor.moveToNext()) {
            this.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPF))));
            this.setOrde(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWORDE))));
            this.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPC))));
            this.setDhpc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWDHPC)));
            this.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNCAT))));
            this.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWDCAT)));
            this.setNcta(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNCTA)));
            this.setCmon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCMON))));
            this.setTcam(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWTCAM))));
            this.setCant(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCANT))));
            this.setPuni(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWPUNI))));
            this.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWIMPT))));
            this.setCref(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCREF)));
            this.setFaci(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWFACI))));
            this.setInex(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWINEX)));
            this.setCprd(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCPRD))));
            this.setNtpo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNTPO))));
            this.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNTPC))));
            this.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWSTAD))));
            this.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWSTAT))));
            this.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWRIDE))));


            Log.e("BSdpw", "obtenerDpw se OBTIENE un REGISTRO ");
        }

    }


    public LinkedList<BsDpw> obtenerOtrosDetalles(int nhpf, int ncat  ){

       LinkedList<BsDpw> list= listarDetalles(nhpf);


        DBmanager.AbrirBD();
        String condicion = DBhelper.COLBSDPWNHPF +" = "+ nhpf +" and "+ DBhelper.COLBSDPWNHPC +" <>  7002 and " +
                 DBhelper.COLBSDPWNHPC + "!= 7080  " +
                " and "+DBhelper.COLBSDPWNHPC + "!= 7004 " +
                " and "+ DBhelper.COLBSDPWNHPC+ "!= 7050 " +
                " and "+ DBhelper.COLBSDPWNHPC+ "!= 7101 " +
                " and "+ DBhelper.COLBSDPWNCAT +" = "+ ncat + " "+
                " and "+ DBhelper.COLBSDPWSTAD+ " = 1  ";

        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTADPW, DBhelper.COLSBSDPW, condicion, null);
        LinkedList<BsDpw> listDpws = new LinkedList<BsDpw>();
        while (cursor.moveToNext()) {
            BsDpw dpw = new BsDpw();
            dpw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPF))));
            dpw.setOrde(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWORDE))));
            dpw.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPC))));
            dpw.setDhpc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWDHPC)));
            dpw.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNCAT))));
            dpw.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWDCAT)));
            dpw.setNcta(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNCTA)));
            dpw.setCmon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCMON))));
            dpw.setTcam(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWTCAM))));
            dpw.setCant(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCANT))));
            dpw.setPuni(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWPUNI))));
            dpw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWIMPT))));
            dpw.setCref(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCREF)));
            dpw.setFaci(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWFACI))));
            dpw.setInex(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWINEX)));
            dpw.setCprd(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCPRD))));
            dpw.setNtpo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNTPO))));
            dpw.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNTPC))));
            dpw.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWSTAD))));
            dpw.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWSTAT))));
            dpw.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWRIDE))));


            Log.e("BSdpw", "obtenerOtrosDetalles se adiciona un REGISTRO ");
            listDpws.add(dpw);
        }
        return listDpws;

    }

    public LinkedList<BsDpw> listarDetallesToEnviar(int nhpf  ){


        DBmanager.AbrirBD();
        String condicion = DBhelper.COLBSDPWNHPF +" = "+ nhpf +" and  "+ DBhelper.COLBSDPWSTAD + " = 1 ";

        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTADPW, DBhelper.COLSBSDPW, condicion, null);
        LinkedList<BsDpw> listDpws = new LinkedList<BsDpw>();
        while (cursor.moveToNext()) {
            BsDpw dpw = new BsDpw();
            dpw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPF))));
            dpw.setOrde(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWORDE))));
            dpw.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPC))));
            dpw.setDhpc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWDHPC)));
            dpw.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNCAT))));
            dpw.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWDCAT)));
            dpw.setNcta(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNCTA)));
            dpw.setCmon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCMON))));
            dpw.setTcam(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWTCAM))));
            dpw.setCant(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCANT))));
            dpw.setPuni(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWPUNI))));
            dpw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWIMPT))));
            dpw.setCref(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCREF)));
            dpw.setFaci(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWFACI))));
            dpw.setInex(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWINEX)));
            dpw.setCprd(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCPRD))));
            dpw.setNtpo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNTPO))));
            dpw.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNTPC))));
            dpw.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWSTAD))));
            dpw.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWSTAT))));
            dpw.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWRIDE))));


            Log.e("BSdpw", "listarDetalles se adiciona un REGISTRO ");
            listDpws.add(dpw);
        }
        return listDpws;

    }

    public LinkedList<BsDpw> listarDetalles(int nhpf  ){


        DBmanager.AbrirBD();
        String condicion = DBhelper.COLBSDPWNHPF +" = "+ nhpf +"  ";

        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTADPW, DBhelper.COLSBSDPW, condicion, null);
        LinkedList<BsDpw> listDpws = new LinkedList<BsDpw>();
        while (cursor.moveToNext()) {
            BsDpw dpw = new BsDpw();
            dpw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPF))));
            dpw.setOrde(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWORDE))));
            dpw.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPC))));
            dpw.setDhpc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWDHPC)));
            dpw.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNCAT))));
            dpw.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWDCAT)));
            dpw.setNcta(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNCTA)));
            dpw.setCmon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCMON))));
            dpw.setTcam(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWTCAM))));
            dpw.setCant(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCANT))));
            dpw.setPuni(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWPUNI))));
            dpw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWIMPT))));
            dpw.setCref(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCREF)));
            dpw.setFaci(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWFACI))));
            dpw.setInex(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWINEX)));
            dpw.setCprd(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCPRD))));
            dpw.setNtpo(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNTPO))));
            dpw.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNTPC))));
            dpw.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWSTAD))));
            dpw.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWSTAT))));
            dpw.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWRIDE))));


            Log.e("BSdpw", "listarDetalles se adiciona un REGISTRO ");
            listDpws.add(dpw);
        }
        return listDpws;

    }

    public void registrarCantidad(){
        String condicion = DBhelper.COLBSDPWNHPF +" = "+ this.Nhpf +" and "+ DBhelper.COLBSDPWNHPC +" = "+ this.Nhpc + "" ;
            DBmanager.AbrirBD();
            List<Object> datos = new ArrayList<Object>();
            datos.add(this.Cant);
            String[] columna = new String[1];
            columna[0] = DBhelper.COLBSDPWCANT;
            DBmanager.modificarTupla(DBhelper.NOMTADPW, columna, datos, condicion);
            DBmanager.CerrarBD();
    }

    public void registrarPrecioUnitario(){
        String condicion = DBhelper.COLBSDPWNHPF +" = "+ this.Nhpf +" and "+ DBhelper.COLBSDPWNHPC +" = "+ this.Nhpc + "" ;
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Puni);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSDPWPUNI;
        DBmanager.modificarTupla(DBhelper.NOMTADPW, columna, datos, condicion);
        DBmanager.CerrarBD();
    }

    public void registrarImporte(){
        String condicion = DBhelper.COLBSDPWNHPF +" = "+ this.Nhpf +" and "+ DBhelper.COLBSDPWNHPC +" = "+ this.Nhpc + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Impt);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSDPWIMPT;
        DBmanager.modificarTupla(DBhelper.NOMTADPW, columna, datos, condicion);
        DBmanager.CerrarBD();
    }

    public int countRegister(){
        int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTADPW);
        return cant;
    }

    @Override
    public String toString() {
        return "BsDpw{" +
                "Nhpf=" + Nhpf +
                ", Orde=" + Orde +
                ", Nhpc=" + Nhpc +
                ", Dhpc='" + Dhpc + '\'' +
                ", Ncat=" + Ncat +
                ", Dcat='" + Dcat + '\'' +
                ", Ncta='" + Ncta + '\'' +
                ", Cmon=" + Cmon +
                ", Tcam=" + Tcam +
                ", Cant=" + Cant +
                ", Puni=" + Puni +
                ", Impt=" + Impt +
                ", Cref='" + Cref + '\'' +
                ", Faci=" + Faci +
                ", Inex='" + Inex + '\'' +
                ", Cprd=" + Cprd +
                ", Ntpo=" + Ntpo +
                ", Ntpc=" + Ntpc +
                ", Stad=" + Stad +
                ", Stat=" + Stat +
                ", Ride=" + Ride +
                '}';
    }
}
