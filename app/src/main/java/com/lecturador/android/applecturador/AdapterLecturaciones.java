package com.lecturador.android.applecturador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lecturador.android.negocio.ItemLecturacion;

import java.util.LinkedList;

/**
 * Created by Dario Pardo on 6/9/2015.
 */
public class AdapterLecturaciones extends BaseAdapter {

    private Context context;
    private LinkedList<ItemLecturacion> listaItemLecturacions;

    public AdapterLecturaciones(Context context) {
        this.context = context;
        listaItemLecturacions = new ItemLecturacion().listarItemsLecturaciones2();
    }

    public AdapterLecturaciones(Context context, LinkedList<ItemLecturacion> listaItemLecturacions) {
        this.context = context;
        this.listaItemLecturacions = listaItemLecturacions;
    }

    public LinkedList<ItemLecturacion> getListaItemLecturacions() {
        return listaItemLecturacions;
    }

    public void setListaItemLecturacions(LinkedList<ItemLecturacion> listaItemLecturacions) {
        this.listaItemLecturacions = listaItemLecturacions;
    }

    @Override
    public int getCount() {
        return this.listaItemLecturacions.size();
    }

    @Override
    public ItemLecturacion getItem(int posicion) {
        return this.listaItemLecturacions.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return this.listaItemLecturacions.get(posicion).getMiLecturacion().getId();
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        ContenedorItem contenedorItem;
        View vItem = view;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            vItem = inflater.inflate(R.layout.itemmedidor,null);
            contenedorItem = new ContenedorItem();
            contenedorItem.tvIdMedidor = (TextView) vItem.findViewById(R.id.tvImCodSocio);
            contenedorItem.tvLectura = (TextView) vItem.findViewById(R.id.tvLectura);
            contenedorItem.tvNombreSocio = (TextView) vItem.findViewById(R.id.tvImNombreSocio);
            vItem.setTag(contenedorItem);
        } else {
            contenedorItem = (ContenedorItem) vItem.getTag();
        }

        ItemLecturacion itemLecturacion = this.listaItemLecturacions.get(posicion);

        contenedorItem.tvIdMedidor.setText(itemLecturacion.getMiMedidor().getid() + "");
        contenedorItem.tvNombreSocio.setText(itemLecturacion.getMiSocio().getNombre());
        contenedorItem.tvLectura.setText(itemLecturacion.getMiLecturacion().getLectura() + "");


        return vItem;
    }

    static class ContenedorItem {
        public TextView tvIdMedidor, tvLectura, tvNombreSocio;
    }
}
