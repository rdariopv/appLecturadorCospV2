package com.lecturador.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 4/19/2017.
 */
public class BsHpw implements Serializable {

//bshpfNhpf
//bshpfNcnt
//bshpfLant
//bshpfLact
//bshpfCons
//bshpfFini
//bshpfFfin
//bshpfDire
//bshpfDnom
//bshpfDcat
//bshpfDciu
//bshpfDuve
//bshpfDmza
//bshpfDlot
//bshpfDbar
//bshpfDimb
//bshpfDzon
//bshpfDrut

private int    Nhpf;
private int    Ncnt;
private int    Lant;
private int    Lact;
private int    Cons;
private String Fini;
private String Ffin;
private String Dire;
private String Dnom;
private String Dcat;
private String Dciu;
private String Duve;
private String Dmza;
private String Dlot;
private String Dbar;
private String Dimb;
private String Dzon;
private String Drut;
private int Cobs;

private int Nmor;
private double Imor;
private String Fcor;

    public BsHpw() {
        setNhpf(0);

        setDcat("");
        setLant(0);
        setLact(0);
        setCons(0);

        setFini("");
        setFfin("");
        setNcnt(0);
        setDciu("");
        setDuve("");
        setDmza("");
        setDlot("");
        setDbar("");
        setDimb("");
        setDzon("");
        setDrut("");
        setDire("");
        setCobs(0);

    }

    @Override
    public String toString() {
        return "BsHpw{" +
                "  Nhpf="  + this.Nhpf +
                ", Ncnt="  + this.Ncnt +
                ", Lant="  + this.Lant +
                ", Lact='" + this.Lact +
                ", Cons='" + this.Cons +
                ", Fini='" + this.Fini +
                ", Ffin='" + this.Ffin +
                ", Dire="  + this.Dire +
                ", Dnom="  + this.Dnom +
                ", Dcat='" + this.Dcat +
                ", Dciu="  + this.Dciu +
                ", Duve="  + this.Duve +
                ", Dmza="  + this.Dmza +
                ", Dlot="  + this.Dlot +
                ", Dbar="  + this.Dbar +
                ", Dimb='" + this.Dimb +
                ", Dzon='" + this.Dzon +
                ", Drut="  + this.Drut +
                ", Cobs="  + this.Cobs +
                '}';
    }

    public void insertarBsHpw() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Nhpf);
        datos.add(this.Ncnt);
        datos.add(this.Lant);
        datos.add(this.Lact);
        datos.add(this.Cons);
        datos.add(this.Fini);
        datos.add(this.Ffin);
        datos.add(this.Dire);
        datos.add(this.Dnom);
        datos.add(this.Dcat);
        datos.add(this.Dciu);
        datos.add(this.Duve);
        datos.add(this.Dmza);
        datos.add(this.Dlot);
        datos.add(this.Dbar);
        datos.add(this.Dimb);
        datos.add(this.Dzon);
        datos.add(this.Drut);
        datos.add(this.Cobs);

        DBmanager.insertarTupla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, datos);
        DBmanager.CerrarBD();
    }

    public void guardarLecturaActual() {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.getLact());

        String[] columna = new String[2];
        columna[0] = DBhelper.COLBSHPWLACT;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }

    public void guardarImporteConsumo() {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Cons);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSHPWCONS;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }

    public void guardarConsumo(){
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.getCons());
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSHPWCONS;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }

    public void guardarObservacion() {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Cobs);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSHPWCOBS;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }


/*
    public void registrarTotal(int nhpf){
        obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        LinkedList<BsDpw> listDtl= dpw.listarDetalles(this.getNhpf());
        double total=0;
        for (BsDpw dtl:listDtl ) {
            total=total+ dtl.getImpt();
        }
        this.setImpt(total);
        Double imor = total+this.getImor();
        this.setImor(imor);
       //this.Nmor=this.Nmor+1;
        this.setNmor(this.Nmor+1);

        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Impt);
        datos.add(this.Imor);
        datos.add(this.Nmor);
        String[] columna = new String[3];
        columna[0] = DBhelper.COLBSHPWIMPT;
        columna[1] = DBhelper.COLBSHPWIMOR;
        columna[2] = DBhelper.COLBSHPWNMOR;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();


    }*/

    public LinkedList<BsHpw> listarBsHpw() {
        LinkedList<BsHpw> listHpw = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);

        while (cursor.moveToNext()) {
            BsHpw hpw = new BsHpw();
            hpw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))));
            hpw.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))));
            hpw.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            hpw.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            hpw.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            hpw.setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            hpw.setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            hpw.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            hpw.setDnom(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            hpw.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            hpw.setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            hpw.setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            hpw.setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            hpw.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            hpw.setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            hpw.setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            hpw.setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            hpw.setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            hpw.setCobs(Integer.valueOf( cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))));

            Log.e("BSHPW", "listarHPW se anhadio un Header a la lista ");


            listHpw.add(hpw);


        }

        return listHpw;
    }
