package com.lecturador.android.applecturador;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;


public class LecturacionBluetooth extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturacion_bluetooth);
        inicializarVariables();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lecturacion_bluetooth, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        // TODO:En caso de que el bluetooth no este activo, hacemos un Intent al sistema
        // para que nos lleve a la pantalla de activacion. Al volver de esta pantalla
        // ejecutara el metodo onActivityResult.

        if (!mBluetoothAdapter.isEnabled()) {
            Log.e(TAG, "Bluetooth apagado: Pedimos permiso para encenderlo.");
            startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), ENABLE_BLUETOOTH);
        } else {
            Log.e(TAG, "Bluetooth encendido.");
            buscarDispositivosBluetooth();
        }

        // TODO: Registramos el BroadcasReceiver
        if (this.discoveryMonitor != null) {
            registerReceiver(discoveryMonitor, new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_STARTED));
            registerReceiver(discoveryMonitor, new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED));
            registerReceiver(discoveryMonitor, new IntentFilter(BluetoothDevice.ACTION_FOUND));
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ENABLE_BLUETOOTH) {
            if (resultCode == RESULT_OK) {
                Log.e(TAG, "Bluetooth: el usuario acepta encenderlo");
                // Ejecutamos el metodo dicoveryBluetooth
                buscarDispositivosBluetooth();
            } else {
                Log.e(TAG, "Bluetooth: el usuario NO acepta encenderlo");
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (this.discoveryMonitor != null) {
            unregisterReceiver(discoveryMonitor);
        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        BluetoothDevice device = btDeviceList.get(position);
        Log.e(TAG, "Dispositivo seleccionado: " + device.getName());

        // Intentamos conectar con el dispositivo remoto.
        if (conectarToRemotoDevice(device)) {
            buttonToggle.setEnabled(true);
        }

    }

    private static final String TAG = "LecturacionBluetooth";
    private static final int ENABLE_BLUETOOTH = 1;

    private BluetoothAdapter mBluetoothAdapter; // variable para obtener el bluetooth del movil
    private ArrayList<BluetoothDevice> btDeviceList = new ArrayList<BluetoothDevice>(); // lista de moviles con blutu activado
    private BluetoothSocket clientSocket;    // cliente socket blutu
    private BroadcastReceiver discoveryMonitor;

    private ArrayAdapter<String> mArrayAdapter;
    private Button buttonToggle;
    private TextView tvLectura;
    private TextView tvValorLectura;

    public void inicializarVariables() {

        // TODO: Get Bluetooth Adapter.
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // TODO: Check smatphone support Bluetooth
        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth.
            Toast.makeText(getApplicationContext(), "Not support bluetooth", Toast.LENGTH_LONG).show();
            Log.e(TAG, "Not support Bluetooth");
            finish();
        }

        // Componentes de la interface grafica.
        mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        this.setListAdapter(mArrayAdapter);

        tvLectura = (TextView) findViewById(R.id.tvLectura);
        tvValorLectura = (TextView) findViewById(R.id.tvValorLectura);
        buttonToggle = (Button) findViewById(R.id.btnTomarLectura);
        buttonToggle.setOnClickListener(buttonToggleOnClickListener);

    }


    private View.OnClickListener buttonToggleOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            enviar();
            Log.e(TAG, " se LLAMA AL METODO esperarToRecibir()");
            esperarToRecibir();
            Log.e(TAG, " se TERMINO DE EJECUTAR EL  esperarToRecibir()");
        }
    };

    @Override
    public void onBackPressed() {

        this.mBluetoothAdapter.disable();
        Intent returnIntent = new Intent();
        String ldLectura = this.tvValorLectura.getText().toString();
        returnIntent.putExtra("ldLectura", ldLectura);
        setResult(RESULT_OK, returnIntent);
        Log.e(TAG, " se retorna atras con el valor = " + ldLectura);
        super.onBackPressed();
        finish();
    }

    // <editor-fold defaultstate="collapsed" desc=" Metodos para CONEXION BLUETOOTH " >


    // Metodo para buscar dispositibos bluetooth cercanos.
    // Este metodo es asincrono y devuelve los resultados mediante
    // un BroadcastReceiver.
    private void buscarDispositivosBluetooth() {

        // Limpiamos la lista de dispositivos detectados.
        mArrayAdapter.clear();
        btDeviceList.clear();

        // Aqui implementamos el BrodcastReceiver
        this.discoveryMonitor = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {

                // TODO: Acciones, al iniciar el dicovery, finalizar y cuando encuentra un dispositivo

                if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(intent.getAction())) {
                    Log.e(TAG, "Discovery started...");
                } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(intent.getAction())) {
                    Log.e(TAG, "Discovery complete.");
                } else if (BluetoothDevice.ACTION_FOUND.equals(intent.getAction())) {

                    // Añadimos el dispositivo encontrado al adaptador del ListView.
                    String remoteName = intent.getStringExtra(BluetoothDevice.EXTRA_NAME);
                    if(remoteName!=null)
                    {
                        mArrayAdapter.add(remoteName);
                        Log.e(TAG, "Dispositivo detectado :" + remoteName);

                        // Recuperamos el dispositivo detectado y lo guardamos en el array de dispositivos.
                        BluetoothDevice remoteDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                        btDeviceList.add(remoteDevice);
                    }

                }

            }
        };

        // TODO: Iniciamos la busqueda de dispositvos bluetooth.
        // Este metodo es muy lento y consumo mucha bateria
        // en otros capitulos veremos como usar otra tecnica.
        mBluetoothAdapter.startDiscovery();

    }


    private boolean conectarToRemotoDevice(BluetoothDevice device) {

        Log.e(TAG, "Connectando");
        boolean connect = false;
        try {

            // TODO: Conexion socket cliente.
            // String mmUUID = "00001101-0000-1000-8000-00805F9B34FB";

            String mmUUID = "00001101-0000-1000-8000-00805F9B34FB";
            this.clientSocket = device.createRfcommSocketToServiceRecord(UUID.fromString(mmUUID));
            clientSocket.connect();
            connect = true;

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            connect = false;
        }

        return connect;
    }


    public void enviar() {
        Log.v(TAG, "Enviando solicitud para obtener el marcador del MEDIDOR");

        // TODO: Enviando informacion del Movil hacia el Arduino.
        OutputStream mmOutStream = null;

        try {
            if (clientSocket.isConnected()) {
                mmOutStream = clientSocket.getOutputStream();
                mmOutStream.write(new String("L").getBytes());
                Log.v(TAG, " se envio correctamente ");

            } else {
                Toast.makeText(getApplicationContext(), "NO ESTAS CONECTADO", Toast.LENGTH_SHORT).show();
            }

        } catch (IOException e) {
            Log.d(TAG, "enviar()::" + e.getMessage());
            buttonToggle.setEnabled(false);
        }

    }

    public String recibir() {

        Log.d(TAG, "Recibiendo RESPUESTA PARA EL MEDIDOR");

        // TODO: Recibiendo informacion del Arduino hacia el Movil.
        InputStreamReader entrada;
        String resultado = "";
        try {
            if (clientSocket.isConnected()) {

                Log.e(TAG, "si esta conectado y listo para leer el inputStream  ");
                String loqueEntro = "";
                entrada = new InputStreamReader(clientSocket.getInputStream());
                int read = entrada.read();
                while (read != -1) {
                    char lcChar = (char) read;
                    loqueEntro = loqueEntro + lcChar;
                    Log.e(TAG, " El char adicionado es = " + lcChar);
                    if (entrada.ready()) {
                        read = entrada.read();
                    } else {
                        read = -1;
                    }

                }

                Log.e(TAG, " se convirtio a String la data = " + loqueEntro.toString());
                resultado = loqueEntro;


            } else {
                Toast.makeText(getApplicationContext(), "NO ESTAS CONECTADO", Toast.LENGTH_SHORT).show();
            }

        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            buttonToggle.setEnabled(false);
        }
        return resultado;
    }

    public void esperarToRecibir() {

        final ProgressDialog loPDialog = new ProgressDialog(LecturacionBluetooth.this);
        loPDialog.setMessage("Sincronizando Lectura...");
        loPDialog.setIndeterminate(true);
        loPDialog.setCancelable(false);
        loPDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String datoRecibido = "";
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e(TAG, "termino de esperar y llama a recibir ");
                datoRecibido = recibir();
                Log.e(TAG, " se recibio el dato  " + datoRecibido);


                final String dato = datoRecibido;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (dato.equals("")) {
                            tvValorLectura.setText("Sin exito");
                        } else {
                            tvValorLectura.setText(dato);
                        }

                        loPDialog.dismiss();
                    }
                });
            }
        }).start();
    }


    // </editor-fold>


}
