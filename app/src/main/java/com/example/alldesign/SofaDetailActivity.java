package com.example.alldesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SofaDetailActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sofa_detail);

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
                // Obtener los datos del producto
                String productName = getString(R.string.room_sofa);
                String productPrice = getString(R.string.value57000);
                int productImage = R.drawable.chair2;

                // Insertar producto en favoritos
                long resultado = databaseHelper.insertarProducto(productName, productPrice);
                if (resultado != -1) {
                    Toast.makeText(SofaDetailActivity.this, "¡Agregado a Favoritos!", Toast.LENGTH_SHORT).show();

                    // Iniciar FavoritosActivity y pasar datos del producto
                    Intent intent = new Intent(SofaDetailActivity.this, FavoritosActivity.class);
                    intent.putExtra("productName", productName);
                    intent.putExtra("productPrice", productPrice);
                    intent.putExtra("productImage", productImage);
                    startActivity(intent);
                } else {
                    Toast.makeText(SofaDetailActivity.this, "Error al agregar a Favoritos", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // Obtén la referencia del botón Comprar
        Button comprarButton = findViewById(R.id.btnBuy);

        // Establece un OnClickListener para el botón Comprar
        comprarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el botón Comprar, inicia la PagoActivity y pasa detalles del sofá
                Intent intent = new Intent(SofaDetailActivity.this, PagoActivity.class);
                intent.putExtra("productName", getString(R.string.room_sofa));
                intent.putExtra("productImage", R.drawable.chair2);
                intent.putExtra("productPrice", getString(R.string.value57000));
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
                Intent intent = new Intent(SofaDetailActivity.this, ProductsActivity.class);
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
                Intent intent = new Intent(SofaDetailActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });

        // Obtén la referencia al ImageView del icono carrito
        ImageView cartIconImage = findViewById(R.id.cart);

        // Establece un OnClickListener para el icono carrito
        cartIconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el carrito, inicia la CarritoActivity
                Intent intent = new Intent(SofaDetailActivity.this, CarritoActivity.class);
                startActivity(intent);
            }
        });

    }
}

