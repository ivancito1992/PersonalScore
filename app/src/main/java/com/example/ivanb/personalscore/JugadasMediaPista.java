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


public class JugadasMediaPista extends AppCompatActivity implements View.OnClickListener{

    Button borrar, vista, bloquear, guardar, lineaPase, lineaMovimiento, lineaBloqueo, lineaTiro;

    ImageView num1, num2, num3, num4, num5;
    int modificarX = 20;
    int modificarY = 20;
    boolean estanBlock = false;
    RelativeLayout jugada;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.jugadas_pista_media);
        jugada = (RelativeLayout) findViewById(R.id.todoMedia);
        borrar = (Button) findViewById(R.id.borrarPistaMedia);
        borrar.setOnClickListener(this);
        vista = (Button) findViewById(R.id.cvAcompleto);
        vista.setOnClickListener(this);
        bloquear = (Button) findViewById(R.id.bloqueoIconMedia);
        bloquear.setOnClickListener(this);
        guardar = (Button) findViewById(R.id.guardarJugMedia);
        guardar.setOnClickListener(this);

        num1 = (ImageView) findViewById(R.id.num1media);
        num1.setOnTouchListener(handlerMover);
        num2 = (ImageView) findViewById(R.id.num2media);
        num2.setOnTouchListener(handlerMover);
        num3 = (ImageView) findViewById(R.id.num3media);
        num3.setOnTouchListener(handlerMover);
        num4 = (ImageView) findViewById(R.id.num4media);
        num4.setOnTouchListener(handlerMover);
        num5 = (ImageView) findViewById(R.id.num5media);
        num5.setOnTouchListener(handlerMover);

        lineaPase = (Button)findViewById(R.id.trazoPasarMedia);
        lineaPase.setOnClickListener(this);
        lineaMovimiento = (Button)findViewById(R.id.trazoMoverMedia);
        lineaMovimiento.setOnClickListener(this);
        lineaBloqueo = (Button)findViewById(R.id.trazoBloquearMedia);
        lineaBloqueo.setOnClickListener(this);
        lineaTiro = (Button)findViewById(R.id.trazoTiroMedia);
        lineaTiro.setOnClickListener(this);

        Pintar.trazoInvisible();

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
        if(v.getId()==R.id.borrarPistaMedia){
            startActivity(new Intent(JugadasMediaPista.this, JugadasMediaPista.class));
            finish();
        }
        if(v.getId()==R.id.cvAcompleto){
            startActivity(new Intent(JugadasMediaPista.this, JugadasCompleto.class));
            finish();
        }
        if(v.getId()==R.id.trazoPasarMedia){
            Pintar.trazoPase();
        }
        if(v.getId()==R.id.trazoMoverMedia){
            Pintar.trazoMove();
        }
        if(v.getId()==R.id.trazoBloquearMedia){
            Pintar.trazoBloqueo();
        }
        if(v.getId()==R.id.trazoTiroMedia){
            Pintar.trazoTiro();
        }
        if(v.getId()==R.id.bloqueoIconMedia){
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
        if(v.getId()==R.id.guardarJugMedia){
            AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
            saveDialog.setTitle("Guardar Imagen");
            saveDialog.setMessage("¿Quieres guardar la jugada en la galeria?");
            saveDialog.setPositiveButton("Si", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    //save drawing
                    jugada.setDrawingCacheEnabled(true);
                    String imgSaved = MediaStore.Images.Media.insertImage(
                            getContentResolver(), jugada.getDrawingCache(),
                            "JugadaMediaPista.png", "drawing");
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
