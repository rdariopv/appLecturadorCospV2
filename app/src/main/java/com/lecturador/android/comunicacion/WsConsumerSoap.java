package com.lecturador.android.comunicacion;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;
import org.ksoap2.transport.HttpTransportSE;
import org.kxml2.kdom.*;
import org.xmlpull.v1.XmlPullParserException;


import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Map;

/**
 * Created by Dario Pardo on 4/17/2017.
 */
public class WsConsumerSoap {

    private WsDataSoap datos;
    public WsConsumerSoap(WsDataSoap dataws){
        this.datos=dataws;
    }
    public void consumirMetodoServicio()
    {
        SoapObject pregunta = new SoapObject(this.datos.getNAMESPACE(), this.datos.getMETHOD_NAME());


        SoapSerializationEnvelope sobre =new SoapSerializationEnvelope(SoapEnvelope.VER11);
        sobre.dotNet = datos.isPuntoNet();
        datos.adicionarParametro(pregunta,sobre);

        sobre.setOutputSoapObject(pregunta);
        HttpTransportSE transporte = new HttpTransportSE(this.datos.getURL());

        try{
            transporte.call(this.datos.getSOAP_ACTION(), sobre);
            SoapObject respuesta =(SoapObject)sobre.getResponse();
            datos.leerDatos(respuesta);
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    public void consumirMetodoServicioPrimitivo()
    {
        SoapObject pregunta = new SoapObject(this.datos.getNAMESPACE(), this.datos.getMETHOD_NAME());

        SoapSerializationEnvelope sobre =new SoapSerializationEnvelope(SoapEnvelope.VER11);
        sobre.implicitTypes=true;
        sobre.dotNet = datos.isPuntoNet();
        sobre.encodingStyle= SoapSerializationEnvelope.XSD;

        datos.adicionarParametro(pregunta,sobre);
        sobre.setOutputSoapObject(pregunta);

        HttpTransportSE transporte = new HttpTransportSE(this.datos.getURL());
        transporte.setTimeout(100000);

        transporte.debug=true;
        try{
            transporte.call(this.datos.getSOAP_ACTION(), sobre);
          //SoapObject respuesta =(SoapObject)sobre.getResponse();
           SoapPrimitive respuesta = (SoapPrimitive)sobre.getResponse();
          //  String s= sobre.getResponse().toString();
            Log.e("WsConsumerSoap", "consumirMetodoServicioPrimitivo: respuesta =" + respuesta.toString());
            datos.leerDatosPrimitivos(respuesta);

        }catch(SoapFault e){
            //e.printStackTrace();
            SoapObject obj =(SoapObject) sobre.bodyIn;
            String result = obj.toString();
            Log.e("WsConsumerSoap", "consumirMetodoServicioPrimitivo: ERROR =" + result);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
