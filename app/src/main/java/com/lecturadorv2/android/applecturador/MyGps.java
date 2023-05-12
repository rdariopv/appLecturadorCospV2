package com.lecturadorv2.android.applecturador;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Dario Pardo on 8/15/2017.
 */
public class MyGps   implements LocationListener{


    private Context contexto;
    public Double Latitud;
    public Double Longitud;
    public MyGps(Context loContext){
        this.contexto= loContext;
        this.Latitud=0.0;
        this.Longitud=0.0;

    }
    public void iniciarGPS() {
        /* Use the LocationManager class to obtain GPS locations */


        Log.e("MyGps", "iniciarGPS:: se inicio el GPS" );
        LocationManager mlocManager = (LocationManager)   this.contexto.getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(contexto , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(contexto, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,
                    (LocationListener) this);
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        this.Latitud= location.getLatitude();
        this.Longitud=location.getLongitude();
        Log.e("MyGPS", "onLocationChanged:  Latitud"+Latitud+" | Longitud"+Longitud);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
        Toast.makeText(this.contexto,"GPS ACTIVADO ! ! !", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String s) {
       // Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
       // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       // contexto.startActivity(intent);
        Toast.makeText(this.contexto,"GPS DESACTIVADO ! ! !", Toast.LENGTH_LONG).show();

    }

    public void verificarGpsActivo(){
       boolean isGps= isGPSProvider();
       boolean isNetwork = isNetworkProvider();
        if(!isGps || !isNetwork){
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            contexto.startActivity(intent);
            Toast.makeText(this.contexto,"GPS DESACTIVADO ! ! !", Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(this.contexto,"GPS SE ENCUENTRA ACTIVADO ! ! !", Toast.LENGTH_LONG).show();
        }
    }

    public boolean isGPSProvider() {
        LocationManager lm = (LocationManager)contexto.getSystemService(Context.LOCATION_SERVICE);
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public boolean isNetworkProvider() {
        LocationManager lm = (LocationManager)contexto.getSystemService(Context.LOCATION_SERVICE);
        return lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

}
