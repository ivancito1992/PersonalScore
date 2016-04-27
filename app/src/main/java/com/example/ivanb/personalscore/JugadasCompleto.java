package com.example.ivanb.personalscore;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class JugadasCompleto extends AppCompatActivity implements View.OnClickListener{

    Button borrar, vista, bloquear, guardar, lineaPase, lineaMovimiento, lineaBloqueo, lineaTiro;

    ImageView num1L, num2L, num3L, num4L, num5L, num1V, num2V, num3V, num4V, num5V;

    int modificarX = 20;
    int modificarY = 20;

    boolean estanBlock = false;

    RelativeLayout jugada;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.jugadas_pista_completa);
        borrar = (Button) findViewById(R.id.borrarPistaCompleta);
        borrar.setOnClickListener(this);
        vista = (Button) findViewById(R.id.cvAmedia);
        vista.setOnClickListener(this);
        bloquear = (Button) findViewById(R.id.bloqueoIconCompleta);
        bloquear.setOnClickListener(this);
        guardar = (Button) findViewById(R.id.guardarJCompleta);
        guardar.setOnClickListener(this);
        jugada = (RelativeLayout) findViewById(R.id.todoCompleta);

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

        Pintar.negar();
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
        if(v.getId()==R.id.guardarJCompleta){
            AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
            saveDialog.setTitle("Guardar Imagen");
            saveDialog.setMessage("¿Quieres guardar la jugada en la galeria?");
            saveDialog.setPositiveButton("Si", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    //save drawing
                    jugada.setDrawingCacheEnabled(true);
                    String imgSaved = MediaStore.Images.Media.insertImage(
                            getContentResolver(), jugada.getDrawingCache(),
                            "JugadaVistaCompleta.png", "drawing");
                    if(imgSaved!=null){
                        Toast savedToast = Toast.makeText(getApplicationContext(),
                                "La jugada ha sido guardada en la galeria", Toast.LENGTH_SHORT);
                        savedToast.show();
                    }
                    else{
                        Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                "Oops! No se ha podido guardar la jugada", Toast.LENGTH_SHORT);
                        unsavedToast.show();
                    }
                    jugada.destroyDrawingCache();
                }
            });
            saveDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });
            saveDialog.show();
        }
    }
}
