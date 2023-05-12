package com.lecturadorv2.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 4/19/2017.
 */
public class BsDpw {
// bsdpfNhpf
// bsdpfOrde
// bsdpfNhpc
// bshpcDesc
// bsdpfCant
// bsdpfPuni
// bsdpfImpt
    private int Nhpf;
    private int Orde;
    private int Nhpc;
    private String Desc;
    private double Cant;
    private double Puni;
    private double Impt;

    public BsDpw() {
        this.Nhpf=0;
        this.Orde=0;
        this.Nhpc=0;
        this.setDesc("");
        this.Cant=0;
        this.Puni=0;
        this.Impt=0;

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

    public void insertarBsDpw() {


// bsdpfNhpf
// bsdpfOrde
// bsdpfNhpc
// bshpcDesc
// bsdpfCant
// bsdpfPuni
// bsdpfImpt
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Nhpf);
        datos.add(this.Orde);
        datos.add(this.Nhpc);
        datos.add(this.Desc);
        datos.add(this.Cant);
        datos.add(this.Puni);
        datos.add(this.Impt);

        DBmanager.insertarTupla(DBhelper.NOMTADPW, DBhelper.COLSBSDPW, datos);
        DBmanager.CerrarBD();
    }

    public void obtenerDpw(int nhpf, int nhpc ){
        DBmanager.AbrirBD();
        String condicion = DBhelper.COLBSDHWNCNT +" = "+ nhpf + "";

        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTADPW, DBhelper.COLSBSDPW, condicion, null);
        if (cursor.moveToNext()) {
            this.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPF))));
            this.setOrde(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWORDE))));
            this.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPC))));
            this.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWDESC)));
            this.setCant(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCANT))));
            this.setPuni(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWPUNI))));
            this.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWIMPT))));
            Log.e("BSdpw", "obtenerDpw se OBTIENE un REGISTRO ");
        }
    }

/*
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
*/
    public LinkedList<BsDpw> listarDetallesToEnviar(int nhpf  ){
        DBmanager.AbrirBD();
        String condicion = DBhelper.COLBSDPWNHPF +" = "+ nhpf ;

        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTADPW, DBhelper.COLSBSDPW, condicion, null);
        LinkedList<BsDpw> listDpws = new LinkedList<BsDpw>();
        while (cursor.moveToNext()) {
            BsDpw dpw = new BsDpw();
            dpw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPF))));
            dpw.setOrde(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWORDE))));
            dpw.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWNHPC))));
            dpw.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWDESC)));
            dpw.setCant(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCANT))));
            dpw.setPuni(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWPUNI))));
            dpw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWIMPT))));
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
            dpw.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCANT)));
            dpw.setCant(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWCANT))));
            dpw.setPuni(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWPUNI))));
            dpw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSDPWIMPT))));
            Log.e("BSdpw", "listarDetalles se adiciona un REGISTRO ");
            listDpws.add(dpw);
        }
        return listDpws;
    }

    public void eliminarDetalle(int NHPF) {
        DBmanager.AbrirBD();
        DBmanager.eliminarTupla(DBhelper.NOMTADPW, DBhelper.COLBSDPWNHPF + " = " + NHPF + " ");
        DBmanager.CerrarBD();
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
                "  Nhpf=" + Nhpf +
                ", Orde=" + Orde +
                ", Nhpc=" + Nhpc +
                ", Desc='" + Desc + '\'' +
                ", Cant=" + Cant +
                ", Puni='" + Puni + '\'' +
                ", Impt='" + Impt + '\'' +
                '}';
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
