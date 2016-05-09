package com.example.ivanb.personalscore;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Estadisticas extends AppCompatActivity implements View.OnClickListener {

    TextView tvLocal, tvVisitante, tvJugador1, tvPuntosj1, tvEquipoLocal, tvEquipoVisitante, tvEquipodeJugador;
    TextView tvTextoj1tl, tvMetidasj1tl, tvBarraj1tl, tvTotalj1tl;
    TextView tvTextoj1t2, tvMetidasj1t2, tvBarraj1t2, tvTotalj1t2;
    TextView tvTextoj1t3, tvMetidasj1t3, tvBarraj1t3, tvTotalj1t3;
    TextView tvTextoRebotesj1, tvNumRebotesj1;
    TextView tvTextoAsistenciasj1, tvNumAsistenciasj1;
    TextView tvNumRobosj1, tvBarraExtraj1, tvNumTaponesj1;

    Button aciertoLTL, aciertoLT2, aciertoLT3;
    Button aciertoVTL, aciertoVT2, aciertoVT3;
    Button aciertoJ1TL, aciertoJ1T2, aciertoJ1T3, falloJ1TL, falloJ1T2, falloJ1T3;
    Button aumentarRebJ1, aumentarAsisJ1, aumentarExtraJ1, deshacerUltimo, finalizar;

    RadioButton esRobo, esTapon;

    int contadorAciertosJ1TL, contadorAciertosJ1T2, contadorAciertosJ1T3, contadorTiradosJ1TL, contadorTiradosJ1T2, contadorTiradosJ1T3, contadorRebotesJ1,
            contadorAsistenciasJ1, contadorRobosJ1, contadorTaponesJ1, marcadorLocal, marcadorVisitante, puntosJ1 = 0;

    boolean siLTL, siLT2, siLT3, siVTL, siVT2, siVT3, siJ1TL, siJ1T2, siJ1T3, noJ1TL, noJ1T2, noJ1T3, reboteBJ1, asistenciaBJ1, roboBJ1, taponBJ1, esLocalj1, esVisitantej1, esLocal, esVisitante;

    String puntosLocal, puntosVisitante, puntosJugador, stats1, stats2, stats3, statsAsistencias, statsRebotes, statsRobos, statsTapones, fecha, nombreFichero, textoEquipos, textoJugador;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadisticas);

        /* CARGAR LOS TV CON LOS DATOS DEL LAYOUT */
        tvLocal = (TextView) findViewById(R.id.marcadorLocal);
        tvVisitante = (TextView) findViewById(R.id.marcadorVisitante);
        tvPuntosj1 = (TextView) findViewById(R.id.puntosJ1);
        tvTextoj1tl = (TextView) findViewById(R.id.textoJ1TL);
        tvMetidasj1tl = (TextView) findViewById(R.id.metidasJ1TL);
        tvBarraj1tl = (TextView) findViewById(R.id.barraJ1TL);
        tvTotalj1tl = (TextView) findViewById(R.id.totalJ1TL);
        tvTextoj1t2 = (TextView) findViewById(R.id.textoJ1T2);
        tvMetidasj1t2 = (TextView) findViewById(R.id.metidasJ1T2);
        tvBarraj1t2 = (TextView) findViewById(R.id.barraJ1T2);
        tvTotalj1t2 = (TextView) findViewById(R.id.totalJ1T2);
        tvTextoj1t3 = (TextView) findViewById(R.id.textoJ1T3);
        tvMetidasj1t3 = (TextView) findViewById(R.id.metidasJ1T3);
        tvBarraj1t3 = (TextView) findViewById(R.id.barraJ1T3);
        tvTotalj1t3 = (TextView) findViewById(R.id.totalJ1T3);
        tvTextoRebotesj1 = (TextView) findViewById(R.id.textoRebotesJ1);
        tvNumRebotesj1 = (TextView) findViewById(R.id.numRebotesJ1);
        tvTextoAsistenciasj1 = (TextView) findViewById(R.id.textoAsistenciasJ1);
        tvNumAsistenciasj1 = (TextView) findViewById(R.id.numAsistenciasJ1);
        tvNumRobosj1 = (TextView) findViewById(R.id.numRobosJ1);
        tvBarraExtraj1 = (TextView) findViewById(R.id.barraExtraJ1);
        tvNumTaponesj1 = (TextView) findViewById(R.id.numTaponesJ1);

        esRobo = (RadioButton) findViewById(R.id.esRoboJ1);
        esTapon = (RadioButton) findViewById(R.id.esTaponJ1);

        Bundle bundle = getIntent().getExtras();
        tvEquipoLocal = (TextView) findViewById(R.id.equipoLocal);
        tvEquipoLocal.setText(bundle.getString("nel"));
        tvEquipoVisitante = (TextView) findViewById(R.id.equipoVisitante);
        tvEquipoVisitante.setText(bundle.getString("nev"));
        tvJugador1 = (TextView) findViewById(R.id.nombreJugador);
        tvJugador1.setText(bundle.getString("nej"));
        tvEquipodeJugador = (TextView) findViewById(R.id.nombreEquipodeJugador);
        tvEquipodeJugador.setText(bundle.getString("sej"));
        esLocal = bundle.getBoolean("boolsej");



        /* CAMBIAR FUENTE DE LOS TEXTOS */
        String font_path_marcador = "fonts/scoreboard.ttf";
        String font_path_texto = "fonts/displaylcd.ttf";

        Typeface tfMarcador = Typeface.createFromAsset(getAssets(),font_path_marcador);
        tvLocal.setTypeface(tfMarcador);
        tvVisitante.setTypeface(tfMarcador);
        tvPuntosj1.setTypeface(tfMarcador);

        Typeface tfTexto = Typeface.createFromAsset(getAssets(),font_path_texto);
        tvEquipoLocal.setTypeface(tfTexto);
        tvEquipoVisitante.setTypeface(tfTexto);
        tvEquipodeJugador.setTypeface(tfTexto);
        tvJugador1.setTypeface(tfTexto);

        tvTextoj1tl.setTypeface(tfTexto);
        tvMetidasj1tl.setTypeface(tfTexto);
        tvTotalj1tl.setTypeface(tfTexto);
        tvTextoj1t2.setTypeface(tfTexto);
        tvMetidasj1t2.setTypeface(tfTexto);
        tvTotalj1t2.setTypeface(tfTexto);
        tvTextoj1t3.setTypeface(tfTexto);
        tvMetidasj1t3.setTypeface(tfTexto);
        tvTotalj1t3.setTypeface(tfTexto);
        tvTextoRebotesj1.setTypeface(tfTexto);
        tvNumRebotesj1.setTypeface(tfTexto);
        tvTextoAsistenciasj1.setTypeface(tfTexto);
        tvNumAsistenciasj1.setTypeface(tfTexto);
        esRobo.setTypeface(tfTexto);
        esTapon.setTypeface(tfTexto);
        tvNumRobosj1.setTypeface(tfTexto);
        tvNumTaponesj1.setTypeface(tfTexto);

        /* CARGAR LOS BOTONES CON LOS ID DEL LAYOUT*/
        aciertoLTL = (Button) findViewById(R.id.siLTL);
        aciertoLTL.setOnClickListener(this);
        aciertoLT2 = (Button) findViewById(R.id.siLT2);
        aciertoLT2.setOnClickListener(this);
        aciertoLT3 = (Button) findViewById(R.id.siLT3);
        aciertoLT3.setOnClickListener(this);
        aciertoVTL = (Button) findViewById(R.id.siVTL);
        aciertoVTL.setOnClickListener(this);
        aciertoVT2 = (Button) findViewById(R.id.siVT2);
        aciertoVT2.setOnClickListener(this);
        aciertoVT3 = (Button) findViewById(R.id.siVT3);
        aciertoVT3.setOnClickListener(this);
        aciertoJ1TL = (Button) findViewById(R.id.aciertoJ1TL);
        aciertoJ1TL.setOnClickListener(this);
        aciertoJ1T2 = (Button) findViewById(R.id.aciertoJ1T2);
        aciertoJ1T2.setOnClickListener(this);
        aciertoJ1T3 = (Button) findViewById(R.id.aciertoJ1T3);
        aciertoJ1T3.setOnClickListener(this);

        falloJ1TL = (Button) findViewById(R.id.falloJ1TL);
        falloJ1TL.setOnClickListener(this);
        falloJ1T2 = (Button) findViewById(R.id.falloJ1T2);
        falloJ1T2.setOnClickListener(this);
        falloJ1T3 = (Button) findViewById(R.id.falloJ1T3);
        falloJ1T3.setOnClickListener(this);

        aumentarRebJ1 = (Button) findViewById(R.id.btnRebotesJ1);
        aumentarRebJ1.setOnClickListener(this);
        aumentarAsisJ1 = (Button) findViewById(R.id.btnAsistenciasJ1);
        aumentarAsisJ1.setOnClickListener(this);
        aumentarExtraJ1 = (Button) findViewById(R.id.btnExtraJ1);
        aumentarExtraJ1.setOnClickListener(this);
        deshacerUltimo = (Button) findViewById(R.id.deshacer);
        deshacerUltimo.setOnClickListener(this);
        finalizar = (Button) findViewById(R.id.finPartido);
        finalizar.setOnClickListener(this);


        esVisitantej1 = false;
        esLocalj1 = false;

        if(esLocal) {
            tvEquipodeJugador.setTextColor(0xff2996ef);
            /*tvTextoj1tl.setTextColor(0xff2996ef);
            tvTextoj1t2.setTextColor(0xff2996ef);
            tvTextoj1t3.setTextColor(0xff2996ef);
            tvTextoAsistenciasj1.setTextColor(0xff2996ef);
            tvTextoRebotesj1.setTextColor(0xff2996ef);
            esRobo.setTextColor(0xff2996ef);
            esTapon.setTextColor(0xff2996ef);
            aciertoJ1TL.setBackground(getDrawable(R.drawable.btn_acierto_accion_eslocal));
            aciertoJ1T2.setBackground(getDrawable(R.drawable.btn_acierto_accion_eslocal));
            aciertoJ1T3.setBackground(getDrawable(R.drawable.btn_acierto_accion_eslocal));*/
        }
        if(!esLocal){
            tvEquipodeJugador.setTextColor(0xffff8956);
            /*tvTextoj1tl.setTextColor(0xffff8956);
            tvTextoj1t2.setTextColor(0xffff8956);
            tvTextoj1t3.setTextColor(0xffff8956);
            tvTextoAsistenciasj1.setTextColor(0xffff8956);
            tvTextoRebotesj1.setTextColor(0xffff8956);
            esRobo.setTextColor(0xffff8956);
            esTapon.setTextColor(0xffff8956);
            aciertoJ1TL.setBackground(getDrawable(R.drawable.btn_acierto_accion_esvisitante));
            aciertoJ1T2.setBackground(getDrawable(R.drawable.btn_acierto_accion_esvisitante));
            aciertoJ1T3.setBackground(getDrawable(R.drawable.btn_acierto_accion_esvisitante));*/
        }
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
            case R.id.siLTL:
                siLTL = true; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                marcadorLocal++;
                tvLocal.setText(Integer.toString(marcadorLocal));
                break;

            case R.id.siLT2:
                siLTL = false; siLT2 = true; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                marcadorLocal = marcadorLocal + 2;
                tvLocal.setText(Integer.toString(marcadorLocal));
                break;

            case R.id.siLT3:
                siLTL = false; siLT2 = false; siLT3 = true; siVTL = false; siVT2 = false; siVT3 = false;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                marcadorLocal = marcadorLocal + 3;
                tvLocal.setText(Integer.toString(marcadorLocal));
                break;

            case R.id.siVTL:
                siLTL = false; siLT2 = false; siLT3 = false; siVTL = true; siVT2 = false; siVT3 = false;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                marcadorVisitante++;
                tvVisitante.setText(Integer.toString(marcadorVisitante));
                break;

            case R.id.siVT2:
                siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = true; siVT3 = false;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                marcadorVisitante = marcadorVisitante + 2;
                tvVisitante.setText(Integer.toString(marcadorVisitante));
                break;

            case R.id.siVT3:
                siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = true;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                marcadorVisitante = marcadorVisitante + 3;
                tvVisitante.setText(Integer.toString(marcadorVisitante));
                break;

            case R.id.aciertoJ1TL:
                siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                siJ1TL = true; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                if(esLocal){
                    marcadorLocal++;
                    tvLocal.setText(Integer.toString(marcadorLocal));
                }

                if(!esLocal){
                    marcadorVisitante++;
                    tvVisitante.setText(Integer.toString(marcadorVisitante));
                }
                puntosJ1++;
                tvPuntosj1.setText(Integer.toString(puntosJ1));
                contadorAciertosJ1TL++;
                tvMetidasj1tl.setText(Integer.toString(contadorAciertosJ1TL));
                contadorTiradosJ1TL++;
                tvTotalj1tl.setText(Integer.toString(contadorTiradosJ1TL));
                break;

            case R.id.aciertoJ1T2:
                siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                siJ1TL = false; siJ1T2 = true; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                if(esLocal){
                    marcadorLocal = marcadorLocal + 2;
                    tvLocal.setText(Integer.toString(marcadorLocal));
                }

                if(!esLocal){
                    marcadorVisitante = marcadorVisitante + 2;
                    tvVisitante.setText(Integer.toString(marcadorVisitante));
                }
                puntosJ1 = puntosJ1 + 2;
                tvPuntosj1.setText(Integer.toString(puntosJ1));
                contadorAciertosJ1T2++;
                tvMetidasj1t2.setText(Integer.toString(contadorAciertosJ1T2));
                contadorTiradosJ1T2++;
                tvTotalj1t2.setText(Integer.toString(contadorTiradosJ1T2));
                break;

            case R.id.aciertoJ1T3:
                siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = true; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                if(esLocal){
                    marcadorLocal = marcadorLocal + 3;
                    tvLocal.setText(Integer.toString(marcadorLocal));
               }

                if(!esLocal){
                    marcadorVisitante = marcadorVisitante + 3;
                    tvVisitante.setText(Integer.toString(marcadorVisitante));
               }
                puntosJ1 = puntosJ1 + 3;
                tvPuntosj1.setText(Integer.toString(puntosJ1));
                contadorAciertosJ1T3++;
                tvMetidasj1t3.setText(Integer.toString(contadorAciertosJ1T3));
                contadorTiradosJ1T3++;
                tvTotalj1t3.setText(Integer.toString(contadorTiradosJ1T3));
                break;

            case R.id.falloJ1TL:
                siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = true; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                contadorTiradosJ1TL++;
                tvTotalj1tl.setText(Integer.toString(contadorTiradosJ1TL));
                break;

            case R.id.falloJ1T2:
                siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = true; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                contadorTiradosJ1T2++;
                tvTotalj1t2.setText(Integer.toString(contadorTiradosJ1T2));
                break;

            case R.id.falloJ1T3:
                siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = true;
                reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                contadorTiradosJ1T3++;
                tvTotalj1t3.setText(Integer.toString(contadorTiradosJ1T3));
                break;

            case R.id.btnRebotesJ1:
                siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = true; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = false;

                contadorRebotesJ1++;
                tvNumRebotesj1.setText(Integer.toString(contadorRebotesJ1));
                break;

            case R.id.btnAsistenciasJ1:
                siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                reboteBJ1 = false; asistenciaBJ1 = true; roboBJ1 = false; taponBJ1 = false;

                contadorAsistenciasJ1++;
                tvNumAsistenciasj1.setText(Integer.toString(contadorAsistenciasJ1));
                break;

            case R.id.btnExtraJ1:
                if(esRobo.isChecked()){
                    siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                    siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                    reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = true; taponBJ1 = false;

                    contadorRobosJ1++;
                    tvNumRobosj1.setText(Integer.toString(contadorRobosJ1));
                }

                if(esTapon.isChecked()){
                    siLTL = false; siLT2 = false; siLT3 = false; siVTL = false; siVT2 = false; siVT3 = false;
                    siJ1TL = false; siJ1T2 = false; siJ1T3 = false; noJ1TL = false; noJ1T2 = false; noJ1T3 = false;
                    reboteBJ1 = false; asistenciaBJ1 = false; roboBJ1 = false; taponBJ1 = true;

                    contadorTaponesJ1++;
                    tvNumTaponesj1.setText(Integer.toString(contadorTaponesJ1));
                }
                break;

            /* BOTON DESHACER */
            case R.id.deshacer:
                if(siLTL && marcadorLocal > 0){
                    marcadorLocal--;
                    tvLocal.setText(Integer.toString(marcadorLocal));
                    siLTL = false;
                    break;
                }
                if(siLT2 && marcadorLocal > 0){
                    marcadorLocal = marcadorLocal - 2;
                    tvLocal.setText(Integer.toString(marcadorLocal));
                    siLT2 = false;
                    break;
                }
                if(siLT3 && marcadorLocal > 0){
                    marcadorLocal = marcadorLocal - 3;
                    tvLocal.setText(Integer.toString(marcadorLocal));
                    siLT3 = false;
                    break;
                }
                if(siVTL && marcadorVisitante > 0){
                    marcadorVisitante--;
                    tvVisitante.setText(Integer.toString(marcadorVisitante));
                    siVTL = false;
                    break;
                }
                if(siVT2 && marcadorVisitante > 0){
                    marcadorVisitante = marcadorVisitante - 2;
                    tvVisitante.setText(Integer.toString(marcadorVisitante));
                    siVT2 = false;
                    break;
                }
                if(siVT3 && marcadorVisitante > 0){
                    marcadorVisitante = marcadorVisitante - 3;
                    tvVisitante.setText(Integer.toString(marcadorVisitante));
                    siVT3 = false;
                    break;
                }
                if(siJ1TL && puntosJ1 > 0 && contadorAciertosJ1TL > 0 && contadorTiradosJ1TL > 0){
                    if(esLocal && marcadorLocal > 0){
                        marcadorLocal--;
                        tvLocal.setText(Integer.toString(marcadorLocal));
                    }
                    if(!esLocal && marcadorVisitante > 0){
                        marcadorVisitante--;
                        tvVisitante.setText(Integer.toString(marcadorVisitante));
                    }
                    puntosJ1--;
                    tvPuntosj1.setText(Integer.toString(puntosJ1));
                    contadorAciertosJ1TL--;
                    tvMetidasj1tl.setText(Integer.toString(contadorAciertosJ1TL));
                    contadorTiradosJ1TL--;
                    tvTotalj1tl.setText(Integer.toString(contadorTiradosJ1TL));
                    siJ1TL = false;
                    break;
                }
                if(siJ1T2 && puntosJ1 > 0 && contadorAciertosJ1T2 > 0 && contadorTiradosJ1T2 > 0) {
                    if (esLocal && marcadorLocal > 0) {
                        marcadorLocal = marcadorLocal - 2;
                        tvLocal.setText(Integer.toString(marcadorLocal));
                    }
                    if (!esLocal && marcadorVisitante > 0) {
                        marcadorVisitante = marcadorVisitante - 2;
                        tvVisitante.setText(Integer.toString(marcadorVisitante));
                    }
                    puntosJ1 = puntosJ1 - 2;
                    tvPuntosj1.setText(Integer.toString(puntosJ1));
                    contadorAciertosJ1T2--;
                    tvMetidasj1t2.setText(Integer.toString(contadorAciertosJ1T2));
                    contadorTiradosJ1T2--;
                    tvTotalj1t2.setText(Integer.toString(contadorTiradosJ1T2));
                    siJ1T2 = false;
                    break;
                }
                if(siJ1T3 && puntosJ1 > 0 && contadorAciertosJ1T3 > 0 && contadorTiradosJ1T3 > 0) {
                    if (esLocal && marcadorLocal > 0) {
                        marcadorLocal = marcadorLocal - 3;
                        tvLocal.setText(Integer.toString(marcadorLocal));
                    }
                    if (!esLocal && marcadorVisitante > 0) {
                        marcadorVisitante = marcadorVisitante - 3;
                        tvVisitante.setText(Integer.toString(marcadorVisitante));
                    }
                    puntosJ1 = puntosJ1 - 3;
                    tvPuntosj1.setText(Integer.toString(puntosJ1));
                    contadorAciertosJ1T3--;
                    tvMetidasj1t3.setText(Integer.toString(contadorAciertosJ1T3));
                    contadorTiradosJ1T3--;
                    tvTotalj1t3.setText(Integer.toString(contadorTiradosJ1T3));
                    siJ1T3 = false;
                    break;
                }
                if(noJ1TL && contadorTiradosJ1TL > 0){
                    contadorTiradosJ1TL--;
                    tvTotalj1tl.setText(Integer.toString(contadorTiradosJ1TL));
                    noJ1TL = false;
                    break;
                }
                if(noJ1T2 && contadorTiradosJ1T2 > 0) {
                    contadorTiradosJ1T2--;
                    tvTotalj1t2.setText(Integer.toString(contadorTiradosJ1T2));
                    noJ1T2 = false;
                    break;
                }
                if(noJ1T3 && contadorTiradosJ1T3 > 0) {
                    contadorTiradosJ1T3--;
                    tvTotalj1t3.setText(Integer.toString(contadorTiradosJ1T3));
                    noJ1T3 = false;
                    break;
                }
                if(reboteBJ1 && contadorRebotesJ1 > 0){
                    contadorRebotesJ1--;
                    tvNumRebotesj1.setText(Integer.toString(contadorRebotesJ1));
                    reboteBJ1 = false;
                    break;
                }
                if(asistenciaBJ1 && contadorAsistenciasJ1 > 0) {
                    contadorAsistenciasJ1--;
                    tvNumAsistenciasj1.setText(Integer.toString(contadorAsistenciasJ1));
                    asistenciaBJ1 = false;
                    break;
                }
                if(roboBJ1 && contadorRobosJ1 > 0) {
                    contadorRobosJ1--;
                    tvNumRobosj1.setText(Integer.toString(contadorRobosJ1));
                    roboBJ1 = false;
                    break;
                }
                if(taponBJ1 && contadorTaponesJ1 > 0) {
                    contadorTaponesJ1--;
                    tvNumTaponesj1.setText(Integer.toString(contadorTaponesJ1));
                    taponBJ1 = false;
                    break;
                }
                break;
            /* BOTON FIN PARTIDO */
            case R.id.finPartido:
                AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
                saveDialog.setTitle("Finalizar Partido");
                saveDialog.setMessage("¿Quieres finalizar el partido, y guardar los datos?");
                saveDialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        generarTXT();
                        try {
                            moverTXT();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Toast t = Toast.makeText(getApplicationContext(), "El resultado se ha guardado", Toast.LENGTH_SHORT);
                        t.show();
                        finish();
                    }
                });
                saveDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                saveDialog.show();
        }
    }
    public void generarTXT(){
        nombreFichero = "Partido.txt";
        puntosLocal = "La puntuacion del equipo "+tvEquipoLocal.getText().toString()
                +" ha sido: "+Integer.toString(marcadorLocal);
        puntosVisitante = "La puntuacion del equipo "+tvEquipoVisitante.getText().toString()
                +" ha sido: "+Integer.toString(marcadorVisitante);
        if(esLocal){
            puntosJugador =  "La puntuacion de "+tvJugador1.getText().toString()+" que juega en el equipo "
                    +tvEquipoLocal.getText().toString()+" es de: "+Integer.toString(puntosJ1);
        }
        if(!esLocal){
            puntosJugador =  "La puntuacion de "+tvJugador1.getText().toString()+" que juega en el equipo "
                    +tvEquipoVisitante.getText().toString()+" es de: "+Integer.toString(puntosJ1);
        }

        stats1 = "Desde la linea de tiros libres sus estadisticas han sido: "
                +Integer.toString(contadorAciertosJ1TL)+" / "+Integer.toString(contadorTiradosJ1TL);
        stats2 = "En canastas de dos puntos, sus estadisticas han sido: "
                +Integer.toString(contadorAciertosJ1T2)+" / "+Integer.toString(contadorTiradosJ1T2);
        stats3 = "Desde la linea de tres puntos sus estadisticas han sido: "
                +Integer.toString(contadorAciertosJ1T3)+" / "+Integer.toString(contadorTiradosJ1T3);
        statsAsistencias = "Ha repartido un total de: "+Integer.toString(contadorAsistenciasJ1)+" asistencia/s";
        statsRebotes = "Ha cogido un total de: "+Integer.toString(contadorRebotesJ1)+" rebote/s";
        statsRobos = "Ha conseguido: "+Integer.toString(contadorRobosJ1)+" robo/s";
        statsTapones = "Y ha puesto un total de: "+Integer.toString(contadorTaponesJ1)+" tapon/es";

        textoEquipos = puntosLocal+"\r\n"+puntosVisitante+"\r\n"+"--------------------------------------"+"\r\n";
        textoJugador = puntosJugador+"\r\n"+stats1+"\r\n"+stats2+"\r\n"+stats3+"\r\n"
                +statsAsistencias+"\r\n"+statsRebotes+"\r\n"+statsRobos+"\r\n"+statsTapones;
        try {
            OutputStreamWriter file = new OutputStreamWriter(openFileOutput(nombreFichero, Activity.MODE_PRIVATE));
            file.write(textoEquipos);
            file.write(textoJugador);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void moverTXT() throws IOException{
        fecha = new SimpleDateFormat("ddMMyyyy").format(new Date());
        String local, visitante;
        local = tvEquipoLocal.getText().toString();
        visitante = tvEquipoVisitante.getText().toString();
        final String antiguoDir = "/data/data/com.example.ivanb.personalscore/files/Partido.txt";
        File ubicFicheroInnaccesible = new File(antiguoDir);
        FileInputStream fis;

        fis = new FileInputStream(ubicFicheroInnaccesible);

        String nuevoDir = "/storage/sdcard0/PartidosMakingWinners";
        File ubicFicheroAccesible = new File(nuevoDir);
        if(!ubicFicheroAccesible.exists()){
            ubicFicheroAccesible.mkdir();
        }
        String aux = nuevoDir+"/"+local+" VS "+visitante+"_"+fecha+".txt";
        OutputStream ficheroAccesible = new FileOutputStream(aux);

        byte[] buffer = new byte[1024];
        int length;
        while((length = fis.read(buffer))> 0){
            ficheroAccesible.write(buffer,0,length);
        }
        ficheroAccesible.flush();
        ficheroAccesible.close();
        fis.close();
    }
}