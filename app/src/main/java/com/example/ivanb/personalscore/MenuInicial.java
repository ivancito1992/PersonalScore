package com.example.ivanb.personalscore;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuInicial extends AppCompatActivity implements View.OnClickListener {

    Button estadisticas, jugadas;
    ImageButton ayuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu_principal);

        estadisticas = (Button) findViewById(R.id.btn_estadisticas);
        jugadas = (Button) findViewById(R.id.btn_jugadas);
        ayuda = (ImageButton) findViewById(R.id.btnAyuda);

        ayuda.setOnClickListener(this);
        estadisticas.setOnClickListener(this);
        jugadas.setOnClickListener(this);

        String font_path_menu = "fonts/allstarresort.ttf";
        Typeface tfMenu = Typeface.createFromAsset(getAssets(),font_path_menu);

        estadisticas.setTypeface(tfMenu);
        jugadas.setTypeface(tfMenu);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_estadisticas:
                startActivity(new Intent(MenuInicial.this, SeleccionNombre.class));
                break;
            case R.id.btn_jugadas:
                startActivity(new Intent(MenuInicial.this, JugadasMediaPista.class));
                break;
            case R.id.btnAyuda:
                startActivity(new Intent(MenuInicial.this, SeleccionTutorial.class));
        }
    }
}
