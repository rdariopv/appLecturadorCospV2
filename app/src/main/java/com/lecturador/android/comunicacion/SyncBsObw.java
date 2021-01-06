package com.lecturador.android.comunicacion;

import android.util.Log;

import com.lecturador.android.dblecturador.BsObw;
import com.lecturador.android.dblecturador.BsTaw;
import com.lecturador.android.dblecturador.LtCnf;

import org.ksoap2.serialization.PropertyInfo;
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
        tecnica.setSOAP_ACTION("http://activebs.net/BSOBW_obtenerObservacion");
        tecnica.setMETHOD_NAME("BSOBW_obtenerObservacion");

        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }


}
