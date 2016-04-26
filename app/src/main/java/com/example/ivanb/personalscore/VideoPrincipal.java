package com.example.ivanb.personalscore;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;
import android.os.Handler;

public class VideoPrincipal extends Activity {
    VideoView presentacion;
    boolean activo = true;
    final int DURACION = 9800;

    @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.video);
        presentacion = (VideoView) findViewById(R.id.videoView_video);

        Uri path = Uri.parse("android.resource://com.example.ivanb.personalscore/"+ R.raw.logointronegro);
        presentacion.setVideoURI(path);
        presentacion.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(VideoPrincipal.this, MenuInicial.class));
                finish();
            }
        }, DURACION);

    }
}
