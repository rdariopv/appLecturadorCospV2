package com.lecturador.android.applecturador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.lecturador.android.dblecturador.BsObw;
import com.lecturador.android.negocio.NMeses;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/24/2017.
 */
public class AdpObw extends BaseAdapter implements Filterable {

    private Context context;
    private LinkedList<BsObw> listObs;

    public AdpObw(Context context, LinkedList<BsObw> listObs) {
        this.context = context;
        this.listObs = listObs;
    }

    @Override
    public int getCount() {
        return listObs.size();
    }

    @Override
    public Object getItem(int posicion) {
        return this.listObs.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return this.listObs.get(posicion).getCodo();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ContenedorItem contenedorItem;
        View vItem = view;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            vItem = inflater.inflate(R.layout.itemobs,null);
            contenedorItem = new ContenedorItem();
            contenedorItem.txtObs = (TextView) vItem.findViewById(R.id.txtObs);

            vItem.setTag(contenedorItem);
        } else {
            contenedorItem = (ContenedorItem) vItem.getTag();
        }
      //  <Bsobwcodo>1</Bsobwcodo>
      //  <Bsobwdesc>Cons. Negativo</Bsobwdesc>
        BsObw obs = this.listObs.get(i);
        contenedorItem.txtObs.setText( " " + obs.getCodo() +" | "+ obs.getDesc().trim());

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
                    results.count = listObs.size();
                    results.values = listObs;
                } else {//do the search
                    List<String> resultsData = new LinkedList<>();
                    String searchStr = constraint.toString().toUpperCase();
                    for (BsObw s : listObs)
                        if (s.getDesc().toUpperCase().contains(searchStr)) resultsData.add(s.getDesc());
                    results.count = resultsData.size();
                    results.values = resultsData;
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listObs = (LinkedList<BsObw>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    static class ContenedorItem {
        public TextView txtObs;
    }
}
