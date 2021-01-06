package com.lecturador.android.comunicacion;

import android.util.Log;

import com.lecturador.android.dblecturador.BsHpw;
import com.lecturador.android.dblecturador.LtCnf;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by Dario Pardo on 4/20/2017.
 */
public class SyncBsHpw {
    public int liAnio;
    public int liMesf;
    public int liZona;
    public int liRango;

    public void SyncObtenerHeaderAvisos(int piAnio, int piMes, int piZona, int rango) {
        liAnio = piAnio;
        liMesf = piMes;
        liZona = piZona;
        liRango = rango;
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
                int cantProp= dataset.getPropertyCount();
                if(cantProp>0){
                    SoapObject newDataset = (SoapObject) dataset.getProperty(0);

                    // registrar header avisos
                    Log.e("SyncBsHpw", "Cantidad de reg. " + newDataset.getPropertyCount());
                    // List listHpw = new LinkedList<BsHpw>();
                    for (int i = 0; i < newDataset.getPropertyCount(); i++) {
                        SoapObject objHpw = (SoapObject) newDataset.getProperty(i);

                        BsHpw hpw = new BsHpw();
                        hpw.setNhpf(Integer.valueOf(objHpw.getProperty(00).toString()));
                        hpw.setAnio(Integer.valueOf(objHpw.getProperty(01).toString()));
                        hpw.setMesf(Integer.valueOf(objHpw.getProperty(02).toString()));
                        hpw.setFgen(objHpw.getProperty(03).toString());
                        hpw.setFent(objHpw.getProperty(04).toString());
                        hpw.setFvto(objHpw.getProperty(05).toString());
                        hpw.setFcor(objHpw.getProperty(06).toString());
                        hpw.setNhpc(Integer.valueOf(objHpw.getProperty(07).toString()));
                        hpw.setNcat(Integer.valueOf(objHpw.getProperty(8).toString()));
                        hpw.setDcat(objHpw.getProperty(9).toString());
                        hpw.setLant(Integer.valueOf(objHpw.getProperty(10).toString()));
                        hpw.setLact(Integer.valueOf(objHpw.getProperty(11).toString()));
                        hpw.setCons(Integer.valueOf(objHpw.getProperty(12).toString()));
                        hpw.setConf(Integer.valueOf(objHpw.getProperty(13).toString()));
                        hpw.setImco(Double.valueOf(objHpw.getProperty(14).toString()));
                        hpw.setFini(objHpw.getProperty(15).toString());
                        hpw.setFfin(objHpw.getProperty(16).toString());
                        hpw.setImpt(Double.valueOf(objHpw.getProperty(17).toString()));
                        hpw.setIcfi(Double.valueOf(objHpw.getProperty(18).toString()));
                        hpw.setImor(Double.valueOf(objHpw.getProperty(19).toString()));
                        hpw.setNmor(Integer.valueOf(objHpw.getProperty(20).toString()));
                        hpw.setCmor(Integer.valueOf(objHpw.getProperty(21).toString()));
                        hpw.setCort(objHpw.getProperty(22).toString());
                        hpw.setDesc(objHpw.getProperty(23).toString());
                        hpw.setCper(Integer.valueOf(objHpw.getProperty(24).toString()));
                        hpw.setNomb(objHpw.getProperty(25).toString());
                        hpw.setNmed(Integer.valueOf(objHpw.getProperty(26).toString()));
                        hpw.setNume(objHpw.getProperty(27).toString());
                        hpw.setNcnt(Integer.valueOf(objHpw.getProperty(28).toString()));
                        hpw.setNser(Integer.valueOf(objHpw.getProperty(29).toString()));
                        hpw.setDpto(Integer.valueOf(objHpw.getProperty(30).toString()));
                        hpw.setNpro(Integer.valueOf(objHpw.getProperty(31).toString()));
                        hpw.setNciu(Integer.valueOf(objHpw.getProperty(32).toString()));
                        hpw.setDciu(objHpw.getProperty(33).toString());
                        hpw.setNuve(Integer.valueOf(objHpw.getProperty(34).toString()));
                        hpw.setDuve(objHpw.getProperty(35).toString());
                        hpw.setNmza(Integer.valueOf(objHpw.getProperty(36).toString()));
                        hpw.setDmza(objHpw.getProperty(37).toString());
                        hpw.setNlot(Integer.valueOf(objHpw.getProperty(38).toString()));
                        hpw.setDlot(objHpw.getProperty(39).toString());
                        hpw.setNbar(Integer.valueOf(objHpw.getProperty(40).toString()));
                        hpw.setDbar(objHpw.getProperty(41).toString());
                        hpw.setNimb(Integer.valueOf(objHpw.getProperty(42).toString()));
                        hpw.setDimb(objHpw.getProperty(43).toString());
                        hpw.setNzon(Integer.valueOf(objHpw.getProperty(44).toString()));
                        hpw.setDzon(objHpw.getProperty(45).toString());
                        hpw.setNrut(Integer.valueOf(objHpw.getProperty(46).toString()));
                        hpw.setDrut(objHpw.getProperty(47).toString());
                        hpw.setCodf(Integer.valueOf(objHpw.getProperty(48).toString()));
                        hpw.setNred(Integer.valueOf(objHpw.getProperty(49).toString()));
                        hpw.setNvia(Integer.valueOf(objHpw.getProperty(50).toString()));
                        hpw.setNroi(Integer.valueOf(objHpw.getProperty(51).toString()));
                        hpw.setDire(objHpw.getProperty(52).toString());
                        hpw.setClas(Integer.valueOf(objHpw.getProperty(53).toString()));
                        hpw.setIplv(Integer.valueOf(objHpw.getProperty(54).toString()));
                        hpw.setNfac(Integer.valueOf(objHpw.getProperty(55).toString()));
                        hpw.setNtpc(Integer.valueOf(objHpw.getProperty(56).toString()));
                        hpw.setNtcn(Integer.valueOf(objHpw.getProperty(57).toString()));
                        hpw.setNdtb(Integer.valueOf(objHpw.getProperty(58).toString()));
                        hpw.setOnof(Integer.valueOf(objHpw.getProperty(59).toString()));
                        hpw.setLmax(Integer.valueOf(objHpw.getProperty(60).toString()));
                        hpw.setConp(Integer.valueOf(objHpw.getProperty(61).toString()));
                        hpw.setKvat(Integer.valueOf(objHpw.getProperty(62).toString()));
                        hpw.setCobs(Integer.valueOf(objHpw.getProperty(63).toString()));
                        hpw.setNlec(Integer.valueOf(objHpw.getProperty(64).toString()));
                        hpw.setPtjc(Integer.valueOf(objHpw.getProperty(65).toString()));
                        hpw.setStad(Integer.valueOf(objHpw.getProperty(66).toString()));
                        hpw.setLati(objHpw.getProperty(67).toString());
                        hpw.setLong(objHpw.getProperty(68).toString());
                        hpw.setStat(Integer.valueOf(objHpw.getProperty(69).toString()));
                        hpw.setRide(Integer.valueOf(objHpw.getProperty(70).toString()));
                        Log.e("SyncBsHpw", "hasta aqui se convirtio a obj local");
                        hpw.insertarBsHpw();
                        // listHpw.add(hpw);
                        Log.e("SyncBsHpw", "se adiciono el objHpw a la lista");
                        SyncActualizarAviso(hpw.getNhpf(), 2); // estado = 2 indica bajado correcto


                    }
                }

                //   Log.e("SyncBsHpw", "Cantidad de obj Objtenidos via WEb Service=" + listHpw.size());

            }
        };
        //tecnica.setNAMESPACE("http://tempuri.org/");
        tecnica.setNAMESPACE("http://activebs.net/");
       // tecnica.setSOAP_ACTION("http://tempuri.org/BSHPW_obtenerHeaderAvisos");
        tecnica.setSOAP_ACTION("http://activebs.net/BSHPW_obtenerHeaderAvisos");
        tecnica.setMETHOD_NAME("BSHPW_obtenerHeaderAvisos");


        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicio();
    }


    public int SyncActualizarAviso(final int nhpf, final int stad) {

        WsDataSoap tecnica = new WsDataSoap() {

            @Override
            public void leerDatos(SoapObject datos) {

            }

            public void leerDatosPrimitivos(SoapPrimitive datos) {
                int result = Integer.valueOf(datos.toString());
                // int result = Integer.valueOf(diffgram.toString());
                if (result == 1) {
                    Log.e("SyncBsHpw", " se actualizo estado correcctamente");
                } else {
                    Log.e("SyncBsHpw", " ERROR AL ACTUALIZAR ESTADO ");
                }
            }

            @Override
            public void adicionarParametro(SoapObject Pregunta,  SoapSerializationEnvelope sobre) {
                PropertyInfo pNhpf = new PropertyInfo();
                pNhpf.setName("liNhpf");
                pNhpf.setType(int.class);
                pNhpf.setValue(nhpf);
                Pregunta.addProperty(pNhpf);

                PropertyInfo pStad = new PropertyInfo();
                pStad.setName("liStad");
                pStad.setType(int.class);
                pStad.setValue(stad);
                Pregunta.addProperty(pStad);
            }
        };


      //  tecnica.setNAMESPACE("http://tempuri.org/");
      //  tecnica.setSOAP_ACTION("http://tempuri.org/BSHPW_ActualizarEstado");

        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSHPW_ActualizarEstado");

        tecnica.setMETHOD_NAME("BSHPW_ActualizarEstado");
        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicioPrimitivo();
        return 0;
    }


    public int SyncActualizarAvisoHead(final int liNhpf, final int liLact, final int liCons,
                                       final Date ldFfin, final int liImco, final int liCobs,
                                       final int liStad, final String lfLati, final String lfLogi,
                                       final int liNofn, final String lsAppName) {

        final int[] result = {0};
        WsDataSoap tecnica = new WsDataSoap() {
            @Override
            public void adicionarParametro(SoapObject Pregunta,  SoapSerializationEnvelope sobre) {

               // pmtActualizarHead pmtHead= new pmtActualizarHead();
               // pmtHead.setLiNhpf(liNhpf);
               // pmtHead.setLiLact(liLact);
               // pmtHead.setLiCons(liCons);
               // pmtHead.setLdFfin(ldFfin);
               // pmtHead.setLiImco(liImco);
               // pmtHead.setLiCobs(liCobs);
               // pmtHead.setLiStad(liStad);
               // pmtHead.setLfLati(lfLati);
               // pmtHead.setLfLogi(lfLogi);
               // pmtHead.setLiNofn(liNofn);
               // pmtHead.setLsAppName(lsAppName);
               // Log.e(pmtHead.getClass().getSimpleName(), "parametros Head =" + pmtHead.toString());
               // sobre.addMapping(Pregunta.getNamespace(), pmtHead.getClass().getSimpleName(),pmtHead.getClass());
               // MarshalDouble md = new MarshalDouble();
               // md.register(sobre);

               // MarshalDatetime mdt = new MarshalDatetime();
               // mdt.register(sobre);


                PropertyInfo pNhpf = new PropertyInfo();
                pNhpf.setName("liNhpf");
                pNhpf.setType(PropertyInfo.STRING_CLASS);
                pNhpf.setValue(liNhpf+"");
                Pregunta.addProperty(pNhpf);
//
                PropertyInfo pLact = new PropertyInfo();
                pLact.setName("liLact");
                pLact.setType(PropertyInfo.STRING_CLASS);
                pLact.setValue(liLact+"");
                Pregunta.addProperty(pLact);
//
                PropertyInfo pCons = new PropertyInfo();
                pCons.setName("liCons");
                pCons.setType(PropertyInfo.STRING_CLASS);
                pCons.setValue(liCons+"");
                Pregunta.addProperty(pCons);
//
                SimpleDateFormat loSDF = new SimpleDateFormat("yyyy-MM-dd");
                String  lsFecha = loSDF.format(ldFfin);

                PropertyInfo pFfin = new PropertyInfo();
                pFfin.setName("ldFfin");
                pFfin.setType(PropertyInfo.STRING_CLASS);
                pFfin.setValue(lsFecha);
                Pregunta.addProperty(pFfin);
//
                PropertyInfo pImco = new PropertyInfo();
                pImco.setName("liImco");
                pImco.setType(PropertyInfo.STRING_CLASS);
                pImco.setValue(liImco+"");
                Pregunta.addProperty(pImco);
//
                PropertyInfo pCobs = new PropertyInfo();
                pCobs.setName("liCobs");
                pCobs.setType(PropertyInfo.STRING_CLASS);
                pCobs.setValue(liCobs+"");
                Pregunta.addProperty(pCobs);
//
                PropertyInfo pStad = new PropertyInfo();
                pStad.setName("liStad");
                pStad.setType(PropertyInfo.STRING_CLASS);
                pStad.setValue(liStad+"");
                Pregunta.addProperty(pStad);
//
                PropertyInfo pfLati = new PropertyInfo();
                pfLati.setName("lfLati");
                pfLati.setType(PropertyInfo.STRING_CLASS);
                pfLati.setValue(lfLati+"");
                Pregunta.addProperty(pfLati);
//
                PropertyInfo pfLogi = new PropertyInfo();
                pfLogi.setName("lfLogi");
                pfLogi.setType(PropertyInfo.STRING_CLASS);
                pfLogi.setValue(lfLogi+"");
                Pregunta.addProperty(pfLogi);
//
                PropertyInfo pNofn = new PropertyInfo();
                pNofn.setName("liNofn");
                pNofn.setType(PropertyInfo.STRING_CLASS);
                pNofn.setValue(liNofn+"");
                Pregunta.addProperty(pNofn);
//
                PropertyInfo pAppName = new PropertyInfo();
                pAppName.setName("lsAppName");
                pAppName.setType(PropertyInfo.STRING_CLASS);
                pAppName.setValue(pAppName+"");
                Pregunta.addProperty(pAppName);

            }

            @Override
            public void leerDatos(SoapObject datos) {

            }

            public void leerDatosPrimitivos(SoapPrimitive datos) {
                result[0] = Integer.valueOf(datos.toString());
                // int result = Integer.valueOf(diffgram.toString());
                if (result[0] == 1) {
                    Log.e("SyncBsHpw", " se actualizo estado correctamente  result[0]= "+ result[0]);
                } else {
                    Log.e("SyncBsHpw", " ERROR AL ACTUALIZAR ESTADO ");
                }
            }

        };

        http://activebs.net/
       // tecnica.setNAMESPACE("http://tempuri.org/");
       // tecnica.setSOAP_ACTION("http://tempuri.org/BSHPW_ActualizarAvisoHead");
        tecnica.setNAMESPACE("http://activebs.net/");
        tecnica.setSOAP_ACTION("http://activebs.net/BSHPW_ActualizarAvisoHead");
        tecnica.setMETHOD_NAME("BSHPW_ActualizarAvisoHead");

        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        tecnica.setURL(cnf.getCnfwUrl());
        WsConsumerSoap consumo = new WsConsumerSoap(tecnica);
        consumo.consumirMetodoServicioPrimitivo();

        return result[0];
    }


    public class pmtActualizarHead implements KvmSerializable {
        private int     liNhpf;
        private Date    ldFfin;
        private int     liStad;
        private int     liNofn;
        private int     liLact;
        private int     liImco;
        private Double  lfLati;
        private int     liCons;
        private int     liCobs;
        private Double  lfLogi;
        private String  lsAppName;

        @Override
        public String toString() {
            return "pmtActualizarHead{" +
                    "liNhpf=" + liNhpf +
                    ", ldFfin=" + ldFfin +
                    ", liStad=" + liStad +
                    ", liNofn=" + liNofn +
                    ", liLact=" + liLact +
                    ", liImco=" + liImco +
                    ", lfLati=" + lfLati +
                    ", liCons=" + liCons +
                    ", liCobs=" + liCobs +
                    ", lfLogi=" + lfLogi +
                    ", lsAppName='" + lsAppName + '\'' +
                    '}';
        }

        public int getLiNhpf() {
            return liNhpf;
        }

        public void setLiNhpf(int liNhpf) {
            this.liNhpf = liNhpf;
        }

        public Date getLdFfin() {
            return ldFfin;
        }

        public void setLdFfin(Date ldFfin) {
            this.ldFfin = ldFfin;
        }

        public int getLiStad() {
            return liStad;
        }

        public void setLiStad(int liStad) {
            this.liStad = liStad;
        }

        public int getLiNofn() {
            return liNofn;
        }

        public void setLiNofn(int liNofn) {
            this.liNofn = liNofn;
        }

        public int getLiLact() {
            return liLact;
        }

        public void setLiLact(int liLact) {
            this.liLact = liLact;
        }

        public int getLiImco() {
            return liImco;
        }

        public void setLiImco(int liImco) {
            this.liImco = liImco;
        }

        public Double getLfLati() {
            return lfLati;
        }

        public void setLfLati(Double lfLati) {
            this.lfLati = lfLati;
        }

        public int getLiCons() {
            return liCons;
        }

        public void setLiCons(int liCons) {
            this.liCons = liCons;
        }

        public int getLiCobs() {
            return liCobs;
        }

        public void setLiCobs(int liCobs) {
            this.liCobs = liCobs;
        }

        public Double getLfLogi() {
            return lfLogi;
        }

        public void setLfLogi(Double lfLogi) {
            this.lfLogi = lfLogi;
        }

        public String getLsAppName() {
            return lsAppName;
        }

        public void setLsAppName(String lsAppName) {
            this.lsAppName = lsAppName;
        }

        public pmtActualizarHead() {
        }

        @Override
        public Object getProperty(int i) {
            switch (i) {
                case 0: return  liNhpf;
                case 1: return  ldFfin;
                case 2: return  liStad;
                case 3: return  liNofn;
                case 4: return  liLact;
                case 5: return  liImco;
                case 6: return  lfLati;
                case 7: return  liCons;
                case 8: return  liCobs;
                case 9: return  lfLogi;
                case 10: return lsAppName;
            }
            return null;
        }
        @Override
        public int getPropertyCount() {
            return 11;
        }

        @Override
        public void setProperty(int i, Object o) {
            switch (i){
                case 0:
                    this.liNhpf = Integer.valueOf(o.toString());
                    break;
                case 1:
                    this.ldFfin =(Date) o;
                    break;
                case 2:
                    this.liStad = Integer.valueOf(o.toString());
                    break;
                case 3:
                    this.liNofn = Integer.valueOf(o.toString());
                    break;
                case 4:
                    this.liLact = Integer.valueOf(o.toString());
                    break;
                case 5:
                    this.liImco = Integer.valueOf(o.toString());
                    break;
                case 6:
                    this.lfLati = Double.valueOf(o.toString());
                    break;
                case 7:
                    this.liCons = Integer.valueOf(o.toString());
                    break;
                case 8:
                    this.liCobs = Integer.valueOf(o.toString());
                    break;
                case 9:
                    this.lfLogi = Double.valueOf(o.toString());
                    break;
                case 10:
                    this.lsAppName = o.toString();
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
                    propertyInfo.name= "ldFfin";
                    propertyInfo.type= Date.class;
                    break;
                case 2:
                    propertyInfo.name= "liStad";
                    propertyInfo.type= PropertyInfo.INTEGER_CLASS;
                    break;
                case 3:
                    propertyInfo.name= "liNofn";
                    propertyInfo.type= PropertyInfo.INTEGER_CLASS;
                    break;
                case 4:
                    propertyInfo.name= "liLact";
                    propertyInfo.type=PropertyInfo.INTEGER_CLASS;
                    break;
                case 5:
                    propertyInfo.name= "liImco";
                    propertyInfo.type=PropertyInfo.INTEGER_CLASS;
                    break;
                case 6:
                    propertyInfo.name= "lfLati";
                    propertyInfo.type=double.class;
                    break;
                case 7:
                    propertyInfo.name= "liCons";
                    propertyInfo.type=PropertyInfo.INTEGER_CLASS;
                    break;
                case 8:
                    propertyInfo.name= "liCobs";
                    propertyInfo.type=PropertyInfo.INTEGER_CLASS;
                    break;
                case 9:
                    propertyInfo.name= "lfLogi";
                    propertyInfo.type=double.class;
                    break;
                case 10:
                    propertyInfo.name= "lsAppName";
                    propertyInfo.type=PropertyInfo.STRING_CLASS;
                    break;
                default:
                    break;
            }
        }
    }



}
