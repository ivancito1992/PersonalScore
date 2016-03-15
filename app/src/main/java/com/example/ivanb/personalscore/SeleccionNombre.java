package com.example.ivanb.personalscore;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SeleccionNombre extends AppCompatActivity implements View.OnClickListener {

    TextView textoLocal, textoVisitante, tvEquipoLocal, tvEquipoVisitante;
    EditText nombreLocal, nombreVisitante;
    Button continuar;
    String cadenaLocal, cadenaVisitante;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.seleccion_nombres_equipo);

        textoLocal = (TextView) findViewById(R.id.nombreLocal);
        textoVisitante = (TextView) findViewById(R.id.nombreVisitante);
        nombreLocal = (EditText) findViewById(R.id.escribirLocal);
        nombreVisitante = (EditText) findViewById(R.id.escribirVisitante);
        tvEquipoLocal = (TextView) findViewById(R.id.equipoLocal);
        tvEquipoVisitante = (TextView) findViewById(R.id.equipoVisitante);

        continuar = (Button) findViewById(R.id.comenzar);
        continuar.setOnClickListener(this);

        String font_path_texto = "fonts/displaylcd.ttf";
        Typeface fuente = Typeface.createFromAsset(getAssets(),font_path_texto);

        textoLocal.setTypeface(fuente);
        textoVisitante.setTypeface(fuente);
        nombreLocal.setTypeface(fuente);
        nombreVisitante.setTypeface(fuente);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.comenzar:
                cadenaLocal = nombreLocal.getText().toString();
                cadenaVisitante = nombreVisitante.getText().toString();
                tvEquipoLocal.setText(cadenaLocal);
                tvEquipoVisitante.setText(cadenaVisitante);
                startActivity(new Intent(SeleccionNombre.this, Estadisticas.class));
                break;

        }
    }
}
