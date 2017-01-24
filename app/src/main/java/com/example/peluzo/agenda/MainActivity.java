package com.example.peluzo.agenda;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.lang.Object;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, telefono, correo, desc;
    private String etFecha;
    private DatePicker fecha;
    private int dia, mes, anio;
    private Button Boton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.campo_nombre);
        telefono = (EditText) findViewById(R.id.campo_telefono);
        correo = (EditText) findViewById(R.id.campo_email);
        desc = (EditText) findViewById(R.id.campo_desc);

        Boton = (Button) findViewById(R.id.btnMiBoton);
        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fecha = (DatePicker) findViewById(R.id.dp_fecha);
                fecha = (DatePicker) findViewById(R.id.dp_fecha);
                dia = fecha.getDayOfMonth();
                mes = fecha.getMonth();
                anio = fecha.getYear();
                etFecha = String.valueOf(dia+"/"+(mes+1)+"/"+anio);

                lanzarActivity(view, nombre.getText().toString(), telefono.getText().toString(),
                        correo.getText().toString(), desc.getText().toString(), etFecha.toString());
            }



            public void lanzarActivity(View v, String nombre, String telefono, String correo, String desc, String fecha) {
                //Aquí lanzaremos el segundo activity
                Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);
                if (nombre.equals("") || nombre.equals(null)) {
                    i.putExtra(getResources().getString(R.string.pnombre), getResources().getString(R.string.mensajeTexto));
                    i.putExtra(getResources().getString(R.string.ptelefono), getResources().getString(R.string.mensajeTexto));
                    i.putExtra(getResources().getString(R.string.pcorreo), getResources().getString(R.string.mensajeTexto));
                    i.putExtra(getResources().getString(R.string.pdesc), getResources().getString(R.string.mensajeTexto));
                    i.putExtra("fecha", "TEXTO VACIO");

                } else {
                    i.putExtra(getResources().getString(R.string.pnombre), nombre);
                    i.putExtra(getResources().getString(R.string.ptelefono), telefono);
                    i.putExtra(getResources().getString(R.string.pcorreo), correo);
                    i.putExtra(getResources().getString(R.string.pdesc), desc);
                    i.putExtra("fecha", fecha);
                }
                startActivity(i);
            }

        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        AppIndex.AppIndexApi.start(client2, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client2, getIndexApiAction());
        client2.disconnect();
    }
}
