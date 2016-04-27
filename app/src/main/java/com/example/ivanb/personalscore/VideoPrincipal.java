package com.example.ivanb.personalscore;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
}
