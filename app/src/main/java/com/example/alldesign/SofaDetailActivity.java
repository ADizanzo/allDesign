package com.example.alldesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SofaDetailActivity extends AppCompatActivity {

    private CarritoHelper carritoHelper;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sofa_detail);

        // Inicializar el helper de la base de datos del carrito
        carritoHelper = new CarritoHelper(this);

        // Obtener la referencia al ImageView del icono de retroceso
        ImageView backIconImageView = findViewById(R.id.backIcon);

        // Establecer un OnClickListener para el icono de retroceso
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finalizar la actividad actual al hacer clic en el icono de retroceso
                finish();
            }
        });


        // Obtener la referencia al ImageView del icono del corazón (favoritos)
        ImageView heartFavIconImageView = findViewById(R.id.heartIcon);

        // Establecer un OnClickListener para el icono del corazón (favoritos)
        heartFavIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Datos del producto a agregar a favoritos
                String productName = getString(R.string.room_sofa);
                String productPrice = getString(R.string.value57000);

                // Insertar el producto en la base de datos de favoritos
                long result = databaseHelper.insertarProducto(productName, productPrice);
                if (result != -1) {
                    // Mostrar mensaje de éxito
                    Toast.makeText(SofaDetailActivity.this, "Producto agregado a favoritos", Toast.LENGTH_SHORT).show();
                } else {
                    // Mostrar mensaje de error si falla la inserción
                    Toast.makeText(SofaDetailActivity.this, "Error al agregar el producto a favoritos", Toast.LENGTH_SHORT).show();
                }
                // Iniciar la actividad FavoritosActivity al hacer clic en el icono home
                Intent intent = new Intent(SofaDetailActivity.this, FavoritosActivity.class);
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
                Intent intent = new Intent(SofaDetailActivity.this, PagoActivity.class);
                intent.putExtra("productName", getString(R.string.room_sofa));
                intent.putExtra("productImage", R.drawable.chair2);
                intent.putExtra("productPrice", getString(R.string.value57000));
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
                String productName = getString(R.string.room_sofa);
                String productPrice = getString(R.string.value57000);
                // Aquí puedes agregar más lógica para obtener otros detalles del producto si es necesario

                // Insertar producto en el carrito
                long resultado = carritoHelper.agregarProductoFavorito(productName, productPrice);
                if (resultado != -1) {
                    Toast.makeText(SofaDetailActivity.this, "¡Producto agregado al carrito!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SofaDetailActivity.this, "Error al agregar el producto al carrito", Toast.LENGTH_SHORT).show();
                }
                // Cuando se hace clic en el botón Agregar al Carrito, inicia la CarritoActivity
                Intent intent = new Intent(SofaDetailActivity.this, CarritoActivity.class);
                startActivity(intent);
            }
        });


        // Obtener la referencia al ImageView del icono home
        ImageView homeIconImageView = findViewById(R.id.home);

        // Establecer un OnClickListener para el icono home
        homeIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad ProductsActivity al hacer clic en el icono home
                Intent intent = new Intent(SofaDetailActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        // Obtener la referencia al ImageView del icono del corazón en la barra de navegación inferior
        ImageView heartIconImageView = findViewById(R.id.heart);

        // Establecer un OnClickListener para el icono del corazón en la barra de navegación inferior
        heartIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad FavoritosActivity al hacer clic en el icono del corazón
                Intent intent = new Intent(SofaDetailActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });

        // Obtener la referencia al ImageView del icono carrito
        ImageView cartIconImage = findViewById(R.id.cart);

        // Establecer un OnClickListener para el icono carrito
        cartIconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad CarritoActivity al hacer clic en el icono carrito
                Intent intent = new Intent(SofaDetailActivity.this, CarritoActivity.class);
                startActivity(intent);
            }
        });

    }
}

