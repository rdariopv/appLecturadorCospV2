package com.lecturador.android.dblecturador;

public class Empleado{

    private int codigo;
    private int ci;
    private String nombre;
    private int telefono;
    private String direccion;
    private int idzona;
    
    public Empleado(){
        codigo=0;
        ci=0;
        nombre="";
        telefono=0;
        direccion="";
        idzona=0;
    }
    public Empleado( int codigo, int ci, String nombre, int telefono, String direccion, int idzona){
        this.codigo = codigo;
        this.ci = ci;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.idzona = idzona;
    }
    public int getcodigo( ){
     return codigo;
    }
    public int getci( ){
     return ci;
    }
    public String getnombre( ){
     return nombre;
    }
    public int gettelefono( ){
     return telefono;
    }
    public String getdireccion( ){
     return direccion;
    }
    public int getidzona( ){
     return idzona;
    }
    public void setcodigo( int codigo){
     this.codigo = codigo;
    }
    public void setci( int ci){
     this.ci = ci;
    }
    public void setnombre( String nombre){
     this.nombre = nombre;
    }
    public void settelefono( int telefono){
     this.telefono = telefono;
    }
    public void setdireccion( String direccion){
     this.direccion = direccion;
    }
    public void setidzona( int idzona){
     this.idzona = idzona;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", ci=" + ci + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", idzona=" + idzona + '}';
    }
    
    
    
    
}