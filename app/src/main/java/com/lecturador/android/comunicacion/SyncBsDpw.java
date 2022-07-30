package com.lecturador.android.comunicacion;

import android.util.Log;

import com.lecturador.android.dblecturador.BsDpw;
import com.lecturador.android.dblecturador.LtCnf;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Hashtable;

/**
 * Created by Dario Pardo on 4/26/2017.
 */
public class SyncBsDpw {


    public void SyncObtenerDetalleAvisos(final int liAnio, final int liMesf, final int liNcnt) {

        WsDataSoap tecnica = new WsDataSoap() {

            @Override
            public void adicionarParametro(SoapObject pregunta, SoapSerializationEnvelope sobre) {
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
                SoapObject newDataset = (SoapObject) dataset.getProperty(0);

                // registrar header avisos
                Log.e("SyncBsDpw", "Cantidad de reg. " + newDataset.getPropertyCount());
                // List listDpw = new LinkedList<BsDpw>();
                for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                    SoapObject objDpw = (SoapObject) newDataset.getProperty(i);

                    BsDpw dpw = new BsDpw();
                    dpw.setNhpf(Integer.valueOf(objDpw.getProperty(0).toString()));
                    dpw.setOrde(Integer.valueOf(objDpw.getProperty(1).toString()));
                    dpw.setNhpc(Integer.valueOf(objDpw.getProperty(2).toString()));
                    dpw.setDesc(objDpw.getProperty(3).toString());
                    dpw.setCant(Double.valueOf(objDpw.getProperty(4).toString()));
                    dpw.setPuni(Double.valueOf(objDpw.getProperty(5).toString()));
                    dpw.setImpt(Double.valueOf(objDpw.getProperty(6).toString()));


                    Log.e("SyncBsDpw", "hasta aqui se convirtio a obj local");
                    dpw.insertarBsDpw();
                    // listDpw.add(dpw);
                    Log.e("SyncBsDpw", "se adiciono el objDpw a la lista");

                }
                //Log.e("SyncBsHpw", "Cantidad de obj Objtenidos via WEb Service=" + listDpw.size());

            }

        };
        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/W8BSHPF_obtenerDetalleAviso");
        tecnica.setMETHOD_NAME("W8BSHPF_obtenerDetalleAviso");


        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }



}

