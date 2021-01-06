package com.lecturador.android.applecturador;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.lecturador.android.dblecturador.BsHpw;
import com.lecturador.android.dblecturador.LtZon;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/5/2017.
 */
public class AdpZonas extends BaseAdapter implements Filterable {
    private Context mContext;
    private  LinkedList<LtZon> listZonas;

    public AdpZonas(Context mContext, LinkedList<LtZon> listZonas) {
        this.mContext = mContext;
        this.listZonas = listZonas;
    }

    @Override
    public int getCount() {
        return this.listZonas.size();
    }

    @Override
    public Object getItem(int posicion) {
        return  this.listZonas.get(posicion) ;
    }

    @Override
    public long getItemId(int posicion) {
        return  (long)this.listZonas.get(posicion).getNzon();
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        ContenedorItem contenedorItem;
        View vItem = view;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            vItem = inflater.inflate(R.layout.itemzona,null);
            contenedorItem = new ContenedorItem();
            contenedorItem.txtZona = (TextView) vItem.findViewById(R.id.txtZona);

            vItem.setTag(contenedorItem);
        } else {
            contenedorItem = (ContenedorItem) vItem.getTag();
        }

        LtZon itemZona = this.listZonas.get(posicion);

        contenedorItem.txtZona.setText(itemZona.getDzon() + "");


        return vItem;
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                if (constraint == null || constraint.length() == 0) {
                    //no constraint given, just return all the data. (no search)
                    results.count = listZonas.size();
                    results.values = listZonas;
                } else {//do the search
                    List<String> resultsData = new LinkedList<>();
                    String searchStr = constraint.toString().toUpperCase();
                    for (LtZon s : listZonas)
                        if (s.getDzon().toUpperCase().contains(searchStr)) resultsData.add(s.getDzon());
                    results.count = resultsData.size();
                    results.values = resultsData;
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listZonas = (LinkedList<LtZon>) results.values;
                notifyDataSetChanged();
            }
        };
    }



    static class ContenedorItem {
        public TextView txtZona;
    }
}
