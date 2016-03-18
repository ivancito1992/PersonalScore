package com.example.ivanb.personalscore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class JugadasCompleto extends AppCompatActivity implements View.OnClickListener{

    Button borrar, vista;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.jugadas_pista_completa);
        borrar = (Button) findViewById(R.id.borrarPistaCompleta);
        borrar.setOnClickListener(this);
        vista = (Button) findViewById(R.id.cvAmedia);
        vista.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.borrarPistaCompleta){
            startActivity(new Intent(JugadasCompleto.this, JugadasCompleto.class));
            finish();
        }
        if(v.getId()==R.id.cvAmedia){
            startActivity(new Intent(JugadasCompleto.this, JugadasMediaPista.class));
            finish();
        }
    }
}
