package com.lecturador.android.comunicacion;

import android.util.Log;

import com.lecturador.android.dblecturador.BsTaw;
import com.lecturador.android.dblecturador.LtCnf;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/4/2017.
 */
public class SyncBsTaw {
    public int liAnio;
    public int liMesf;


    public void SyncObtenerTarifa(int piAnio, int piMes) {
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
                Log.e("SyncBsTaw", "Cantidad de reg. " + newDataset.getPropertyCount());
                List listTaw = new LinkedList<BsTaw>();
                for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                    SoapObject objTaw = (SoapObject) newDataset.getProperty(i);

                    BsTaw taw = new BsTaw();
                    taw.setAnio(Integer.valueOf(objTaw.getProperty(0).toString()));
                    taw.setMesf(Integer.valueOf(objTaw.getProperty(1).toString()));
                    taw.setNser(Integer.valueOf(objTaw.getProperty(2).toString()));
                    taw.setNose(objTaw.getProperty(3).toString());
                    taw.setNhpc(Integer.valueOf(objTaw.getProperty(4).toString()));
                    taw.setNoco(objTaw.getProperty(5).toString());
                    taw.setNcat(Integer.valueOf(objTaw.getProperty(6).toString()));
                    taw.setNoca(objTaw.getProperty(7).toString());
                    taw.setFiva(objTaw.getProperty(8).toString());
                    taw.setVafa(objTaw.getProperty(9).toString());
                    taw.setDesd(Integer.valueOf(objTaw.getProperty(10).toString()));
                    taw.setHast(Integer.valueOf(objTaw.getProperty(11).toString()));
                    taw.setCmon(Integer.valueOf(objTaw.getProperty(12).toString()));
                    taw.setVal1(Double.valueOf(objTaw.getProperty(13).toString()));
                    taw.setVal2(Double.valueOf(objTaw.getProperty(14).toString()));
                    taw.setStat(Integer.valueOf(objTaw.getProperty(15).toString()));


                    Log.e("SyncBsTaw", "hasta aqui se convirtio a obj local");
                    taw.insertarBsTaw();
                    Log.e("SyncBsTaw", "se adiciono el objTaw a la lista");

                }


            }
        };
        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSTAW_obtenerTarifa");
        tecnica.setMETHOD_NAME("BSTAW_obtenerTarifa");


        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }

}
