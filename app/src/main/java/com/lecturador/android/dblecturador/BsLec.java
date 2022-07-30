package com.lecturador.android.dblecturador;

import android.database.Cursor;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BsLec implements Serializable {
   /*
   *  BslecNlec   integer  ID de lectura
      BslecAact   integer  año
      BslecMact   integer  mes
      BslecCodf   integer  codigo ubicacion
      BslecNcnt   integer  codigo fijo
      BslecLant   integer  lectura anterior
      BslecConp   integer  consumo promedio
      BslecMedi   integer  Si tiene medidor
      BslecNume   string   numero de medidor
      BslecdNom   string   nombre del asociado
      BslecDire   string   direccion
      BslecDUve   string   uve
      BslecDMza   string   manzana
      BslecDlot   string   lote
   *
   * */
        private int    Nlec;
        private int    Aact;
        private int    Mact;
        private int    Codf;
        private int    Ncnt;
        private int    Lant;
        private int    Conp;
        private int    Medi;
        private String Nume;
        private String dNom;
        private String Dire;
        private String DUve;
        private String DMza;
        private String Dlot;

        /*aqui mis utilitarios*/
        private int Cobs;   // codigo de observacion
        private int Stat;   // estado de 0: no esta lecturado; 1: esta lecturado
        private int Lact;   // lectura actual

    public BsLec() {
    }

    public int getNlec() {
        return Nlec;
    }

    public void setNlec(int nlec) {
        Nlec = nlec;
    }

    public int getAact() {
        return Aact;
    }

    public void setAact(int aact) {
        Aact = aact;
    }

    public int getMact() {
        return Mact;
    }

    public void setMact(int mact) {
        Mact = mact;
    }

    public int getCodf() {
        return Codf;
    }

    public void setCodf(int codf) {
        Codf = codf;
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

    public int getConp() {
        return Conp;
    }

    public void setConp(int conp) {
        Conp = conp;
    }

    public int getMedi() {
        return Medi;
    }

    public void setMedi(int medi) {
        Medi = medi;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getdNom() {
        return dNom;
    }

    public void setdNom(String dNom) {
        this.dNom = dNom;
    }

    public String getDire() {
        return Dire;
    }

    public void setDire(String dire) {
        Dire = dire;
    }

    public String getDUve() {
        return DUve;
    }

    public void setDUve(String DUve) {
        this.DUve = DUve;
    }

    public String getDMza() {
        return DMza;
    }

    public void setDMza(String DMza) {
        this.DMza = DMza;
    }

    public String getDlot() {
        return Dlot;
    }

    public void setDlot(String dlot) {
        Dlot = dlot;
    }

    public int getCobs() {
        return Cobs;
    }

    public void setCobs(int cobs) {
        Cobs = cobs;
    }

    public int getStat() {
        return Stat;
    }

    public void setStat(int stat) {
        Stat = stat;
    }

    public int getLact() {
        return Lact;
    }

    public void setLact(int lact) {
        Lact = lact;
    }
    public void insertarBsLec() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Nlec);
        datos.add(this.Aact);
        datos.add(this.Mact);
        datos.add(this.Codf);
        datos.add(this.Ncnt);
        datos.add(this.Lant);
        datos.add(this.Conp);
        datos.add(this.Medi);
        datos.add(this.Nume);
        datos.add(this.dNom);
        datos.add(this.Dire);
        datos.add(this.DUve);
        datos.add(this.DMza);
        datos.add(this.Dlot);
        datos.add(this.Cobs);
        datos.add(this.Stat);
        datos.add(this.Lact);

        DBmanager.insertarTupla(DBhelper.NOMTABSLEC, DBhelper.COLSBSLEC, datos);
        DBmanager.CerrarBD();
    }
    public void guardarObservacion() {
        String lsConsulta = DBhelper.COLBSLECNLEC + " = " + this.getNlec() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Cobs);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSLECCOBS;
        DBmanager.modificarTupla(DBhelper.NOMTABSLEC, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }


    public LinkedList<BsLec> listarBslec() {
        LinkedList<BsLec> listLec = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTABSLEC , DBhelper.COLSBSLEC);

        while (cursor.moveToNext()) {
            BsLec lec = new BsLec();
            lec.setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECNLEC))));
            lec.setAact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECAACT))));
            lec.setMact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECMACT))));
            lec.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECCODF))));
            lec.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECNCNT))));
            lec.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECLANT))));
            lec.setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECCONP))));
            lec.setMedi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECMEDI))));
            lec.setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECNUME)));
            lec.setdNom(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDNOM)));
            lec.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDIRE)));
            lec.setDUve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDUVE)));
            lec.setDMza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDMZA)));
            lec.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDLOT)));
            lec.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECCOBS))));
            lec.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECSTAT))));
            lec.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECLACT))));

            Log.e("BSLEC", "listarLEC se anhadio un Header a la lista ");


            listLec.add(lec);


        }

        return listLec;
    }


    public LinkedList<BsLec> listarNoLecturadosBsLec() {
        LinkedList<BsLec> listLec = new LinkedList<>();
        DBmanager.AbrirBD();
        // Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);
        String condicion = DBhelper.COLBSLECLACT  +" = 0 ";
        String orderby = DBhelper.COLBSLECCODF  +" ASC";
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTABSLEC, DBhelper.COLSBSLEC, condicion,orderby);
        while (cursor.moveToNext()) {
            BsLec lec = new BsLec();
            lec.setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECNLEC))));
            lec.setAact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECAACT))));
            lec.setMact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECMACT))));
            lec.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECCODF))));
            lec.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECNCNT))));
            lec.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECLANT))));
            lec.setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECCONP))));
            lec.setMedi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECMEDI))));
            lec.setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECNUME)));
            lec.setdNom(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDNOM)));
            lec.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDIRE)));
            lec.setDUve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDUVE)));
            lec.setDMza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDMZA)));
            lec.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDLOT)));
            lec.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECCOBS))));
            lec.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECSTAT))));
            lec.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECLACT))));

            Log.e("BSLEC", "listarLEC se anhadio un Header a la lista ");


            listLec.add(lec);


        }
        DBmanager.CerrarBD();
        return listLec;
    }


    public void obtenerBsLec(int nlec) {
        // LinkedList<BsHpw> listHpw = new LinkedList<>();
        DBmanager.AbrirBD();
        // Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);
        String condicion = DBhelper.COLBSLECNLEC + " = " + nlec;
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTABSLEC, DBhelper.COLSBSLEC, condicion, null);

        if (cursor.moveToNext()) {
            // BsHpw hpw = new BsHpw();
           this.setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECNLEC))));
           this.setAact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECAACT))));
           this.setMact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECMACT))));
           this.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECCODF))));
           this.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECNCNT))));
           this.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECLANT))));
           this.setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECCONP))));
           this.setMedi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECMEDI))));
           this.setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECNUME)));
           this.setdNom(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDNOM)));
           this.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDIRE)));
           this.setDUve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDUVE)));
           this.setDMza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDMZA)));
           this.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECDLOT)));
           this.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECCOBS))));
           this.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECSTAT))));
           this.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSLECLACT))));




            Log.e("BSHPW", "obtenerBsHpw se obtiene el Header con el nlec= "+ nlec);
        }

    }

    public void guardarLact() {
        String lsConsulta = DBhelper.COLBSLECNLEC + " = " + this.getNlec() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Lact);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSLECLACT;
        DBmanager.modificarTupla(DBhelper.NOMTABSLEC, columna, datos, lsConsulta);
        DBmanager.CerrarBD();

    }
}
