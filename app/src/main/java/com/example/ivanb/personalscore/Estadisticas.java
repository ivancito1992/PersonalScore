package com.example.ivanb.personalscore;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ivanb on 29/02/2016.
 */
public class Estadisticas extends AppCompatActivity {

    TextView tvLocal, tvVisitante, tvNombrej1, tvPuntosj1, tvLocalj1, tvVisitantej1;
    TextView tvEquipoLocal, tvEquipoVisitante, tvAcertadosLocal, tvBarraLocal, tvTotalLocal, tvAcertadosVisitante, tvBarraVisitante, tvTotalesVisitantes;
    TextView tvTextoj1tl, tvMetidasj1tl, tvBarraj1tl, tvTotalj1tl;
    TextView tvTextoj1t2, tvMetidasj1t2, tvBarraj1t2, tvTotalj1t2;
    TextView tvTextoj1t3, tvMetidasj1t3, tvBarraj1t3, tvTotalj1t3;
    TextView tvTextoRebotesj1, tvNumRebotesj1;
    TextView tvTextoAsistenciasj1, tvNumAsistenciasj1;
    TextView tvTextoRobosj1, tvTextoTaponesj1, tvNumRobosj1, tvBarraExtraj1, tvNumTaponesj1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadisticas);

        /*CARGAR LOS TV CON LOS DATOS DEL LAYOUT*/

        tvLocal = (TextView) findViewById(R.id.marcadorLocal);
        tvVisitante = (TextView) findViewById(R.id.marcadorVisitante);
        tvNombrej1 = (TextView) findViewById(R.id.nombreJ1);
        tvPuntosj1 = (TextView) findViewById(R.id.puntosJ1);
        tvLocalj1 = (TextView) findViewById(R.id.localJ1);
        tvVisitantej1 = (TextView) findViewById(R.id.visitanteJ1);
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
        tvTextoRobosj1 = (TextView) findViewById(R.id.textoRoboJ1);
        tvTextoTaponesj1 = (TextView) findViewById(R.id.textoTaponJ1);
        tvNumRobosj1 = (TextView) findViewById(R.id.numRobosJ1);
        tvBarraExtraj1 = (TextView) findViewById(R.id.barraExtraJ1);
        tvNumTaponesj1 = (TextView) findViewById(R.id.numTaponesJ1);
        tvEquipoLocal = (TextView) findViewById(R.id.equipoLocal);
        tvEquipoVisitante = (TextView) findViewById(R.id.equipoVisitante);
        tvAcertadosLocal = (TextView) findViewById(R.id.tirosAcertadosLocal);
        tvBarraLocal = (TextView) findViewById(R.id.barraLocal);
        tvBarraVisitante = (TextView) findViewById(R.id.barraVisitante);
        tvTotalLocal = (TextView) findViewById(R.id.tirosTiradosLocal);
        tvAcertadosVisitante = (TextView) findViewById(R.id.tirosAcertadosVisitantes);
        tvTotalesVisitantes = (TextView) findViewById(R.id.tirosTiradosVisitantes);


        /*CAMBIAR FUENTE DE LOS TEXTOS*/

        String font_path_marcador = "fonts/scoreboard.ttf";
        String font_path_texto = "fonts/displaylcd.ttf";

        Typeface tfMarcador = Typeface.createFromAsset(getAssets(),font_path_marcador);
        tvLocal.setTypeface(tfMarcador);
        tvVisitante.setTypeface(tfMarcador);

        Typeface tfTexto = Typeface.createFromAsset(getAssets(),font_path_texto);
        tvEquipoLocal.setTypeface(tfTexto);
        tvEquipoVisitante.setTypeface(tfTexto);
        tvAcertadosLocal.setTypeface(tfTexto);
        tvTotalLocal.setTypeface(tfTexto);
        tvAcertadosVisitante.setTypeface(tfTexto);
        tvTotalesVisitantes.setTypeface(tfTexto);
        tvNombrej1.setTypeface(tfTexto);
        tvPuntosj1.setTypeface(tfTexto);
        tvLocalj1.setTypeface(tfTexto);
        tvVisitantej1.setTypeface(tfTexto);
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
        tvTextoRobosj1.setTypeface(tfTexto);
        tvTextoTaponesj1.setTypeface(tfTexto);
        tvNumRobosj1.setTypeface(tfTexto);
        tvNumTaponesj1.setTypeface(tfTexto);

    }

}
