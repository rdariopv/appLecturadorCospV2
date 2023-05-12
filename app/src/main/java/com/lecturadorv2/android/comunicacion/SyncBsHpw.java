package com.lecturadorv2.android.comunicacion;

import android.util.Log;

import com.lecturadorv2.android.dblecturador.BsHpw;
import com.lecturadorv2.android.dblecturador.LtCnf;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

/**
 * Created by Dario Pardo on 4/20/2017.
 */
public class SyncBsHpw {
    public int liAnio;
    public int liMesf;
    public int liNcnt;


    public void SyncObtenerHeaderAvisos(int piAnio, int piMes, int piNcnt) {
   /*
      <W7BSHPF_obtenerHeaderAviso xmlns="http://activebs.net/">
            <liAnio>int</liAnio>
            <liMesf>int</liMesf>
            <liNcnt>int</liNcnt>
      </W7BSHPF_obtenerHeaderAviso>*/
        liAnio = piAnio;
        liMesf = piMes;
        liNcnt = piNcnt;

        WsDataSoap tecnica = new WsDataSoap() {

            @Override
            public void adicionarParametro(SoapObject pregunta,  SoapSerializationEnvelope sobre) {
                PropertyInfo pAnio = new PropertyInfo();
                pAnio.setName("liAnio");
                pAnio.setType(int.class);
                pAnio.setValue(liAnio);
                pregunta.addProperty(pAnio);

                PropertyInfo pMes = new PropertyInfo();
                pMes.setName("liMesf");
                pMes.setType(int.class);
                pMes.setValue(liMesf);
                pregunta.addProperty(pMes);

                PropertyInfo pNcnt = new PropertyInfo();
                pNcnt.setName("liNcnt");
                pNcnt.setType(int.class);
                pNcnt.setValue(liNcnt);
                pregunta.addProperty(pNcnt);


            }

            @Override
            public void leerDatos(SoapObject datos) {
                SoapObject diffgram = (SoapObject) datos.getProperty(0);
                SoapObject dataset = (SoapObject) datos.getProperty(1);
                int cantProp= dataset.getPropertyCount();
                if(cantProp>0){
                    SoapObject newDataset = (SoapObject) dataset.getProperty(0);

                    // registrar header avisos
                    Log.e("SyncBsHpw", "Cantidad de reg. " + newDataset.getPropertyCount());
                    // List listHpw = new LinkedList<BsHpw>();
                    for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                        SoapObject objHpw = (SoapObject) newDataset.getProperty(i);

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


                        BsHpw hpw = new BsHpw();
                        hpw.setNhpf(Integer.valueOf(objHpw.getProperty(00).toString()));
                        hpw.setNcnt(Integer.valueOf(objHpw.getProperty(01).toString()));
                        hpw.setLant(Integer.valueOf(objHpw.getProperty(02).toString()));
                        hpw.setLact(Integer.valueOf(objHpw.getProperty(03).toString()));
                        hpw.setCons(Integer.valueOf(objHpw.getProperty(04).toString()));
                        hpw.setFini(objHpw.getProperty(05).toString());
                        hpw.setFfin(objHpw.getProperty(06).toString());
                        hpw.setDire(objHpw.getProperty(07).toString());
                        hpw.setNmor(Integer.parseInt( objHpw.getProperty(8).toString()));
                        hpw.setImor(Double.parseDouble( objHpw.getProperty(9).toString()));
                        hpw.setFcor(objHpw.getProperty(10).toString());

                        hpw.setDnom(objHpw.getProperty(11).toString());
                        hpw.setDcat(objHpw.getProperty(12).toString());
                        hpw.setDciu(objHpw.getProperty(13).toString());
                        hpw.setDuve(objHpw.getProperty(14).toString());
                        hpw.setDmza(objHpw.getProperty(15).toString());
                        hpw.setDlot(objHpw.getProperty(16).toString());
                        hpw.setDbar(objHpw.getProperty(17).toString());
                        hpw.setDimb(objHpw.getProperty(18).toString());
                        hpw.setDzon(objHpw.getProperty(19).toString());
                        hpw.setDrut(objHpw.getProperty(20).toString());

                        Log.e("SyncBsHpw", "hasta aqui se convirtio a obj local");
                        hpw.insertarBsHpw();
                        // listHpw.add(hpw);
                        Log.e("SyncBsHpw", "se adiciono el objHpw a la lista");
                       // SyncActualizarAviso(hpw.getNhpf(), 2); // estado = 2 indica bajado correcto


                    }
                }

                //   Log.e("SyncBsHpw", "Cantidad de obj Objtenidos via WEb Service=" + listHpw.size());

            }
        };
        //tecnica.setNAMESPACE("http://tempuri.org/");
        tecnica.setNAMESPACE("http://activebs.net/");
       // tecnica.setSOAP_ACTION("http://tempuri.org/BSHPW_obtenerHeaderAvisos");
        tecnica.setSOAP_ACTION("http://activebs.net/W7BSHPF_obtenerHeaderAviso");
        tecnica.setMETHOD_NAME("W7BSHPF_obtenerHeaderAviso");


        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }





}
