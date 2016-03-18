package com.example.ivanb.personalscore;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class JugadasMediaPista extends AppCompatActivity implements View.OnClickListener{

    Button borrar, vista;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.jugadas_pista_media);
        borrar = (Button) findViewById(R.id.borrarPistaCompleta);
        borrar.setOnClickListener(this);
        vista = (Button) findViewById(R.id.cvAcompleto);
        vista.setOnClickListener(this);
   }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.borrarPistaCompleta){
            startActivity(new Intent(JugadasMediaPista.this, JugadasMediaPista.class));
            finish();
        }
        if(v.getId()==R.id.cvAcompleto){
            startActivity(new Intent(JugadasMediaPista.this, JugadasCompleto.class));
            finish();
        }
    }
}
