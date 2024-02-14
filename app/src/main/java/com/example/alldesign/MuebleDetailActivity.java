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

        // Obtener la referencia al ImageView del icono del corazón (favoritos)
        ImageView heartFavIconImageView = findViewById(R.id.heartIcon);

        // Establecer un OnClickListener para el icono del corazón (favoritos)
        heartFavIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Datos del producto a agregar a favoritos
                String productName = getString(R.string.mueble);
                String productPrice = getString(R.string.value36000);

                // Insertar el producto en la base de datos de favoritos
                long result = databaseHelper.insertarProducto(productName, productPrice);
                if (result != -1) {
                    // Mostrar mensaje de éxito
                    Toast.makeText(MuebleDetailActivity.this, "Producto agregado a favoritos", Toast.LENGTH_SHORT).show();
                } else {
                    // Mostrar mensaje de error si falla la inserción
                    Toast.makeText(MuebleDetailActivity.this, "Error al agregar el producto a favoritos", Toast.LENGTH_SHORT).show();
                }
                // Iniciar la actividad FavoritosActivity al hacer clic en el icono home
                Intent intent = new Intent(MuebleDetailActivity.this, FavoritosActivity.class);
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
                intent.putExtra("productName", getString(R.string.mueble));
                intent.putExtra("productImage", R.drawable.mueble);
                intent.putExtra("productPrice", getString(R.string.value36000));
                startActivity(intent);
            }
        });

        // Obtén la referencia del botón Agregar al Carrito
        Button addToCartButton = findViewById(R.id.btnAddToCart);

        // Establece un OnClickListener para el botón Agregar al Carrito
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos del producto
                String productName = getString(R.string.mueble);
                String productPrice = getString(R.string.value36000);
                // Aquí puedes agregar más lógica para obtener otros detalles del producto si es necesario

                // Insertar producto en el carrito
                long resultado = databaseHelper.insertarProducto(productName, productPrice);
                if (resultado != -1) {
                    Toast.makeText(MuebleDetailActivity.this, "¡Producto agregado al carrito!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MuebleDetailActivity.this, "Error al agregar el producto al carrito", Toast.LENGTH_SHORT).show();
                }
                // Cuando se hace clic en el botón Agregar al Carrito, inicia MuebleDetailActivity
                Intent intent = new Intent(MuebleDetailActivity.this, CarritoActivity.class);
                startActivity(intent);
            }
        });
    }


}