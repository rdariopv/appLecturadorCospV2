package com.lecturadorv2.android.applecturador;

import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.lecturadorv2.android.dblecturador.LtCnf;

public class AjustesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        inicializarVariables();
    }

    // <editor-fold defaultstate="collapsed" desc="Codigo Adicionado">
    private EditText etUrlFU;
    private Button btnAceptarFU;
    private Switch swOnlineFU;
    private Switch swPrint;
    private Switch swGpsA;
    private Spinner spPrinter;
    private EditText etIDprinter;
    public void inicializarVariables() {


        etUrlFU = (EditText) findViewById(R.id.etUrlFU);
        btnAceptarFU = (Button) findViewById(R.id.btnAceptarFU);
        swOnlineFU= (Switch) findViewById(R.id.swOnlineFU);
        swPrint= (Switch)findViewById(R.id.swPrint) ;
        swGpsA= (Switch)findViewById(R.id.swGpsA) ;
        spPrinter=(Spinner) findViewById(R.id.spPrinter);
        etIDprinter=(EditText)findViewById(R.id.etIdPrinter);


        String[] test=new String[]{"Horizontal ZQ520", "Horizontal ZQ520 SW"};
        ArrayAdapter<String> adpPrinter= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,test);
        spPrinter.setAdapter(adpPrinter);
        LtCnf cnf = new LtCnf();
        boolean existe = cnf.obtenerCnf(1);
        if (existe) {
            etUrlFU.setText(cnf.getCnfwUrl());
            swOnlineFU.setChecked(cnf.isCnfOnly());
            swPrint.setChecked(cnf.isPrintOnline());
            swGpsA.setChecked(cnf.isCnfGpsA());
            spPrinter.setSelection(cnf.getCnfNpri());
            etIDprinter.setText(cnf.getCnfIdpr().toString());
        }

       swGpsA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(b){
                   //activar gps
                   MenuPrincipal.gps.verificarGpsActivo();
               }
           }
       });

        btnAceptarFU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarCnf();
            }
        });

    }

    public void registrarCnf() {
        try {
            String url = etUrlFU.getText().toString();
            int online =  (swOnlineFU.isChecked()) ? 1 : 0;

            int printOnline =  (swPrint.isChecked()) ? 1 : 0;
            boolean GpsA = swGpsA.isChecked();

            if (url == "") {
                Toast.makeText(this, "Ingrese la URL del servicio WEB", Toast.LENGTH_SHORT).show();
            }
            String idPrinter = this.etIDprinter.getText().toString();
            int printer =spPrinter.getSelectedItemPosition();
            Log.e("AjustesACtivity","la impresora seleccionada es ="+printer);

            LtCnf cnf = new LtCnf();

            cnf.registrar(1, url,online,printOnline , GpsA, printer, idPrinter);
            Toast.makeText(this, "Se Registro AJUSTES Correctamente", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // </editor-fold>
}
