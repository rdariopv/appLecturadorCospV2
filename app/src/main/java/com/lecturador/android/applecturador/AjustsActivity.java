package com.lecturador.android.applecturador;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.lecturador.android.dblecturador.LtCnf;
import com.lecturador.android.zebra.BluetoothDeviceArrayAdapter;
import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinterFactory;

import java.util.ArrayList;
import java.util.Set;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class AjustsActivity extends AppCompatActivity {

    /**
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    final Context context = this;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajusts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

      //  TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
      //  tabLayout.setupWithViewPager(mViewPager);

        /*
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        */
    }


  //  @Override
  //  public boolean onCreateOptionsMenu(Menu menu) {
  //      // Inflate the menu; this adds items to the action bar if it is present.
  //      getMenuInflater().inflate(R.menu.menu_ajusts, menu);
  //      return true;
  //  }

   // @Override
   // public boolean onOptionsItemSelected(MenuItem item) {
   //     // Handle action bar item clicks here. The action bar will
   //     // automatically handle clicks on the Home/Up button, so long
   //     // as you specify a parent activity in AndroidManifest.xml.
   //     int id = item.getItemId();
   //     //noinspection SimplifiableIfStatement
   //     if (id == R.id.action_settings) {
   //         return true;
   //     }
   //     return super.onOptionsItemSelected(item);
   // }

    /**
     * A URL fragment containing a simple view.
     */
    public static class UrlFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_URL = "section_URL";

        public UrlFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static UrlFragment newInstance() {
            UrlFragment fragment = new UrlFragment();
            Bundle args = new Bundle();
            args.putString(ARG_SECTION_URL, "aqui el layout pa guardar la URL");
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
         /*   View rootView = inflater.inflate(R.layout.fragment_url, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.labelUrl);
            textView.setText( getArguments().getString(ARG_SECTION_URL));
            */
            View rootView = inicializarVariables(inflater, container, savedInstanceState);
            return rootView;
        }

        // <editor-fold defaultstate="collapsed" desc="Codigo Adicionado">
        private EditText etUrlFU;
        private Button btnAceptarFU;
        private Switch swOnlineFU;

        public View inicializarVariables(LayoutInflater inflater, ViewGroup container,
                                         Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_url, container, false);

            etUrlFU = (EditText) rootView.findViewById(R.id.etUrlFU);
            btnAceptarFU = (Button) rootView.findViewById(R.id.btnAceptarFU);
            swOnlineFU= (Switch) rootView.findViewById(R.id.swOnlineFU);


            LtCnf cnf = new LtCnf();
            boolean existe = cnf.obtenerCnf(1);
            if (existe) {
                etUrlFU.setText(cnf.getCnfwUrl());
                swOnlineFU.setChecked(cnf.isCnfOnly());
            }

            btnAceptarFU.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    registrarCnf();
                }
            });
            return rootView;
        }

        public void registrarCnf() {
            try {
                String url = etUrlFU.getText().toString();
                int online =  (swOnlineFU.isChecked()) ? 1 : 0;
                int printOnline =  0;
                boolean GpsA= true;

                if (url == "") {
                    Toast.makeText(getActivity(), "Ingrese la URL del servicio WEB", Toast.LENGTH_SHORT).show();
                }


                LtCnf cnf = new LtCnf();

                cnf.registrar(1, url,online,printOnline, GpsA ,0);
                Toast.makeText(getActivity(), "Se Registro la Url Correctamente", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // </editor-fold>
    }

    public static class PrintFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_PRINT = "section_PRINT";


        private BluetoothDeviceArrayAdapter adpPrinters;
        private ListView lvPrinters;
        private Switch swPrintOnline;

        private AlertDialog successDialog;


        //Printer data variables
        private String bluetoothAddress;
        private String ipAddress;
        private String uniqueId;
        private Integer port;

        public PrintFragment() {

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PrintFragment newInstance() {
            PrintFragment fragment = new PrintFragment();
            Bundle args = new Bundle();
            args.putString(ARG_SECTION_PRINT, "aqui el layout pa CONFIGURAR LA ZEBRA");
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_print, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.labelPrint);
           // textView.setText(getArguments().getString(ARG_SECTION_PRINT));



            try {


                lvPrinters = (ListView) rootView.findViewById(R.id.lvPrinters);
                adpPrinters = new BluetoothDeviceArrayAdapter(this.getActivity().getBaseContext(), getPairedPrinters());
                lvPrinters.setAdapter(adpPrinters);
                lvPrinters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                        final BluetoothDevice item = (BluetoothDevice) parent.getItemAtPosition(position);
                        if (item != null && item.getAddress() != null && isBluetoothPrinter(item)) {
                            bluetoothAddress = item.getAddress();
                            new enviarImprimir().execute();
                        } else {
                            Log.e(this.getClass().getName(), "tap on item list and not  isBluetoothPrinter");
                        }
                    }
                });

            } catch (Exception e) {
                 Toast.makeText(getActivity().getBaseContext(), "el Bluetooth no esta activado ",Toast.LENGTH_LONG).show();
            }

            return rootView;
        }

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
                    ZebraPrinterFactory.getInstance(conn).printConfigurationLabel();
                    //   stopSearching(printerName);
                }
                Thread.sleep(500);
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
                displayToast("ERROR: Unable to connect to Printer");
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
                    toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                }
            }).start();
        }

        public class enviarImprimir extends AsyncTask<String, Integer, Boolean> {
            ProgressDialog pd = new ProgressDialog(getActivity().getWindow().getContext());

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


    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return UrlFragment.newInstance();
              //  case 1:
              //      return PrintFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Ajustes";
               // case 1:
               //     return "Impresora";
            }
            return null;
        }
    }
}
