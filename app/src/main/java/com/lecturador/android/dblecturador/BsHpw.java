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
    private int Nhpf;
    private int Anio;
    private int Mesf;
    private String Fgen;
    private String Fent;
    private String Fvto;
    private String Fcor;
    private int Nhpc;
    private int Ncat;
    private String Dcat;
    private int Lant;
    private int Lact;
    private int Cons;
    private int Conf;
    private double Imco;
    private String Fini;
    private String Ffin;
    private double Impt;
    private double Icfi;
    private double Imor;
    private int Nmor;
    private int Cmor;
    private String Cort;
    private String Desc;
    private int Cper;
    private String Nomb;
    private int Nmed;
    private String Nume;
    private int Ncnt;
    private int Nser;
    private int Dpto;
    private int Npro;
    private int Nciu;
    private String Dciu;
    private int Nuve;
    private String Duve;
    private int Nmza;
    private String Dmza;
    private int Nlot;
    private String Dlot;
    private int Nbar;
    private String Dbar;
    private int Nimb;
    private String Dimb;
    private int Nzon;
    private String Dzon;
    private int Nrut;
    private String Drut;
    private int Codf;
    private int Nred;
    private int Nvia;
    private int Nroi;
    private String Dire;
    private int Clas;
    private int Iplv;
    private int Nfac;
    private int Ntpc;
    private int Ntcn;
    private int Ndtb;
    private int Onof;
    private int Lmax;
    private int Conp;
    private int Kvat;
    private int Cobs;
    private int Nlec;
    private int Ptjc;
    private int Stad;
    private String Lati;
    private String Long;
    private int Stat;
    private int Ride;


    public BsHpw() {
        Nhpf = 0;
        Anio = 0;
        Mesf = 0;
        Fgen = "";
        Fent = "";
        Fvto = "";
        Fcor = "";
        Nhpc = 0;
        Ncat = 0;
        Dcat = "";
        Lant = 0;
        Lact = 0;
        Cons = 0;
        Conf = 0;
        Imco = 0;
        Fini = "";
        Ffin = "";
        Impt = 0;
        Icfi = 0;
        Imor = 0;
        Nmor = 0;
        Cmor = 0;
        Cort = "";
        Desc = "";
        Cper = 0;
        Nomb = "";
        Nmed = 0;
        Nume = "";
        Ncnt = 0;
        Nser = 0;
        Dpto = 0;
        Npro = 0;
        Nciu = 0;
        Dciu = "";
        Nuve = 0;
        Duve = "";
        Nmza = 0;
        Dmza = "";
        Nlot = 0;
        Dlot = "";
        Nbar = 0;
        Dbar = "";
        Nimb = 0;
        Dimb = "";
        Nzon = 0;
        Dzon = "";
        Nrut = 0;
        Drut = "";
        Codf = 0;
        Nred = 0;
        Nvia = 0;
        Nroi = 0;
        Dire = "";
        Clas = 0;
        Iplv = 0;
        Nfac = 0;
        Ntpc = 0;
        Ntcn = 0;
        Ndtb = 0;
        Onof = 0;
        Lmax = 0;
        Conp = 0;
        Kvat = 0;
        Cobs = 0;
        Nlec = 0;
        Ptjc = 0;
        Stad = 0;
        Lati = "";
        Long = "";
        Stat = 0;
        Ride = 0;
    }

    public int getNhpf() {
        return Nhpf;
    }

    public void setNhpf(int nhpf) {
        Nhpf = nhpf;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int anio) {
        Anio = anio;
    }

    public int getMesf() {
        return Mesf;
    }

    public void setMesf(int mesf) {
        Mesf = mesf;
    }

    public String getFgen() {
        return Fgen;
    }

    public void setFgen(String fgen) {
        Fgen = fgen;
    }

    public String getFent() {
        return Fent;
    }

    public void setFent(String fent) {
        Fent = fent;
    }

    public String getFvto() {
        return Fvto;
    }

    public void setFvto(String fvto) {
        Fvto = fvto;
    }

    public String getFcor() {
        return Fcor;
    }

    public void setFcor(String fcor) {
        Fcor = fcor;
    }

    public int getNhpc() {
        return Nhpc;
    }

    public void setNhpc(int nhpc) {
        Nhpc = nhpc;
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

    public int getConf() {
        return Conf;
    }

    public void setConf(int conf) {
        Conf = conf;
    }

    public double getImco() {
        return Imco;
    }

    public void setImco(double imco) {
        Imco = imco;
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

    public double getImpt() {
        return Impt;
    }

    public void setImpt(double impt) {
        Impt = impt;
    }

    public double getIcfi() {
        return Icfi;
    }

    public void setIcfi(double icfi) {
        Icfi = icfi;
    }

    public double getImor() {
        return Imor;
    }

    public void setImor(double imor) {
        Imor = imor;
    }

    public int getNmor() {
        return Nmor;
    }

    public void setNmor(int nmor) {
        Nmor = nmor;
    }

    public int getCmor() {
        return Cmor;
    }

    public void setCmor(int cmor) {
        Cmor = cmor;
    }

    public String getCort() {
        return Cort;
    }

    public void setCort(String cort) {
        Cort = cort;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getCper() {
        return Cper;
    }

    public void setCper(int cper) {
        Cper = cper;
    }

    public String getNomb() {
        return Nomb;
    }

    public void setNomb(String nomb) {
        Nomb = nomb;
    }

    public int getNmed() {
        return Nmed;
    }

    public void setNmed(int nmed) {
        Nmed = nmed;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public int getNcnt() {
        return Ncnt;
    }

    public void setNcnt(int ncnt) {
        Ncnt = ncnt;
    }

    public int getNser() {
        return Nser;
    }

    public void setNser(int nser) {
        Nser = nser;
    }

    public int getDpto() {
        return Dpto;
    }

    public void setDpto(int dpto) {
        Dpto = dpto;
    }

    public int getNpro() {
        return Npro;
    }

    public void setNpro(int npro) {
        Npro = npro;
    }

    public int getNciu() {
        return Nciu;
    }

    public void setNciu(int nciu) {
        Nciu = nciu;
    }

    public String getDciu() {
        return Dciu;
    }

    public void setDciu(String dciu) {
        Dciu = dciu;
    }

    public int getNuve() {
        return Nuve;
    }

    public void setNuve(int nuve) {
        Nuve = nuve;
    }

    public String getDuve() {
        return Duve;
    }

    public void setDuve(String duve) {
        Duve = duve;
    }

    public int getNmza() {
        return Nmza;
    }

    public void setNmza(int nmza) {
        Nmza = nmza;
    }

    public String getDmza() {
        return Dmza;
    }

    public void setDmza(String dmza) {
        Dmza = dmza;
    }

    public int getNlot() {
        return Nlot;
    }

    public void setNlot(int nlot) {
        Nlot = nlot;
    }

    public String getDlot() {
        return Dlot;
    }

    public void setDlot(String dlot) {
        Dlot = dlot;
    }

    public int getNbar() {
        return Nbar;
    }

    public void setNbar(int nbar) {
        Nbar = nbar;
    }

    public String getDbar() {
        return Dbar;
    }

    public void setDbar(String dbar) {
        Dbar = dbar;
    }

    public int getNimb() {
        return Nimb;
    }

    public void setNimb(int nimb) {
        Nimb = nimb;
    }

    public String getDimb() {
        return Dimb;
    }

    public void setDimb(String dimb) {
        Dimb = dimb;
    }

    public int getNzon() {
        return Nzon;
    }

    public void setNzon(int nzon) {
        Nzon = nzon;
    }

    public String getDzon() {
        return Dzon;
    }

    public void setDzon(String dzon) {
        Dzon = dzon;
    }

    public int getNrut() {
        return Nrut;
    }

    public void setNrut(int nrut) {
        Nrut = nrut;
    }

    public String getDrut() {
        return Drut;
    }

    public void setDrut(String drut) {
        Drut = drut;
    }

    public int getCodf() {
        return Codf;
    }

    public void setCodf(int codf) {
        Codf = codf;
    }

    public int getNred() {
        return Nred;
    }

    public void setNred(int nred) {
        Nred = nred;
    }

    public int getNvia() {
        return Nvia;
    }

    public void setNvia(int nvia) {
        Nvia = nvia;
    }

    public int getNroi() {
        return Nroi;
    }

    public void setNroi(int nroi) {
        Nroi = nroi;
    }

    public String getDire() {
        return Dire;
    }

    public void setDire(String dire) {
        Dire = dire;
    }

    public int getClas() {
        return Clas;
    }

    public void setClas(int clas) {
        Clas = clas;
    }

    public int getIplv() {
        return Iplv;
    }

    public void setIplv(int iplv) {
        Iplv = iplv;
    }

    public int getNfac() {
        return Nfac;
    }

    public void setNfac(int nfac) {
        Nfac = nfac;
    }

    public int getNtpc() {
        return Ntpc;
    }

    public void setNtpc(int ntpc) {
        Ntpc = ntpc;
    }

    public int getNtcn() {
        return Ntcn;
    }

    public void setNtcn(int ntcn) {
        Ntcn = ntcn;
    }

    public int getNdtb() {
        return Ndtb;
    }

    public void setNdtb(int ndtb) {
        Ndtb = ndtb;
    }

    public int getOnof() {
        return Onof;
    }

    public void setOnof(int onof) {
        Onof = onof;
    }

    public int getLmax() {
        return Lmax;
    }

    public void setLmax(int lmax) {
        Lmax = lmax;
    }

    public int getConp() {
        return Conp;
    }

    public void setConp(int conp) {
        Conp = conp;
    }

    public int getKvat() {
        return Kvat;
    }

    public void setKvat(int kvat) {
        Kvat = kvat;
    }

    public int getCobs() {
        return Cobs;
    }

    public void setCobs(int cobs) {
        Cobs = cobs;
    }

    public int getNlec() {
        return Nlec;
    }

    public void setNlec(int nlec) {
        Nlec = nlec;
    }

    public int getPtjc() {
        return Ptjc;
    }

    public void setPtjc(int ptjc) {
        Ptjc = ptjc;
    }

    public int getStad() {
        return Stad;
    }

    public void setStad(int stad) {
        Stad = stad;
    }

    public String getLati() {
        return Lati;
    }

    public void setLati(String lati) {
        Lati = lati;
    }

    public String getLong() {
        return Long;
    }

    public void setLong(String aLong) {
        Long = aLong;
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

    @Override
    public String toString() {
        return "BsHpw{" +
                "Nhpf=" + Nhpf +
                ", Anio=" + Anio +
                ", Mesf=" + Mesf +
                ", Fgen='" + Fgen + '\'' +
                ", Fent='" + Fent + '\'' +
                ", Fvto='" + Fvto + '\'' +
                ", Fcor='" + Fcor + '\'' +
                ", Nhpc=" + Nhpc +
                ", Ncat=" + Ncat +
                ", Dcat='" + Dcat + '\'' +
                ", Lant=" + Lant +
                ", Lact=" + Lact +
                ", Cons=" + Cons +
                ", Conf=" + Conf +
                ", Imco=" + Imco +
                ", Fini='" + Fini + '\'' +
                ", Ffin='" + Ffin + '\'' +
                ", Impt=" + Impt +
                ", Icfi=" + Icfi +
                ", Imor=" + Imor +
                ", Nmor=" + Nmor +
                ", Cmor=" + Cmor +
                ", Cort='" + Cort + '\'' +
                ", Desc='" + Desc + '\'' +
                ", Cper=" + Cper +
                ", Nomb='" + Nomb + '\'' +
                ", Nmed=" + Nmed +
                ", Nume='" + Nume + '\'' +
                ", Ncnt=" + Ncnt +
                ", Nser=" + Nser +
                ", Dpto=" + Dpto +
                ", Npro=" + Npro +
                ", Nciu=" + Nciu +
                ", Dciu='" + Dciu + '\'' +
                ", Nuve=" + Nuve +
                ", Duve='" + Duve + '\'' +
                ", Nmza=" + Nmza +
                ", Dmza='" + Dmza + '\'' +
                ", Nlot=" + Nlot +
                ", Dlot='" + Dlot + '\'' +
                ", Nbar=" + Nbar +
                ", Dbar='" + Dbar + '\'' +
                ", Nimb=" + Nimb +
                ", Dimb='" + Dimb + '\'' +
                ", Nzon=" + Nzon +
                ", Dzon='" + Dzon + '\'' +
                ", Nrut=" + Nrut +
                ", Drut='" + Drut + '\'' +
                ", Codf=" + Codf +
                ", Nred=" + Nred +
                ", Nvia=" + Nvia +
                ", Nroi=" + Nroi +
                ", Dire='" + Dire + '\'' +
                ", Clas=" + Clas +
                ", Iplv=" + Iplv +
                ", Nfac=" + Nfac +
                ", Ntpc=" + Ntpc +
                ", Ntcn=" + Ntcn +
                ", Ndtb=" + Ndtb +
                ", Onof=" + Onof +
                ", Lmax=" + Lmax +
                ", Conp=" + Conp +
                ", Kvat=" + Kvat +
                ", Cobs=" + Cobs +
                ", Nlec=" + Nlec +
                ", Ptjc=" + Ptjc +
                ", Stad=" + Stad +
                ", Lati=" + Lati +
                ", Long=" + Long +
                ", Stat=" + Stat +
                ", Ride=" + Ride +
                '}';
    }

    public void insertarBsHpw() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Nhpf);
        datos.add(this.Anio);
        datos.add(this.Mesf);
        datos.add(this.Fgen);
        datos.add(this.Fent);
        datos.add(this.Fvto);
        datos.add(this.Fcor);
        datos.add(this.Nhpc);
        datos.add(this.Ncat);
        datos.add(this.Dcat);
        datos.add(this.Lant);
        datos.add(this.Lact);
        datos.add(this.Cons);
        datos.add(this.Conf);
        datos.add(this.Imco);
        datos.add(this.Fini);
        datos.add(this.Ffin);
        datos.add(this.Impt);
        datos.add(this.Icfi);
        datos.add(this.Imor);
        datos.add(this.Nmor);
        datos.add(this.Cmor);
        datos.add(this.Cort);
        datos.add(this.Desc);
        datos.add(this.Cper);
        datos.add(this.Nomb);
        datos.add(this.Nmed);
        datos.add(this.Nume);
        datos.add(this.Ncnt);
        datos.add(this.Nser);
        datos.add(this.Dpto);
        datos.add(this.Npro);
        datos.add(this.Nciu);
        datos.add(this.Dciu);
        datos.add(this.Nuve);
        datos.add(this.Duve);
        datos.add(this.Nmza);
        datos.add(this.Dmza);
        datos.add(this.Nlot);
        datos.add(this.Dlot);
        datos.add(this.Nbar);
        datos.add(this.Dbar);
        datos.add(this.Nimb);
        datos.add(this.Dimb);
        datos.add(this.Nzon);
        datos.add(this.Dzon);
        datos.add(this.Nrut);
        datos.add(this.Drut);
        datos.add(this.Codf);
        datos.add(this.Nred);
        datos.add(this.Nvia);
        datos.add(this.Nroi);
        datos.add(this.Dire);
        datos.add(this.Clas);
        datos.add(this.Iplv);
        datos.add(this.Nfac);
        datos.add(this.Ntpc);
        datos.add(this.Ntcn);
        datos.add(this.Ndtb);
        datos.add(this.Onof);
        datos.add(this.Lmax);
        datos.add(this.Conp);
        datos.add(this.Kvat);
        datos.add(this.Cobs);
        datos.add(this.Nlec);
        datos.add(this.Ptjc);
        datos.add(this.Stad);
        datos.add(this.Lati);
        datos.add(this.Long);
        datos.add(this.Stat);
        datos.add(this.Ride);
        DBmanager.insertarTupla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, datos);
        DBmanager.CerrarBD();
    }

    public void guardarLecturaActual() {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Lact);
        datos.add(this.Stat);
        String[] columna = new String[2];
        columna[0] = DBhelper.COLBSHPWLACT;
        columna[1] = DBhelper.COLBSHPWSTAT;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }

    public void guardarImporteConsumo() {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Imco);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSHPWIMCO;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }

    public void guardarConsumo(){
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Cons);
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

    public void registrarUbicacion() {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.Nhpf + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Lati);
        datos.add(this.Long);
        Log.e("BSHPW", "registrarUbicacion: Latitud=" +this.Lati +" | Longitud="+this.Long );
        String[] columna = new String[2];
        columna[0] = DBhelper.COLBSHPWLATI;
        columna[1] = DBhelper.COLBSHPWLONG;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }


    public void actualizarEstado(int estado) {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        this.Stad=estado;
        List<Object> datos = new ArrayList<Object>();
        datos.add(estado);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSHPWSTAD;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }

    public void registrarTotal(int nhpf){
        obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        LinkedList<BsDpw> listDtl= dpw.listarDetalles(this.Nhpf);
        double total=0;
        for (BsDpw dtl:listDtl ) {
            total=total+ dtl.getImpt();
        }
        this.setImpt(total);
        Double imor = total+this.getImor();
        this.setImor(imor);
       //this.Nmor=this.Nmor+1;
        this.setNmor(this.Nmor+1);

        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.Nhpf + " ";
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


    }

    public LinkedList<BsHpw> listarBsHpw() {
        LinkedList<BsHpw> listHpw = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);

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
            hpw.setLati( cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLATI)));
            hpw.setLong(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLONG)));
            hpw.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAT))));
            hpw.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWRIDE))));

            Log.e("BSHPW", "listarHPW se anhadio un Header a la lista ");


            listHpw.add(hpw);


        }

        return listHpw;
    }

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

            Log.e("BSHPW", "obtenerBsHpw se obtiene el Header con el nhpf= "+ nhpf);
        }

    }


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
    }

    public int countRegister(){
        int cant= DBmanager.Cantidad_de_Registros(DBhelper.NOMTAHPW);
        return cant;
    }

}
