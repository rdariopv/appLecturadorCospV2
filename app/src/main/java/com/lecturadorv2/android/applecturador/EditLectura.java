package com.lecturadorv2.android.applecturador;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
//import android.support.design.widget.Snackbar;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.ui.AppBarConfiguration;

import com.lecturadorv2.android.applecturador.databinding.ActivityEditlecturaBinding;
import com.lecturadorv2.android.dblecturador.BsDhw;

import com.lecturadorv2.android.comunicacion.SyncBsDhw;
import com.lecturadorv2.android.comunicacion.SyncBsDpw;
import com.lecturadorv2.android.comunicacion.SyncBsHpw;
import com.lecturadorv2.android.comunicacion.SyncBsLec;
import com.lecturadorv2.android.dblecturador.BsDpw;
import com.lecturadorv2.android.dblecturador.BsEnw;
import com.lecturadorv2.android.dblecturador.BsHpw;
import com.lecturadorv2.android.dblecturador.BsLec;
import com.lecturadorv2.android.dblecturador.BsObw;
import com.lecturadorv2.android.dblecturador.LtCnf;
import com.lecturadorv2.android.zebra.BluetoothDeviceArrayAdapter;
import com.lecturadorv2.android.zebra.MyZebra;
import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.PrinterStatus;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.LinkedList;