/*
    public LinkedList<BsHpw> listarNoLecturadosBsHpw() {
        LinkedList<BsHpw> listHpw = new LinkedList<>();
        DBmanager.AbrirBD();
        // Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);
        String condicion = DBhelper.COLBSHPWSTAT + " = 0";
        String orderby = DBhelper.COLBSHPWCODF  +" ASC";
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, condicion,orderby);
        while (cursor.moveToNext()) {
            BsHpw hpw = new BsHpw();
            hpw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))));
            hpw.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))));
            hpw.setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWMESF))));
            hpw.setFgen(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFGEN)));
            hpw.setFent(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFENT)));
            hpw.setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
            hpw.setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
            hpw.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPC))));
            hpw.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCAT))));
            hpw.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            hpw.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            hpw.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))));
            hpw.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))));
            hpw.setConf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONF))));
            hpw.setImco(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMCO))));
            hpw.setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            hpw.setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            hpw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))));
            hpw.setIcfi(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWICFI))));
            hpw.setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))));
            hpw.setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))));
            hpw.setCmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCMOR))));
            hpw.setCort(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCORT)));
            hpw.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDESC)));
            hpw.setCper(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCPER))));
            hpw.setNomb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNOMB)));
            hpw.setNmed(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMED))));
            hpw.setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUME)));
            hpw.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))));
            hpw.setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNSER))));
            hpw.setDpto(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDPTO))));
            hpw.setNpro(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNPRO))));
            hpw.setNciu(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCIU))));
            hpw.setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            hpw.setNuve(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUVE))));
            hpw.setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            hpw.setNmza(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMZA))));
            hpw.setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            hpw.setNlot(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLOT))));
            hpw.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            hpw.setNbar(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNBAR))));
            hpw.setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            hpw.setNimb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNIMB))));
            hpw.setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            hpw.setNzon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNZON))));
            hpw.setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            hpw.setNrut(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRUT))));
            hpw.setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            hpw.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))));
            hpw.setNred(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRED))));
            hpw.setNvia(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNVIA))));
            hpw.setNroi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNROI))));
            hpw.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            hpw.setClas(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCLAS))));
            hpw.setIplv(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIPLV))));
            hpw.setNfac(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNFAC))));
            hpw.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTPC))));
            hpw.setNtcn(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTCN))));
            hpw.setNdtb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNDTB))));
            hpw.setOnof(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWONOF))));
            hpw.setLmax(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLMAX))));
            hpw.setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONP))));
            hpw.setKvat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWKVAT))));
            hpw.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))));
            hpw.setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLEC))));
            hpw.setPtjc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWPTJC))));
            hpw.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAD))));
            hpw.setLati(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLATI)));
            hpw.setLong(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLONG)));
            hpw.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAT))));
            hpw.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWRIDE))));

            Log.e("BSHPW", "listarNoLecturadosBsHpw se anhadio un Header a la lista ");


            listHpw.add(hpw);


        }
        DBmanager.CerrarBD();
        return listHpw;
    }

    public LinkedList<BsHpw> listarLecturadosBsHpw() {
        LinkedList<BsHpw> listHpw = new LinkedList<>();
        DBmanager.AbrirBD();
        // Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);
        String condicion = DBhelper.COLBSHPWSTAT + " = -100 and "+ DBhelper.COLBSHPWSTAD +" = 1";
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, condicion, null);
        while (cursor.moveToNext()) {
            BsHpw hpw = new BsHpw();
            hpw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))));
            hpw.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))));
            hpw.setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWMESF))));
            hpw.setFgen(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFGEN)));
            hpw.setFent(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFENT)));
            hpw.setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
            hpw.setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
            hpw.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPC))));
            hpw.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCAT))));
            hpw.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            hpw.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            hpw.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))));
            hpw.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))));
            hpw.setConf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONF))));
            hpw.setImco(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMCO))));
            hpw.setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            hpw.setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            hpw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))));
            hpw.setIcfi(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWICFI))));
            hpw.setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))));
            hpw.setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))));
            hpw.setCmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCMOR))));
            hpw.setCort(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCORT)));
            hpw.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDESC)));
            hpw.setCper(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCPER))));
            hpw.setNomb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNOMB)));
            hpw.setNmed(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMED))));
            hpw.setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUME)));
            hpw.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))));
            hpw.setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNSER))));
            hpw.setDpto(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDPTO))));
            hpw.setNpro(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNPRO))));
            hpw.setNciu(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCIU))));
            hpw.setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            hpw.setNuve(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUVE))));
            hpw.setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            hpw.setNmza(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMZA))));
            hpw.setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            hpw.setNlot(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLOT))));
            hpw.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            hpw.setNbar(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNBAR))));
            hpw.setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            hpw.setNimb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNIMB))));
            hpw.setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            hpw.setNzon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNZON))));
            hpw.setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            hpw.setNrut(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRUT))));
            hpw.setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            hpw.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))));
            hpw.setNred(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRED))));
            hpw.setNvia(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNVIA))));
            hpw.setNroi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNROI))));
            hpw.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            hpw.setClas(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCLAS))));
            hpw.setIplv(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIPLV))));
            hpw.setNfac(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNFAC))));
            hpw.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTPC))));
            hpw.setNtcn(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTCN))));
            hpw.setNdtb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNDTB))));
            hpw.setOnof(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWONOF))));
            hpw.setLmax(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLMAX))));
            hpw.setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONP))));
            hpw.setKvat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWKVAT))));
            hpw.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))));
            hpw.setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLEC))));
            hpw.setPtjc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWPTJC))));
            hpw.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAD))));
            hpw.setLati(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLATI)));
            hpw.setLong(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLONG)));
            hpw.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAT))));
            hpw.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWRIDE))));

            Log.e("BSHPW", "listarLecturadosBsHpw se anhadio un Header a la lista ");
            listHpw.add(hpw);
        }
        return listHpw;
    }
*/
    public void obtenerBsHpw(int nhpf) {
       // LinkedList<BsHpw> listHpw = new LinkedList<>();
        DBmanager.AbrirBD();
        // Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);
        String condicion = DBhelper.COLBSHPWNHPF + " = " + nhpf;
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, condicion, null);
        BsHpw hpw = new BsHpw();
        if (cursor.moveToNext()) {
           // BsHpw hpw = new BsHpw();
            this.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))));
            this.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))));
            this.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            this.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            this.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            this.setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            this.setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            this.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            this.setDnom(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            this.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            this.setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            this.setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            this.setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            this.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            this.setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            this.setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            this.setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            this.setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            this.setCobs(Integer.valueOf( cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))));


            Log.e("BSHPW", "obtenerBsHpw se obtiene el Header con el nhpf= "+ nhpf);
        }

    }

