package com.lecturadorv2.android.applecturador;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AlertDialog;
//import android.support.design.widget.Snackbar;
import com.lecturadorv2.android.dblecturador.BsHpw;
import com.lecturadorv2.android.dblecturador.BsLec;
import com.lecturadorv2.android.dblecturador.LtCnf;

//import android.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.ActionBarActivity;


public class ListaMedidores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listamedidores);

        inicializarVariables();
    }


   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
       // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.menu_listamedidores, menu);
       return true;
   }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.reimprimir) {
            otroDialogo();
            //lanzarDialogBusquedaCliente();
            //Toast.makeText(this,"En desarrollo",Toast.LENGTH_LONG ).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        this.adpListLec.notifyDataSetChanged();
        super.onPause();
    }

    // private AdapterLecturaciones adapterLecturaciones;
    private AdpSocioMedidor adpListLec;
    private ListView lvLecturaciones;

    public void inicializarVariables()
    {
        BsLec lec = new BsLec();
       // this.adapterLecturaciones= new AdapterLecturaciones(this);
        this.adpListLec = new AdpSocioMedidor(this,lec.listarNoLecturadosBsLec());
        lvLecturaciones= (ListView)findViewById(R.id.lvLecturaciones);
        lvLecturaciones.setAdapter(this.adpListLec);

        lvLecturaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long idLecturacion) {
                Toast.makeText(getApplicationContext(),"se presiono el item con posc="+posicion+"  con id= "+idLecturacion+" ",Toast.LENGTH_LONG).show();
              //  ItemLecturacion item = adapterLecturaciones.getItem(posicion);
                BsLec item = adpListLec.getItem(posicion);
                lanzarRealizarLecturacion(item);
            }
        });
    }

    public void lanzarRealizarLecturacion(BsLec itemLecturacion)
    {
       // finish();
        Intent intent= new Intent(this,RealizarLecturacion.class);
        intent.putExtra("item",   itemLecturacion);
        // intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    public void lanzarDialogBusquedaCliente() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this.getWindow().getContext());

        LtCnf cnf= new LtCnf();
        cnf.obtenerCnf(1);
        final EditText etNroContrato = new EditText(this);
        etNroContrato.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(etNroContrato);
        builder.setTitle("LECTURADOR");
        builder.setMessage("Digite Codigo de ubicacion" );
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               String Ncnt1= etNroContrato.getText().toString();
                buscarCliente(Integer.valueOf(Ncnt1));
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.create();
        builder.show();
    }

    public void buscarCliente(int NroContrato){
        Intent intent= new Intent(this,ReImprimir.class);
        BsHpw itemLecturacion= new BsHpw();
      //  boolean existe= itemLecturacion.obtenerBsHpwByNroContrato(NroContrato);
        Snackbar.make(findViewById(android.R.id.content),"EN DESARROLLO.",Snackbar.LENGTH_LONG).show();
      /* if (existe) {
           intent.putExtra("item", itemLecturacion);
           startActivity(intent);
       }else{
           Snackbar.make(findViewById(android.R.id.content),"SOCIO NO ENCONTRADO.",Snackbar.LENGTH_LONG).show();
       }*/

    }
    public void otroDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());

        LayoutInflater inflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View textEntryView = inflater.inflate(R.layout.dialog_search, null);
        final EditText etCodf = (EditText) textEntryView.findViewById(R.id.etNcnt);
        final EditText etNcnt = (EditText) textEntryView.findViewById(R.id.etCodf);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle((CharSequence) "Editar lectura cliente:").setView(textEntryView).setPositiveButton((CharSequence) "Aceptar", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String Ncnt1 = etNcnt.getText().toString();
                String Codf1 = etCodf.getText().toString();
                int liNcnt = 0;
                int liCodf = 0;
                if (!Ncnt1.isEmpty()) {
                    liNcnt = Integer.valueOf(Ncnt1).intValue();
                } else if (!Codf1.isEmpty()) {
                    liCodf = Integer.valueOf(Codf1).intValue();
                }
                buscarOtroCliente(liNcnt, liCodf);
            }
        }).setNegativeButton((CharSequence) "Cancelar", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        alert.show();
    }
    public void buscarOtroCliente(int liNcnt, int liCodf) {
        Intent intent = new Intent(this, EditLectura.class);
        BsLec itemLecturacion = new BsLec();
        boolean existe = false;
        if (liNcnt != 0) {
            existe = itemLecturacion.obtenerBsLecByCodFijo(liNcnt);
        } else if (liCodf != 0) {
            existe = itemLecturacion.obtenerBsLecByCodUbicacion(liCodf);
        }
        if (existe) {
            intent.putExtra("item", itemLecturacion);
            startActivity(intent);
           // return;
        }else{
            Snackbar.make(findViewById(android.R.id.content), (CharSequence) "SOCIO NO ENCONTRADO.", Snackbar.LENGTH_LONG).show();
        }

    }


}
