package com.lecturador.android.negocio;

import android.util.Log;

import com.lecturador.android.dblecturador.Lecturacion;
import com.lecturador.android.dblecturador.Medidor;
import com.lecturador.android.dblecturador.Socio;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Dario Pardo on 6/9/2015.
 */
public class ItemLecturacion implements Serializable {
    private Lecturacion miLecturacion;
    private Medidor miMedidor;
    private Socio miSocio;

    public ItemLecturacion() {
        this.miLecturacion= new Lecturacion();
        this.miMedidor= new Medidor();
        this.miSocio= new Socio();
    }

    public ItemLecturacion(Medidor miMedidor) {
        Log.e("ItemLecturacion", "ItemLecturacion se CONSTRUYE UN OBJ  con medidor =" + miMedidor.toString());
        this.miLecturacion = new NLecturacion().ObtenerLecturacion(miMedidor.getid());

            Log.e("ItemLecturacion", "ItemLecturacion se OBTIENE OBJ  con lecturacion =" +this.miLecturacion.toString());
            this.miMedidor = miMedidor;
            this.miSocio= new NSocio().getSocio(miMedidor.getcodsocio());
            Log.e("ItemLecturacion", "ItemLecturacion se OBTIENE OBJ  con SOCIO =" +this.miSocio.toString());






    }

    public Lecturacion getMiLecturacion() {
        return miLecturacion;
    }

    public void setMiLecturacion(Lecturacion miLecturacion) {
        this.miLecturacion = miLecturacion;
    }

    public Medidor getMiMedidor() {
        return miMedidor;
    }

    public void setMiMedidor(Medidor miMedidor) {
        this.miMedidor = miMedidor;
    }

    public Socio getMiSocio() {
        return miSocio;
    }

    public void setMiSocio(Socio miSocio) {
        this.miSocio = miSocio;
    }

    public LinkedList<ItemLecturacion> listarItemsLecturacion()
    {
        LinkedList<Medidor>  medidorLinkedList= new NMedidor().listarMedidores();

        LinkedList<ItemLecturacion> itemLecturaciones= new LinkedList<>();

        for (Medidor medidor: medidorLinkedList)
        {
            if(medidor.getid()!=0){

                ItemLecturacion itemLecturaciones1= new ItemLecturacion(medidor);
                itemLecturaciones.add(itemLecturaciones1);
            }

        }


        return itemLecturaciones;
    }
    public LinkedList<ItemLecturacion> listarItemsLecturaciones2()
    {
        LinkedList<Medidor>  medidorLinkedList= new NMedidor().listarMedidores();
        LinkedList<Lecturacion> lecturacionLinkedList= new NLecturacion().listarLecturacion();
        LinkedList<ItemLecturacion> itemLecturaciones= new LinkedList<>();

        for (Lecturacion lecturacion: lecturacionLinkedList)
        {
             Medidor medidor= new NMedidor().getMedidor(lecturacion.getIdmedidor());
            ItemLecturacion itemLecturaciones1= new ItemLecturacion();
            itemLecturaciones1.setMiLecturacion(lecturacion);
            itemLecturaciones1.setMiMedidor(medidor);
            Socio socio= new NSocio().getSocio(medidor.getcodsocio());
            itemLecturaciones1.setMiSocio(socio);
            itemLecturaciones.add(itemLecturaciones1);


        }
        return itemLecturaciones;
    }
    @Override
    public String toString() {
        return "ItemLecturacion{" +
                "miLecturacion=" + miLecturacion.toString() +
                ", miMedidor=" + miMedidor.toString() +
                ", miSocio=" + miSocio.toString() +
                '}';
    }
}
