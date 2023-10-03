package com.lecturadorv2.android.applecturador;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.support.v4.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lecturadorv2.android.comunicacion.SyncBsEnw;
import com.lecturadorv2.android.comunicacion.SyncBsObw;
import com.lecturadorv2.android.comunicacion.SyncBsTaw;
import com.lecturadorv2.android.comunicacion.SyncLtZon;
import com.lecturadorv2.android.dblecturador.BsEnw;
import com.lecturadorv2.android.dblecturador.DBmanager;
import com.lecturadorv2.android.dblecturador.LtCnf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        inicializarVariables();
    }


 // @Override
 // public boolean onCreateOptionsMenu(Menu menu) {
 //     // Inflate the menu; this adds items to the action bar if it is present.
 //     getMenuInflater().inflate(R.menu.menu_mprincipal, menu);
 //     return true;
 // }

   // @Override
   //public boolean onOptionsItemSelected(MenuItem item) {
   //    // Handle action bar item clicks here. The action bar will
   //    // automatically handle clicks on the Home/Up button, so long
   //    // as you specify a parent activity in AndroidManifest.xml.
   //    int id = item.getItemId();
   //    //noinspection SimplifiableIfStatement
   //    if (id == R.id.action_settings) {
   //        return true;
   //    }
   //    return super.onOptionsItemSelected(item);
   //}

    private Button btnLecturar;
    private Button btnSyncAC;
    private Button btnAjustes;
    ProgressDialog pd;
    public static MyGps gps;
    public LtCnf miCnf;

    private static final String[] REQUIRED_SDK_PERMISSIONS = new String[] {

            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.BLUETOOTH_ADMIN,
            Manifest.permission.BLUETOOTH,
            Manifest.permission.SYSTEM_ALERT_WINDOW,
            Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS};
    public static final int REQUEST_CODE_ASK_PERMISSIONS=1;
    public void inicializarVariables() {
        //----------------------------------------------------------------------------------------

        final List<String> missingPermissions = new ArrayList<>();
        for (final String permission : REQUIRED_SDK_PERMISSIONS) {
            final int result = ContextCompat.checkSelfPermission(this, permission);
            if (result != PackageManager.PERMISSION_GRANTED) {
                missingPermissions.add(permission);
            }
        }
        if (!missingPermissions.isEmpty()) {
// request all missing permissions
            final String[] permissions = missingPermissions
                    .toArray(new String[missingPermissions.size()]);
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_ASK_PERMISSIONS);
        } else {
            final int[] grantResults = new int[REQUIRED_SDK_PERMISSIONS.length];
            Arrays.fill(grantResults, PackageManager.PERMISSION_GRANTED);
            onRequestPermissionsResult(REQUEST_CODE_ASK_PERMISSIONS, REQUIRED_SDK_PERMISSIONS,
                    grantResults);
        }

        //----------------------------------------------------------------------------------------





        DBmanager.CrearBD(this);
        btnSyncAC = (Button) findViewById(R.id.btnSyncAC);
        btnLecturar = (Button) findViewById(R.id.btnLecturar);
        btnAjustes = (Button) findViewById(R.id.btnAjustes);
        miCnf= new LtCnf();
       boolean isCnf=miCnf.obtenerCnf(1);
        if( !isCnf){
             miCnf.registrar(1, "http://190.186.159.123/wsLectura/wsBS.asmx", 0, 0, true,0,"");
            miCnf.obtenerCnf(1);
        }



        btnSyncAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarSincronizacion();

            }
        });


        btnLecturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("MenuPrincipal::se ejecuto el onclik de lecturar ");
                listarMedidores();
            }
        });
        // MyGps gps= new MyGps(getApplicationContext());
        //gps.verificarGpsActivo();
        //   this.miCnf= new LtCnf();
          boolean lbCnf=this.miCnf.obtenerCnf(1);
          if(!lbCnf){
              Toast.makeText(this,"No se puede obtener Ajustes",Toast.LENGTH_LONG).show();
              return;
          }
        gps= new MyGps(getBaseContext());
          if(miCnf.isCnfGpsA()){

              gps.verificarGpsActivo();
          }


        btnAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarAjustes();
            }
        });


        pd = new ProgressDialog(MenuPrincipal.this);
    }

    public void listarMedidores() {
         if(this.miCnf.isCnfGpsA()){
             gps.iniciarGPS();
         }
        Intent intent = new Intent(this, ListaMedidores.class);
        startActivity(intent);
    }

    public void lanzarAjustes() {
        Intent intent = new Intent(this, AjustesActivity.class);
        // intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    public void lanzarSincronizacion() {
        // Intent intent = new Intent(this, DownloadActivity.class);
        // startActivity(intent);
        Intent intent = new Intent(this, SyncActivity.class);
        startActivity(intent);

    }


    public void lanzarDownloadParametros() {
        new DownloadDataEmpresa().execute();
    }

    public class DownloadDataEmpresa extends AsyncTask<String, Integer, Boolean> {

        ProgressDialog pd = new ProgressDialog(MenuPrincipal.this);

        @Override
        protected void onPreExecute() {
            pd.setTitle("Sincronizando");
            pd.setMessage("DATOS DE EMPRESA");
            pd.setIndeterminate(false);
            pd.show();

            // super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {

            SyncBsEnw syncBsEnw = new SyncBsEnw();
            syncBsEnw.SyncObtenerDatosEmpresa();


            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            pd.dismiss();
            BsEnw enw = new BsEnw();
            enw.ObtenerBsEnw();
            String anio = enw.getAnio() + "";
            String mes = enw.getMesf() + "";
            String[] parametros = {anio, mes};

            new DownloadZonas().execute(parametros);
            // super.onPostExecute(aBoolean);
        }

        @Override
        protected void onCancelled() {
            //  super.onCancelled();
        }
    }

    public class DownloadZonas extends AsyncTask<String, Integer, Boolean> {

        ProgressDialog pd = new ProgressDialog(MenuPrincipal.this);

        @Override
        protected void onPreExecute() {
            pd.setTitle("Sincronizando");
            pd.setMessage("ZONAS");
            pd.setIndeterminate(false);
            pd.show();


            // super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            int anio = Integer.valueOf(params[0]);
            int mes = Integer.valueOf(params[1]);
            SyncLtZon syncLtZon = new SyncLtZon();
            syncLtZon.SyncObtenerZonas(anio, mes);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            pd.dismiss();
            BsEnw enw = new BsEnw();
            enw.ObtenerBsEnw();
            String anio = enw.getAnio() + "";
            String mes = enw.getMesf() + "";
            String[] parametros = {anio, mes};
            new DownloadTarifa().execute(parametros);
            // super.onPostExecute(aBoolean);
        }

        @Override
        protected void onCancelled() {
            //  super.onCancelled();
            //  pd.dismiss();
        }
    }

    public class DownloadTarifa extends AsyncTask<String, Integer, Boolean> {

        ProgressDialog pd = new ProgressDialog(MenuPrincipal.this);

        @Override
        protected void onPreExecute() {
            pd.setTitle("Sincronizando");
            pd.setMessage("TARIFAS");
            pd.setIndeterminate(false);
            pd.show();

            // super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            int anio = Integer.valueOf(params[0]);
            int mes = Integer.valueOf(params[1]);

            SyncBsTaw syncBsTaw = new SyncBsTaw();
            syncBsTaw.SyncObtenerTarifa(anio, mes);

            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            pd.dismiss();
            new DownloadObservaciones().execute();
            // super.onPostExecute(aBoolean);
        }

        @Override
        protected void onCancelled() {
            //  super.onCancelled();
        }
    }

    public class DownloadObservaciones extends AsyncTask<Boolean, Integer, Boolean> {

        ProgressDialog pd = new ProgressDialog(MenuPrincipal.this);

        @Override
        protected void onPreExecute() {
            pd.setTitle("Sincronizando");
            pd.setMessage("Observaciones");
            pd.setIndeterminate(false);
            pd.show();

            // super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Boolean... val) {
            SyncBsObw syncBsObw = new SyncBsObw();
            syncBsObw.SyncObtenerObservaciones();
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
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        Log.e("request code", "el request code ="+requestCode);
        DBmanager.CrearBD(this);
        Log.e("MenuPrincipal", "se lanzo el dialogo de permisos");
        //for(int index=0; index<=permissions.length - 1;index++){
           // if (grantResults[index] != PackageManager.PERMISSION_GRANTED) {
           //    if(permissions[index].trim()==Manifest.permission.WRITE_EXTERNAL_STORAGE){
//
           //     }
           //     if(permissions[index].trim()==Manifest.permission.ACCESS_FINE_LOCATION){
       //  //           //asi es como se inicia un servicio desde una actividad
////
           //    }
           //}
       // }

    }


}
