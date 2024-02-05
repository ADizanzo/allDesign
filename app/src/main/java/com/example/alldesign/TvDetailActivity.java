package com.example.alldesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TvDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_detail);

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

        // Obtén la referencia al ImageView del ícono del corazón en la esquina superior derecha
        ImageView heartFavtIconImageView = findViewById(R.id.heartIcon);

        // Establece un OnClickListener para el ícono del corazón en la esquina superior derecha
        heartFavtIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realiza la acción de agregar el producto a la lista de favoritos
                agregarProductoAFavoritos();

                // Mensaje de "Agregado a Favoritos"
                Toast.makeText(TvDetailActivity.this, "¡Agregado a Favoritos!", Toast.LENGTH_SHORT).show();

                // Cuando se hace clic en el ícono del corazón, inicia la FavoritosActivity
                Intent intent = new Intent(TvDetailActivity.this, FavoritosActivity.class);
                intent.putExtra("productName", getString(R.string.samsung_tv));
                intent.putExtra("productImage", R.drawable.tele);
                intent.putExtra("productPrice", getString(R.string.value112000));
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
                Intent intent = new Intent(TvDetailActivity.this, ProductsActivity.class);
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
                Intent intent = new Intent(TvDetailActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });

        // Obtén la referencia al ImageView del icono carrito
        ImageView cartIconImage = findViewById(R.id.cart);

        // Establece un OnClickListener para el icono carrito
        cartIconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono home, inicia la CarritoActivity
                Intent intent = new Intent(TvDetailActivity.this,CarritoActivity.class);
                startActivity(intent);
            }
        });


        // Obtén la referencia del botón Comprar
        Button comprarButton = findViewById(R.id.btnBuy);

        // Establece un OnClickListener para el botón Comprar
        comprarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el botón Comprar, inicia la PagoActivity y pasa detalles del tv
                Intent intent = new Intent(TvDetailActivity.this, PagoActivity.class);
                intent.putExtra("productName", getString(R.string.samsung_tv));
                intent.putExtra("productImage", R.drawable.tele);
                intent.putExtra("productPrice", getString(R.string.value112000));
                startActivity(intent);
            }
        });
    }

    private void agregarProductoAFavoritos() {
        // Aquí deberías agregar la lógica para agregar el producto a la lista de favoritos
        // Puedes almacenar la información del producto en una base de datos, SharedPreferences, etc.
    }
}