package com.lecturadorv2.android.applecturador;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

//import android.support.design.widget.TabLayout;
//import android.support.design.widget.TextInputLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

import com.lecturadorv2.android.comunicacion.SyncBsDhw;
import com.lecturadorv2.android.comunicacion.SyncBsDpw;
import com.lecturadorv2.android.comunicacion.SyncBsEnw;
import com.lecturadorv2.android.comunicacion.SyncBsHpw;
import com.lecturadorv2.android.comunicacion.SyncBsLec;
import com.lecturadorv2.android.comunicacion.SyncBsObw;
import com.lecturadorv2.android.comunicacion.SyncBsTaw;
import com.lecturadorv2.android.comunicacion.SyncBsccw;
import com.lecturadorv2.android.comunicacion.SyncLtZon;
import com.lecturadorv2.android.comunicacion.TestConexionHttp;
import com.lecturadorv2.android.dblecturador.BsCcw;
import com.lecturadorv2.android.dblecturador.BsDhw;
import com.lecturadorv2.android.dblecturador.BsDpw;
import com.lecturadorv2.android.dblecturador.BsEnw;
import com.lecturadorv2.android.dblecturador.BsHpw;
import com.lecturadorv2.android.dblecturador.BsObw;
import com.lecturadorv2.android.dblecturador.BsTaw;
import com.lecturadorv2.android.dblecturador.DBhelper;
import com.lecturadorv2.android.dblecturador.DBmanager;
import com.lecturadorv2.android.dblecturador.LtCnf;
import com.lecturadorv2.android.dblecturador.LtZon;

import java.util.Date;
import java.util.LinkedList;

//import android.app.AlertDialog;
import androidx.appcompat.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
//import android.support.v4.app.Fragment;
import androidx.fragment.app.Fragment;
//import android.support.v4.app.FragmentManager;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.app.FragmentStatePagerAdapter;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager;

public class SyncActivity extends AppCompatActivity {

