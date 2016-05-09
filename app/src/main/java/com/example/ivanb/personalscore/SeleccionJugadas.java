package com.example.ivanb.personalscore;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class SeleccionJugadas extends AppCompatActivity implements View.OnClickListener {

    Button verJugada, crearJugadas, volver;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_jugadas);

        verJugada = (Button) findViewById(R.id.tutEstadisticas);
        crearJugadas = (Button) findViewById(R.id.tutJugadas);
        volver = (Button) findViewById(R.id.volver);

        volver.setOnClickListener(this);
        verJugada.setOnClickListener(this);
        crearJugadas.setOnClickListener(this);

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
        if(v.getId()==R.id.crearJugadas){
            startActivity(new Intent(SeleccionJugadas.this, JugadasMediaPista.class));
        }
        if(v.getId()==R.id.verJugadas){
            startActivity(new Intent(SeleccionJugadas.this, TutorialJugadas.class));
        }
        if(v.getId()==R.id.volver){
            startActivity(new Intent(SeleccionJugadas.this, MenuInicial.class));
            finish();
        }

    }
}