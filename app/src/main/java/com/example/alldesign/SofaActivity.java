package com.example.alldesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SofaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sofa);


        // Obtén la referencia al ImageView del icono de retroceso
        ImageView backIconImageView = findViewById(R.id.backIcon);

        // Establece un OnClickListener para el icono de retroceso
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono de retroceso, finaliza la actividad actual
                finish();
            }
        });

        // Obtén la referencia al ImageView del icono all
        TextView allIconTextView = findViewById(R.id.allText);

        // Establece un OnClickListener para el icono all
        allIconTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono home, inicia la ProductsActivity
                Intent intent = new Intent(SofaActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        // Obtén la referencia al ImageView del ícono del tv
        ImageView tvIconImageView = findViewById(R.id.lampSquare);

        // Establece un OnClickListener para el ícono del tv
        tvIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el ícono del corazón, inicia la TvActivity
                Intent intent = new Intent(SofaActivity.this, TvActivity.class);
                startActivity(intent);
            }
        });

        // Obtén la referencia al ImageView del ícono del velador
        ImageView veladorIconImageView = findViewById(R.id.furnitureSquare);

        // Establece un OnClickListener para el ícono del velador
        veladorIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el ícono del corazón, inicia la VeladorActivity
                Intent intent = new Intent(SofaActivity.this, VeladorActivity.class);
                startActivity(intent);
            }
        });



        // Obtén la referencia al ImageView del icono "Más" en la tarjeta 1
        ImageView addIconImageView1 = findViewById(R.id.add_icon1);
        ImageView addIconImageView2 = findViewById(R.id.add_icon2);
        ImageView addIconImageView3 = findViewById(R.id.add_icon3);
        ImageView addIconImageView4 = findViewById(R.id.add_icon4);

        // Establece un OnClickListener para el icono "Más" en la tarjeta 1
        addIconImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono "Más" en la tarjeta 1, inicia la SofaDetailActivity
                Intent intent = new Intent(SofaActivity.this, SofaDetailActivity.class);
                startActivity(intent);
            }
        });

        // Establece un OnClickListener para el icono "Más" en la tarjeta 2
        addIconImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono "Más" en la tarjeta 2, inicia la SofaDetailActivity
                Intent intent = new Intent(SofaActivity.this, SofaDetailActivity.class);
                startActivity(intent);
            }
        });

        // Establece un OnClickListener para el icono "Más" en la tarjeta 3
        addIconImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono "Más" en la tarjeta 3, inicia la SofaDetailActivity
                Intent intent = new Intent(SofaActivity.this, SofaDetailActivity.class);
                startActivity(intent);
            }
        });

        // Establece un OnClickListener para el icono "Más" en la tarjeta 4
        addIconImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono "Más" en la tarjeta 4, inicia la SofaDetailActivity
                Intent intent = new Intent(SofaActivity.this, SofaDetailActivity.class);
                startActivity(intent);
            }
        });



        // Obtén la referencia al ImageView del icono home
        ImageView homeIconImageView = findViewById(R.id.home);

        // Establece un OnClickListener para el icono home
        homeIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono home, inicia la ProductsActivity
                Intent intent = new Intent(SofaActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });
    }
}