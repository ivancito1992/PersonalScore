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
