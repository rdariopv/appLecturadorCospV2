package com.lecturadorv2.android.zebra;

import android.os.Environment;
import android.util.Log;


import com.lecturadorv2.android.dblecturador.BsCcw;
import com.lecturadorv2.android.dblecturador.BsDhw;
import com.lecturadorv2.android.dblecturador.BsDpw;
import com.lecturadorv2.android.dblecturador.BsEnw;
import com.lecturadorv2.android.dblecturador.BsHpw;
import com.lecturadorv2.android.dblecturador.BsLec;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

//import static org.apache.commons.math.util.MathUtils.mulAndCheck;
//import static org.apache.commons.math.util.MathUtils.round;

/**
 * Created by Dario Pardo on 8/10/2017.
 */
public class MyZebra {

/*
   /* public StringBuilder imprimirLaPortenha(BsHpw Hpw) {
        StringBuilder sb = new StringBuilder();

        // sb.append("! 0 200 200 406 1\r\n");
        // sb.append("ON-FEED IGNORE\r\n");
        // sb.append("BOX 20 20 380 380 8\r\n");
        // sb.append("T 0 6 137 177 TEST\r\n");
        // sb.append("PRINT\r\n");
        // Av. Bolivar Nro. 137
        //   ¡¡ PARA CUALQUIER RECLAMO DENTRO DE LOS 7 DIAS DE EMISION !!
        //           Nota: C/Cobros:Coop. San Martin,Jesus Nazareno,PRODEM

        // sb.append("T 0 4 1 125  Paid: 5 $\r\n");
        //  sb.append("T 0 2 30 160   'LA PORTENA' LTDA. COOPERATIVA DE SERVICIOS PUBLICOS\r\n");
        //   sb.append("T 0 2 30 185       AGUA POTABLE Y ALZANTARILLADO SANITARIO\r\n");
        // sb.append("T 0 2 30 217 Av. Eduardo Silver s/n - San Ignacio de Velasco Santa Cruz Bolivia \r\n");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dl = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df1=new DecimalFormat("#.00");
        String [] laFini= Hpw.getFini().split("T");
        String [] laFin= Hpw.getFfin().split("T");
        String [] laFcor = Hpw.getFcor().split("T");

        String lsfini = laFini[0];
        String lsFin = (new Date().toString());
        String lsFcor = laFcor[0];
        Date fini = new Date();
        Date ffin = new Date();
        Date fcor = new Date();
        Calendar today= Calendar.getInstance();
        Calendar finicio= Calendar.getInstance();
        long dias=1;

        try {
            fini = df.parse(lsfini.trim());
            finicio.setTime(fini);
            long diff= today.getTimeInMillis()- finicio.getTimeInMillis();
            dias= (diff/(24*60*60*1000))+1;

            ffin = new Date();
            fcor= df.parse(lsFcor.trim());
            lsfini = dl.format(fini);
            lsFin = dl.format(ffin);
            lsFcor= dl.format(fcor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BsEnw enw = new BsEnw();
        enw.ObtenerBsEnw();
        sb.append("! 0 200 200 1100 1\r\n");
        sb.append("T 5 0 125 185          '" + enw.getNomb().trim() + "'\r\n");
        sb.append("T 5 0 125 217            " + enw.getDire().trim() + " \r\n");
        sb.append("T 5 0 125 246              NIT:" + enw.getNnit().trim() + "\r\n");
        sb.append("T 5 0 125 270         Telefono:" + enw.getTelf().trim() + "\r\n");
        sb.append("T 5 0 125 290 --------------------------------------------\r\n");
        sb.append("T 5 0 60 310            AVISO DE COBRANZA Nro. " + Hpw.getNhpf() + "\r\n");
        sb.append("T 0 3 20 338        MES " + enw.getDmes().trim() + "/" + enw.getAnio() + "\r\n");
        sb.append("T 5 0 40 358  ---------------------------------------------\r\n");
        // sb.append("T 5 0 40 358       Del:" + lsfini.trim() + " Al:" + lsFin.trim() + "\r\n");
        sb.append("T 7 0 30 390 Codigo Fijo: " + Hpw.getNcnt() + "\r\n");
        sb.append("T 7 0 30 415 Codigo de Persona: " + Hpw.getCper() + "\r\n");
        sb.append("T 7 0 30 440 Nombre: " + Hpw.getNomb().toUpperCase().trim() + "\r\n");
        sb.append("T 7 0 30 465 Direccion: " + Hpw.getDire().toUpperCase().trim() + "\r\n");
        sb.append("T 7 0 30 490 Ruta: " + Hpw.getDrut().trim() + "\r\n");
        sb.append("T 7 0 30 515 Cod.Ubic.: " + Hpw.getCodf()+ "; No.Medidor:"+Hpw.getNume() + "\r\n");
        sb.append("T 7 0 30 543 UV:" + Hpw.getDuve().trim() + " Mza:" + Hpw.getDmza().trim() + " lote:" + Hpw.getDlot().trim() + "\r\n");
        sb.append("T 7 0 30 568 Categoria: " + Hpw.getDcat().trim() + "\r\n");
        sb.append("T 7 0 30 591 Fecha Emision:\r\n");

        //sb.append("T 7 0 30 618 F.Emision:" + lsfini.trim() + "; dias consumo:" + dias + "\r\n");
        sb.append("T 7 0 30 618 Del:" + lsfini.trim() + "   Al:" + lsFin.trim() + "\r\n");
        sb.append("T 7 0 30 640 Dias Consumo:" + dias + "\r\n");
        sb.append("T 7 0 30 663 Lec. Ant:" + Hpw.getLant() + "  Lec. Act: " + Hpw.getLact() + "\r\n");
        sb.append("T 7 0 30 710 Consumo(M3): " + Hpw.getCons() + "\r\n");
        sb.append("T 5 0 40 735 --------------------------------------------\r\n");
        sb.append("T 5 0 40 758 CONCEPTOS\r\n");
        sb.append("T 5 0 40 780 --------------------------------------------\r\n");
        // sb.append("T 7 0 30 780 Consumo Agua Potable..............." + loitemLecturacion.getImco() + "\r\n");
        BsDpw dpw = new BsDpw();
        int yLon = 805;
        LinkedList<BsDpw> listDtl = dpw.listarDetalles(Hpw.getNhpf());

        for (BsDpw dtl : listDtl) {
            String lsDtl = dtl.getDhpc().trim();
            int longMax = 43;
            int cantPtos = longMax - lsDtl.length() - String.valueOf(dtl.getImpt()).length();
            String lsPtos = "";

            for (int i = 0; i < cantPtos; i++) {
                lsPtos = lsPtos + ".";
            }
            String impt= df1.format(dtl.getImpt());
            sb.append("T 7 0 30 " + yLon + "" + dtl.getDhpc().trim() + lsPtos + impt + "\r\n");
            yLon = yLon + 25;
        }
        yLon = yLon + 25;
        //  sb.append("T 7 0 30 "+yLon+" Recuperacion de Inversion.......... 9.64\r\n");
        //  sb.append("T 7 0 30 "+yLon+" Alcantarillado Sanitario...........12.18\r\n");
        //  sb.append("T 7 0 30 \"+yLon+\" AFCOOP D.S. 2762................... 0.50\r\n");
        int cantPtos= 43- (Hpw.getImpt()+"").length()-14;
        String lsPtos = "";
        for (int i = 0; i <cantPtos ; i++) {
            lsPtos = lsPtos + ".";
        }
        String impt= df1.format(Hpw.getImpt());
        sb.append("T 5 0 40 " + yLon + "Importe Total Bs:"+lsPtos + impt + "\r\n");


        yLon = yLon + 25;

        sb.append("T 5 0 40 " + yLon + "-------------------------------------\r\n");
        yLon = yLon + 25;
        String imor= df1.format(Hpw.getImor());
        sb.append("T 5 0 40 " + yLon + "facturas Impagas:" + Hpw.getNmor() + "        Total Bs:" + imor + "\r\n");
                yLon = yLon + 25;
        if(Hpw.getNmor()>1){
            sb.append("T 5 0 40 " + yLon + "Fecha de Corte:" + lsFcor.trim() +"\r\n");
            yLon = yLon + 25;
        }
        // sb.append("T 7 1 20 952 ESTIMADOS SOCIOS Y USUARIOS:CUALQUIER RECLAMO\r\n");
        // sb.append("T 7 1 20 990 DESPUES DE HABER EMITIDO EL AVISO\r\n");

        BsCcw ccobranza= new BsCcw();
        LinkedList<BsCcw> llcc=ccobranza.listarBsCcw();
        if(llcc.size()>0){
            for (int i = 2; i <=llcc.size() ; i++) {
                Log.e("MyZebra","centroCobranza="+i);
                BsCcw cc= llcc.get(i-1);
                String desc=cc.getDesc().substring(0,33);
                String desc2= cc.getDesc().substring(33,cc.getDesc().length());

                sb.append("T 7 0 20 "+yLon+desc+"\r\n");
                yLon = yLon + 25;
                sb.append("T 7 0 20 "+yLon+desc+"\r\n");
                yLon = yLon + 25;
            }
        }
       // sb.append("T 7 0 20 " + yLon + "CUALQUIER RECLAMO DENTRO DE 7 DIAS DE EMISION\r\n");
       // yLon = yLon + 25;
       // sb.append("T 7 0 20 " + yLon + "C/Cobros:Coop. San Martin,Jesus Nazareno,\r\n");

       // yLon = yLon + 25;
       // sb.append("T 7 0 20 " + yLon + "PRODEM\r\n");
        //   sb.append("FORM\r\n");
        sb.append("PRINT\r\n");
        //  configLabel = cpclConfigLabel.getBytes();
        //configLabel = sb.toString().getBytes();
        //}catch (Exception e){
        //    Toast.makeText(this, "aqui sucede un error " + e.toString(), Toast.LENGTH_SHORT).show();
        //}

        return sb;
    }*/

