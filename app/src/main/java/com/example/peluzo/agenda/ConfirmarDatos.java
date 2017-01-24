package com.example.peluzo.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ConfirmarDatos extends AppCompatActivity {

    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String correo = parametros.getString(getResources().getString(R.string.pcorreo));
        String desc = parametros.getString(getResources().getString(R.string.pdesc));
        String fecha = parametros.getString("fecha");

        TextView tvNombre = (TextView) findViewById(R.id.tv_nombre);
        tvNombre.setText(nombre);
        TextView tvTelefono = (TextView) findViewById(R.id.tv_telefono);
        tvTelefono.setText(telefono);
        TextView tvCorreo = (TextView) findViewById(R.id.tv_email);
        tvCorreo.setText(correo);
        TextView tvDesc = (TextView) findViewById(R.id.tv_desc);
        tvDesc.setText(desc);
        TextView tvFecha = (TextView) findViewById(R.id.tv_fecha);
        tvFecha.setText(fecha);

        boton = (Button) findViewById(R.id.btnMiBoton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });


    }
}
