package com.lecturador.android.comunicacion;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Dario Pardo on 4/20/2017.
 */
public abstract class WsDataSoap implements Serializable {
    private String NAMESPACE;
    private String METHOD_NAME;
    private String URL;
    private String SOAP_ACTION;
    private boolean puntoNet;


    public WsDataSoap(){
        this.NAMESPACE="";
        this.METHOD_NAME="";
        this.URL="";
        this.SOAP_ACTION="";
        this.puntoNet=true;

    }
    public String getNAMESPACE() {
        return NAMESPACE;
    }

    public void setNAMESPACE(String NAMESPACE) {
        this.NAMESPACE = NAMESPACE;
    }

    public String getMETHOD_NAME() {
        return METHOD_NAME;
    }

    public void setMETHOD_NAME(String METHOD_NAME) {
        this.METHOD_NAME = METHOD_NAME;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getSOAP_ACTION() {
        return SOAP_ACTION;
    }

    public void setSOAP_ACTION(String SOAP_ACTION) {
        this.SOAP_ACTION = SOAP_ACTION;
    }

    public boolean isPuntoNet() {
        return puntoNet;
    }

    public void setPuntoNet(boolean puntoNet) {
        this.puntoNet = puntoNet;
    }

    public  abstract   void leerDatos(SoapObject datos);
    public   void leerDatosPrimitivos(SoapPrimitive datos){}
    public abstract  void adicionarParametro(SoapObject Pregunta , SoapSerializationEnvelope sobre);

}
