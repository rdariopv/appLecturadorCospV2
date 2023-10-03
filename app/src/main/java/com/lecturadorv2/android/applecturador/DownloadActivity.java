package com.lecturadorv2.android.applecturador;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.support.design.widget.TextInputLayout;
//import android.support.v7.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.lecturadorv2.android.comunicacion.SyncBsHpw;
import com.lecturadorv2.android.comunicacion.SyncBsLec;
import com.lecturadorv2.android.dblecturador.BsEnw;
import com.lecturadorv2.android.dblecturador.LtZon;

import java.util.LinkedList;

public class DownloadActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();
        inicializarVar();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
       // client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // <editor-fold defaultstate="collapsed" desc="Codigo Adicionado">
    private TextInputLayout tilAnio;
    private TextInputLayout tilMes;
    private TextView tvMesf;
    private Spinner spZona;
    // ProgressDialog pd ;


    private Button btnSincronizar;
    private AdpZonas adpZonas;

    private int posMes;
    private int posZona;

    public void inicializarVar() {
        tilAnio = (TextInputLayout) findViewById(R.id.tilAnio);
        tilMes = (TextInputLayout) findViewById(R.id.tilMes);
        tvMesf = (TextView) findViewById(R.id.tvMesf);
        spZona = (Spinner) findViewById(R.id.spinner);
        BsEnw enw = new BsEnw();
        enw.ObtenerBsEnw();
        //pd= new ProgressDialog(DownloadActivity.this);

        // bspMeses.setText(mesActual.getMes());
        tilAnio.getEditText().setText(enw.getAnio() + "");
        tilMes.getEditText().setText(enw.getDmes());
        tvMesf.setText(enw.getMesf() + "");


        LtZon zon = new LtZon();
        LinkedList<LtZon> listZonas = zon.listarLtZon();

        adpZonas = new AdpZonas(DownloadActivity.this, listZonas);
        spZona.setAdapter(adpZonas);


        btnSincronizar = (Button) findViewById(R.id.btnSincronizar);

        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sincronizarDatosAvisosCobranza();
            }
        });
    }

    String[] parametros = new String[10];

    public void sincronizarDatosAvisosCobranza() {
        String anio = this.tilAnio.getEditText().getText().toString();

        BsEnw enw = new BsEnw();
        enw.ObtenerBsEnw();
        String mes = enw.getMesf() + "";
        LtZon zonaActual = (LtZon) this.spZona.getSelectedItem();

        String zona = zonaActual.getNzon() + "";
        String rango = zonaActual.getRngo() + "";


        Log.e(this.getClass().getName(), "Zona seleccionada = " + zonaActual.toString1());

        this.parametros[0] = anio;
        this.parametros[1] = mes;
        this.parametros[2] = zona;
        this.parametros[3] = rango;

        int nVeces = Math.round(zonaActual.getCreD() / zonaActual.getRngo());

        for (int i = 0; i <= nVeces; i++) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    new SyncDetallesAvisos().execute(parametros);

                }
            });

        }


    }


    public class SyncHeaderAvisos extends AsyncTask<String, Integer, Boolean> {
        ProgressDialog pd = new ProgressDialog(DownloadActivity.this);

        @Override
        protected void onPreExecute() {
            //pd = new ProgressDialog(getBaseContext());
            // pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.setTitle("Sincronizando");
            pd.setMessage("Header Aviso de Cobranza");
            // pd.setProgress(0);
            pd.setIndeterminate(false);
            pd.show();


            // super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            int anio = Integer.valueOf(params[0]);
            int mes = Integer.valueOf(params[1]);
            int zona = Integer.valueOf(params[2]);
            int rango = Integer.valueOf(params[3]);
            SyncBsHpw syncHpw = new SyncBsHpw();

            //syncHpw.SyncObtenerHeaderAvisos(anio, mes, zona, rango);

            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            pd.dismiss();
            // super.onPostExecute(aBoolean);
        }

        @Override
        protected void onCancelled() {
            //  super.onCancelled();
            //  pd.dismiss();
        }
    }

    public class SyncDetallesAvisos extends AsyncTask<String, Integer, Boolean> {

        ProgressDialog pd = new ProgressDialog(DownloadActivity.this);

        @Override
        protected void onPreExecute() {
            // pd = new ProgressDialog(getBaseContext());
            // pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

             pd.setTitle("Sincronizando");
             pd.setMessage("Detalles Aviso de Cobranza");
            // pd.setProgress(0);
            pd.setIndeterminate(false);
            pd.show();
            // cambiarMensajePD("Sincronizando","Detalles Aviso de Cobranza");
           // mostrarProgresDialog();
            // super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            int anio = Integer.valueOf(params[0]);
            int mes = Integer.valueOf(params[1]);
            int zona = Integer.valueOf(params[2]);
            int rango = Integer.valueOf(params[3]);
            SyncBsLec syncLec = new SyncBsLec();

            syncLec.SyncObtenerHeaderAvisos(anio, mes, zona, rango);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            //   super.onPostExecute(aBoolean);
            pd.dismiss();
          //  new SyncHeaderAvisos().execute(parametros);

        }

        @Override
        protected void onCancelled() {
            //  super.onCancelled();
            //  pd.dismiss();
            //  new SyncHeaderAvisos().execute(parametros);
        }
    }


    // </editor-fold>


}
