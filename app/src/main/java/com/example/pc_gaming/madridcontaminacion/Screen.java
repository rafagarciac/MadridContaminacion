package com.example.pc_gaming.madridcontaminacion;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class Screen extends AppCompatActivity {

    private ImageView imagenFondo;
    private ProgressBar barraProgreso;
    private int progreso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        imagenFondo = findViewById(R.id.fondo);
        barraProgreso = findViewById(R.id.progressBar);


        //Utilizo la libreria Glide
        Glide.with(getApplicationContext()).load(R.drawable.screen).into(imagenFondo);

        //Pruebo la libreria Picasso NO FUNCIONA!
        //Picasso.with(getApplicationContext()).load(R.drawable.screen).into(imagenFondo);

        new Thread(miHilo).start();
    }

    private Runnable miHilo = new Runnable() {
        @Override
        public void run() {
            while(progreso < 100){
                try {

                    miHandle.sendMessage(miHandle.obtainMessage());
                    Thread.sleep(25);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }catch (Throwable t){
                    t.printStackTrace();
                }
            }

            Intent i = new Intent(Screen.this, ListaCiudades.class);
            startActivity(i);
            finish();
        }

        Handler miHandle = new Handler(){

            public void handleMessage(Message msg) {
                progreso++;
                barraProgreso.setProgress(progreso);
                //tvProgreso.setText(progreso);
            }
        };
    };
}
