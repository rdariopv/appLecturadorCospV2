package com.lecturadorv2.android.dblecturador;

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
private int Anio;
    private int Cobs;
    private int Codf;
    private int Cons;
    private String Dbar;
    private String Dcat;
    private String Dciu;
    private int Dias;
    private String Dimb;
    private String Dire;
    private String Dlot;
    private String Dmes;
    private String Dmza;
    private String Dnom;
    private String Drut;
    private String Duve;
    private String Dzon;
    private String Fcor;
    private String Ffin;
    private String Fini;
    private String Fvto;
    private double Imor;
    private double Impt;
    private int Lact;
    private int Lant;
    private int Ncnt;
    private int Nhpf;
    private int Nmor;

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

    public String toString() {
        return "BsHpw{  Nhpf=" + this.Nhpf + ", Ncnt=" + this.Ncnt + ", Lant=" + this.Lant + ", Lact='" + this.Lact + ", Cons='" + this.Cons + ", Fini='" + this.Fini + ", Ffin='" + this.Ffin + ", Dire=" + this.Dire + ", Dnom=" + this.Dnom + ", Dcat='" + this.Dcat + ", Dciu=" + this.Dciu + ", Duve=" + this.Duve + ", Dmza=" + this.Dmza + ", Dlot=" + this.Dlot + ", Dbar=" + this.Dbar + ", Dimb='" + this.Dimb + ", Dzon='" + this.Dzon + ", Drut=" + this.Drut + ", Cobs=" + getCobs() + '}';
    }

    public void insertarBsHpw() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<>();
        datos.add(Integer.valueOf(this.Nhpf));
        datos.add(Integer.valueOf(this.Ncnt));
        datos.add(Integer.valueOf(this.Lant));
        datos.add(Integer.valueOf(this.Lact));
        datos.add(Integer.valueOf(this.Cons));
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
        datos.add(Integer.valueOf(this.Cobs));
        datos.add(Integer.valueOf(this.Nmor));
        datos.add(Double.valueOf(this.Imor));
        datos.add(this.Fcor);
        datos.add(Double.valueOf(this.Impt));
        datos.add(Integer.valueOf(this.Codf));
        datos.add(Integer.valueOf(this.Anio));
        datos.add(this.Dmes);
        datos.add(Integer.valueOf(this.Dias));
        datos.add(this.Fvto);
        DBmanager.insertarTupla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, datos);
        DBmanager.CerrarBD();
    }

    public void guardarLecturaActual() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<>();
        datos.add(Integer.valueOf(getLact()));
        String[] columna = new String[2];
        columna[0] = DBhelper.COLBSHPWLACT;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, DBhelper.COLBSHPWNHPF + " = " + getNhpf() + " ");
        DBmanager.CerrarBD();
    }

    public void eliminarHeader(int NCNT) {
        DBmanager.AbrirBD();
        DBmanager.eliminarTupla(DBhelper.NOMTAHPW, DBhelper.COLBSHPWNCNT + " = " + NCNT + " ");
        DBmanager.CerrarBD();
    }

    public void guardarImporteConsumo() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<>();
        datos.add(Integer.valueOf(this.Cons));
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, new String[]{DBhelper.COLBSHPWCONS}, datos, DBhelper.COLBSHPWNHPF + " = " + getNhpf() + " ");
        DBmanager.CerrarBD();
    }

    public void guardarConsumo() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<>();
        datos.add(Integer.valueOf(getCons()));
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, new String[]{DBhelper.COLBSHPWCONS}, datos, DBhelper.COLBSHPWNHPF + " = " + getNhpf() + " ");
        DBmanager.CerrarBD();
    }

    public void guardarObservacion() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<>();
        datos.add(Integer.valueOf(getCobs()));
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, new String[]{DBhelper.COLBSHPWCOBS}, datos, DBhelper.COLBSHPWNHPF + " = " + getNhpf() + " ");
        DBmanager.CerrarBD();
    }

    public LinkedList<BsHpw> listarBsHpw() {
        LinkedList<BsHpw> listHpw = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);
        while (cursor.moveToNext()) {
            BsHpw hpw = new BsHpw();
            hpw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))).intValue());
            hpw.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))).intValue());
            hpw.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))).intValue());
            hpw.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))).intValue());
            hpw.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))).intValue());
            hpw.setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            hpw.setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            hpw.setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
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
            hpw.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))).intValue());
            hpw.setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))).intValue());
            hpw.setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))).doubleValue());
            hpw.setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
            hpw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))).doubleValue());
            hpw.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))).intValue());
            hpw.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))).intValue());
            hpw.setDmes(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMES)));
            hpw.setDias(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIAS))).intValue());
            Log.e("BSHPW", "listarHPW se anhadio un Header a la lista ");
            listHpw.add(hpw);
        }
        return listHpw;
    }

    public void obtenerBsHpw(int nhpf) {
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, DBhelper.COLBSHPWNHPF + " = " + nhpf, (String) null);
        new BsHpw();
        if (cursor.moveToNext()) {
            setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))).intValue());
            setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))).intValue());
            setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))).intValue());
            setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))).intValue());
            setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))).intValue());
            setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
            setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            setDnom(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))).intValue());
            setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))).intValue());
            setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))).doubleValue());
            setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
            setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))).doubleValue());
            setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))).intValue());
            setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))).intValue());
            setDmes(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMES)));
            setDias(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIAS))).intValue());
            Log.e("BSHPW", "obtenerBsHpw se obtiene el Header con el nhpf= " + nhpf);
        }
    }

    public void obtenerBsHpwbyNcnt(int liNcnt) {
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, DBhelper.COLBSHPWNCNT + " = " + liNcnt, (String) null);
        new BsHpw();
        if (cursor.moveToNext()) {
            setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))).intValue());
            setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))).intValue());
            setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))).intValue());
            setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))).intValue());
            setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))).intValue());
            setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
            setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            setDnom(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDNOM)));
            setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))).intValue());
            setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))).intValue());
            setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))).doubleValue());
            setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
            setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))).doubleValue());
            setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))).intValue());
            setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))).intValue());
            setDmes(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMES)));
            setDias(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIAS))).intValue());
            Log.e("BSHPW", "obtenerBsHpw se obtiene el Header con el Ncnt= " + liNcnt);
        }
    }

    public boolean getBsHpwbyNcnt(int liNcnt) {
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, DBhelper.COLBSHPWNCNT + " = " + liNcnt, (String) null);
        new BsHpw();
        if (!cursor.moveToNext()) {
            return false;
        }
        setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))).intValue());
        setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))).intValue());
        setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))).intValue());
        setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))).intValue());
        setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))).intValue());
        setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
        setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
        setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
        setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
        setDnom(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDNOM)));
        setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
        setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
        setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
        setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
        setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
        setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
        setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
        setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
        setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
        setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))).intValue());
        setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))).intValue());
        setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))).doubleValue());
        setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
        setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))).doubleValue());
        setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))).intValue());
        setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))).intValue());
        setDmes(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMES)));
        setDias(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIAS))).intValue());
        Log.e("BSHPW", "obtenerBsHpw se obtiene el Header con el Ncnt= " + liNcnt);
        return true;
    }

    public int countRegister() {
        return DBmanager.Cantidad_de_Registros(DBhelper.NOMTAHPW);
    }

    public int getNhpf() {
        return this.Nhpf;
    }

    public void setNhpf(int nhpf) {
        this.Nhpf = nhpf;
    }

    public int getNcnt() {
        return this.Ncnt;
    }

    public void setNcnt(int ncnt) {
        this.Ncnt = ncnt;
    }

    public int getLant() {
        return this.Lant;
    }

    public void setLant(int lant) {
        this.Lant = lant;
    }

    public int getLact() {
        return this.Lact;
    }

    public void setLact(int lact) {
        this.Lact = lact;
    }

    public int getCons() {
        return this.Cons;
    }

    public void setCons(int cons) {
        this.Cons = cons;
    }

    public String getFini() {
        return this.Fini;
    }

    public void setFini(String fini) {
        this.Fini = fini;
    }

    public String getFfin() {
        return this.Ffin;
    }

    public void setFfin(String ffin) {
        this.Ffin = ffin;
    }

    public String getDire() {
        return this.Dire;
    }

    public void setDire(String dire) {
        this.Dire = dire;
    }

    public String getDnom() {
        return this.Dnom;
    }

    public void setDnom(String dnom) {
        this.Dnom = dnom;
    }

    public String getDcat() {
        return this.Dcat;
    }

    public void setDcat(String dcat) {
        this.Dcat = dcat;
    }

    public String getDciu() {
        return this.Dciu;
    }

    public void setDciu(String dciu) {
        this.Dciu = dciu;
    }

    public String getDuve() {
        return this.Duve;
    }

    public void setDuve(String duve) {
        this.Duve = duve;
    }

    public String getDmza() {
        return this.Dmza;
    }

    public void setDmza(String dmza) {
        this.Dmza = dmza;
    }

    public String getDlot() {
        return this.Dlot;
    }

    public void setDlot(String dlot) {
        this.Dlot = dlot;
    }

    public String getDbar() {
        return this.Dbar;
    }

    public void setDbar(String dbar) {
        this.Dbar = dbar;
    }

    public String getDimb() {
        return this.Dimb;
    }

    public void setDimb(String dimb) {
        this.Dimb = dimb;
    }

    public String getDzon() {
        return this.Dzon;
    }

    public void setDzon(String dzon) {
        this.Dzon = dzon;
    }

    public String getDrut() {
        return this.Drut;
    }

    public void setDrut(String drut) {
        this.Drut = drut;
    }

    public int getCobs() {
        return this.Cobs;
    }

    public void setCobs(int cobs) {
        this.Cobs = cobs;
    }

    public int getNmor() {
        return this.Nmor;
    }

    public void setNmor(int nmor) {
        this.Nmor = nmor;
    }

    public double getImor() {
        return this.Imor;
    }

    public void setImor(double imor) {
        this.Imor = imor;
    }

    public String getFcor() {
        return this.Fcor;
    }

    public void setFcor(String fcor) {
        this.Fcor = fcor;
    }

    public double getImpt() {
        return this.Impt;
    }

    public void setImpt(double impt) {
        this.Impt = impt;
    }

    public int getCodf() {
        return this.Codf;
    }

    public void setCodf(int codf) {
        this.Codf = codf;
    }

    public int getDias() {
        return this.Dias;
    }

    public void setDias(int dias) {
        this.Dias = dias;
    }

    public int getAnio() {
        return this.Anio;
    }

    public void setAnio(int anio) {
        this.Anio = anio;
    }

    public String getDmes() {
        return this.Dmes;
    }

    public void setDmes(String dmes) {
        this.Dmes = dmes;
    }

    public String getFvto() {
        return this.Fvto;
    }

    public void setFvto(String fvto) {
        this.Fvto = fvto;
    }

}
