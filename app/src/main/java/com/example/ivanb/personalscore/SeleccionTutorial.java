package com.example.ivanb.personalscore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class SeleccionTutorial extends AppCompatActivity implements View.OnClickListener {

    Button estadisticas, jugadas, volver;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_tutorial);

        estadisticas = (Button) findViewById(R.id.tutEstadisticas);
        jugadas = (Button) findViewById(R.id.tutJugadas);
        volver = (Button) findViewById(R.id.volver);

        volver.setOnClickListener(this);
        estadisticas.setOnClickListener(this);
        jugadas.setOnClickListener(this);
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
        if(v.getId()==R.id.tutEstadisticas){
            startActivity(new Intent(SeleccionTutorial.this, TutorialEstadisticas.class));
        }
        if(v.getId()==R.id.tutJugadas){
            startActivity(new Intent(SeleccionTutorial.this, TutorialJugadas.class));
        }
        if(v.getId()==R.id.volver){
            startActivity(new Intent(SeleccionTutorial.this, MenuInicial.class));
            finish();
        }

    }
}
