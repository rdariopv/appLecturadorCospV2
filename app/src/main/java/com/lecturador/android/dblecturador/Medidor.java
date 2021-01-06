package com.lecturador.android.dblecturador;

import java.io.Serializable;

public class Medidor implements Serializable{

    private int id;
    private int marcador;
    private int idcategoria;
    private int idzona;
    private int codsocio;
    public Medidor(){
        id=0;
        marcador=0;
        idcategoria=0;
        idcategoria=0;
        idzona=0;
        codsocio=0;

    }
    public Medidor( int id, int marcador, int idcategoria, int idzona, int codsocio){
        this.id = id;
        this.marcador = marcador;
        this.idcategoria = idcategoria;
        this.idzona = idzona;
        this.codsocio = codsocio;
    }
    public int getid( ){
     return id;
    }
    public int getmarcador( ){
     return marcador;
    }
    public int getidcategoria( ){
     return idcategoria;
    }
    public int getidzona( ){
     return idzona;
    }
    public int getcodsocio( ){
     return codsocio;
    }
    public void setid( int id){
     this.id = id;
    }
    public void setmarcador( int marcador){
     this.marcador = marcador;
    }
    public void setidcategoria( int idcategoria){
     this.idcategoria = idcategoria;
    }
    public void setidzona( int idzona){
     this.idzona = idzona;
    }
    public void setcodsocio( int codsocio){
     this.codsocio = codsocio;
    }

    @Override
    public String toString() {
        return "Medidor{" + "id=" + id + ", marcador=" + marcador + ", idcategoria=" + idcategoria + ", idzona=" + idzona + ", codsocio=" + codsocio + '}';
    }
    
}