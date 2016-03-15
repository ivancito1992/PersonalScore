package com.example.ivanb.personalscore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MenuInicial extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu_principal);
        siguiente();
    }

    private void siguiente() {
        ImageButton estadisticas = (ImageButton) findViewById(R.id.btn_estadisticas);
        ImageButton jugadas = (ImageButton) findViewById(R.id.btn_jugadas);
        estadisticas.setOnClickListener(this);
        jugadas.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_estadisticas:
                startActivity(new Intent(MenuInicial.this, SeleccionNombre.class));
                break;
            case R.id.btn_jugadas:
                startActivity(new Intent(MenuInicial.this, JugadasCompleto.class));
                break;
        }
    }
}
