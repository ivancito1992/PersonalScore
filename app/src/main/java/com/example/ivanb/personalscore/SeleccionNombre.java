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

    TextView textoLocal, textoVisitante, textoJugador, tvEquipoLocal, tvEquipoVisitante, tvJugador;
    EditText nombreLocal, nombreVisitante, nombreJugador;
    Button continuar;
    String cadenaLocal, cadenaVisitante, cadenaJugador;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_nombres);

        textoLocal = (TextView) findViewById(R.id.nombreLocal);
        textoVisitante = (TextView) findViewById(R.id.nombreVisitante);
        textoJugador = (TextView) findViewById(R.id.nombreJugador);
        nombreLocal = (EditText) findViewById(R.id.escribirLocal);
        nombreVisitante = (EditText) findViewById(R.id.escribirVisitante);
        nombreJugador = (EditText) findViewById(R.id.escribirJugador);
        tvEquipoLocal = (TextView) findViewById(R.id.equipoLocal);
        tvEquipoVisitante = (TextView) findViewById(R.id.equipoVisitante);
        //tvJugador = (TextView) findViewById(R.id.)

        continuar = (Button) findViewById(R.id.comenzar);
        continuar.setOnClickListener(this);

        String font_path_texto = "fonts/displaylcd.ttf";
        Typeface fuente = Typeface.createFromAsset(getAssets(),font_path_texto);

        textoLocal.setTypeface(fuente);
        textoVisitante.setTypeface(fuente);
        textoJugador.setTypeface(fuente);

        nombreLocal.setTypeface(fuente);
        nombreVisitante.setTypeface(fuente);
        nombreJugador.setTypeface(fuente);
    }

    @Override
    public void onWindowFocusChanged(boolean hasfocus){
        super.onWindowFocusChanged(hasfocus);
        View decorView = getWindow().getDecorView();
        if(hasfocus){
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.comenzar:
                cadenaLocal = nombreLocal.getText().toString();
                cadenaVisitante = nombreVisitante.getText().toString();
                cadenaJugador = nombreJugador.getText().toString();
                if (cadenaLocal.isEmpty()){
                    cadenaLocal = "Home";
                }
                if (cadenaVisitante.isEmpty()){
                    cadenaVisitante = "Away";
                }
                if (cadenaJugador.isEmpty()){
                    cadenaJugador = "Nombre Jugador";
                }
                Intent i = new Intent(this, Estadisticas.class);
                i.putExtra("nel", cadenaLocal);
                i.putExtra("nev", cadenaVisitante);
                i.putExtra("nej", cadenaJugador);
                startActivity(i);
                break;
        }
    }
}