  /*  public StringBuilder printZPLVertical1(BsHpw Hpw){


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dl = new SimpleDateFormat("dd/MM/yyyy");

        DecimalFormat df1=new DecimalFormat("#.00");

        String [] laFini= Hpw.getFini().split("T");
        String [] laFin= Hpw.getFfin().split("T");
        String [] laFcor = Hpw.getFcor().split("T");

        String lsfini = laFini[0];
        String lsFin = (new Date().toString());
        String lsFcor = laFcor[0];
        Date fini = new Date();
        Date ffin = new Date();
        Date fcor = new Date();
        Calendar today= Calendar.getInstance();
        Calendar finicio= Calendar.getInstance();
        long dias=1;

        BsCcw ccobranza= new BsCcw();
        LinkedList<BsCcw> llcc=ccobranza.listarBsCcw();


        try {
            fini = df.parse(lsfini.trim());
            finicio.setTime(fini);
            long diff= today.getTimeInMillis()- finicio.getTimeInMillis();
            dias= (diff/(24*60*60*1000))+1;

            ffin = new Date();
            fcor= df.parse(lsFcor.trim());
            lsfini = dl.format(fini);
            lsFin = dl.format(ffin);
            lsFcor= dl.format(fcor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BsEnw enw = new BsEnw();
        enw.ObtenerBsEnw();


        StringBuilder sb=  new StringBuilder();
        int yLon=0;
        int xlon=80;
      //  sb.append("^XA");
      //  sb.append("! U1 setvar Non-Continuous ");
      //  sb.append("! U1 setvar Black Mark Sensor \"bar\"");
       // sb.append("~jc^xa^jus^xz");
        sb.append("^XA");
        //sb.append("^LT0");
        sb.append("^LH0,0^FS");
        sb.append("^FX Top section");
        //sb.append("^FO30,30^AD^FDaqui ya"+ "^FS");
        sb.append("^CF0,40");
        //^FB670,1,15,C,0
       // sb.append("^FO"+xlon+","+yLon+"^FB670,1,15,C,0^FD"+ enw.getNomb().trim() +"^FS");
        sb.append("^FO"+xlon+","+yLon+"^FB670,1,15,C,0^FD"+ enw.getNomb().trim() +"^FS");
        sb.append("^CF0,35");
     //   sb.append("Av. Bolivar Nro. 137");
        yLon=yLon+40;
        sb.append("^FO"+xlon+","+yLon+"^FB670,1,15,C,0^FD    " + enw.getDire().trim() +"^FS");
        yLon=yLon+40;
        sb.append("^FO"+xlon+","+yLon+"^FB670,1,15,C,0^FD NIT:" + enw.getNnit().trim() + "^FS");
        yLon=yLon+40;
        sb.append("^FO"+xlon+","+yLon+"^FB670,1,15,C,0^FD Telefono:" + enw.getTelf().trim() + "^FS");
        yLon=yLon+40;
        sb.append("^FO50,"+yLon+"^GB710,1,3^FS");
        sb.append("^CF0,30");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FB670,1,15,C,0^FD AVISO DE COBRANZA Nro. " + Hpw.getNhpf() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FB670,1,15,C,0^FD MES " + enw.getDmes().trim() + "/" + enw.getAnio() +"^FS");
        yLon=yLon+30;

        sb.append("^FO50,"+yLon+"^GB710,1,3^FS");
        // sb.append("T 5 0 40 358       Del:" + lsfini.trim() + " Al:" + lsFin.trim() + "\r\n");
        sb.append("^CF0,25");
       yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Codigo Fijo: " + Hpw.getNcnt() + "; ");
       // yLon=yLon+30;
        //sb.append("^FO"+xlon+","+yLon+"^FD Codigo de Persona: " + Hpw.getCper() + "^FS");
        sb.append(" Codigo de Persona: " + Hpw.getCper() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Nombre: " + Hpw.getNomb().toUpperCase().trim() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Direccion: " + Hpw.getDire().toUpperCase().trim() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Ruta: " + Hpw.getDrut().trim() + "; ");
        //yLon=yLon+30;
        //sb.append("^FO"+xlon+","+yLon+"^FD Cod.Ubic.: " + Hpw.getCodf()+ "; No.Medidor:"+Hpw.getNume() + "^FS");
        sb.append("Cod.Ubic.: " + Hpw.getCodf()+ "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD No.Medidor:"+Hpw.getNume().trim() + "; UV:" + Hpw.getDuve().trim() + " Mza:" + Hpw.getDmza().trim() + " lote:" + Hpw.getDlot().trim() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Categoria: " + Hpw.getDcat().trim() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Fecha Emision:^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Del:" + lsfini.trim() + "   Al:" + lsFin.trim() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Dias Consumo:" + dias + "; ");
       // yLon=yLon+30;
        sb.append(" Lec. Ant:" + Hpw.getLant() + ";  Lec. Act: " + Hpw.getLact() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Consumo(M3): " + Hpw.getCons() + "^FS");
        yLon=yLon+30;
        sb.append("^FO50,"+yLon+"^GB710,1,3^FS");
       // sb.append("^FO220,530^FD --------------------------------------------\r\n");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD CONCEPTOS^FS");
        yLon=yLon+30;
        sb.append("^FO50,"+yLon+"^GB710,1,3^FS");
       // sb.append("T 5 0 40 780 --------------------------------------------\r\n");

        BsDpw dpw = new BsDpw();
        yLon =yLon+45;
        LinkedList<BsDpw> listDtl = dpw.listarDetalles(Hpw.getNhpf());
        for (BsDpw dtl : listDtl) {
            String lsDtl = dtl.getDhpc().trim();
            String impt= df1.format(dtl.getImpt());
            int longMax = 73;
            int cantPtos = longMax - lsDtl.length() - impt.length();
            String lsPtos = "";
            for (int i = 0; i < cantPtos; i++) {
                lsPtos = lsPtos + ".";
            }
            sb.append("^FO"+xlon+"," + yLon + "^FD"+ dtl.getDhpc().trim() + lsPtos + impt + "^FS");
            yLon = yLon + 25;
        }
        yLon = yLon + 25;
        String impt= df1.format(Hpw.getImpt());
        int cantPtos= 73- impt.length()-14;
        String lsPtos = "";
        for (int i = 0; i <cantPtos ; i++) {
            lsPtos = lsPtos + ".";
        }
        sb.append("^FO"+xlon+"," + yLon + "^FD Importe Total Bs:"+lsPtos + impt + "^FS");


        yLon = yLon + 25;
        sb.append("^FO50,"+yLon+"^GB710,1,3^FS");
        //sb.append("T 5 0 40 " + yLon + "-------------------------------------\r\n");
        yLon = yLon + 25;
        String imor= df1.format(Hpw.getImor());
        sb.append("^FO"+xlon+","+yLon+"^FD facturas Impagas:" + Hpw.getNmor() + "        Total Bs:" + imor + "^FS");
        yLon = yLon + 25;
        if(Hpw.getNmor()>1){
            sb.append("^FO"+xlon+","+yLon+"^FD Fecha de Corte:" + lsFcor.trim() +"^FS");
            yLon = yLon + 25;
        }
        // sb.append("T 7 1 20 952 ESTIMADOS SOCIOS Y USUARIOS:CUALQUIER RECLAMO\r\n");
        // sb.append("T 7 1 20 990 DESPUES DE HABER EMITIDO EL AVISO\r\n");
       // sb.append("^FO"+xlon+","+yLon+"^FD CUALQUIER RECLAMO DENTRO DE 7 DIAS DE EMISION^FS");
       // yLon = yLon + 25;
       // sb.append("^FO"+xlon+","+yLon+"^FD C/Cobros:Coop. San Martin,Jesus Nazareno,^FS");

       // yLon = yLon + 25;
       // sb.append("^FO"+xlon+","+yLon+"^FD PRODEM^FS");
        if(llcc.size()>0){
            for (int i = 2; i <=llcc.size() ; i++) {
                Log.e("MyZebra","centroCobranza="+i);
                BsCcw cc= llcc.get(i-1);
                String desc=cc.getDesc().substring(0,33);
                String desc2= cc.getDesc().substring(33,cc.getDesc().length());

                sb.append("^FO"+xlon+","+yLon+"^FD "+desc+"^FS");
                yLon = yLon + 25;
            }
        }

        //NIT:124161025
        sb.append("^XZ");
        return sb;
    }

    public StringBuilder printZPLVertical2(BsHpw Hpw){


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dl = new SimpleDateFormat("dd/MM/yyyy");

        DecimalFormat df1=new DecimalFormat("0.00");

        String [] laFini= Hpw.getFini().split("T");
        String [] laFin= Hpw.getFfin().split("T");
        String [] laFcor = Hpw.getFcor().split("T");

        String lsfini = laFini[0];
        String lsFin = (new Date().toString());
        String lsFcor = laFcor[0];
        Date fini = new Date();
        Date ffin = new Date();
        Date fcor = new Date();
        Calendar today= Calendar.getInstance();
        Calendar finicio= Calendar.getInstance();
        long dias=1;

        BsCcw ccobranza= new BsCcw();
        LinkedList<BsCcw> llcc=ccobranza.listarBsCcw();


        try {
            fini = df.parse(lsfini.trim());
            finicio.setTime(fini);
            long diff= today.getTimeInMillis()- finicio.getTimeInMillis();
            dias= (diff/(24*60*60*1000))+1;

            ffin = new Date();
            fcor= df.parse(lsFcor.trim());
            lsfini = dl.format(fini);
            lsFin = dl.format(ffin);
            lsFcor= dl.format(fcor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BsEnw enw = new BsEnw();
        enw.ObtenerBsEnw();


        StringBuilder sb=  new StringBuilder();
        int yLon=0;
        int xlon=1;
        //  sb.append("^XA");
        //  sb.append("! U1 setvar Non-Continuous ");
        //  sb.append("! U1 setvar Black Mark Sensor \"bar\"");
        // sb.append("~jc^xa^jus^xz");
        sb.append("^XA");
        //sb.append("^LT0");
        sb.append("^LH0,0^FS");
        sb.append("^FX Top section");
        //sb.append("^FO30,30^AD^FDaqui ya"+ "^FS");
        sb.append("^CF0,40");
        //^FB670,1,15,C,0
        // sb.append("^FO"+xlon+","+yLon+"^FB670,1,15,C,0^FD"+ enw.getNomb().trim() +"^FS");
        sb.append("^FO"+xlon+","+yLon+"^FB600,1,15,C,0^FD"+ enw.getNomb().trim() +"^FS");
        sb.append("^CF0,35");
        //   sb.append("Av. Bolivar Nro. 137");
        yLon=yLon+40;
        sb.append("^FO"+xlon+","+yLon+"^FB600,1,15,C,0^FD    " + enw.getDire().trim() +"^FS");
        yLon=yLon+40;
        sb.append("^FO"+xlon+","+yLon+"^FB600,1,15,C,0^FD NIT:" + enw.getNnit().trim() + "^FS");
        yLon=yLon+40;
        sb.append("^FO"+xlon+","+yLon+"^FB600,1,15,C,0^FD Telefono:" + enw.getTelf().trim() + "^FS");
        yLon=yLon+40;
        sb.append("^FO1,"+yLon+"^GB710,1,3^FS");
        sb.append("^CF0,30");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FB600,1,10,C,0^FD AVISO DE COBRANZA Nro. " + Hpw.getNhpf() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FB600,1,15,C,0^FD MES " + enw.getDmes().trim() + "/" + enw.getAnio() +"^FS");
        yLon=yLon+30;

        sb.append("^FO1,"+yLon+"^GB710,1,3^FS");
        // sb.append("T 5 0 40 358       Del:" + lsfini.trim() + " Al:" + lsFin.trim() + "\r\n");
        sb.append("^CF0,25");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Codigo Fijo: " + Hpw.getNcnt() + "; ");
        // yLon=yLon+30;
        //sb.append("^FO"+xlon+","+yLon+"^FD Codigo de Persona: " + Hpw.getCper() + "^FS");
        sb.append(" Codigo de Persona: " + Hpw.getCper() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Nombre: " + Hpw.getNomb().toUpperCase().trim() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Direccion: " + Hpw.getDire().toUpperCase().trim() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Ruta: " + Hpw.getDrut().trim() + "; ");
        //yLon=yLon+30;
        //sb.append("^FO"+xlon+","+yLon+"^FD Cod.Ubic.: " + Hpw.getCodf()+ "; No.Medidor:"+Hpw.getNume() + "^FS");
        sb.append("Cod.Ubic.: " + Hpw.getCodf()+ "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD No.Medidor:"+Hpw.getNume().trim() + "; UV:" + Hpw.getDuve().trim() + " Mza:" + Hpw.getDmza().trim() + " lote:" + Hpw.getDlot().trim() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Categoria: " + Hpw.getDcat().trim() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Fecha Emision:^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Del:" + lsfini.trim() + "   Al:" + lsFin.trim() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Dias Consumo:" + dias + "; ");
        // yLon=yLon+30;
        sb.append(" Lec. Ant:" + Hpw.getLant() + ";  Lec. Act: " + Hpw.getLact() + "^FS");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD Consumo(M3): " + Hpw.getCons() + "^FS");
        yLon=yLon+30;
        sb.append("^FO1,"+yLon+"^GB710,1,3^FS");
        // sb.append("^FO220,530^FD --------------------------------------------\r\n");
        yLon=yLon+30;
        sb.append("^FO"+xlon+","+yLon+"^FD CONCEPTOS^FS");
        yLon=yLon+30;
        sb.append("^FO1,"+yLon+"^GB710,1,3^FS");
        // sb.append("T 5 0 40 780 --------------------------------------------\r\n");

        BsDpw dpw = new BsDpw();
        yLon =yLon+45;
        LinkedList<BsDpw> listDtl = dpw.listarDetalles(Hpw.getNhpf());
        double totalDtl =0;
        for (BsDpw dtl : listDtl) {
            String lsDtl = dtl.getDhpc().trim();
            int longMax = 63;
           double ldImpt= org.apache.commons.math.util.MathUtils.round(dtl.getImpt(),2);
            totalDtl= totalDtl + ldImpt;
          //   Precision.round(dtl.getImpt(), 3);
          String impt= df1.format(ldImpt);



            int cantPtos=0;



             cantPtos = longMax - lsDtl.length() - String.valueOf(ldImpt).length();
            String lsPtos = "";
            for (int i = 0; i < cantPtos; i++) {
                lsPtos = lsPtos + ".";
            }
            if(impt.contains(".")){
                if(impt.substring(0,1).equals("0")){
                    lsPtos= lsPtos+ "...";
                }else if(impt.length()==5){
                    lsPtos= lsPtos+ "..";
                }
            }

            sb.append("^FO"+xlon+"," + yLon + "^FD"+ lsDtl + lsPtos + impt + "^FS");
            yLon = yLon + 25;
        }
        yLon = yLon + 25;
       // double lhImpt= org.apache.commons.math.util.MathUtils.round(Hpw.getImpt(),2);
        double lhImpt= org.apache.commons.math.util.MathUtils.round(totalDtl,2);
        String impt= df1.format(lhImpt);
        //String impt = lhImpt+"";
        int cantPtos= 65 - impt.length()-14;
        String lsPtos = "";
        for (int i = 0; i <cantPtos ; i++) {
            lsPtos = lsPtos + ".";
        }
        sb.append("^FO"+xlon+"," + yLon + "^FD Importe Total Bs:"+lsPtos + impt + "^FS");


        yLon = yLon + 25;
        sb.append("^FO1,"+yLon+"^GB710,1,3^FS");
        //sb.append("T 5 0 40 " + yLon + "-------------------------------------\r\n");
        yLon = yLon + 25;
        double ldImor= org.apache.commons.math.util.MathUtils.round(Hpw.getImor(),2);
        String imor= df1.format(ldImor);
       // String imor = ldImor+"";
        sb.append("^FO"+xlon+","+yLon+"^FD facturas Impagas:" + Hpw.getNmor() + "        Total Bs:" + imor + "^FS");
        yLon = yLon + 25;
        if(Hpw.getNmor()>1){
            sb.append("^FO"+xlon+","+yLon+"^FD Fecha de Corte:" + lsFcor.trim() +"^FS");
            yLon = yLon + 25;
        }
        // sb.append("T 7 1 20 952 ESTIMADOS SOCIOS Y USUARIOS:CUALQUIER RECLAMO\r\n");
        // sb.append("T 7 1 20 990 DESPUES DE HABER EMITIDO EL AVISO\r\n");
        // sb.append("^FO"+xlon+","+yLon+"^FD CUALQUIER RECLAMO DENTRO DE 7 DIAS DE EMISION^FS");
        // yLon = yLon + 25;
        // sb.append("^FO"+xlon+","+yLon+"^FD C/Cobros:Coop. San Martin,Jesus Nazareno,^FS");

        // yLon = yLon + 25;
        // sb.append("^FO"+xlon+","+yLon+"^FD PRODEM^FS");
        if(llcc.size()>0){
            for (int i = 2; i <=llcc.size() ; i++) {
                Log.e("MyZebra","centroCobranza="+i);
                BsCcw cc= llcc.get(i-1);
                String lsDesc= cc.getDesc();
                if(lsDesc!=null){
                    lsDesc=lsDesc.trim();
                    if(lsDesc.length()>0){

                        int li= lsDesc.length()/45;
                        int l1=0;
                        int l2=45;

                            while(l1<lsDesc.length()){
                                if(l2>lsDesc.length()){
                                    l2=lsDesc.length();
                                }
                                String desc2= lsDesc.substring(l1,l2);
                                sb.append("^FO"+xlon+","+yLon+"^FD "+desc2+"^FS");
                                yLon = yLon + 25;
                                l1=l2;
                                l2=l2+45;
                            }


                    }
                }




            }
        }

        //NIT:124161025
        sb.append("^XZ");
        return sb;
    }*/

