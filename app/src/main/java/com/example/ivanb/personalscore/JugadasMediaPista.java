package com.example.ivanb.personalscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;


public class JugadasMediaPista extends AppCompatActivity implements View.OnClickListener{

    Button borrar;
    AttributeSet attrs;
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.jugadas_media_pista);
       borrar = (Button) findViewById(R.id.borrar);
       borrar.setOnClickListener(this);
   }

    @Override
    public void onClick(View v) {
        Pintar pintar = new Pintar(this, attrs);
        //if(v.getId()==R.id.borrar){
            //pintar.BorrarCanvas();
       // }
    }
}
