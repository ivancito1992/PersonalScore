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

    ImageView num1L, num2L, num3L, num4L, num5L, num1V, num2V, num3V, num4V, num5V;

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

        num1L = (ImageView) findViewById(R.id.num1Lcompleta);
        num1L.setOnTouchListener(handlerMover);
        num2L = (ImageView) findViewById(R.id.num2Lcompleta);
        num2L.setOnTouchListener(handlerMover);
        num3L = (ImageView) findViewById(R.id.num3Lcompleta);
        num3L.setOnTouchListener(handlerMover);
        num4L = (ImageView) findViewById(R.id.num4Lcompleta);
        num4L.setOnTouchListener(handlerMover);
        num5L = (ImageView) findViewById(R.id.num5Lcompleta);
        num5L.setOnTouchListener(handlerMover);

        num1V = (ImageView) findViewById(R.id.num1Vcompleta);
        num1V.setOnTouchListener(handlerMover);
        num2V = (ImageView) findViewById(R.id.num2Vcompleta);
        num2V.setOnTouchListener(handlerMover);
        num3V = (ImageView) findViewById(R.id.num3Vcompleta);
        num3V.setOnTouchListener(handlerMover);
        num4V = (ImageView) findViewById(R.id.num4Vcompleta);
        num4V.setOnTouchListener(handlerMover);
        num5V = (ImageView) findViewById(R.id.num5Vcompleta);
        num5V.setOnTouchListener(handlerMover);

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
