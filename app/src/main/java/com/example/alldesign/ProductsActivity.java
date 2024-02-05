package com.example.alldesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);


        // Obtén la referencia al ImageView del ícono del sofa
        ImageView sofaIconImageView = findViewById(R.id.tvSquare);

        // Establece un OnClickListener para el ícono del sofa
        sofaIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el ícono del sofa, inicia la SofaActivity
                Intent intent = new Intent(ProductsActivity.this, SofaActivity.class);
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
                Intent intent = new Intent(ProductsActivity.this, TvActivity.class);
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
                Intent intent = new Intent(ProductsActivity.this, VeladorActivity.class);
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
                Intent intent = new Intent(ProductsActivity.this, SofaDetailActivity.class);
                startActivity(intent);
            }
        });

        // Establece un OnClickListener para el icono "Más" en la tarjeta 2
        addIconImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono "Más" en la tarjeta 2, inicia la TvDetailActivity
                Intent intent = new Intent(ProductsActivity.this, TvDetailActivity.class);
                startActivity(intent);
            }
        });

        // Establece un OnClickListener para el icono "Más" en la tarjeta 3
        addIconImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono "Más" en la tarjeta 3, inicia la VeladorDetailActivity
                Intent intent = new Intent(ProductsActivity.this, VeladorDetailActivity.class);
                startActivity(intent);
            }
        });

        // Establece un OnClickListener para el icono "Más" en la tarjeta 4
        addIconImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono "Más" en la tarjeta 4, inicia la MuebleDetailActivity
                Intent intent = new Intent(ProductsActivity.this, MuebleDetailActivity.class);
                startActivity(intent);
            }
        });


        // Obtén la referencia al ImageView del ícono del corazón en la barra de navegación inferior
        ImageView heartIconImageView = findViewById(R.id.heart);

        // Establece un OnClickListener para el ícono del corazón
        heartIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el ícono del corazón, inicia la FavoritosActivity
                Intent intent = new Intent(ProductsActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });

        // Obtén la referencia al ImageView del ícono del carrito en la barra de navegación inferior
        ImageView cartIconImageView = findViewById(R.id.cart);

        // Establece un OnClickListener para el ícono del carrito
        cartIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el ícono del corazón, inicia la CarritoActivity
                Intent intent = new Intent(ProductsActivity.this,CarritoActivity.class);
                startActivity(intent);
            }
        });


    }
}
