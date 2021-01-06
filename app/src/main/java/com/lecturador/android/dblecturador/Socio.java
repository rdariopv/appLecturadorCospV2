package com.lecturador.android.dblecturador;
import java.io.Serializable;
import java.util.Date;
public class Socio implements Serializable{

    private int codigo;
    private int ci;
    private String nombre;
    private String direccion;
    public Socio(){
        this.codigo=0;
        this.ci=0;
        this.nombre="";
        this.direccion="";
    }
    public Socio( int codigo, int ci, String nombre, String direccion){
        this.codigo = codigo;
        this.ci = ci;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "codigo=" + codigo +
                ", ci=" + ci +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}