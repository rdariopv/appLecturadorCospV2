package com.lecturadorv2.android.applecturador;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
//import android.support.design.widget.Snackbar;
import com.google.android.material.snackbar.Snackbar;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.lecturadorv2.android.comunicacion.SyncBsDhw;
import com.lecturadorv2.android.comunicacion.SyncBsDpw;
import com.lecturadorv2.android.comunicacion.SyncBsHpw;
import com.lecturadorv2.android.comunicacion.SyncBsLec;
import com.lecturadorv2.android.dblecturador.BsEnw;
import com.lecturadorv2.android.dblecturador.BsHpw;
import com.lecturadorv2.android.dblecturador.BsLec;
import com.lecturadorv2.android.dblecturador.BsObw;
import com.lecturadorv2.android.dblecturador.BsTaw;
import com.lecturadorv2.android.dblecturador.LtCnf;
import com.lecturadorv2.android.zebra.BluetoothDeviceArrayAdapter;
import com.lecturadorv2.android.zebra.MyZebra;
import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Set;


public class RealizarLecturacion extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizarlecturacion);
        inicializarVariables();

    }

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
    //    // Inflate the menu; this adds items to the action bar if it is present.
    //    getMenuInflater().inflate(R.menu.menu_realizarlecturacion, menu);
    //    return true;
    //}

    //@Override
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


    private TextView tvDescCodigo;
    private TextView tvNombreS;
    private TextView tvConP;
    private TextView tvDCodF;
    private EditText etLectura;
    private EditText etNombreSocioLect;
    private Button btnSendLecturacion;
    private BsLec loitemLecturacion;
    private BsHpw loitemLect;
    private LtCnf config;
    private boolean reprint;
    private Switch swNmed;
    private TextView tvNume;
    private TextView tvDataConsumo;
    private Button btnCalc;
    private boolean consumoElevado;
    private boolean consumoNegativo;
    private TextView tvAlert;


    private Spinner spObs;

    public void inicializarVariables() {
        tvDescCodigo = (TextView) findViewById(R.id.tvDescCodigo);
        tvNombreS = (TextView) findViewById(R.id.tvNombreS);
        tvConP = (TextView) findViewById(R.id.tvConP);
        etLectura = (EditText) findViewById(R.id.etLectura);
        tvNume= (TextView) findViewById(R.id.tvNume);
        tvDataConsumo = (TextView) findViewById(R.id.tvDataConsumo);
        btnCalc= (Button) findViewById(R.id.btnCalc);
        tvDCodF=(TextView)findViewById(R.id.tvDCodf);
        btnSendLecturacion = (Button) findViewById(R.id.btnSendLecturacion);
        swNmed=(Switch)findViewById(R.id.swNmed);
        this.tvAlert = (TextView) findViewById(R.id.tvAlert);
        BsObw obw = new BsObw();
        LinkedList<BsObw> listObw = obw.listarBsObw();
        config = new LtCnf();
        config.obtenerCnf(1);
        AdpObw adpObw = new AdpObw(this, listObw);
        spObs = (Spinner) findViewById(R.id.spObs);
        spObs.setAdapter(adpObw);
        this.spObs.setSelection(adpObw.getIndexbyId(1));
        // reprint = false;
        loitemLecturacion = (BsLec) getIntent().getExtras().getSerializable("item");
        // if (getIntent().getExtras().containsKey("reprint")) {
        //     reprint = (boolean) getIntent().getExtras().getSerializable("reprint");
        // }
        // if (reprint) {
        //     etLectura.setText(loitemLecturacion.getLact() + "");
        // }

        tvDescCodigo.setText(loitemLecturacion.getCodf() + "");
        tvDCodF.setText(loitemLecturacion.getNcnt()+"");
        BsEnw enw = new BsEnw();
        enw.ObtenerBsEnw();
        tvConP.setText(loitemLecturacion.getConp()+ "");

        if(loitemLecturacion.getMedi() ==0){
            this.swNmed.setChecked(false);
        }else{
            this.swNmed.setChecked(true);
            this.tvNume.setText(loitemLecturacion.getNume().trim());
        }
       this.swNmed.setEnabled(false);

        //etLectura.setText(loitemLecturacion.getLact() + "");
        tvNombreS.setText(loitemLecturacion.getdNom() );

        btnSendLecturacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarLecturacion();
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularConsumo();
            }
        });
    }

    private void registrarLecturacion() {

        BsObw obs = (BsObw) spObs.getAdapter().getItem(spObs.getSelectedItemPosition());
        int cobs = obs.getCodo();
        loitemLecturacion.setCobs(cobs);
        loitemLecturacion.guardarObservacion();

        int poscision = this.spObs.getSelectedItemPosition();
        String lsLectura = this.etLectura.getText().toString().trim();

        if(this.consumoElevado && poscision==0 ){
            Toast.makeText(getApplicationContext(), "Seleccione otra observación", Toast.LENGTH_LONG).show();
        }
        if(this.consumoNegativo && poscision==0){
            Toast.makeText(getApplicationContext(), "Seleccione otra observación", Toast.LENGTH_LONG).show();
        }
        if(!lsLectura.isEmpty()){
                loitemLecturacion.setLact(Integer.parseInt( etLectura.getText().toString())) ;
                loitemLecturacion.guardarLact();
                if (config.isCnfOnly()) {
                    try{

                        new sincronizarConsumo().execute();
                    }catch (Exception e){
                    }
                    Toast.makeText(getApplicationContext(),"Registro Satisfactorio", Toast.LENGTH_LONG).show();
                }
        }else{
            Snackbar.make(getWindow().getDecorView(), (CharSequence) "digite la Lectura", Snackbar.LENGTH_LONG).show();
        }
       // if (config.isPrintOnline()) {
       //    try{
       //         Toast.makeText(getApplicationContext(),"EN PROCESO DE IMPRESION", Toast.LENGTH_LONG).show();
       //         new enviarImprimir().execute();
       //     }catch (Exception e){
       //         //Toast.makeText(getApplicationContext(),"Verifique la impresora o dispositivos vinculados", Toast.LENGTH_LONG).show();
       //         Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
       //     }
       //
       // }

    }

    public void irSiguiente(View v) {
        this.loitemLecturacion = this.loitemLecturacion.listarNoLecturadosBsLec().getFirst();
        TextView textView = this.tvDescCodigo;
        textView.setText(this.loitemLecturacion.getCodf() + "");
        TextView textView2 = this.tvConP;
        textView2.setText(this.loitemLecturacion.getConp() + "");
        if (this.loitemLecturacion.getMedi() == 0) {
            this.swNmed.setChecked(false);
        } else {
            this.swNmed.setChecked(true);
            this.tvNume.setText(this.loitemLecturacion.getNume().trim());
        }
        this.swNmed.setEnabled(false);
        this.etLectura.setText("");
        this.tvNombreS.setText(this.loitemLecturacion.getdNom());
        this.tvAlert.setText("");

        this.tvDCodF.setText(this.loitemLecturacion.getNcnt() + "");
        this.tvDataConsumo.setText("");
        Toast.makeText(getApplicationContext(), "ir a siguiente", Toast.LENGTH_LONG).show();
        lanzarNuevoItem();
    }

    public void lanzarNuevoItem() {
        this.loitemLecturacion = this.loitemLecturacion.listarNoLecturadosBsLec().getFirst();
        finish();
        Intent intent = new Intent(this, RealizarLecturacion.class);
        intent.putExtra("item", this.loitemLecturacion);
        intent.setFlags(intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }


    public void escribirAviso() {
        StringBuilder sb = new StringBuilder();
        MyZebra myZebra = new MyZebra();
        sb.append(myZebra.printZPLHorizontalZQ520_Cospail(loitemLecturacion));
        try {
            String url = Environment.getExternalStorageDirectory().getAbsolutePath();
            File myFile = new File(url + "/avsCobranza" + loitemLecturacion.getNlec() + ".txt");
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(sb.toString());
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
            Log.e("ERRR", "Could not create file", e);
        }


    }

    public void listarMedidores() {
        finish();
        Intent intent = new Intent(this, ListaMedidores.class);
        startActivity(intent);
    }

    public int calcularConsumo() {

        //String lact = etLectura.getText().toString();
        //loitemLecturacion.setLact(Integer.parseInt(lact));
        //int  liConsumo= loitemLecturacion.getLact() - loitemLecturacion.getLant();
        //tvDataConsumo.setText(liConsumo + "");
//
        //return liConsumo;
        this.tvAlert.setText("");
        this.loitemLecturacion.setLact(Integer.parseInt(this.etLectura.getText().toString()));
        int liConsumo = this.loitemLecturacion.getLact() - this.loitemLecturacion.getLant();
        if (liConsumo >= 0) {
            if (liConsumo > this.loitemLecturacion.getConr()) {
                this.tvAlert.setText("CONSUMO ELEVADO ");
                this.consumoElevado = true;
            } else {
                this.consumoElevado = false;
            }
            this.consumoNegativo = false;
        } else {
            this.consumoElevado = false;
            this.consumoNegativo = true;
            this.tvAlert.setText("CONSUMO NEGATIVO");
        }
        TextView textView = this.tvDataConsumo;
        textView.setText(liConsumo + "");
        return liConsumo;


    }

    public void lanzarLecturacionBluetooth() {
        Intent intent = new Intent(this, LecturacionBluetooth.class);
        // startActivityForResult(intent, 1);
        //  startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("RealizarLecturacion", " se ejecuta onActivityResult  = ");
        if (requestCode == 1) {
            Log.e("RealizarLecturacion", " si el requestCode==1 ??   requestCode=" + requestCode);

            Log.e("RealizarLecturacion", " si el resultCode==RESULT_OK ??   resultCode=" + resultCode);
            if (resultCode == RESULT_OK) {
                String lsLectura = data.getStringExtra("ldLectura");
                Log.e("RealizarLecturacion", " onActivityResult  con el valor = " + lsLectura);
                if (lsLectura != "" && lsLectura != null) {
                    // int liLectuta= Integer.valueOf(lsLectura);
                    // this.loitemLecturacion.getMiLecturacion().setLectura(liLectuta);
                    // this.loitemLecturacion.getMiLecturacion().setIdtipo(125);
                    // this.etLectura.setText(lsLectura);
                }
            }
        } else {
            Log.e("RealizarLecturacion", " si el requestCode==1 ??   requestCode=" + requestCode);

        }
    }

    //region para IMPRESORA
    private BluetoothDeviceArrayAdapter adpPrinters;
    private String bluetoothAddress;


    private boolean isBluetoothPrinter(BluetoothDevice bluetoothDevice) {

        return bluetoothDevice.getBluetoothClass().getMajorDeviceClass() == BluetoothClass.Device.Major.IMAGING
                || bluetoothDevice.getBluetoothClass().getMajorDeviceClass() == BluetoothClass.Device.Major.UNCATEGORIZED;
    }

    private ArrayList<BluetoothDevice> getPairedPrinters() {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        ArrayList<BluetoothDevice> pairedDevicesList = new ArrayList<BluetoothDevice>();
        for (BluetoothDevice device : pairedDevices) {
            if (isBluetoothPrinter(device))
                pairedDevicesList.add(device);
        }
        return pairedDevicesList;
    }

    private void connectAndPrint(Connection conn) {
        try {
           // if(conn.isConnected()){
                conn.open();
                String printerName = SGD.GET("device.unique_id", conn);
                if (findPrinterStatus(conn)) {
                    byte[] configLabel = getConfigLabel(conn);
                    //connection.write(configLabel);
                    ByteArrayInputStream bis = new ByteArrayInputStream(configLabel);

                    conn.write(bis);
                    //ZebraPrinterFactory.getInstance(conn).printConfigurationLabel();
                    //   stopSearching(printerName);
                }
                // Thread.sleep(500);
                conn.close();
           // }
           // else{
           //     Snackbar.make(this.getWindow().getDecorView(),"No es posible conectarse con la impresora", Snackbar.LENGTH_LONG).show();
           // }


        } catch (Exception e) {
            displayToast("ERROR: Unable to connect to Printer");
            e.printStackTrace();
            //  stopSearching(null);
        }
    }

    private boolean findPrinterStatus(final Connection conn) {
        try {
            if (ZebraPrinterFactory.getInstance(conn).getCurrentStatus().isHeadOpen) {
                displayToast("ERROR: Printer Head is Open");
                return false;
            } else if (ZebraPrinterFactory.getInstance(conn).getCurrentStatus().isPaperOut) {
                displayToast("ERROR: No Media Detected");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true; // Returns if neither of the above error states is found
    }

    public void displayToast(final String message) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Toast toast;
                toast = Toast.makeText(getApplication(), message, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            }
        }).start();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public class enviarImprimir extends AsyncTask<String, Integer, Boolean> {
        ProgressDialog pd = new ProgressDialog(RealizarLecturacion.this);
        private ZebraPrinter printer;

        @Override
        protected void onPreExecute() {
            pd.setTitle("Imprimiendo");
            pd.setMessage("Enviando datos para imprimir");
            // pd.setProgress(0);

            escribirAviso();
            pd.setIndeterminate(false);
            pd.show();
            // super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... strings) {

          //  bluetoothAddress = getPairedPrinters().get(0).getAddress();
           // BluetoothDevice bt= getPairedPrinters().get(0);
            bluetoothAddress= config.getCnfIdpr();

          try{
              BluetoothConnection conn = new BluetoothConnection(bluetoothAddress);
              connectAndPrint(conn);
          }catch (Exception e){
              pd.setMessage(e.getMessage());
          }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            pd.dismiss();
            lanzarNuevoItem();
            // super.onPostExecute(aBoolean);
        }
    }

    ZebraPrinter printer = null;

    private byte[] getConfigLabel(Connection conn) {
        byte[] configLabel = null;
        try {
            try {
                printer = ZebraPrinterFactory.getInstance(conn);
            } catch (ZebraPrinterLanguageUnknownException e) {
                Log.e(this.getClass().getName(), "error al obtener la instancia de la impresora e= " + e.getMessage());
                Toast.makeText(this, "al crear el printer = ZebraPrinterFactory.getInstance(conn); sucede un ERROR " + e.toString(), Toast.LENGTH_SHORT).show();
            }

            PrinterLanguage printerLanguage = printer.getPrinterControlLanguage();
            SGD.SET("device.languages", "zpl", conn);

            LtCnf cnf= new LtCnf();
          boolean existe=  cnf.obtenerCnf(1);
            if(existe){
                if (printerLanguage == PrinterLanguage.ZPL) {
                    // configLabel = "^XA^FO17,16^GB379,371,8^FS^FT65,255^A0N,135,134^FDZPL NO PROGRAMADO^FS^XZ".getBytes();
                    // configLabel = etToPrint.getText().toString().getBytes();

                    if (cnf.getCnfNpri() == 0) {
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.printZPLHorizontalZQ520_Cospail(loitemLecturacion);
                        configLabel = sb.toString().getBytes();
                    }
                   // if (cnf.getCnfNpri() == 2) {
                   //     MyZebra myZebra = new MyZebra();
                   //     StringBuilder sb = myZebra.printZPLHorizontalZQ520(loitemLect);
                   //     configLabel = sb.toString().getBytes();
                   // }
                   // if (cnf.getCnfNpri() == 3) {
                   //     MyZebra myZebra = new MyZebra();
                   //     StringBuilder sb = myZebra.printZPLVertical2(loitemLect);
                   //     configLabel = sb.toString().getBytes();
                   // }

                   // if (cnf.getCnfNpri() == 4) {
                   //     MyZebra myZebra = new MyZebra();
                   //     StringBuilder sb = myZebra.printZPLHorizontalZQ320(loitemLect) ;
                   //     configLabel = sb.toString().getBytes();
                   // }

                   // if (cnf.getCnfNpri() == 5) {
                   //     MyZebra myZebra = new MyZebra();
                   //     StringBuilder sb = myZebra.printZPLHorizontalZQ520_Cospail(loitemLecturacion) ;
                   //     configLabel = sb.toString().getBytes();
                   // }
                    //  StringBuilder sb = myZebra.printZPL(loitemLecturacion);


                } else if (printerLanguage == PrinterLanguage.CPCL) {
                    //  String cpclConfigLabel = "! 0 200 200 406 1\r\n" + "ON-FEED IGNORE\r\n" + "BOX 20 20 380 380 8\r\n" + "T 0 6 137 177 " + etToPrint.getText().toString() + "\r\n" + "PRINT\r\n";
                   // if(cnf.getCnfNpri()==0){
                   //     MyZebra myZebra = new MyZebra();
                   //     StringBuilder sb = myZebra.imprimirLaPortenha(loitemLect);
                   //     configLabel = sb.toString().getBytes();
                   // }

                }
            }

        } catch (ConnectionException e) {
            Toast.makeText(this, "aqui sucede un error " + e.toString(), Toast.LENGTH_SHORT).show();
        }
        return configLabel;
    }


// endregion

    //region Sinronizacion en linea
    public class sincronizarConsumo extends AsyncTask<String, Integer, Boolean> {
        ProgressDialog pd = new ProgressDialog(RealizarLecturacion.this);

        @Override
        protected void onPreExecute() {
    //        super.onPreExecute();
            pd.setTitle("Enviando Datos");
            pd.setMessage("enviando datos de lectura");
            pd.setIndeterminate(false);
            pd.show();
        }

        @Override
        protected Boolean doInBackground(String... strings) {

            SyncBsLec slec = new SyncBsLec();
            try{
                slec.SyncEnviarLecturacion(loitemLecturacion.getNlec(),loitemLecturacion.getLact(),loitemLecturacion.getCobs(),new Date(),MenuPrincipal.gps.Latitud,MenuPrincipal.gps.Longitud,1,"appMovil");
            } catch (Exception e) {
                displayToast(e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
//            super.onPostExecute(aBoolean);
            new sincronizarHeaderAviso().execute();
            //new sincronizarDetalleAviso().execute();
         //   new sincronizarHistoricoAviso().execute();

            pd.dismiss();


        }

        @Override
        protected void onCancelled(Boolean aBoolean) {
  //          super.onCancelled(aBoolean);
        }



        public class sincronizarHeaderAviso extends AsyncTask<String, Integer, Boolean> {
            ProgressDialog pd = new ProgressDialog(RealizarLecturacion.this);
            @Override
            protected void onPreExecute() {
                //        super.onPreExecute();
                this.pd.setTitle("Enviando Datos");
                this.pd.setMessage("Descargando Header lectura");
                this.pd.setIndeterminate(false);
                this.pd.show();
            }

            @Override
            protected Boolean doInBackground(String... strings) {
                SyncBsHpw shpw = new SyncBsHpw();
                BsEnw enw= new BsEnw();
                enw.ObtenerBsEnw();
                loitemLecturacion.obtenerBsLec(loitemLecturacion.getNlec());
                if(loitemLecturacion.getRspO()==1){
                    shpw.SyncObtenerHeaderAvisos(enw.getAnio(),enw.getMesf(),loitemLecturacion.getNcnt());

                }else{
                    this.pd.setMessage("sin Datos de impresion");
                }

                return null;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
//            super.onPostExecute(aBoolean);
                this.pd.dismiss();
                if(loitemLecturacion.getRspO()==1){
                    new sincronizarDetalleAviso().execute();
                }else{
                    RealizarLecturacion.this.displayToast("No exiten datos para impresion");
                    lanzarNuevoItem();
                }


            }

            @Override
            protected void onCancelled(Boolean aBoolean) {
                //          super.onCancelled(aBoolean);
            }

        }

        public class sincronizarDetalleAviso extends AsyncTask<String, Integer, Boolean> {
            ProgressDialog pd = new ProgressDialog(RealizarLecturacion.this);

            @Override
            protected void onPreExecute() {
                //        super.onPreExecute();
                this.pd.setTitle("Enviando Datos");
                this.pd.setMessage("Descargando Detalle lectura");
                this.pd.setIndeterminate(false);
                this.pd.show();
            }

            @Override
            protected Boolean doInBackground(String... strings) {

                BsEnw enw= new BsEnw();
                enw.ObtenerBsEnw();
                SyncBsDpw sDpw=new SyncBsDpw();
                if(loitemLecturacion.getRspO()==1){
                    sDpw.SyncObtenerDetalleAvisos(enw.getAnio(), enw.getMesf(),loitemLecturacion.getNcnt());
                    return null;
                }
                this.pd.setMessage("sin Datos de impresion");

                return null;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
//            super.onPostExecute(aBoolean);
                this.pd.dismiss();
                new sincronizarHistoricoAviso().execute();
            }

            @Override
            protected void onCancelled(Boolean aBoolean) {
                //          super.onCancelled(aBoolean);
            }

        }

        public class sincronizarHistoricoAviso extends AsyncTask<String, Integer, Boolean> {
            ProgressDialog pd = new ProgressDialog(RealizarLecturacion.this);
            @Override
            protected void onPreExecute() {
                //        super.onPreExecute();
                this.pd.setTitle("Enviando Datos");
                this.pd.setMessage("Descargando Historico de lectura");
                this.pd.setIndeterminate(false);
                this.pd.show();
            }

            @Override
            protected Boolean doInBackground(String... strings) {
                SyncBsDhw sdhw = new SyncBsDhw();
                BsEnw enw = new BsEnw();
                enw.ObtenerBsEnw();
                sdhw.SyncObtenerHistoricoAvisos(enw.getAnio(), enw.getMesf(), RealizarLecturacion.this.loitemLecturacion.getNcnt());

                return null;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
//            super.onPostExecute(aBoolean);
                this.pd.dismiss();
                escribirAviso();
                if (RealizarLecturacion.this.config.isPrintOnline()) {
                    try {
                        Toast.makeText(RealizarLecturacion.this.getApplicationContext(), "EN PROCESO DE IMPRESION", Toast.LENGTH_LONG).show();
                        new enviarImprimir().execute();
                    } catch (Exception e) {
                        Toast.makeText(RealizarLecturacion.this.getApplicationContext(), e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
                else{

                    lanzarNuevoItem();
                }


            }

            @Override
            protected void onCancelled(Boolean aBoolean) {
                //          super.onCancelled(aBoolean);
            }

        }
    }
    //endregion
}
