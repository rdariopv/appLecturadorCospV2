package com.lecturador.android.comunicacion;

import android.util.Log;

import com.lecturador.android.dblecturador.BsDhw;
import com.lecturador.android.dblecturador.LtCnf;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;

/**
 * Created by Dario Pardo on 2/23/2018.
 */
public class SyncBsDhw {
    public int liAnio;
    public int liMesf;
    public int liZona;
    public int liRango;

    public void SyncObtenerHistoricoAvisos(int piAnio, int piMes, int piZona, int rango) {
        liAnio = piAnio;
        liMesf = piMes;
        liZona = piZona;
        liRango = rango;
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

                PropertyInfo pZona = new PropertyInfo();
                pZona.setName("liZona");
                pZona.setType(int.class);
                pZona.setValue(liZona);
                pregunta.addProperty(pZona);

                PropertyInfo pRango = new PropertyInfo();
                pRango.setName("liRango");
                pRango.setType(int.class);
                pRango.setValue(liRango);
                pregunta.addProperty(pRango);
            }

            @Override
            public void leerDatos(SoapObject datos) {
                SoapObject diffgram = (SoapObject) datos.getProperty(0);
                SoapObject dataset = (SoapObject) datos.getProperty(1);
                int cantProp = dataset.getPropertyCount();
                if (cantProp > 0) {
                    SoapObject newDataset = (SoapObject) dataset.getProperty(0);

                    // registrar header avisos
                    Log.e("SyncBsDhw", "Cantidad de reg. " + newDataset.getPropertyCount());
                    // List listHpw = new LinkedList<BsHpw>();
                    for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                        SoapObject objHpw = (SoapObject) newDataset.getProperty(i);

                        BsDhw hpw = new BsDhw();
                        hpw.setNhpf(Integer.valueOf(objHpw.getProperty(00).toString()));
                        hpw.setOrde(Integer.valueOf(objHpw.getProperty(01).toString()));
                        hpw.setPeri(objHpw.getProperty(02).toString());
                        hpw.setCons(Integer.valueOf(objHpw.getProperty(03).toString()));
                        hpw.setImpt(Double.valueOf(objHpw.getProperty(04).toString()));
                        hpw.setStad(objHpw.getProperty(05).toString());

                        Log.e("SyncBsDhw", "hasta aqui se convirtio a obj local");
                        hpw.insertarBsDhw();
                        // listHpw.add(hpw);
                        Log.e("SyncBsDhw", "se adiciono el objDhw a la lista");
                        //  SyncActualizarAviso(hpw.getNhpf(), 2); // estado = 2 indica bajado correcto
                        SyncActualizaHistoricoAviso(hpw.getNhpf(), 2);// estado = 2 indica bajado correcto


                    }
                }

                //   Log.e("SyncBsHpw", "Cantidad de obj Objtenidos via WEb Service=" + listHpw.size());

            }
        };
        //tecnica.setNAMESPACE("http://tempuri.org/");
        tecnica.setNAMESPACE("http://activebs.net/");
        // tecnica.setSOAP_ACTION("http://tempuri.org/BSHPW_obtenerHeaderAvisos");
        tecnica.setSOAP_ACTION("http://activebs.net/BSDPW_obtenerDetalleHistoricoAvisos");
        tecnica.setMETHOD_NAME("BSDPW_obtenerDetalleHistoricoAvisos");


        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }


    public int SyncActualizaHistoricoAviso(final int nhpf, final int stad) {

        WsDataSoap tecnica = new WsDataSoap() {

            @Override
            public void leerDatos(SoapObject datos) {

            }

            public void leerDatosPrimitivos(SoapPrimitive datos) {
                int result = Integer.valueOf(datos.toString());
                // int result = Integer.valueOf(diffgram.toString());
                if (result == 1) {
                    Log.e("SyncBsDhw", " se actualizo estado correcctamente");
                } else {
                    Log.e("SyncBsDhw", " ERROR AL ACTUALIZAR ESTADO ");
                }
            }

            @Override
            public void adicionarParametro(SoapObject Pregunta, SoapSerializationEnvelope sobre) {
                PropertyInfo pNhpf = new PropertyInfo();
                pNhpf.setName("liNhpf");
                pNhpf.setType(int.class);
                pNhpf.setValue(nhpf);
                Pregunta.addProperty(pNhpf);

                PropertyInfo pStad = new PropertyInfo();
                pStad.setName("liStat");
                pStad.setType(int.class);
                pStad.setValue(stad);
                Pregunta.addProperty(pStad);
            }
        };


        //  tecnica.setNAMESPACE("http://tempuri.org/");
        //  tecnica.setSOAP_ACTION("http://tempuri.org/BSHPW_ActualizarEstado");

        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSHPW_ActualizarHistoricoStatxNhpf");

        tecnica.setMETHOD_NAME("BSHPW_ActualizarHistoricoStatxNhpf");
        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicioPrimitivo();
        return 0;
    }


}
