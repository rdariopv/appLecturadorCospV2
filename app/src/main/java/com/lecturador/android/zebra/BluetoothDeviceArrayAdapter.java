package com.lecturador.android.zebra;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lecturador.android.applecturador.R;

import java.util.ArrayList;

/**
 * Created by Dario Pardo on 5/30/2017.
 */
public class BluetoothDeviceArrayAdapter extends ArrayAdapter<BluetoothDevice> {
    private final Context context;
    private final ArrayList<BluetoothDevice> values;

    public BluetoothDeviceArrayAdapter(Context context, ArrayList<BluetoothDevice> values) {
        super(context, android.R.layout.simple_expandable_list_item_2, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(android.R.layout.simple_expandable_list_item_2,parent, false);
        TextView tvDeviceName = (TextView) rowView.findViewById(android.R.id.text1);
        tvDeviceName.setText(values.get(position).getName());
        TextView tvDeviceAddress = (TextView) rowView.findViewById(android.R.id.text2);
        tvDeviceAddress.setText(values.get(position).getAddress());
        return rowView;
    }


}
