package com.example.alldesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MuebleDetailActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mueble_detail);

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


        databaseHelper = new DatabaseHelper(this);

        // Obtén la referencia al ImageView del ícono del corazón en la esquina superior derecha
        ImageView heartFavIconImageView = findViewById(R.id.heartIcon);

        // Establece un OnClickListener para el ícono del corazón en la esquina superior derecha
        heartFavIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Insertar producto en favoritos
                long resultado = databaseHelper.insertarProducto(getString(R.string.mueble), getString(R.string.value36000));
                if (resultado != -1) {
                    Toast.makeText(MuebleDetailActivity.this, "¡Agregado a Favoritos!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MuebleDetailActivity.this, "Error al agregar a Favoritos", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Obtén la referencia al ImageView del icono home
        ImageView homeIconImageView = findViewById(R.id.home);

        // Establece un OnClickListener para el icono home
        homeIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono home, inicia la ProductsActivity
                Intent intent = new Intent(MuebleDetailActivity.this, ProductsActivity.class);
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
                Intent intent = new Intent(MuebleDetailActivity.this, FavoritosActivity.class);
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
                Intent intent = new Intent(MuebleDetailActivity.this,CarritoActivity.class);
                startActivity(intent);
            }
        });



        // Obtén la referencia del botón Comprar
        Button comprarButton = findViewById(R.id.btnBuy);

        // Establece un OnClickListener para el botón Comprar
        comprarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el botón Comprar, inicia la PagoActivity y pasa detalles del mueble
                Intent intent = new Intent(MuebleDetailActivity.this, PagoActivity.class);
                intent.putExtra("productName", getString(R.string.MuebleRústico));
                intent.putExtra("productImage", R.drawable.mueble);
                intent.putExtra("productPrice", getString(R.string.value36000));
                startActivity(intent);
            }
        });
    }

    private void agregarProductoAFavoritos() {
        // Aquí puedes realizar cualquier acción adicional cuando se agrega a favoritos
    }
}