    /**
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link FragmentStatePagerAdapter}.
     */
    private CustomSectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarS);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new CustomSectionsPagerAdapter(getSupportFragmentManager());


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.containerS);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsS);
       // tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               // Toast.makeText(getApplicationContext(), tab.getPosition() + ":onTabSelected", Toast.LENGTH_LONG).show();
                if(mSectionsPagerAdapter!=null){
                   // mSectionsPagerAdapter.notifyDataSetChanged();

                }
                mViewPager.setCurrentItem(tab.getPosition());

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(mViewPager);



        // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        // fab.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View view) {
        //         Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                 .setAction("Action", null).show();
        //     }
        // });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //  client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void lanzarDialogVerifConex() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this.getWindow().getContext());

        LtCnf cnf = new LtCnf();
        cnf.obtenerCnf(1);
        builder.setTitle("LECTURADOR");
        builder.setMessage("No se puede conectar a :" + cnf.getCnfwUrl());
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.create();
        builder.show();
    }

    public boolean verificarConectividad() {
        boolean conecta = false;
        try {

            LtCnf cnf = new LtCnf();
            cnf.obtenerCnf(1);
            String[] url = {cnf.getCnfwUrl().trim()};
            TestConexionHttp cnxHttp = new TestConexionHttp(this.getApplicationContext());
            conecta = cnxHttp.execute(url).get();
            return conecta;
        } catch (Exception e) {
            Toast.makeText(this.getWindow().getContext(),
                    "Error al probar conexion a URL" + e.getMessage(),
                    Toast.LENGTH_LONG).show();
            conecta = false;
        }
        return conecta;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sync, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu1syncact) {
            // limpiarBD();
            lanzarDialogoLimpiarBD();
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void limpiarBD() {
        try {
            DBmanager.AbrirBD();
            DBmanager.LimpiarTabla(DBhelper.NOMTAHPW);
            DBmanager.LimpiarTabla(DBhelper.NOMTADPW);
            DBmanager.LimpiarTabla(DBhelper.NOMTAOBW);
            DBmanager.LimpiarTabla(DBhelper.NOMTAENW);
            DBmanager.LimpiarTabla(DBhelper.NOMTALTZON);
            DBmanager.LimpiarTabla(DBhelper.NOMTATAW);
            DBmanager.LimpiarTabla(DBhelper.NOMTABSCCW);
            DBmanager.LimpiarTabla(DBhelper.NOMTABSDHW);
            DBmanager.LimpiarTabla(DBhelper.NOMTABSLEC);
            DBmanager.CerrarBD();
            Toast.makeText(this.getWindow().getContext(), "Se ha limpiado la Base de datos CORRECTAMENTE", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this.getWindow().getContext(), "Se ha producido un error al limpiar la Base de datos", Toast.LENGTH_LONG).show();
        }
    }
    public void lanzarDialogoLimpiarBD() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this.getWindow().getContext());
        builder.setTitle("LECTURADOR");
        builder.setMessage("Esta seguro de eliminar los datos de lecturacion");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                limpiarBD();
                // dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();
            }
        });
        builder.create();
        builder.show();
    }
    public boolean conexion = false;

    public static class ParametrosFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public ParametrosFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ParametrosFragment newInstance() {
            ParametrosFragment fragment = new ParametrosFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, 0);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            //  View rootView = inflater.inflate(R.layout.fragment_parametros, container, false);
            //  TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //  textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            View rootView = IniciarlizarParametros(inflater, container, savedInstanceState);
            return rootView;
        }

        private Button btnSyncPMT;
        public BsEnw enwPmt;

        public View IniciarlizarParametros(LayoutInflater inflater, ViewGroup container,
                                           Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_parametros, container, false);
            enwPmt = new BsEnw();
            btnSyncPMT = (Button) rootView.findViewById(R.id.btnSyncPmt);
            btnSyncPMT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    lanzarDownloadParametros();
                }
            });
            // aqui le adidicionas el codigo que querras
            return rootView;

        }


        //region sincronizar parametros
        public void lanzarDownloadParametros() {

            ((SyncActivity) this.getActivity()).conexion = ((SyncActivity) this.getActivity()).verificarConectividad();
            if (!((SyncActivity) this.getActivity()).conexion) {
                ((SyncActivity) this.getActivity()).lanzarDialogVerifConex();
            } else {

                new DownloadDataEmpresa().execute();
            }
            //new DownloadDataEmpresa().execute();
        }

        public class DownloadDataEmpresa extends AsyncTask<String, Integer, Boolean> {

            ProgressDialog pd = new ProgressDialog(getActivity().getWindow().getContext());

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
                enwPmt = new BsEnw();
                enwPmt.ObtenerBsEnw();
                String anio = enwPmt.getAnio() + "";
                String mes = enwPmt.getMesf() + "";
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

            ProgressDialog pd = new ProgressDialog(getActivity().getWindow().getContext());

            @Override
            protected void onPreExecute() {
                pd.setTitle("Sincronizando");
                pd.setMessage("RUTAS");
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

                String anio = enwPmt.getAnio() + "";
                String mes = enwPmt.getMesf() + "";
                String[] parametros = {anio, mes};
                new DownloadObservaciones().execute();
                // super.onPostExecute(aBoolean);
            }

            @Override
            protected void onCancelled() {
                //  super.onCancelled();
                //  pd.dismiss();
            }
        }

        public class DownloadTarifa extends AsyncTask<String, Integer, Boolean> {

            ProgressDialog pd = new ProgressDialog(getActivity().getWindow().getContext());

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

            ProgressDialog pd = new ProgressDialog(getActivity().getWindow().getContext());

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
                new DownloadCentrosCostos().execute();
                // super.onPostExecute(aBoolean);
            }

            @Override
            protected void onCancelled() {
                //  super.onCancelled();
            }
        }

        public class DownloadCentrosCostos extends AsyncTask<Boolean, Integer, Boolean> {

            ProgressDialog pd = new ProgressDialog(getActivity().getWindow().getContext());

            @Override
            protected void onPreExecute() {
                pd.setTitle("Sincronizando");
                pd.setMessage("Centros de costo");
                pd.setIndeterminate(false);
                pd.show();

                // super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Boolean... val) {
                SyncBsccw syncBsCcw = new SyncBsccw();
                syncBsCcw.SyncObtenerCentroCobranza();
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {

                pd.dismiss();
                confirmPmt();
                // super.onPostExecute(aBoolean);
            }

            @Override
            protected void onCancelled() {
                //  super.onCancelled();
               // confirmPmt();
            }
        }


// endregion


        public void confirmPmt(){
            //aqui abrir el dialogo
            final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity().getWindow().getContext());
            builder.setTitle("Datos Descargados");
            BsEnw enw= new BsEnw();
            LtZon zon = new LtZon();
            BsTaw tar= new BsTaw();
            BsObw obw= new BsObw();
            BsCcw ccw= new BsCcw();
            String pmt= enw.countRegister()+" Registros de Empresa." +System.getProperty("line.separator")+
                    ""+zon.countRegister()+" Registros de Zona. " +System.getProperty("line.separator")+
                    ""+tar.countRegister()+" Registros de Tarifas. " +System.getProperty("line.separator")+
                    ""+obw.countRegister()+" Registros de Observaciones. " +System.getProperty("line.separator")+
                    ""+ccw.countRegister()+" Registros de Centros de cobranzas.";
            builder.setMessage(pmt);
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            builder.create();
            builder.show();

        }
    }

    public static class DescargarFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public DescargarFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static DescargarFragment newInstance() {
            DescargarFragment fragment = new DescargarFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, 1);

            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // View rootView = inflater.inflate(R.layout.fragment_descargar, container, false);
            // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            View rootView = inicializarVar(inflater, container, savedInstanceState);
            return rootView;
        }


        // <editor-fold defaultstate="collapsed" desc="Codigo 1Adicionado">
        private TextInputLayout tilAnio;
        private TextInputLayout tilMes;
        private TextView tvMesf;
        private Spinner spZona;
        // ProgressDialog pd ;


        private Button btnSincronizar;
        private AdpZonas adpZonas;

        private int posMes;
        private int posZona;

        public BsEnw enwDsc;

        public View inicializarVar(LayoutInflater inflater, ViewGroup container,
                                   Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_descargar, container, false);
            tilAnio = (TextInputLayout) rootView.findViewById(R.id.tilAnio);
            tilMes = (TextInputLayout) rootView.findViewById(R.id.tilMes);
            tvMesf = (TextView) rootView.findViewById(R.id.tvMesf);
            spZona = (Spinner) rootView.findViewById(R.id.spinner);

            enwDsc = new BsEnw();
            enwDsc.ObtenerBsEnw();
            //pd= new ProgressDialog(DownloadActivity.this);

            // bspMeses.setText(mesActual.getMes());
            tilAnio.getEditText().setText(enwDsc.getAnio() + "");
            tilMes.getEditText().setText(enwDsc.getDmes());
            tvMesf.setText(enwDsc.getMesf() + "");


            LtZon zon = new LtZon();
            LinkedList<LtZon> listZonas = zon.listarLtZon();

            adpZonas = new AdpZonas(getActivity().getWindow().getContext(), listZonas);
            spZona.setAdapter(adpZonas);


            btnSincronizar = (Button) rootView.findViewById(R.id.btnSincronizar);

            btnSincronizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sincronizarDatosAvisosCobranza();
                }
            });
            return rootView;
        }

        public void updateView() {

            tilAnio.getEditText().setText(enwDsc.getAnio() + "");
            tilMes.getEditText().setText(enwDsc.getDmes());
            tvMesf.setText(enwDsc.getMesf() + "");


            LtZon zon = new LtZon();
            LinkedList<LtZon> listZonas = zon.listarLtZon();

            adpZonas = new AdpZonas(getActivity().getWindow().getContext(), listZonas);
            spZona.setAdapter(adpZonas);
        }

        String[] parametros = new String[10];

        public void sincronizarDatosAvisosCobranza() {
            String anio = this.tilAnio.getEditText().getText().toString();
            String mes = enwDsc.getMesf() + "";
            LtZon zonaActual = (LtZon) this.spZona.getSelectedItem();

            String zona = zonaActual.getNzon() + "";
            String rango = zonaActual.getRngo() + "";

            Log.e(this.getClass().getName(), "Zona seleccionada = " + zonaActual.toString1());

            this.parametros[0] = anio;
            this.parametros[1] = mes;
            this.parametros[2] = zona;
            this.parametros[3] = rango;

            int liVcsHist = Math.round(zonaActual.getCrhi() / zonaActual.getRngo());
            for (int i = 0; i <= liVcsHist; i++) {
                //  aqui descargar los historicos
                Log.e("SyncActivity", "anio=" + anio + "mes=" + mes + "zona=" + zona);
              //  new SyncHistoricoAvisos().execute(parametros);
            }

            int nVecesDtl = Math.round(zonaActual.getCreD() / zonaActual.getRngo());
            for (int i = 0; i <= nVecesDtl; i++) {
                new SyncDetallesAvisos().execute(parametros);
            }
            int liVecesHdr = Math.round(zonaActual.getCreh() / zonaActual.getRngo());
            for (int i = 0; i <= liVecesHdr; i++) {
              //  new SyncHeaderAvisos().execute(parametros);
            }


        }

        public class SyncHeaderAvisos extends AsyncTask<String, Integer, Boolean> {
            ProgressDialog pd = new ProgressDialog(getActivity().getWindow().getContext());

            @Override
            protected void onPreExecute() {
                //pd = new ProgressDialog(getBaseContext());
                // pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pd.setTitle("Sincronizando");
                pd.setMessage("Header Aviso de Cobranza");
                // pd.setProgress(0);
                pd.setIndeterminate(false);
                pd.setCanceledOnTouchOutside(false);
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

              //  syncHpw.SyncObtenerHeaderAvisos(anio, mes, zona, rango);

                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                pd.dismiss();
                // super.onPostExecute(aBoolean);
                confirmDataLectura();
            }

            @Override
            protected void onCancelled() {
                //  super.onCancelled();
                //  pd.dismiss();
            }

            public void confirmDataLectura(){

                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity().getWindow().getContext());
                builder.setTitle("Datos Descargados");
                BsHpw hpw= new BsHpw();
                BsDpw dpw = new BsDpw();
                BsDhw dhw= new BsDhw();
                String pmt= hpw.countRegister()+" Registros de header Avs. cobranza." +System.getProperty("line.separator")+
                        ""+dpw.countRegister()+" Registros de Detalle Avs. cobranza. " +System.getProperty("line.separator")+
                        ""+dhw.countRegister()+" Registros de Historico Avs. cobranza. " ;

                builder.setMessage(pmt);
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                builder.create();
                builder.show();

            }
        }

        public class SyncDetallesAvisos extends AsyncTask<String, Integer, Boolean> {

            ProgressDialog pd = new ProgressDialog(getActivity().getWindow().getContext());

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
               /* int anio = Integer.valueOf(params[0]);
                int mes = Integer.valueOf(params[1]);
                int zona = Integer.valueOf(params[2]);
                int rango = Integer.valueOf(params[3]);
                SyncBsDpw syncHpw = new SyncBsDpw();

               syncHpw.SyncObtenerDetalleAvisos(anio, mes, zona, rango);*/

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
                // new SyncHeaderAvisos().execute(parametros);

            }


        }

        public class SyncHistoricoAvisos extends AsyncTask<String, Integer, Boolean> {

            ProgressDialog pd = new ProgressDialog(getActivity().getWindow().getContext());

            @Override
            protected void onPreExecute() {
                // pd = new ProgressDialog(getBaseContext());
                // pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                pd.setTitle("Sincronizando");
                pd.setMessage("Historico Aviso de Cobranza");
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
                SyncBsDhw syncDhw = new SyncBsDhw();

               // syncDhw.SyncObtenerHistoricoAvisos(anio, mes, zona, rango);

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



            }



        }

        // </editor-fold>



    }

    public static class SubirFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public SubirFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static SubirFragment newInstance() {
            SubirFragment fragment = new SubirFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, 2);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // View rootView = inflater.inflate(R.layout.fragment_subir, container, false);
            // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            View rootView = inicializarVariables(inflater, container, savedInstanceState);
            return rootView;


        }

        //region codigo para subir lecturaciones
        private Button btnSubir;
        public BsEnw enwSubir;

        public View inicializarVariables(LayoutInflater inflater, ViewGroup container,
                                         Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_subir, container, false);
            enwSubir = new BsEnw();
            enwSubir.ObtenerBsEnw();
            btnSubir = (Button) rootView.findViewById(R.id.btnSubir);
            btnSubir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    subirDatos();
                }
            });
            return rootView;
        }

        public void subirDatos() {
            new subirLecturas().execute();
        }


        //region Subir Consumo
        public class subirLecturas extends AsyncTask<String, Integer, Boolean> {

            ProgressDialog pd = new ProgressDialog(getActivity().getWindow().getContext());

            @Override
            protected void onPreExecute() {

                this.pd.setTitle("Sincronizando");
                this.pd.setMessage("Subiendo Header lecturado");
                // pd.setProgress(0);
                this.pd.setIndeterminate(false);
                if (!this.pd.isShowing()) {
                    this.pd.show();
                }

                // super.onPreExecute();
            }


            @Override
            protected Boolean doInBackground(String... strings) {
                SyncBsHpw shpw = new SyncBsHpw();
                BsHpw hpw = new BsHpw();
                LinkedList<BsHpw> list = new LinkedList<BsHpw>();
            //    LinkedList<BsHpw> list = hpw.listarLecturadosBsHpw();
                boolean b = false;
                for (BsHpw hp : list) {
                    Log.e("SyncAcctivity", "enviar Hpw =" + hp.toString());
                    int liNhpf = hp.getNhpf();
                    int lact = hp.getLact();
                    int cons = hp.getCons();
                    Date fecha = new Date();
                  //  int imco = (int) hp.getImco();
                    int cobs = hp.getCobs();
                    //String latitud = hp.getLati();
                    //String longitud = hp.getLong();
                    int stadx = 3;
                    BsDpw dpw = new BsDpw();
                    // dpw.obtenerDpw(hp.getNhpf(), hp.getNhpc(), hp.getNcat());
                    LinkedList<BsDpw> listDtl = dpw.listarDetallesToEnviar(hp.getNhpf());
                    int nofn = 1;
                    int result=1;
                //    int result = shpw.SyncActualizarAvisoHead(liNhpf, lact, cons, fecha, imco, cobs, stadx, latitud, longitud, nofn, "appMovil");
                    // int result = shpw.SyncActualizarAvisoHead(604363, 10, 10, fecha, 100, 1, 3, 0.0 , 0.0, 1, "appMovil");

                    SyncBsDpw sdpw = new SyncBsDpw();
                    if (result == 1) {
                        for (BsDpw dtl : listDtl) {
                            Log.e("SyncActivity", "enviar Dpw =" + dtl.toString());
                            int nhpc = dtl.getNhpc();
                            int cant = (int) dtl.getCant();
                            double puni = dtl.getPuni();
                            double impt = dtl.getImpt();
                            int result1=1;
                          //  int result1 = sdpw.SyncActualizarAvisoDetalle(liNhpf, nhpc, cant, puni, impt);
                            // int result1 = sdpw.SyncActualizarAvisoDetalle(604363, 7002, 20, 10.34, 20);
                            if (result1 == 1) {
                                b = true;
                               // hp.actualizarEstado(3); // estado lecturado
                            }

                        }
                    //   sdpw.SyncActualizarAvisoStatxNhpf(hp.getNhpf(), 0);


                    }

                }
                return true;
            }

            @Override
            protected void onPostExecute(Boolean result) {
                if (this.pd.isShowing()) {
                    this.pd.dismiss();
                    //    this.pd= null;
                }
                //super.onPostExecute(result);
            }

        }
        //endregion

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class CustomSectionsPagerAdapter extends FragmentPagerAdapter {

        public CustomSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    Log.e("getItem","ParametrosFragment.newInstance()" );
                    return ParametrosFragment.newInstance();
                case 1:
                    Log.e("getItem","DescargarFragment.newInstance()" );
                    return DescargarFragment.newInstance();
                case 2:
                    Log.e("getItem","SubirFragment.newInstance()" );
                    return SubirFragment.newInstance();
            }
          //  notifyDataSetChanged();
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

       @Override
       public int getItemPosition(Object object) {
          // if (object instanceof DescargarFragment) {
          //     ((DescargarFragment) object).updateView();
          // }

          // notifyDataSetChanged();
           return POSITION_NONE;
       }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "PARAMETROS";
                case 1:
                    return "DESCARGAR DATOS";
                case 2:
                    return "SUBIR DATOS";
            }
            return null;
        }
    }
}
