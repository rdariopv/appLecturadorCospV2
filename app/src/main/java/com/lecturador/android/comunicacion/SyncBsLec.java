package com.lecturador.android.comunicacion;

import android.util.Log;

import com.lecturador.android.dblecturador.BsHpw;
import com.lecturador.android.dblecturador.BsLec;
import com.lecturador.android.dblecturador.LtCnf;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SyncBsLec {
    public int liAnio;
    public int liMesf;
    public int liNrut;
    public int liRango;
    public int sNlec;

    public void SyncObtenerHeaderAvisos(int piAnio, int piMes, int piNrut, int rango) {
      /* <liAnio>int</liAnio>
      <liMesf>int</liMesf>
      <liNrut>int</liNrut>
      <liRango>int</liRango>*/
        liAnio = piAnio;
        liMesf = piMes;
        liNrut = piNrut;
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

                PropertyInfo pNrut = new PropertyInfo();
                pNrut.setName("liNrut");
                pNrut.setType(int.class);
                pNrut.setValue(liNrut);
                pregunta.addProperty(pNrut);

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
                int cantProp= dataset.getPropertyCount();
                if(cantProp>0){
                    SoapObject newDataset = (SoapObject) dataset.getProperty(0);

                    // registrar header avisos
                    Log.e("SyncBslec", "Cantidad de reg. " + newDataset.getPropertyCount());
                    // List listHpw = new LinkedList<BsHpw>();
                    for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                        SoapObject objLec = (SoapObject) newDataset.getProperty(i);

                        BsLec lec = new BsLec();
                        lec.setNlec(Integer.valueOf(objLec.getProperty(00).toString()));
                        lec.setAact(Integer.valueOf(objLec.getProperty(01).toString()));
                        lec.setMact(Integer.valueOf(objLec.getProperty(02).toString()));
                        lec.setCodf(Integer.valueOf(objLec.getProperty(03).toString()));
                        lec.setNcnt(Integer.valueOf(objLec.getProperty(04).toString()));
                        lec.setLant(Integer.valueOf(objLec.getProperty(05).toString()));
                        lec.setConp(Integer.valueOf(objLec.getProperty(06).toString()));
                        lec.setMedi(Integer.valueOf(objLec.getProperty(07).toString()));
                        lec.setNume(objLec.getProperty(8).toString());
                        lec.setdNom(objLec.getProperty(9).toString());
                        lec.setDire(objLec.getProperty(10).toString());
                        lec.setDUve(objLec.getProperty(11).toString());
                        lec.setDMza(objLec.getProperty(12).toString());
                        lec.setDlot(objLec.getProperty(13).toString());
                        lec.setCobs(0);
                        lec.setStat(0);
                        lec.setLact(0);


                        Log.e("SyncBsLec", "hasta aqui se convirtio a obj local");
                        lec.insertarBsLec();
                        // listHpw.add(hpw);
                        Log.e("SyncBsLec", "se adiciono el objLec a la lista");
                        SyncActualizarEstado(lec.getNlec(), 4); // estado = 4 indica bajado webservice


                    }
                }

                //   Log.e("SyncBsHpw", "Cantidad de obj Objtenidos via WEb Service=" + listHpw.size());

            }
        };
        //tecnica.setNAMESPACE("http://tempuri.org/");
        tecnica.setNAMESPACE("http://activebs.net/");
        // tecnica.setSOAP_ACTION("http://tempuri.org/BSHPW_obtenerHeaderAvisos");
        tecnica.setSOAP_ACTION("http://activebs.net/W4BSLEC_ALecturarxRuta");
        tecnica.setMETHOD_NAME("W4BSLEC_ALecturarxRuta");


        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();


    }



    public int SyncActualizarEstado(final int liNlec, final int liVial) {

        WsDataSoap tecnica = new WsDataSoap() {

            @Override
            public void leerDatos(SoapObject datos) {

            }

            public void leerDatosPrimitivos(SoapPrimitive datos) {
                int result = Integer.valueOf(datos.toString());
                // int result = Integer.valueOf(diffgram.toString());
                if (result == 1) {
                    Log.e("SyncBsLec", " se actualizo estado correcctamente");
                } else {
                    Log.e("SyncBsLec", " ERROR AL ACTUALIZAR ESTADO ");
                }
            }

            @Override
            public void adicionarParametro(SoapObject Pregunta,  SoapSerializationEnvelope sobre) {

               /* <liNlec>int</liNlec>
                  <liVial>int</liVial>*/
                sNlec=liNlec;
                PropertyInfo pNlec = new PropertyInfo();
                pNlec.setName("liNlec");
                pNlec.setType(int.class);
                pNlec.setValue(liNlec);
                Pregunta.addProperty(pNlec);

                PropertyInfo pVial = new PropertyInfo();
                pVial.setName("liVial");
                pVial.setType(int.class);
                pVial.setValue(liVial);
                Pregunta.addProperty(pVial);
            }
        };

        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/W5BSLEC_ActualizarEstado");
        tecnica.setMETHOD_NAME("W5BSLEC_ActualizarEstado");
        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicioPrimitivo();
        return 0;
    }


    public int SyncEnviarLecturacion(final int piNlec, final int piLact, final int piCobs,
                                     final Date pdFfin, final Double Lati, final double Logt,
                                     final int piNofn, final String lsAppName){
        /* <W6BSLEC_UpdateNewLectura xmlns="http://activebs.net/">
      <liNlec>int</liNlec>
      <liLact>int</liLact>
      <liCobs>int</liCobs>
      <ldFfin>dateTime</ldFfin>
      <lfLati>double</lfLati>
      <lfLogi>double</lfLogi>
      <liNofn>int</liNofn>
      <lsAppName>string</lsAppName>
    </W6BSLEC_UpdateNewLectura>*/

        WsDataSoap tecnica = new WsDataSoap() {

            final int[] result = {0};
            @Override
            public void adicionarParametro(SoapObject pregunta, SoapSerializationEnvelope sobre) {
                PropertyInfo pNlec = new PropertyInfo();
                pNlec.setName("liNlec");
                pNlec.setType(int.class);
                pNlec.setValue(piNlec);
                pregunta.addProperty(pNlec);

                PropertyInfo pLact = new PropertyInfo();
                pLact.setName("liLact");
                pLact.setType(int.class);
                pLact.setValue(piLact);
                pregunta.addProperty(pLact);

                PropertyInfo pCobs = new PropertyInfo();
                pCobs.setName("liCobs");
                pCobs.setType(int.class);
                pCobs.setValue(piCobs);
                pregunta.addProperty(pCobs);


                SimpleDateFormat loSDF = new SimpleDateFormat("yyyy-MM-dd");
                String  lsFecha = loSDF.format(pdFfin);

                PropertyInfo pFfin = new PropertyInfo();
                pFfin.setName("ldFfin");
                pFfin.setType(PropertyInfo.STRING_CLASS);
                pFfin.setValue(lsFecha);
                pregunta.addProperty(pFfin);

                PropertyInfo pfLati = new PropertyInfo();
                pfLati.setName("lfLati");
                pfLati.setType(PropertyInfo.STRING_CLASS);
                pfLati.setValue(Lati+"");
                pregunta.addProperty(pfLati);
//
                PropertyInfo pfLogi = new PropertyInfo();
                pfLogi.setName("lfLogi");
                pfLogi.setType(PropertyInfo.STRING_CLASS);
                pfLogi.setValue(Logt+"");
                pregunta.addProperty(pfLogi);
//
                PropertyInfo pNofn = new PropertyInfo();
                pNofn.setName("liNofn");
                pNofn.setType(PropertyInfo.STRING_CLASS);
                pNofn.setValue(piNofn+"");
                pregunta.addProperty(pNofn);
//
                PropertyInfo pAppName = new PropertyInfo();
                pAppName.setName("lsAppName");
                pAppName.setType(PropertyInfo.STRING_CLASS);
                pAppName.setValue(lsAppName+"");
                pregunta.addProperty(pAppName);
            }

            @Override
            public void leerDatos(SoapObject datos) {

            }

            public void leerDatosPrimitivos(SoapPrimitive datos) {
                result[0] = Integer.valueOf(datos.toString());
                // int result = Integer.valueOf(diffgram.toString());
                if (result[0] > 0) {
                    Log.e("SyncBsLec", " se actualizo estado correctamente  result[0]= "+ result[0]);
                    BsLec lec= new BsLec();
                    //lec.obtenerBsLec(sNlec);

                } else {
                    Log.e("SyncBsLec", " ERROR AL ACTUALIZAR ESTADO ");
                }
            }
        };
        //tecnica.setNAMESPACE("http://tempuri.org/");
        tecnica.setNAMESPACE("http://activebs.net/");
        // tecnica.setSOAP_ACTION("http://tempuri.org/BSHPW_obtenerHeaderAvisos");
        tecnica.setSOAP_ACTION("http://activebs.net/W6BSLEC_UpdateNewLectura");
        tecnica.setMETHOD_NAME("W6BSLEC_UpdateNewLectura");


        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicioPrimitivo();

        return 0;
    }
}
