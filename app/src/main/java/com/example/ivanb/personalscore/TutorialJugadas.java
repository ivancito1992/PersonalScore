package com.example.ivanb.personalscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;


public class TutorialJugadas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.tutorial_jugadas);
    }
}