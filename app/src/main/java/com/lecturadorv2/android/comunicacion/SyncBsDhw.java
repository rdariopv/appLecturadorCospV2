package com.lecturadorv2.android.comunicacion;

import android.util.Log;

import com.lecturadorv2.android.dblecturador.BsDhw;
import com.lecturadorv2.android.dblecturador.LtCnf;

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
    public int liNcnt;

    public void SyncObtenerHistoricoAvisos(int piAnio, int piMes, int piNcnt) {
        liAnio = piAnio;
        liMesf = piMes;
        liNcnt = piNcnt;
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
                int cantProp = dataset.getPropertyCount();
                if (cantProp > 0) {
                    SoapObject newDataset = (SoapObject) dataset.getProperty(0);

                    // registrar header avisos
                    Log.e("SyncBsDhw", "Cantidad de reg. " + newDataset.getPropertyCount());
                    // List listHpw = new LinkedList<BsHpw>();
                    for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                        SoapObject objHpw = (SoapObject) newDataset.getProperty(i);

                        BsDhw dhw = new BsDhw();
                        dhw.setNcnt(Integer.valueOf(objHpw.getProperty(0).toString()).intValue());
                        dhw.setPeri(objHpw.getProperty(1).toString());
                        dhw.setCons(Integer.valueOf(objHpw.getProperty(2).toString()).intValue());
                        dhw.setImpt(Double.valueOf(objHpw.getProperty(3).toString()).doubleValue());
                        dhw.setStad(objHpw.getProperty(4).toString());
                        dhw.setCobs(Integer.parseInt(objHpw.getProperty(5).toString()));
                        Log.e("SyncBsDhw", "hasta aqui se convirtio a obj local");
                        dhw.insertarBsDhw();

                      // dhw.setNhpf(Integer.valueOf(objHpw.getProperty(00).toString()));
                      // dhw.setOrde(Integer.valueOf(objHpw.getProperty(01).toString()));
                      // dhw.setPeri(objHpw.getProperty(02).toString());
                      // dhw.setCons(Integer.valueOf(objHpw.getProperty(03).toString()));
                      // dhw.setImpt(Double.valueOf(objHpw.getProperty(04).toString()));
                      // dhw.setStad(objHpw.getProperty(05).toString());



                        Log.e("SyncBsDhw", "hasta aqui se convirtio a obj local");
                      //  dhw.insertarBsDhw();
                        // listHpw.add(hpw);
                        Log.e("SyncBsDhw", "se adiciono el objDhw a la lista");
                        //  SyncActualizarAviso(hpw.getNhpf(), 2); // estado = 2 indica bajado correcto
                        SyncActualizaHistoricoAviso(dhw.getNhpf(), 2);// estado = 2 indica bajado correcto
                    }
                }
                //   Log.e("SyncBsHpw", "Cantidad de obj Objtenidos via WEb Service=" + listHpw.size());
            }
        };

        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/W9BSHPF_obtenerHistoricoAviso");
        tecnica.setMETHOD_NAME("W9BSHPF_obtenerHistoricoAviso");

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
