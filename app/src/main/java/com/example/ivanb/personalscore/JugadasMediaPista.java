package com.example.ivanb.personalscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class JugadasMediaPista extends AppCompatActivity implements View.OnClickListener{

    Button borrar;
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.jugadas_media_pista);

       borrar = (Button) findViewById(R.id.borrar);
   }

    @Override
    public void onClick(View v) {
        Pintar pintar = new Pintar(this);
        if(v.getId()==R.id.borrar){
            pintar.BorrarCanvas();
        }
    }
}
