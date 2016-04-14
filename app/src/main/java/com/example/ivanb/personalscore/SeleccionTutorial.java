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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.seleccion_tutorial);

        estadisticas = (Button) findViewById(R.id.tutEstadisticas);
        jugadas = (Button) findViewById(R.id.tutJugadas);
        volver = (Button) findViewById(R.id.volver);

        volver.setOnClickListener(this);
        estadisticas.setOnClickListener(this);
        jugadas.setOnClickListener(this);
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
