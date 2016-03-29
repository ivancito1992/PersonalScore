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


public class JugadasMediaPista extends AppCompatActivity implements View.OnClickListener{

    Button borrar, vista;
    ImageView num1, num2, num3, num4, num5;
    int modificarX = 50;
    int modificarY = 50;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.jugadas_pista_media);
        borrar = (Button) findViewById(R.id.borrarPistaMedia);
        borrar.setOnClickListener(this);
        vista = (Button) findViewById(R.id.cvAcompleto);
        vista.setOnClickListener(this);
        num1 = (ImageView) findViewById(R.id.imageView);
        num1.setOnTouchListener(handlerMover);
        num2 = (ImageView) findViewById(R.id.imageView2);
        num2.setOnTouchListener(handlerMover);
        num3 = (ImageView) findViewById(R.id.imageView3);
        num3.setOnTouchListener(handlerMover);
        num4 = (ImageView) findViewById(R.id.imageView4);
        num4.setOnTouchListener(handlerMover);
        num5 = (ImageView) findViewById(R.id.imageView5);
        num5.setOnTouchListener(handlerMover);

   }
    View.OnTouchListener handlerMover = new View.OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            PointF DownPT = new PointF();
            PointF StartPT;
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    DownPT.x = event.getX();
                    DownPT.y = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    StartPT = new PointF(v.getX(), v.getY());
                    PointF mv = new PointF(event.getX() - DownPT.x, event.getY() - DownPT.y);

                    v.setX((StartPT.x + mv.x) - modificarX);
                    v.setY((StartPT.y+mv.y) - modificarY);
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                default:
                    break;
            }
            return true;
        }
    };
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.borrarPistaMedia){
            startActivity(new Intent(JugadasMediaPista.this, JugadasMediaPista.class));
            finish();
        }
        if(v.getId()==R.id.cvAcompleto){
            startActivity(new Intent(JugadasMediaPista.this, JugadasCompleto.class));
            finish();
        }
    }
}