/*
    public boolean obtenerBsHpwByNroContrato(int NroContrato) {

        boolean existe=false;
        DBmanager.AbrirBD();
        String condicion = DBhelper.COLBSHPWCODF  + " = " + NroContrato;
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, condicion, null);
        BsHpw hpw = new BsHpw();
        if (cursor.moveToNext()) {
            // BsHpw hpw = new BsHpw();
            this.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))));
            this.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))));
            this.setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWMESF))));
            this.setFgen(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFGEN)));
            this.setFent(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFENT)));
            this.setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
            this.setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
            this.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPC))));
            this.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCAT))));
            this.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            this.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            this.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))));
            this.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))));
            this.setConf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONF))));
            this.setImco(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMCO))));
            this.setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            this.setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            this.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))));
            this.setIcfi(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWICFI))));
            this.setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))));
            this.setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))));
            this.setCmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCMOR))));
            this.setCort(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCORT)));
            this.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDESC)));
            this.setCper(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCPER))));
            this.setNomb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNOMB)));
            this.setNmed(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMED))));
            this.setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUME)));
            this.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))));
            this.setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNSER))));
            this.setDpto(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDPTO))));
            this.setNpro(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNPRO))));
            this.setNciu(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCIU))));
            this.setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            this.setNuve(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUVE))));
            this.setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            this.setNmza(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMZA))));
            this.setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            this.setNlot(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLOT))));
            this.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            this.setNbar(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNBAR))));
            this.setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            this.setNimb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNIMB))));
            this.setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            this.setNzon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNZON))));
            this.setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            this.setNrut(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRUT))));
            this.setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            this.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))));
            this.setNred(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRED))));
            this.setNvia(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNVIA))));
            this.setNroi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNROI))));
            this.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            this.setClas(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCLAS))));
            this.setIplv(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIPLV))));
            this.setNfac(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNFAC))));
            this.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTPC))));
            this.setNtcn(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTCN))));
            this.setNdtb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNDTB))));
            this.setOnof(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWONOF))));
            this.setLmax(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLMAX))));
            this.setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONP))));
            this.setKvat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWKVAT))));
            this.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))));
            this.setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLEC))));
            this.setPtjc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWPTJC))));
            this.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAD))));
            this.setLati(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLATI)));
            this.setLong(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLONG)));
            this.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAT))));
            this.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWRIDE))));

            existe=true;
            Log.e("BSHPW", "obtenerBsHpwByCodigoFijo se obtiene el Header con el NroContrato= "+ NroContrato);
        }
     return existe;
    }*/

    public int countRegister(){
        int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTAHPW);
        return cant;
    }

    public int getNhpf() {
        return Nhpf;
    }

    public void setNhpf(int nhpf) {
        Nhpf = nhpf;
    }

    public int getNcnt() {
        return Ncnt;
    }

    public void setNcnt(int ncnt) {
        Ncnt = ncnt;
    }

    public int getLant() {
        return Lant;
    }

    public void setLant(int lant) {
        Lant = lant;
    }

    public int getLact() {
        return Lact;
    }

    public void setLact(int lact) {
        Lact = lact;
    }

    public int getCons() {
        return Cons;
    }

    public void setCons(int cons) {
        Cons = cons;
    }

    public String getFini() {
        return Fini;
    }

    public void setFini(String fini) {
        Fini = fini;
    }

    public String getFfin() {
        return Ffin;
    }

    public void setFfin(String ffin) {
        Ffin = ffin;
    }

    public String getDire() {
        return Dire;
    }

    public void setDire(String dire) {
        Dire = dire;
    }

    public String getDnom() {
        return Dnom;
    }

    public void setDnom(String dnom) {
        Dnom = dnom;
    }

    public String getDcat() {
        return Dcat;
    }

    public void setDcat(String dcat) {
        Dcat = dcat;
    }

    public String getDciu() {
        return Dciu;
    }

    public void setDciu(String dciu) {
        Dciu = dciu;
    }

    public String getDuve() {
        return Duve;
    }

    public void setDuve(String duve) {
        Duve = duve;
    }

    public String getDmza() {
        return Dmza;
    }

    public void setDmza(String dmza) {
        Dmza = dmza;
    }

    public String getDlot() {
        return Dlot;
    }

    public void setDlot(String dlot) {
        Dlot = dlot;
    }

    public String getDbar() {
        return Dbar;
    }

    public void setDbar(String dbar) {
        Dbar = dbar;
    }

    public String getDimb() {
        return Dimb;
    }

    public void setDimb(String dimb) {
        Dimb = dimb;
    }

    public String getDzon() {
        return Dzon;
    }

    public void setDzon(String dzon) {
        Dzon = dzon;
    }

    public String getDrut() {
        return Drut;
    }

    public void setDrut(String drut) {
        Drut = drut;
    }

    public int getCobs() {
        return Cobs;
    }

    public void setCobs(int cobs) {
        Cobs = cobs;
    }

    public int getNmor() {
        return Nmor;
    }

    public void setNmor(int nmor) {
        Nmor = nmor;
    }

    public double getImor() {
        return Imor;
    }

    public void setImor(double imor) {
        Imor = imor;
    }

    public String getFcor() {
        return Fcor;
    }

    public void setFcor(String fcor) {
        Fcor = fcor;
    }
}
