package com.lecturador.android.applecturador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lecturador.android.dblecturador.BsHpw;
import com.lecturador.android.dblecturador.BsLec;

import java.util.LinkedList;

/**
 * Created by Dario Pardo on 5/4/2017.
 */
public class AdpSocioMedidor extends BaseAdapter {

    private Context context;
    private LinkedList<BsLec> listLec;

    public AdpSocioMedidor(Context context, LinkedList<BsLec> listLecs) {
        this.context = context;
        this.listLec = listLecs;
    }

    @Override
    public int getCount() {
        return this.listLec.size();
    }

    @Override
    public BsLec getItem(int posicion) {
        return this.listLec.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return this.listLec.get(posicion).getNlec();
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        ContenedorItem contenedorItem;
        View vItem = view;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            vItem = inflater.inflate(R.layout.itemmedidor,null);
            contenedorItem = new ContenedorItem();
            contenedorItem.tvImNombreSocio = (TextView) vItem.findViewById(R.id.tvImNombreSocio);
            contenedorItem.tvNtcn = (TextView) vItem.findViewById(R.id.tvNtcn );
            contenedorItem.tvCodf = (TextView) vItem.findViewById(R.id.tvCodf );
            vItem.setTag(contenedorItem);
        } else {
            contenedorItem = (ContenedorItem) vItem.getTag();
        }

        BsLec itemLecturacion = this.listLec.get(posicion);

        contenedorItem.tvNtcn.setText(itemLecturacion.getNcnt() + "");
        contenedorItem.tvImNombreSocio.setText(itemLecturacion.getdNom());
        contenedorItem.tvCodf.setText(itemLecturacion.getCodf()+"");

        return vItem;
    }

    static class ContenedorItem {
        public TextView  tvCodf, tvImNombreSocio, tvNtcn;
    }
}