public class EditLectura extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityEditlecturaBinding binding;

    private BluetoothDeviceArrayAdapter adpPrinters;
    /* access modifiers changed from: private */
    public String bluetoothAddress;
    private Button btnSendLecturacion;
    private Button btnSendReprint;
    /* access modifiers changed from: private */
    public LtCnf config;
    private boolean consumoElevado;
    private boolean consumoNegativo;
    private EditText etLectura;
    private EditText etNombreSocioLect;
    /* access modifiers changed from: private */
    public BsHpw loitemLect;
    /* access modifiers changed from: private */
    public BsLec loitemLecturacion;
    ZebraPrinter printer = null;
    private boolean reprint;
    private Spinner spObsE;
    private Switch swNmed;
    private TextView tvAlert;
    private TextView tvConP;
    private TextView tvDCodf;
    private TextView tvDataConsumo;
    private TextView tvDescCodigo;
    private TextView tvNombreS;
    private TextView tvNume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editlectura);
        // binding = ActivityEditlecturaBinding.inflate(getLayoutInflater());
        // setContentView(binding.getRoot());

        // setSupportActionBar(binding.toolbar);

        // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_edit_lectura);
        // appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //  binding.fab.setOnClickListener(new View.OnClickListener() {
        //      @Override
        //      public void onClick(View view) {
        //          Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                  .setAction("Action", null).show();
        //      }
        //  });
        inicializarVariables();
    }

    //@Override
    //public boolean onSupportNavigateUp() {
    //    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_edit_lectura);
    //    return NavigationUI.navigateUp(navController, appBarConfiguration)
    //            || super.onSupportNavigateUp();
    //}


    public void inicializarVariables() {
        this.tvDescCodigo = (TextView) findViewById(R.id.tvDescCodigoE);
        this.tvNombreS = (TextView) findViewById(R.id.tvNombreSE);
        this.tvConP = (TextView) findViewById(R.id.tvConE);
        this.etLectura = (EditText) findViewById(R.id.etLecturaE);
        this.tvNume = (TextView) findViewById(R.id.tvNumeE);
        this.tvDataConsumo = (TextView) findViewById(R.id.tvDataConsumoE);
        this.btnSendReprint = (Button) findViewById(R.id.btnSendReprint);
        this.btnSendLecturacion = (Button) findViewById(R.id.btnSendReprint);
        this.swNmed = (Switch) findViewById(R.id.swNmedE);
        this.tvAlert = (TextView) findViewById(R.id.tvAlertE);
        this.tvDCodf = (TextView) findViewById(R.id.tvDCodfE);
        LinkedList<BsObw> listObw = new BsObw().listarBsObw();
        LtCnf ltCnf = new LtCnf();

        this.config = ltCnf;
        ltCnf.obtenerCnf(1);
        AdpObw adpObw = new AdpObw(this, listObw);
        LtCnf ltCnf2 = new LtCnf();
        this.config = ltCnf2;
        ltCnf2.obtenerCnf(1);
        this.loitemLecturacion = (BsLec) getIntent().getExtras().getSerializable("item");






        this.spObsE = (Spinner) findViewById(R.id.spObsE);
       int indexCobs= adpObw.getIndexbyId(this.loitemLecturacion.getCobs());

        this.spObsE.setAdapter(adpObw);
        if(indexCobs<0){
            this.spObsE.setSelection(0);
        }else{
            this.spObsE.setSelection(indexCobs);
        }




        this.tvDescCodigo.setText(this.loitemLecturacion.getCodf() + "");
        new BsEnw().ObtenerBsEnw();
        if (this.loitemLecturacion.getMedi() == 0) {
            this.swNmed.setChecked(false);
        } else {
            this.swNmed.setChecked(true);
            this.tvNume.setText(this.loitemLecturacion.getNume().trim());
        }
        this.swNmed.setEnabled(false);
        this.loitemLect = new BsHpw();
        this.loitemLect.obtenerBsHpwbyNcnt(this.loitemLecturacion.getNcnt());

        this.tvNombreS.setText(this.loitemLecturacion.getdNom());
        this.tvAlert.setText("");

        this.tvDCodf.setText(this.loitemLecturacion.getNcnt() + "");
        this.etLectura.setText(this.loitemLecturacion.getLact() + "");
        this.etLectura.setEnabled(true);
        this.tvDataConsumo.setText((this.loitemLecturacion.getLact() - this.loitemLecturacion.getLant()) + "");
        if (this.loitemLecturacion.getCobs() != 0) {
           // this.etLectura.setEnabled(false);
           // this.spObsE.setEnabled(false);  // se comenta a pedido de la ingeniera fecha 15/mayo/2024
        }
        this.etLectura.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    EditLectura.this.calcularConsumo();
                }
            }
        });
        this.btnSendReprint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                registrarLecturacion();
               // EditLectura.this.imprimirLecturacion();
                //if (EditLectura.this.loitemLecturacion.getCobs() != 0) {} else {}
            }
        });
    }

    public void imprimirLecturacion() {
        if (this.config.isPrintOnline()) {
            try {
                Toast.makeText(getApplicationContext(), "EN PROCESO DE IMPRESION", Toast.LENGTH_LONG).show();
                new enviarImprimir().execute(new String[0]);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "HABILITAR IMPRESION EN AJUSTES", Toast.LENGTH_LONG).show();
        }
    }

    public int calcularConsumo() {
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

    public void registrarLecturacion() {
        this.loitemLecturacion.setCobs(((BsObw) this.spObsE.getAdapter().getItem(this.spObsE.getSelectedItemPosition())).getCodo());
        this.loitemLecturacion.guardarObservacion();
        int poscision = this.spObsE.getSelectedItemPosition();
        String lsLectura = this.etLectura.getText().toString().trim();
        if (this.consumoElevado && poscision == 0) {
            Toast.makeText(getApplicationContext(), "Seleccione otra observación", Toast.LENGTH_LONG).show();
        } else if (this.consumoNegativo && poscision == 0) {
            Toast.makeText(getApplicationContext(), "Seleccione otra observación", Toast.LENGTH_LONG).show();
        } else if (!lsLectura.isEmpty()) {
            this.loitemLecturacion.setLact(Integer.parseInt(this.etLectura.getText().toString()));
            this.loitemLecturacion.guardarLact();
            if (this.config.isCnfOnly()) {
                try {
                    new sincronizarConsumo().execute();
                } catch (Exception e) {
                }
            }
            Toast.makeText(getApplicationContext(), "Registro Satisfactorio", Toast.LENGTH_LONG).show();
        } else {
            Snackbar.make(getWindow().getDecorView(), (CharSequence) "digite la Lectura",  Snackbar.LENGTH_LONG).show();
        }
    }

    public class sincronizarConsumo extends AsyncTask<String, Integer, Boolean> {

        /* renamed from: pd */
        ProgressDialog pd = new ProgressDialog(EditLectura.this);

        public sincronizarConsumo() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            pd.setTitle("Enviando Datos");
            pd.setMessage("enviando datos de lectura");
            pd.setIndeterminate(false);
            pd.show();
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strings) {
            try {
                new SyncBsLec().SyncEnviarLecturacion(EditLectura.this.loitemLecturacion.getNlec(), EditLectura.this.loitemLecturacion.getLact(), EditLectura.this.loitemLecturacion.getCobs(), new Date(), MenuPrincipal.gps.Latitud, MenuPrincipal.gps.Longitud.doubleValue(), 1, "appMovil");
               // return null;
            } catch (Exception e) {
              displayToast(e.getMessage());

            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean aBoolean) {

            new sincronizarHeaderAviso().execute();
            pd.dismiss();

        }



    }
    public class sincronizarHeaderAviso extends AsyncTask<String, Integer, Boolean> {

        /* renamed from: pd */
        ProgressDialog pd = new ProgressDialog(EditLectura.this);

        public sincronizarHeaderAviso() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            pd.setTitle("Enviando Datos");
            pd.setMessage("Descargando Header lectura");
            pd.setIndeterminate(false);
            pd.show();
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strings) {
            SyncBsHpw shpw = new SyncBsHpw();
            BsEnw enw= new BsEnw();
            enw.ObtenerBsEnw();
            loitemLecturacion.obtenerBsLec(loitemLecturacion.getNlec());
            if(loitemLecturacion.getRspO()==1){
                shpw.SyncObtenerHeaderAvisos(enw.getAnio(),enw.getMesf(),loitemLecturacion.getNcnt());
               int newNhpf= loitemLect.getMaxBshpw(loitemLecturacion.getNcnt());
                loitemLect.obtenerBsHpw(newNhpf);
            }else{
                pd.setMessage("sin Datos de impresion");
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean aBoolean) {
            pd.dismiss();
            //EditLectura.this.loitemLect.obtenerBsHpwbyNcnt(EditLectura.this.loitemLecturacion.getNcnt());
            BsDpw dpw = new BsDpw();

            this.pd.dismiss();
            if(loitemLecturacion.getRspO()==1){
                dpw.eliminarDetalle(loitemLect.getNhpf());
                new sincronizarDetalleAviso().execute();

            }else{
                Snackbar.make(EditLectura.this.getWindow().getDecorView(), (CharSequence) "sin Datos de impresion", Snackbar.LENGTH_LONG).show();
            }
           // LinkedList<BsDpw> listarDetalles = dpw.listarDetalles(EditLectura.this.loitemLect.getNhpf());
           // if (EditLectura.this.loitemLecturacion.getRspO() >= 1) {
           //     dpw.eliminarDetalle(EditLectura.this.loitemLect.getNhpf());
           //     new sincronizarDetalleAviso().execute(new String[0]);
           //     return;
           // }

        }

        /* access modifiers changed from: protected */
        public void onCancelled(Boolean aBoolean) {
        }
    }
    public class enviarImprimir extends AsyncTask<String, Integer, Boolean> {

        /* renamed from: pd */
        ProgressDialog pd = new ProgressDialog(EditLectura.this);
        private ZebraPrinter printer;

        public enviarImprimir() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.pd.setTitle("Imprimiendo");
            this.pd.setMessage("Enviando datos para imprimir");
            this.pd.setIndeterminate(false);
            this.pd.show();
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strings) {
            EditLectura editLectura = EditLectura.this;
            String unused = editLectura.bluetoothAddress = editLectura.config.getCnfIdpr();
            try {
                connectAndPrint(new BluetoothConnection(EditLectura.this.bluetoothAddress));
            } catch (Exception e) {
                displayToast(e.getMessage());
                this.pd.setMessage(e.getMessage());
            }
            return true;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean aBoolean) {
            this.pd.dismiss();
        }
    }
    private boolean isBluetoothPrinter(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice.getBluetoothClass().getMajorDeviceClass() == BluetoothClass.Device.Major.IMAGING
                || bluetoothDevice.getBluetoothClass().getMajorDeviceClass() == BluetoothClass.Device.Major.UNCATEGORIZED;
    }

    private boolean connectAndPrint(Connection conn) {
        boolean result = true;
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
            result=false;
            displayToast("ERROR: deshabilitado para conectar a la impresora");
            Log.e(this.getClass().getName(), "connectAndPrint:" + e.getMessage());
            //  stopSearching(null);
        }
        return  result;
    }

    private byte[] getConfigLabel(Connection conn) {
        byte[] configLabel = null;
        try {
            try {
                printer = ZebraPrinterFactory.getInstance(conn);
            } catch (ZebraPrinterLanguageUnknownException e) {
                displayToast("ERROR:: " + e.getMessage());
                Log.e(this.getClass().getName(), "error al obtener la instancia de la impresora e= " + e.getMessage());
                //Toast.makeText(this, "al crear el printer = ZebraPrinterFactory.getInstance(conn); sucede un ERROR " + e.toString(), Toast.LENGTH_SHORT).show();
            }
            PrinterLanguage printerLanguage = printer.getPrinterControlLanguage();
            SGD.SET("device.languages", "zpl", conn);
            LtCnf cnf= new LtCnf();
            boolean existe=  cnf.obtenerCnf(1);

            if(existe){
                if(printerLanguage == PrinterLanguage.ZPL){
                    if (cnf.getCnfNpri() == 0) {
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.printZPLHorizontalZQ520_Cospail_QR(loitemLecturacion);
                        configLabel = sb.toString().getBytes();
                    }
                    if (cnf.getCnfNpri() == 1) {
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.printZPLHorizontalZQ520_SinWebService(loitemLecturacion);
                        configLabel = sb.toString().getBytes();
                    }
                }

            }

        } catch (ConnectionException e) {
            displayToast("ERROR:: " + e.getMessage());
           // Toast.makeText(this, "aqui sucede un error " + e.toString(), Toast.LENGTH_SHORT).show();
        }
        return configLabel;
    }

    public void displayToast(final String message) {

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                Toast toast;
                toast = Toast.makeText(EditLectura.this, message, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            }
        });
    }
    private boolean findPrinterStatus(Connection conn) {
        try {
            PrinterStatus currentStatus = ZebraPrinterFactory.getInstance(conn).getCurrentStatus();
            boolean b1 = currentStatus.isHeadOpen;
            boolean b2 = currentStatus.isPaperOut;
            if (!b1 && !b2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e("Reimprimir", "findPrinterStatus:" + e.getMessage());
            displayToast(e.getMessage());
            return true;
        }
    }

    public class sincronizarDetalleAviso extends AsyncTask<String, Integer, Boolean> {

        /* renamed from: pd */
        ProgressDialog pd = new ProgressDialog(EditLectura.this);

        public sincronizarDetalleAviso() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.pd.setTitle("Enviando Datos");
            this.pd.setMessage("Descargando detalle de lectura");
            this.pd.setIndeterminate(false);
            this.pd.show();
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strings) {
            BsEnw enw = new BsEnw();
            enw.ObtenerBsEnw();
            BsDpw dpw= new BsDpw();
            SyncBsDpw sDpw=new SyncBsDpw();

            if(loitemLecturacion.getRspO()==1){
                dpw.eliminarDetalle(loitemLect.getNhpf());
                sDpw.SyncObtenerDetalleAvisos(enw.getAnio(), enw.getMesf(),loitemLecturacion.getNcnt());
                return null;
            }
           // dpw.eliminarDetalle(loitemLect.getNhpf());
            //new SyncBsDpw().SyncObtenerDetalleAvisos(enw.getAnio(), enw.getMesf(), EditLectura.this.loitemLecturacion.getNcnt());
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean aBoolean) {
            this.pd.dismiss();
            new BsEnw().ObtenerBsEnw();
            BsHpw hpw = new BsHpw();
            hpw.obtenerBsHpwbyNcnt(EditLectura.this.loitemLecturacion.getNcnt());
            LinkedList<BsDhw> listarBsDhw = new BsDhw().listarBsDhw(hpw.getNcnt());
            if (EditLectura.this.loitemLecturacion.getRspO() >= 1) {
                new sincronizarHistoricoAviso().execute();
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled(Boolean aBoolean) {
        }
    }

    public class sincronizarHistoricoAviso extends AsyncTask<String, Integer, Boolean> {

        /* renamed from: pd */
        ProgressDialog pd = new ProgressDialog(EditLectura.this);

        public sincronizarHistoricoAviso() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.pd.setTitle("Enviando Datos");
            this.pd.setMessage("Descargando Historico de lectura");
            this.pd.setIndeterminate(false);
            this.pd.show();
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strings) {
            SyncBsDhw sdhw = new SyncBsDhw();
            BsEnw enw = new BsEnw();
            enw.ObtenerBsEnw();

            new BsDhw().eliminarHistorico(loitemLecturacion.getNcnt());
            sdhw.SyncObtenerHistoricoAvisos(enw.getAnio(), enw.getMesf(), loitemLecturacion.getNcnt());
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean aBoolean) {
            this.pd.dismiss();
            MyZebra mizebra= new MyZebra();
            mizebra.escribirAviso(loitemLecturacion);
            if (EditLectura.this.config.isPrintOnline()) {
                try {
                    Toast.makeText(EditLectura.this.getApplicationContext(), "EN PROCESO DE IMPRESION", Toast.LENGTH_LONG).show();
                    new enviarImprimir().execute();
                } catch (Exception e) {
                    Toast.makeText(EditLectura.this.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled(Boolean aBoolean) {
        }
    }



}

