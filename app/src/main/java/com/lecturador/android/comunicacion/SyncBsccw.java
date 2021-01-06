package com.lecturador.android.comunicacion;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import android.util.Log;

import com.lecturador.android.dblecturador.BsCcw;
import com.lecturador.android.dblecturador.LtCnf;

import java.util.LinkedList;
import java.util.List;
/**
 * Created by Dario Pardo on 2/21/2018.
 */
public class SyncBsccw {

    public void SyncObtenerCentroCobranza() {


        WsDataSoap tecnica = new WsDataSoap() {

            @Override
            public void adicionarParametro(SoapObject pregunta,  SoapSerializationEnvelope sobre) {
                // no hay parametros
            }

            @Override
            public void leerDatos(SoapObject datos) {
                SoapObject diffgram = (SoapObject) datos.getProperty(0);
                SoapObject dataset = (SoapObject) datos.getProperty(1);
                SoapObject newDataset = (SoapObject) dataset.getProperty(0);

                // registrar parametros
                Log.e("SyncBsCcw", "Cantidad de reg. " + newDataset.getPropertyCount());
                List list = new LinkedList<BsCcw>();
                for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                    SoapObject objCcw = (SoapObject) newDataset.getProperty(i);

                    BsCcw ccw = new BsCcw();
                    ccw.setCodo(Integer.valueOf(objCcw.getProperty(0).toString()));
                    ccw.setDesc(objCcw.getProperty(1).toString());


                    Log.e("SyncBsCcw", "hasta aqui se convirtio a obj local");
                    ccw.insertarBsCcw();
                    Log.e("SyncBsCcw", "se adiciono el objCcw a la lista");

                }


            }

        };
        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSCCW_obtenerCentroCobranza");
        tecnica.setMETHOD_NAME("BSCCW_obtenerCentroCobranza");


        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }

}
