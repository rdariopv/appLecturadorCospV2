package com.lecturador.android.applecturador;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.lecturador.android.dblecturador.LtZon;
import com.lecturador.android.negocio.NMeses;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/21/2017.
 */
public class AdpMes extends BaseAdapter implements Filterable {

    private Context mContext;
    private LinkedList<NMeses> listMeses;

    public AdpMes(Context mContext, LinkedList<NMeses> listMeses) {
        this.mContext = mContext;
        this.listMeses = listMeses;
    }

    @Override
    public int getCount() {
        return this.listMeses.size();
    }

    @Override
    public Object getItem(int i) {
        return this.listMeses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.listMeses.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ContenedorItem contenedorItem;
        View vItem = view;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            vItem = inflater.inflate(R.layout.itemmes,null);
            contenedorItem = new ContenedorItem();
            contenedorItem.txtMes = (TextView) vItem.findViewById(R.id.txtMes);

            vItem.setTag(contenedorItem);
        } else {
            contenedorItem = (ContenedorItem) vItem.getTag();
        }

        NMeses itemMes = this.listMeses.get(i);

        contenedorItem.txtMes.setText(itemMes.getMes() + "");
       // contenedorItem.txtItemZona.setGravity(Gravity.CENTER);
       // contenedorItem.txtItemZona.setIncludeFontPadding(false);
       // contenedorItem.txtItemZona.setPadding(1, 3, 1,3);

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
                    results.count = listMeses.size();
                    results.values = listMeses;
                } else {//do the search
                    List<String> resultsData = new LinkedList<>();
                    String searchStr = constraint.toString().toUpperCase();
                    for (NMeses s : listMeses)
                        if (s.getMes().toUpperCase().contains(searchStr)) resultsData.add(s.getMes());
                    results.count = resultsData.size();
                    results.values = resultsData;
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listMeses = (LinkedList<NMeses>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    static class ContenedorItem {
        public TextView txtMes;
    }
}
