package com.example.alldesign;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar la transición de desvanecimiento
        Fade fade = new Fade();
        fade.setDuration(3000); // Duración de la transición en milisegundos

        // Establecer la transición en la ventana de la actividad actual
        getWindow().setEnterTransition(fade);

        // Agrega un retraso de 3 segundos antes de iniciar LoginActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Transición a LoginActivity después de 3 segundos
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

                // Finalizar la actividad actual para evitar que permanezca visible
                finish();
            }
        }, 2000); // 2000 milisegundos = 2 segundos
    }
}

