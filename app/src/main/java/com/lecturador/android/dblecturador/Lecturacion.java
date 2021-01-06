package com.lecturador.android.dblecturador;

import java.io.Serializable;

public class Lecturacion implements Serializable{

    private int id;
    private int lectura;
    private int idtipo;
    private int consumo;
    private String observacion;
    private int idPeriodo;
    private int idmedidor;

    public Lecturacion(){
        this.id=0;
        this.lectura=0;
        this.idtipo=0;
        this.consumo=0;
        this.observacion="";
        this.idPeriodo=0;
        this.idmedidor=0;

    }
    public Lecturacion( int id, int lectura, int idtipo, int consumo, String observacion, int idPeriodo, int idmedidor){
        this.id = id;
        this.lectura = lectura;
        this.idtipo = idtipo;
        this.consumo = consumo;
        this.observacion = observacion;
        this.idPeriodo = idPeriodo;
        this.idmedidor = idmedidor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLectura() {
        return lectura;
    }

    public void setLectura(int lectura) {
        this.lectura = lectura;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public int getIdmedidor() {
        return idmedidor;
    }

    public void setIdmedidor(int idmedidor) {
        this.idmedidor = idmedidor;
    }

    @Override
    public String toString() {
        return "Lecturacion{" +
                "id=" + id +
                ", lectura=" + lectura +
                ", idtipo=" + idtipo +
                ", consumo=" + consumo +
                ", observacion='" + observacion + '\'' +
                ", idPeriodo=" + idPeriodo +
                ", idmedidor=" + idmedidor +
                '}';
    }
}