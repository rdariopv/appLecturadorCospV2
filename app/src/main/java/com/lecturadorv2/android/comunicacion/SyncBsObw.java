package com.lecturadorv2.android.comunicacion;

import android.util.Log;

import com.lecturadorv2.android.dblecturador.BsCon;
import com.lecturadorv2.android.dblecturador.BsObw;
import com.lecturadorv2.android.dblecturador.LtCnf;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/25/2017.
 */
public class SyncBsObw {

    public void SyncObtenerObservaciones() {

        WsDataSoap tecnica = new WsDataSoap() {

            @Override
            public void adicionarParametro(SoapObject pregunta,  SoapSerializationEnvelope sobre) {

            }

            @Override
            public void leerDatos(SoapObject datos) {
                SoapObject diffgram = (SoapObject) datos.getProperty(0);
                SoapObject dataset = (SoapObject) datos.getProperty(1);
                SoapObject newDataset = (SoapObject) dataset.getProperty(0);

                // registrar header avisos
                Log.e("SyncBsObw", "Cantidad de reg. " + newDataset.getPropertyCount());
                List listTaw = new LinkedList<BsObw>();
                for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                    SoapObject objObw = (SoapObject) newDataset.getProperty(i);

                    BsObw obw = new BsObw();
                    obw.setCodo(Integer.valueOf(objObw.getProperty(0).toString()));
                    obw.setDesc(objObw.getProperty(1).toString());

                    Log.e("SyncBsObw", "hasta aqui se convirtio a obj local");
                   obw.insertarBsObw();
                    Log.e("SyncBsObw", "se adiciono el objObw a la lista");

                }


            }
        };
        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/W3BSCON_obtenerObservacion");
        tecnica.setMETHOD_NAME("W3BSCON_obtenerObservacion");

        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }

    public void SyncObtenerLinkQR() {

        WsDataSoap tecnica = new WsDataSoap() {

            @Override
            public void adicionarParametro(SoapObject pregunta,  SoapSerializationEnvelope sobre) {

            }

            @Override
            public void leerDatos(SoapObject datos) {
                SoapObject diffgram = (SoapObject) datos.getProperty(0);
                SoapObject dataset = (SoapObject) datos.getProperty(1);
                SoapObject newDataset = (SoapObject) dataset.getProperty(0);

                // registrar header avisos
                Log.e("SyncBsCon", "Cantidad de reg. " + newDataset.getPropertyCount());
                List listTaw = new LinkedList<BsObw>();
                for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                    SoapObject objObw = (SoapObject) newDataset.getProperty(i);

                    BsCon con = new BsCon();
                    con.setPref(1);
                    con.setCodo(Integer.valueOf(objObw.getProperty(0).toString()));
                    con.setDesc(objObw.getProperty(1).toString());

                    Log.e("SyncBsCon", "hasta aqui se convirtio a obj local");
                    con.insertarBsCon();
                    Log.e("SyncBsCon", "se adiciono el objObw a la lista");

                }
            }
        };
        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSOBW_LinkQR");
        tecnica.setMETHOD_NAME("BSOBW_LinkQR");

        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }


}
