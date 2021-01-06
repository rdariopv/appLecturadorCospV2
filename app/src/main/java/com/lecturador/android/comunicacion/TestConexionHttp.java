package com.lecturador.android.comunicacion;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Dario Pardo on 7/15/2017.
 */
public class TestConexionHttp extends AsyncTask<String, Void, Boolean> {

    static Context context;
    boolean conecta;

    public TestConexionHttp(Context pContext) {
        this.context = pContext;
        conecta= false;
    }

    public boolean isConecta() {
        return conecta;
    }

    public void setConecta(boolean conecta) {
        this.conecta = conecta;
    }

    @Override
    protected Boolean doInBackground(String... urls) {

        try {
            URL url = new URL(urls[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int statusCode =Integer.valueOf( con.getResponseCode());
            if (statusCode != 200) {
                conecta= false;
            }
            else{
                conecta=true;
            }
        } catch (Exception e) {
           // Toast.makeText(context, "Error al probar conectividad", Toast.LENGTH_SHORT).show();
            conecta= false;
        }


        return conecta;
    }


}
