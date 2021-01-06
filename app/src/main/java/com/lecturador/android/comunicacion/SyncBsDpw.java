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


    public void SyncObtenerDetalleAvisos(final int piAnio, final int piMes, final int piZona, final int piRango) {

        WsDataSoap tecnica = new WsDataSoap() {

            @Override
            public void adicionarParametro(SoapObject pregunta, SoapSerializationEnvelope sobre) {
                PropertyInfo pAnio = new PropertyInfo();
                pAnio.setName("liAnio");
                pAnio.setType(int.class);
                pAnio.setValue(piAnio);
                pregunta.addProperty(pAnio);

                PropertyInfo pMes = new PropertyInfo();
                pMes.setName("liMesf");
                pMes.setType(int.class);
                pMes.setValue(piMes);
                pregunta.addProperty(pMes);

                PropertyInfo pZona = new PropertyInfo();
                pZona.setName("liZona");
                pZona.setType(int.class);
                pZona.setValue(piZona);
                pregunta.addProperty(pZona);

                PropertyInfo pRango = new PropertyInfo();
                pRango.setName("liRango");
                pRango.setType(int.class);
                pRango.setValue(piRango);
                pregunta.addProperty(pRango);
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
                    dpw.setDhpc(String.valueOf(objDpw.getProperty(3).toString()));
                    dpw.setNcat(Integer.valueOf(objDpw.getProperty(4).toString()));
                    dpw.setDcat(String.valueOf(objDpw.getProperty(5).toString()));
                    dpw.setNcta(String.valueOf(objDpw.getProperty(6).toString()));
                    dpw.setCmon(Integer.valueOf(objDpw.getProperty(7).toString()));
                    dpw.setTcam(Double.valueOf(objDpw.getProperty(8).toString()));
                    dpw.setCant(Double.valueOf(objDpw.getProperty(9).toString()));
                    dpw.setPuni(Double.valueOf(objDpw.getProperty(10).toString()));
                    dpw.setImpt(Double.valueOf(objDpw.getProperty(11).toString()));
                    dpw.setCref(String.valueOf(objDpw.getProperty(12).toString()));
                    dpw.setFaci(Double.valueOf(objDpw.getProperty(13).toString()));
                    dpw.setInex(String.valueOf(objDpw.getProperty(14).toString()));
                    dpw.setCprd(Integer.valueOf(objDpw.getProperty(15).toString()));
                    dpw.setNtpo(Integer.valueOf(objDpw.getProperty(16).toString()));
                    dpw.setNtpc(Integer.valueOf(objDpw.getProperty(17).toString()));
                    dpw.setStad(Integer.valueOf(objDpw.getProperty(18).toString()));
                    dpw.setStat(Integer.valueOf(objDpw.getProperty(19).toString()));
                    dpw.setRide(Integer.valueOf(objDpw.getProperty(20).toString()));

                    Log.e("SyncBsDpw", "hasta aqui se convirtio a obj local");
                    dpw.insertarBsDpw();
                    // listDpw.add(dpw);
                    Log.e("SyncBsDpw", "se adiciono el objDpw a la lista");
                    SyncActualizarAvisoDescargado(dpw.getNhpf(),dpw.getNhpc(),dpw.getNtpo(),1);
                }
                //Log.e("SyncBsHpw", "Cantidad de obj Objtenidos via WEb Service=" + listDpw.size());

            }

        };
        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSDPW_obtenerDetalleAvisos");
        tecnica.setMETHOD_NAME("BSDPW_obtenerDetalleAvisos");


        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }


    public int SyncActualizarAvisoDetalle(final int liNhpf, final int liNhpc, final int liCant,
                                          final double lfPuni, final double lfImpt) {
       final int[] result = {0};
        WsDataSoap tecnica = new WsDataSoap() {
            @Override
            public void adicionarParametro(SoapObject Pregunta, SoapSerializationEnvelope sobre) {
             //   pmtActualizarAvsDtl pmtActAvsDtl = new pmtActualizarAvsDtl();

               // pmtActAvsDtl.setLiNhpf(liNhpf);
               // pmtActAvsDtl.setLiNhpc(liNhpc);
               // pmtActAvsDtl.setLiCant(liCant);
               // pmtActAvsDtl.setLfPuni(lfPuni);
               // pmtActAvsDtl.setLfImpt(lfImpt);
               // sobre.addMapping(Pregunta.getNamespace(), pmtActAvsDtl.getClass().getSimpleName(),pmtActAvsDtl.getClass());
               // MarshalDouble md = new MarshalDouble();
               // md.register(sobre);

                PropertyInfo pNhpf = new PropertyInfo();
                pNhpf.setName("liNhpf");
                pNhpf.setType(PropertyInfo.STRING_CLASS);
                pNhpf.setValue(liNhpf+"");
                Pregunta.addProperty(pNhpf);
//
                PropertyInfo pNhpc = new PropertyInfo();
                pNhpc.setName("liNhpc");
                pNhpc.setType(PropertyInfo.STRING_CLASS);
                pNhpc.setValue(liNhpc+"");
                Pregunta.addProperty(pNhpc);

                PropertyInfo pCant = new PropertyInfo();
                pCant.setName("liCant");
                pCant.setType(PropertyInfo.STRING_CLASS);
                pCant.setValue(liCant+"");
                Pregunta.addProperty(pCant);

                PropertyInfo pPuni = new PropertyInfo();
                pPuni.setName("lfPuni");
                pPuni.setType(PropertyInfo.STRING_CLASS);
                pPuni.setValue(lfPuni+"");
                Pregunta.addProperty(pPuni);

                PropertyInfo pImpt = new PropertyInfo();
                pImpt.setName("lfImpt");
                pImpt.setType(PropertyInfo.STRING_CLASS);
                pImpt.setValue(lfImpt+"");
                Pregunta.addProperty(pImpt);
            }

            @Override
            public void leerDatos(SoapObject datos) {

            }


            public void leerDatosPrimitivos(SoapPrimitive datos) {
                result[0] = Integer.valueOf(datos.toString());
                // int result = Integer.valueOf(diffgram.toString());
                if (result[0] == 1) {
                    Log.e("SyncBsDpw", " se actualizo estado correctamente result[0]= "+ result[0]);
                } else {
                    Log.e("SyncBsDpw", " ERROR AL ACTUALIZAR ESTADO ");
                }
            }

        };

        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSHPW_ActualizarAvisoDetalle");
        tecnica.setMETHOD_NAME("BSHPW_ActualizarAvisoDetalle");

        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);

        tecnica.setURL(cnf.getCnfwUrl().trim());

        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicioPrimitivo();

        return result[0];
    }


    public int SyncActualizarAvisoDetalleXX1(final int liNhpf, final int liNhpc, final int liCant,
                                          final double lfPuni, final int lfImpt) {

        int x=0;
        String NAMESPACE = "http://activebs.net/";
        String METHOD_NAME = "BSHPW_ActualizarAvisoDetalle";

        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        String URL = cnf.getCnfwUrl().trim();
        // String URL = "http://192.168.43.138/testsoap/wsme.asmx";
        String SOAP_ACTION = "http://activebs.net/BSHPW_ActualizarAvisoDetalle";

        SoapObject pregunta = new SoapObject(NAMESPACE, METHOD_NAME);
        SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        sobre.dotNet = true;

        sobre.encodingStyle = SoapSerializationEnvelope.XSD;
        sobre.implicitTypes = true;

        PropertyInfo pNhpf = new PropertyInfo();
        pNhpf.setName("liNhpf");
        pNhpf.setType(PropertyInfo.STRING_CLASS);
        pNhpf.setValue(liNhpf+"");
        pregunta.addProperty(pNhpf);

        PropertyInfo pNhpc = new PropertyInfo();
        pNhpc.setName("liNhpc");
        pNhpc.setType(PropertyInfo.STRING_CLASS);
        pNhpc.setValue(liNhpc+"");
        pregunta.addProperty(pNhpc);

        PropertyInfo pCant = new PropertyInfo();
        pCant.setName("liCant");
        pCant.setType(PropertyInfo.STRING_CLASS);
        pCant.setValue(liCant+"");
        pregunta.addProperty(pCant);

        PropertyInfo pPuni = new PropertyInfo();
        pPuni.setName("lfPuni");
        pPuni.setType(PropertyInfo.STRING_CLASS);
        pPuni.setValue(lfPuni+"");
        pregunta.addProperty(pPuni);

        PropertyInfo pImpt = new PropertyInfo();
        pImpt.setName("lfImpt");
        pImpt.setType(PropertyInfo.STRING_CLASS);
        pImpt.setValue(lfImpt+"");
        pregunta.addProperty(pImpt);


        sobre.setOutputSoapObject(pregunta);
        HttpTransportSE transporte = new HttpTransportSE(URL);
        transporte.debug = true;
        transporte.setTimeout(100000);
        try {
            transporte.call(SOAP_ACTION, sobre);
            SoapPrimitive primitive = (SoapPrimitive) sobre.getResponse();
             x = Integer.valueOf(primitive.toString());
            Log.e("MainActivity","dato obtenido  =  " + x +"---------------------------------------");

        } catch (Exception e) {
            // SoapObject obj =(SoapObject) sobre.bodyIn;
            //  String result = obj.toString();
            Log.e("MainActivity","se dio un error :"+ e.getMessage());
            e.printStackTrace();
        }



        return x;
    }


    public int SyncActualizarAvisoDescargado(final int nhpf, final int nhpc, final int ntpo, final int stat) {

        WsDataSoap tecnica = new WsDataSoap() {

            @Override
            public void leerDatos(SoapObject datos) {

            }

            public void leerDatosPrimitivos(SoapPrimitive datos) {
                int result = Integer.valueOf(datos.toString());
                // int result = Integer.valueOf(diffgram.toString());
                if (result == 1) {
                    Log.e("SyncBsDpw", " se confirmo descarga de detalle  correctamente");
                } else {
                    Log.e("SyncBsDpw", " ERROR AL confirmar DESCARGA DE ESTADO ESTADO ");
                }
            }

            @Override
            public void adicionarParametro(SoapObject Pregunta,  SoapSerializationEnvelope sobre) {
                PropertyInfo pNhpf = new PropertyInfo();
                pNhpf.setName("liNhpf");
                pNhpf.setType(int.class);
                pNhpf.setValue(nhpf);
                Pregunta.addProperty(pNhpf);

                PropertyInfo pNhpc = new PropertyInfo();
                pNhpc.setName("liNhpc");
                pNhpc.setType(int.class);
                pNhpc.setValue(nhpc);
                Pregunta.addProperty(pNhpc);

                PropertyInfo pNtpo = new PropertyInfo();
                pNtpo.setName("liNtpo");
                pNtpo.setType(int.class);
                pNtpo.setValue(ntpo);
                Pregunta.addProperty(pNtpo);

                PropertyInfo pStat = new PropertyInfo();
                pStat.setName("liStat");
                pStat.setType(int.class);
                pStat.setValue(stat);
                Pregunta.addProperty(pStat);
            }
        };

        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSHPW_ActualizarDetalleStat");
        tecnica.setMETHOD_NAME("BSHPW_ActualizarDetalleStat");
        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicioPrimitivo();
        return 0;
    }

    public int SyncActualizarAvisoStatxNhpf(final int nhpf, final int stat) {

        WsDataSoap tecnica = new WsDataSoap() {

            @Override
            public void leerDatos(SoapObject datos) {

            }

            public void leerDatosPrimitivos(SoapPrimitive datos) {
                int result = Integer.valueOf(datos.toString());
                // int result = Integer.valueOf(diffgram.toString());
                if (result == 1) {
                    Log.e("SyncBsDpw", " se confirmo descarga de detalle  correctamente");
                } else {
                    Log.e("SyncBsDpw", " ERROR AL confirmar DESCARGA DE ESTADO ESTADO ");
                }
            }

            @Override
            public void adicionarParametro(SoapObject Pregunta,  SoapSerializationEnvelope sobre) {
                PropertyInfo pNhpf = new PropertyInfo();
                pNhpf.setName("liNhpf");
                pNhpf.setType(int.class);
                pNhpf.setValue(nhpf);
                Pregunta.addProperty(pNhpf);

                PropertyInfo pStat = new PropertyInfo();
                pStat.setName("liStat");
                pStat.setType(int.class);
                pStat.setValue(stat);
                Pregunta.addProperty(pStat);
            }
        };

        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSHPW_ActualizarDetalleStatxNhpf");

        tecnica.setMETHOD_NAME("BSHPW_ActualizarDetalleStatxNhpf");
        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicioPrimitivo();
        return 0;
    }


    public class pmtActualizarAvsDtl implements KvmSerializable {
        private int liNhpf;
        private int liNhpc;
        private int liCant;
        private Double lfPuni;
        private Double lfImpt;

        //<BSHPW_ActualizarAvisoDetalle xmlns="http://activebs.net/">
        //<liNhpf>int</liNhpf>
        //<liNhpc>int</liNhpc>
        //<liCant>int</liCant>
        //<lfPuni>double</lfPuni>
        //<lfImpt>int</lfImpt>
        //</BSHPW_ActualizarAvisoDetalle>
        public pmtActualizarAvsDtl() {
        }

        public int getLiNhpf() {
            return liNhpf;
        }

        public void setLiNhpf(int liNhpf) {
            this.liNhpf = liNhpf;
        }

        public int getLiNhpc() {
            return liNhpc;
        }

        public void setLiNhpc(int liNhpc) {
            this.liNhpc = liNhpc;
        }

        public int getLiCant() {
            return liCant;
        }

        public void setLiCant(int liCant) {
            this.liCant = liCant;
        }

        public double getLfPuni() {
            return lfPuni;
        }

        public void setLfPuni(double lfPuni) {
            this.lfPuni = lfPuni;
        }

        public double getLfImpt() {
            return lfImpt;
        }

        public void setLfImpt(double lfImpt) {
            this.lfImpt = lfImpt;
        }

        @Override
        public Object getProperty(int i) {
            switch (i) {
                case 0: return liNhpf;
                case 1: return liNhpc;
                case 2: return liCant;
                case 3: return lfPuni;
                case 4: return lfImpt;
            }
            return null;
        }

        @Override
        public int getPropertyCount() {
            return 5;
        }

        @Override
        public void setProperty(int i, Object o) {
            switch (i){
                case 0:
                    this.liNhpf = Integer.valueOf(o.toString());
                    break;
                case 1:
                    this.liNhpc = Integer.valueOf(o.toString());
                    break;
                case 2:
                    this.liCant = Integer.valueOf(o.toString());
                    break;
                case 3:
                    this.lfPuni = Double.valueOf(o.toString());
                    break;
                case 4:
                    this.lfImpt = Double.valueOf(o.toString());
                    break;
            }
        }

        @Override
        public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {
           switch (i){
               case 0:
                   propertyInfo.name= "liNhpf";
                   propertyInfo.type= PropertyInfo.INTEGER_CLASS;
                   break;
               case 1:
                   propertyInfo.name= "liNhpc";
                   propertyInfo.type= PropertyInfo.INTEGER_CLASS;
                   break;
               case 2:
                   propertyInfo.name= "liCant";
                   propertyInfo.type= PropertyInfo.INTEGER_CLASS;
                   break;
               case 3:
                   propertyInfo.name= "lfPuni";
                   propertyInfo.type= double.class;
                   break;
               case 4:
                   propertyInfo.name= "lfImpt";
                   propertyInfo.type= double.class;
                   break;
               default:
                   break;
           }
        }
    }

}