    public void escribirAviso(BsLec loitemLecturacion) {
        StringBuilder sb = new StringBuilder();
        MyZebra myZebra = new MyZebra();
        sb.append(myZebra.printZPLHorizontalZQ520_SinWebService(loitemLecturacion));
        try {
            String url = Environment.getExternalStorageDirectory().getAbsolutePath();
            File myFile = new File(url + "/avsCobranza" + loitemLecturacion.getNlec() + ".txt");
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(sb.toString());
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
            Log.e("ERRR", "Could not create file", e);
        }
    }

    public StringBuilder printZPLHorizontalZQ520_Cospail(BsLec lec){

        /* Aqui descargar */



        StringBuilder sb = new StringBuilder();


        BsHpw hpw= new BsHpw();
        hpw.obtenerBsHpwbyNcnt(lec.getNcnt());



        DecimalFormat df1=new DecimalFormat("#.00");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dl = new SimpleDateFormat("dd/MM/yyyy");
        String [] laFini= hpw.getFini().split("T");
        String [] laFin= hpw.getFfin().split("T");
        String [] laFcor = hpw.getFcor().split("T");



        String lsfini = laFini[0];
        String lsFin = (new Date().toString());
        String lsFcor = laFcor[0];
        Date fini = new Date();
        Date ffin = new Date();
        Date fcor = new Date();
        Calendar today= Calendar.getInstance();
        Calendar finicio= Calendar.getInstance();
        long dias=1;

        try {
            fini = df.parse(lsfini.trim());
            finicio.setTime(fini);
            long diff= today.getTimeInMillis()- finicio.getTimeInMillis();
            dias= (diff/(24*60*60*1000))+1;

            ffin = new Date();
            fcor= df.parse(lsFcor.trim());
            lsfini = dl.format(fini);
            lsFin = dl.format(ffin);
            lsFcor= dl.format(fcor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BsEnw enw = new BsEnw();
        enw.ObtenerBsEnw();

        BsDpw dpw= new BsDpw();
        LinkedList<BsDpw> lldpw= dpw.listarDetalles(hpw.getNhpf());

        BsDhw dhw = new BsDhw();
        LinkedList<BsDhw> lldhw= dhw.listarBsDhw(hpw.getNcnt());

        BsCcw ccobranza= new BsCcw();
        LinkedList<BsCcw> llcc=ccobranza.listarBsCcw();

        int ylon=100;
        //"+xlon+","+yLon+"
        sb.append("^XA ");
        sb.append("^FO625,"+ylon+"^A0R,0,25^FD "+ lec.getdNom().trim()+" ^FS ");
        sb.append("^FO550,"+ylon+"^A0R,0,25^FD "+hpw.getDire().trim()+"; UV:" + hpw.getDuve().trim() + "; Mza:" + hpw.getDmza().trim() + "; lote:" + hpw.getDlot().trim() + "^FS ");
        //sb.append("^FO530,290^A0R,0,25^FD Nro. Distrito^FS ");
        ylon=1235;
        sb.append("^FO625,"+ylon+"^A0R,0,25^FD "+lec.getCodf()+"^FS ");
        //   sb.append("^FO630,900^A0R,38,20^FD Fecha Emision^FS ");
        sb.append("^FO550,"+ylon+"^A0R,0,25^FD "+dpw.getNhpc()+"^FS ");
        // sb.append("^FO550,900^A0R,36,20^FD F.Venc^FS ");
        ylon=1475;
        sb.append("^FO625,"+ylon+"^A0R,0,25^FD "+hpw.getDcat().trim()+"^FS ");
        sb.append("^FO550,"+ylon+"^A0R,0,25^FD "+enw.getMesf()+"/"+enw.getAnio()+"^FS ");

        int xlon=705;
        sb.append("^FO"+xlon+","+ylon+"^A0R,0,25^FD "+hpw.getNcnt()+"^FS ");
        sb.append(" ");
        xlon=440;
        sb.append("^FO"+xlon+",90^A0R,0,25^FD "+lsFin+" ^FS ");
        sb.append("^FO"+xlon+",320^A0R,0,25^FD "+hpw.getLant()+"^FS ");
        sb.append("^FO"+xlon+",530^A0R,0,25^FD "+hpw.getLact()+"^FS ");
        sb.append("^FO"+xlon+",700^A0R,0,25^FD "+hpw.getCons()+"^FS ");
        // sb.append("^FO410,110^A0R,0,25FD "+lsfini+"^FS ");
        // sb.append("^FO410,420^A0R,0,25FD "+hpw.getLant()+"^FS ");
        // sb.append("^FO410,560^A0R,0,25^FD  ^FS ");

        //sb.append("^FO420,720^A0R,0,25^FD "+hpw.getImor()+"^FS ");
        //sb.append("^FO420,970^A0R,0,25^FD "+hpw.getNmor()+"^FS ");
        //sb.append("^FO420,1000^A0R,0,25^FD Fcorte.^FS ");


        String imor=df1.format(hpw.getImor());
        xlon=430;
        sb.append("^FO"+xlon+",940^A0R,0,25^FD "+imor+"^FS ");
        sb.append("^FO"+xlon+",1180^A0R,0,25^FD "+String.valueOf(hpw.getNmor())+"^FS ");

        if(!lsFcor.equals("01/01/1900"))
        {
            sb.append("^FO"+xlon+",1470^A0R,0,25^FD "+lsFcor+"^FS ");
        }


        //sb.append("^FO350,620^A0R,0,36^FD itm1^FS ");
        //sb.append("^FO390,750^A0R,0,25^FD DATOS DE LA FACTURA^FS ");
        // sb.append("^FO350,840^A0R,0,20^FD impt^FS ");

        //    sb.append("^FO363,750^A0R,0,20^FD ITEM^FS ");
        //    sb.append("^FO363,860^A0R,0,20^FD DETALLE^FS ");
        //    sb.append("^FO363,1050^A0R,0,20^FD IMPORTE Bs.^FS ");

        int x=310;
        for (BsDpw d:lldpw) {
            if(x>=80){
                sb.append("^FO"+x+",730^A0R,0,20^FD "+d.getOrde()+"^FS ");
                String dhpc=d.getDesc().trim();
                if(dhpc.length()>16){
                    sb.append("^FO"+x+",800^A0R,0,20^FD "+d.getDesc().trim().substring(0,16)+"^FS ");
                }else{
                    sb.append("^FO"+x+",800^A0R,0,20^FD "+d.getDesc().trim()+"^FS ");
                }

                sb.append("^FO"+x+",1000^A0R,0,20^FD "+d.getImpt()+"^FS ");
            }
            x=x-30;
        }


        // sb.append("^FO27,765^A0R,0,20^FD IMPORTE TOTAL FACTURA Bs^FS ");
        String impt= df1.format(hpw.getImpt());
        sb.append("^FO40,1000^A0R,0,20^FD "+impt+"^FS ");

        //sb.append("^FO390,300^A0R,0,25^FD HISTORICO^FS ");

        //    sb.append("^FO363,110^A0R,0,20^FD MES^FS ");
        //   sb.append("^FO363,270^A0R,0,20^FD CONSUMO m3^FS ");
        //   sb.append("^FO363,450^A0R,0,20^FD IMPORTE Bs^FS ");
        //   sb.append("^FO363,600^A0R,0,20^FD ESTADO^FS ");
        //   sb.append("  ");


        int x1,y;
        x1=310;
        sb.append("^FO"+x1+",80^A0R,0,20^FD "+enw.getAnio()+"-"+enw.getMesf()+" ^FS ");
        sb.append("^FO"+x1+",230^A0R,0,20^FD "+hpw.getCons()+" ^FS ");
        sb.append("^FO"+x1+",430^A0R,0,20^FD "+impt+" ^FS ");
        sb.append("^FO"+x1+",570^A0R,0,20^FD IMPAGA ^FS ");
        x1=x1-30;

        y=0;

        for (BsDhw h:lldhw) {

            if(x1>=80) {

                sb.append("^FO"+x1+",80^A0R,0,20^FD "+h.getPeri().trim()+" ^FS ");
                sb.append("^FO"+x1+",230^A0R,0,20^FD "+h.getCons()+"^FS ");
                sb.append("^FO"+x1+",430^A0R,0,20^FD "+h.getImpt()+"^FS ");
                sb.append("^FO"+x1+",570^A0R,0,20^FD "+h.getStad()+" ^FS ");
            }
            x1=x1-30;
        }

        //   sb.append("^FO27,115^A0R,0,20^FD IMPORTE DEUDA Bs ^FS ");
        // sb.append("^FO"+x1+",200^A0R,0,25^FD "+h.getCons()+" ^FS ");
        double ttlDeuda= hpw.getImor();

        // sb.append("^FO27,600^A0R,0,20^FD "+String.format("%.2f", ttlDeuda)+" ^FS ");
        Log.e("MyZebra","tamanho de la lista de centros de cobranza="+llcc.size());
        int x2=350;

        if(llcc.size()>0){
            for (int i = 0; i < llcc.size() ; i++) {
                Log.e("MyZebra","centroCobranza="+i);
                BsCcw cc= llcc.get(i);
                String desc=cc.getDesc().trim();
                int count=desc.length();
                String result="";
                while(desc!="" && x2>=30)
                {
                    int nCant=desc.length();
                    if(nCant>0 && nCant>43){
                        result= desc.substring(0,43);
                        sb.append("^FO"+x2+",1200^A0R,0,20^FD "+result+" ^FS ");
                        desc=desc.substring(43,nCant);
                        x2=x2-30;
                    }else{
                        result=desc.substring(0,nCant);
                        sb.append("^FO"+x2+",1200^A0R,0,20^FD "+result+" ^FS ");
                        desc="";
                        x2=x2-30;
                    }
                }
            }
        }

        sb.append("^XZ");


        //Log.e("printZPLHoriontal","aqui va a imprimir la cadena "+ sb.toString());
        return sb;
    }

    public StringBuilder printZPLHorizontalZQ520_SinWebService(BsLec lec){


        BsHpw hpw= new BsHpw();
        hpw.obtenerBsHpwbyNcnt(lec.getNcnt());
            StringBuilder sb = new StringBuilder();

            DecimalFormat df1=new DecimalFormat("0.00");

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dl = new SimpleDateFormat("dd/MM/yyyy");
            String [] laFini= hpw.getFini().split("T");
            String [] laFin= hpw.getFfin().split("T");
            String [] laFcor = hpw.getFcor().split("T");

            String lsfini = laFini[0];
            String lsFin = (new Date().toString());
            String lsFcor = laFcor[0];
            Date fini = new Date();
            Date ffin = new Date();
            Date fcor = new Date();
            Calendar today= Calendar.getInstance();
            Calendar finicio= Calendar.getInstance();
            long dias=1;

            try {
                fini = df.parse(lsfini.trim());
                finicio.setTime(fini);
                long diff= today.getTimeInMillis()- finicio.getTimeInMillis();
                dias= (diff/(24*60*60*1000))+1;

                ffin = new Date();
                fcor= df.parse(lsFcor.trim());
                lsfini = dl.format(fini);
                lsFin = dl.format(ffin);
                lsFcor= dl.format(fcor);
            } catch (Exception e) {
                e.printStackTrace();
            }

            BsEnw enw = new BsEnw();
            enw.ObtenerBsEnw();

            BsDpw dpw= new BsDpw();
            LinkedList<BsDpw> lldpw= dpw.listarDetalles(hpw.getNhpf());

            BsDhw dhw = new BsDhw();
            LinkedList<BsDhw> lldhw= dhw.listarBsDhw(hpw.getNcnt());

            BsCcw ccobranza= new BsCcw();
            LinkedList<BsCcw> llcc=ccobranza.listarBsCcw();

            int ylon=100;
            //"+xlon+","+yLon+"
            sb.append("^XA ");
            sb.append("^FO625,"+ylon+"^A0R,0,25^FD "+lec.getdNom().trim()+" ^FS "); //  ("+hpw.getCper()+")^FS ");
            sb.append("^FO550,"+ylon+"^A0R,0,25^FD "+hpw.getDire().trim()+"; UV:" + hpw.getDuve().trim() + "; Mza:" + hpw.getDmza().trim() + "; lote:" + hpw.getDlot().trim() + "^FS ");
            //sb.append("^FO530,290^A0R,0,25^FD Nro. Distrito^FS ");
            ylon=1235;
            sb.append("^FO625,"+ylon+"^A0R,0,25^FD "+hpw.getCodf()+"^FS ");
            //   sb.append("^FO630,900^A0R,38,20^FD Fecha Emision^FS ");
            sb.append("^FO550,"+ylon+"^A0R,0,25^FD "+lec.getNume()+"^FS ");
            // sb.append("^FO550,900^A0R,36,20^FD F.Venc^FS ");
            ylon=1475;
            sb.append("^FO625,"+ylon+"^A0R,0,25^FD "+hpw.getDcat().trim()+"^FS ");
            sb.append("^FO550,"+ylon+"^A0R,0,25^FD "+enw.getMesf()+"/"+enw.getAnio()+"^FS ");

            int xlon=705;
            sb.append("^FO"+xlon+","+ylon+"^A0R,0,25^FD "+hpw.getNcnt()+"^FS ");
            sb.append(" ");
            xlon=440;
            sb.append("^FO"+xlon+",90^A0R,0,25^FD "+lsFin+" ^FS ");
            sb.append("^FO"+xlon+",320^A0R,0,25^FD "+hpw.getLant()+"^FS ");
            sb.append("^FO"+xlon+",530^A0R,0,25^FD "+hpw.getLact()+"^FS ");
            sb.append("^FO"+xlon+",700^A0R,0,25^FD "+hpw.getCons()+"^FS ");
            // sb.append("^FO410,110^A0R,0,25FD "+lsfini+"^FS ");
            // sb.append("^FO410,420^A0R,0,25FD "+hpw.getLant()+"^FS ");
            // sb.append("^FO410,560^A0R,0,25^FD  ^FS ");

            //sb.append("^FO420,720^A0R,0,25^FD "+hpw.getImor()+"^FS ");
            //sb.append("^FO420,970^A0R,0,25^FD "+hpw.getNmor()+"^FS ");
            //sb.append("^FO420,1000^A0R,0,25^FD Fcorte.^FS ");

            // cambio
            // double ldImptMora =  new BigDecimal(hpw.getImor()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            String imor=df1.format(hpw.getImor());
            xlon=430;
            sb.append("^FO"+xlon+",940^A0R,0,25^FD "+String.valueOf(imor)+"^FS ");
            sb.append("^FO"+xlon+",1180^A0R,0,25^FD "+String.valueOf(hpw.getNmor())+"^FS ");


        if(!lsFcor.equals("01/01/1900"))
        {
            sb.append("^FO"+xlon+",1470^A0R,0,25^FD "+lsFcor+"^FS ");
        }



            int x=310;
            int cont=0;
            String lsOrde="";
            double lsImptLast=0;
            int auxCont=0;

            for (BsDpw d:lldpw) {

                if(x>=80){
                    if(cont<8){
                        sb.append("^FO"+x+",730^A0R,0,20^FD "+d.getOrde()+"^FS ");
                        String dhpc=  d.getDesc().trim();
                        if(dhpc.length()>16){
                            sb.append("^FO"+x+",800^A0R,0,20^FD "+d.getDesc().trim().substring(0,16)+"^FS ");
                        }else{
                            sb.append("^FO"+x+",800^A0R,0,20^FD "+d.getDesc().trim()+"^FS ");
                        }
                        // double ldImptDtl =  new BigDecimal(d.getImpt()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

                        String dtlImpt=df1.format(d.getImpt());
                        sb.append("^FO"+x+",1000^A0R,0,20^FD "+dtlImpt+"^FS ");
                    }else{
                        // double ldImptDtl =  new BigDecimal(d.getImpt()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
                        lsImptLast=lsImptLast+d.getImpt();
                        auxCont=auxCont+1;

                    }

                }
                cont=cont+1;
                x=x-30;
            }

            if( lsImptLast>0){
                cont= cont+1;
                x=x+(30*auxCont);
                sb.append("^FO"+x+",730^A0R,0,20^FD ^FS ");
                sb.append("^FO"+x+",800^A0R,0,20^FD Otros. ^FS ");
                sb.append("^FO"+x+",1000^A0R,0,20^FD "+df1.format(lsImptLast)+"^FS ");
            }


            // sb.append("^FO27,765^A0R,0,20^FD IMPORTE TOTAL FACTURA Bs^FS ");
            String impt= df1.format(hpw.getImpt());
            sb.append("^FO40,1000^A0R,0,20^FD "+impt+"^FS ");

            //sb.append("^FO390,300^A0R,0,25^FD HISTORICO^FS ");

            //    sb.append("^FO363,110^A0R,0,20^FD MES^FS ");
            //   sb.append("^FO363,270^A0R,0,20^FD CONSUMO m3^FS ");
            //   sb.append("^FO363,450^A0R,0,20^FD IMPORTE Bs^FS ");
            //   sb.append("^FO363,600^A0R,0,20^FD ESTADO^FS ");
            //   sb.append("  ");


            int x1,y;
            x1=310;
            //sb.append("^FO"+x1+",80^A0R,0,20^FD "+enw.getAnio()+"-"+enw.getMesf()+" ^FS ");
            //sb.append("^FO"+x1+",230^A0R,0,20^FD "+hpw.getCons()+" ^FS ");
            //sb.append("^FO"+x1+",430^A0R,0,20^FD "+impt+" ^FS ");
            //sb.append("^FO"+x1+",570^A0R,0,20^FD IMPAGA ^FS ");
            //x1=x1-30;
            y=0;

            for (BsDhw h:lldhw) {

                if(x1>=80) {

                    sb.append("^FO"+x1+",80^A0R,0,20^FD "+h.getPeri().trim()+" ^FS ");
                    sb.append("^FO"+x1+",230^A0R,0,20^FD "+h.getCons()+"^FS ");
                    sb.append("^FO"+x1+",430^A0R,0,20^FD "+h.getImpt()+"^FS ");
                    sb.append("^FO"+x1+",570^A0R,0,20^FD "+h.getStad()+" ^FS ");
                }
                x1=x1-30;
            }

            // sb.append("^FO27,600^A0R,0,20^FD "+String.format("%.2f", ttlDeuda)+" ^FS ");
            Log.e("MyZebra","tamanho de la lista de centros de cobranza="+llcc.size());
            int x2=350;
            //  if(llcc.size()>0){
            //      for (int i = 2; i <=llcc.size() ; i++) {
            //          Log.e("MyZebra","centroCobranza="+i);
            //          BsCcw cc= llcc.get(i-1);
            //          String desc=cc.getDesc().substring(0,33);
            //          String desc2= cc.getDesc().substring(33,cc.getDesc().length());
            //          sb.append("^FO"+x2+",1250^A0R,0,20^FD "+desc+" ^FS ");
            //          x2=x2-30;
            //          sb.append("^FO"+x2+",1250^A0R,0,20^FD "+desc2+" ^FS ");
            //          x2=x2-30;
            //      }
            //  }
            if(llcc.size()>0){
                for (int i = 0; i < llcc.size() ; i++) {
                    Log.e("MyZebra","centroCobranza="+i);
                    BsCcw cc= llcc.get(i);
                    String desc=cc.getDesc().trim();
                    int count=desc.length();
                    String result="";
                    while(desc!="" && x2>=30)
                    {
                        int nCant=desc.length();
                        if(nCant>0 && nCant>40){
                            result= desc.substring(0,40);
                            sb.append("^FO"+x2+",1200^A0R,0,20^FD "+result+" ^FS ");
                            desc=desc.substring(40,nCant);
                            x2=x2-30;
                        }else{
                            result=desc.substring(0,nCant);
                            sb.append("^FO"+x2+",1200^A0R,0,20^FD "+result+" ^FS ");
                            desc="";
                            x2=x2-30;
                        }
                    }
                }
            }

            sb.append("^XZ");

            //Log.e("printZPLHoriontal","aqui va a imprimir la cadena "+ sb.toString());
            return sb;
    }
}
