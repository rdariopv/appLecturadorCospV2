package com.lecturador.android.comunicacion;

import android.util.Log;

import com.lecturador.android.dblecturador.BsEnw;
import com.lecturador.android.dblecturador.BsTaw;
import com.lecturador.android.dblecturador.LtCnf;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/5/2017.
 */
public class SyncBsEnw {

    public void SyncObtenerDatosEmpresa() {


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
                Log.e("SyncBsEnw", "Cantidad de reg. " + newDataset.getPropertyCount());
                List listTaw = new LinkedList<BsTaw>();
                for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                    SoapObject objEnw = (SoapObject) newDataset.getProperty(i);

                    BsEnw enw = new BsEnw();
                    enw.setImpr(Integer.valueOf(objEnw.getProperty(0).toString()));
                    enw.setNomb(objEnw.getProperty(1).toString());
                    enw.setSigl(objEnw.getProperty(2).toString());
                    enw.setNnit(objEnw.getProperty(3).toString());
                    enw.setDire(objEnw.getProperty(4).toString());
                    enw.setTelf(objEnw.getProperty(5).toString());
                    enw.setAnio(Integer.valueOf(objEnw.getProperty(6).toString()));
                    enw.setMesf(Integer.valueOf(objEnw.getProperty(7).toString()));
                    enw.setDmes(objEnw.getProperty(8).toString());
                    enw.setNhpc(Integer.valueOf(objEnw.getProperty(9).toString()));


                    Log.e("SyncBsEnw", "hasta aqui se convirtio a obj local");
                    enw.insertarBsEnw();
                    Log.e("SyncBsEnw", "se adiciono el objEnw a la lista");

                }


            }

        };
        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSEMW_obtenerDatEmpresa");
        tecnica.setMETHOD_NAME("BSEMW_obtenerDatEmpresa");


        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }

}
