package com.example.ivanb.personalscore;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class JugadasCompleto extends AppCompatActivity implements View.OnClickListener{

    Button borrar, vista, bloquear, lineaPase, lineaMovimiento, lineaBloqueo, lineaTiro;

    ImageView num1, num2, num3, num4, num5;

    int modificarX = 100;
    int modificarY = 100;

    boolean estanBlock = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.jugadas_pista_completa);
        borrar = (Button) findViewById(R.id.borrarPistaCompleta);
        borrar.setOnClickListener(this);
        vista = (Button) findViewById(R.id.cvAmedia);
        vista.setOnClickListener(this);
        bloquear = (Button) findViewById(R.id.bloqueoIconCompleta);
        bloquear.setOnClickListener(this);

        num1 = (ImageView) findViewById(R.id.num1completa);
        num1.setOnTouchListener(handlerMover);
        num2 = (ImageView) findViewById(R.id.num2completa);
        num2.setOnTouchListener(handlerMover);
        num3 = (ImageView) findViewById(R.id.num3completa);
        num3.setOnTouchListener(handlerMover);
        num4 = (ImageView) findViewById(R.id.num4completa);
        num4.setOnTouchListener(handlerMover);
        num5 = (ImageView) findViewById(R.id.num5completa);
        num5.setOnTouchListener(handlerMover);

        lineaPase = (Button)findViewById(R.id.trazoPasarCompleta);
        lineaPase.setOnClickListener(this);
        lineaMovimiento = (Button)findViewById(R.id.trazoMoverCompleta);
        lineaMovimiento.setOnClickListener(this);
        lineaBloqueo = (Button)findViewById(R.id.trazoBloquearCompleta);
        lineaBloqueo.setOnClickListener(this);
        lineaTiro = (Button)findViewById(R.id.trazoTiroCompleta);
        lineaTiro.setOnClickListener(this);
    }

    View.OnTouchListener handlerMover = new View.OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            PointF DownPT = new PointF();
            PointF StartPT;
            if (!estanBlock) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        DownPT.x = event.getX();
                        DownPT.y = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        StartPT = new PointF(v.getX(), v.getY());
                        PointF mv = new PointF(event.getX() - DownPT.x, event.getY() - DownPT.y);

                        v.setX((StartPT.x + mv.x) - modificarX);
                        v.setY((StartPT.y + mv.y) - modificarY);
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    default:
                        break;
                }
            }
            return true;
        }
    };

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
        if(v.getId()==R.id.trazoPasarCompleta){
            Pintar.trazoPase();
        }
        if(v.getId()==R.id.trazoMoverCompleta){
            Pintar.trazoMove();
        }
        if(v.getId()==R.id.trazoBloquearCompleta){
            Pintar.trazoBloqueo();
        }
        if(v.getId()==R.id.trazoTiroCompleta){
            Pintar.trazoTiro();
        }
        if(v.getId()==R.id.bloqueoIconCompleta){
            estanBlock = !estanBlock;
            if (estanBlock) {
                bloquear.setText(R.string.iconosFijados);
                Toast mensaje2 =
                        Toast.makeText(getApplicationContext(),
                                "Los iconos estan fijados, selecciona tipo de trazo para empezar la jugada",
                                Toast.LENGTH_SHORT);
                mensaje2.show();
            }
            else{
                bloquear.setText(R.string.iconosParaMover);
                Pintar.trazoInvisible();
                Toast mensaje1 =
                        Toast.makeText(getApplicationContext(), "Coloca los iconos en posicion",
                                Toast.LENGTH_SHORT);
                mensaje1.show();
            }
        }
    }
}
