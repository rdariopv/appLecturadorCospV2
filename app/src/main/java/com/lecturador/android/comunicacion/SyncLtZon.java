package com.lecturador.android.comunicacion;

import android.util.Log;

import com.lecturador.android.dblecturador.BsTaw;
import com.lecturador.android.dblecturador.LtCnf;
import com.lecturador.android.dblecturador.LtZon;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/4/2017.
 */
public class SyncLtZon {

    public int liAnio;
    public int liMesf;


    public void SyncObtenerZonas(int piAnio, int piMes) {
        liAnio = piAnio;
        liMesf = piMes;

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
            }

            @Override
            public void leerDatos(SoapObject datos) {
                SoapObject diffgram = (SoapObject) datos.getProperty(0);
                SoapObject dataset = (SoapObject) datos.getProperty(1);
                SoapObject newDataset = (SoapObject) dataset.getProperty(0);

                // registrar header avisos
                Log.e("SyncLTZON", "Cantidad de reg. " + newDataset.getPropertyCount());
                List listTaw = new LinkedList<BsTaw>();
                for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                    SoapObject objZona = (SoapObject) newDataset.getProperty(i);

                    LtZon zon= new LtZon();
                    zon.setNzon(Integer.valueOf(objZona.getProperty(0).toString()));
                    zon.setDzon(objZona.getProperty(1).toString());
                    zon.setRngo(Integer.valueOf(objZona.getProperty(2).toString()));
                    zon.setCreH(Integer.valueOf(objZona.getProperty(3).toString()));
                    zon.setCreD(Integer.valueOf(objZona.getProperty(4).toString()));
                    zon.setCrhi(Integer.valueOf(objZona.getProperty(5).toString()));


                    Log.e("SyncLtZon", "hasta aqui se convirtio a obj local");
                    zon.insertarLtZon();
                    Log.e("SyncLtZon", "se adiciono el objLtZon a la lista");

                }


            }
        };
        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSZON_obtenerZonas");
        tecnica.setMETHOD_NAME("BSZON_obtenerZonas");


        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }

}
