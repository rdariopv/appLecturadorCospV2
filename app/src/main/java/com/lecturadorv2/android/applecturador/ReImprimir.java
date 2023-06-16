package com.lecturadorv2.android.applecturador;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.lecturadorv2.android.dblecturador.BsHpw;
import com.lecturadorv2.android.dblecturador.LtCnf;
import com.lecturadorv2.android.zebra.BluetoothDeviceArrayAdapter;
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
import java.util.ArrayList;
import java.util.Set;

public class ReImprimir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reimprimir);
        iniciarlizarVariables();
    }


    private TextView tvDescCodigoP;
    private TextView tvNombreSP;
    private TextView tvDescPeriodoP;
    private EditText etLecturaP;
    private Button btnSendPrint;
    private BsHpw lHpwPrint;
    private LtCnf config;


    private Spinner spObsP;
   private Switch swNmedP;
    private TextView tvNumeP;

    public void iniciarlizarVariables() {
        tvDescCodigoP = (TextView) findViewById(R.id.tvDescCodigoP);
        tvNombreSP = (TextView) findViewById(R.id.tvNombreSP);
        tvDescPeriodoP = (TextView) findViewById(R.id.tvDescPeriodoP);
        etLecturaP = (EditText) findViewById(R.id.etLecturaP);

        swNmedP = (Switch) findViewById(R.id.swNmedP);
        tvNumeP= (TextView)findViewById(R.id.tvNumeP);
        btnSendPrint = (Button) findViewById(R.id.btnSendPrint);

        lHpwPrint = (BsHpw) getIntent().getExtras().getSerializable("item");
        etLecturaP.setText(lHpwPrint.getLact() + "");
        etLecturaP.setEnabled(false);
/*

        BsObw obw = new BsObw();
        LinkedList<BsObw> listObw = obw.listarBsObw();

        config = new LtCnf();
        config.obtenerCnf(1);

        AdpObw adpObw = new AdpObw(this, listObw);

        spObsP = (Spinner) findViewById(R.id.spObsP);
        spObsP.setAdapter(adpObw);
        spObsP.setSelection(lHpwPrint.getCobs());
        spObsP.setEnabled(false);

        tvDescCodigoP.setText(lHpwPrint.getCodf() + "");
        BsEnw enw = new BsEnw();
        enw.ObtenerBsEnw();
        tvDescPeriodoP.setText(enw.getAnio() + " - " + enw.getDmes());

        if(lHpwPrint.getNmed()==0){
            this.swNmedP.setChecked(false);
        }else{
            this.swNmedP.setChecked(true);
            this.tvNumeP.setText(lHpwPrint.getNume().trim());
        }
        this.swNmedP.setEnabled(false);


        //etLectura.setText(loitemLecturacion.getLact() + "");
        tvNombreSP.setText(lHpwPrint.getDnom());

        btnSendPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imprimirLecturacion();
            }
        });
*/
    }

    public void imprimirLecturacion() {

        if (config.isPrintOnline()) {
            new enviarImprimir().execute();
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

        } catch (Exception e) {
            displayToast("ERROR: Unable to connect to Printer");
          //  e.printStackTrace();
            //  stopSearching(null);
        }
    }

    private boolean findPrinterStatus(final Connection conn) {
        try {
            final PrinterStatus currentStatus = ZebraPrinterFactory.getInstance(conn).getCurrentStatus();
            Boolean b1= currentStatus.isHeadOpen;
            boolean b2=currentStatus.isPaperOut;
            if (b1) {
                //displayToast("ERROR: Printer Head is Open");
                return false;
            } else if (b2) {
              //  displayToast("ERROR: No Media Detected");
                return false;
            }
        } catch (Exception e) {
            Log.e("Reimprimir", "findPrinterStatus:"+e.getMessage());
            e.printStackTrace();
        }

        return true; // Returns if neither of the above error states is found
    }

    public void displayToast(final String message) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Toast toast;
                toast = Toast.makeText(getWindow().getContext(), message, Toast.LENGTH_LONG);

               // toast = Toast.makeText(ReImprimir.this, message, Toast.LENGTH_LONG);
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
        ProgressDialog pd = new ProgressDialog(getWindow().getContext());
        private ZebraPrinter printer;

        @Override
        protected void onPreExecute() {
            pd.setTitle("Imprimiendo");
            pd.setMessage("Enviando datos para imprimir");
            // pd.setProgress(0);
            pd.setIndeterminate(false);
            pd.show();
            // super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            bluetoothAddress = getPairedPrinters().get(0).getAddress();
            BluetoothConnection conn = new BluetoothConnection(bluetoothAddress);
            connectAndPrint(conn);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            pd.dismiss();
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
/*
                    if (cnf.getCnfNpri() == 1) {
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.printZPLVertical1(lHpwPrint);
                        configLabel = sb.toString().getBytes();
                    }
                    if (cnf.getCnfNpri() == 2) {
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.printZPLHorizontalZQ520(lHpwPrint);
                        configLabel = sb.toString().getBytes();
                    }
                    if (cnf.getCnfNpri() == 3) {
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.printZPLVertical2(lHpwPrint);
                        configLabel = sb.toString().getBytes();
                    }

                    if (cnf.getCnfNpri() == 4) {
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.printZPLHorizontalZQ320(lHpwPrint) ;
                        configLabel = sb.toString().getBytes();
                    }
                    //  StringBuilder sb = myZebra.printZPL(loitemLecturacion);

                    // configLabel = etToPrint.getText().toString().getBytes();
                } else if (printerLanguage == PrinterLanguage.CPCL) {
                    if(cnf.getCnfNpri()==0){
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.imprimirLaPortenha(lHpwPrint);
                        configLabel = sb.toString().getBytes();
                    }*/

                }
            }

        } catch (ConnectionException e) {
            Toast.makeText(this, "aqui sucede un error " + e.toString(), Toast.LENGTH_SHORT).show();
        }
        return configLabel;
    }


// endregion


}
