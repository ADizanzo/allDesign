package com.example.alldesign;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class CarritoActivity extends AppCompatActivity {

    private CarritoHelper carritoHelper;
    private CarritoCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        carritoHelper = new CarritoHelper(this);
        ListView listView = findViewById(R.id.listViewCarrito);

        // Obtén los productos del carrito de la base de datos
        Cursor cursor = carritoHelper.obtenerProductosFavoritos();
        cursorAdapter = new CarritoCursorAdapter(this, cursor, 0);
        listView.setAdapter(cursorAdapter);

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

        // Obtén la referencia al ImageView del icono home
        ImageView homeIconImageView = findViewById(R.id.home);

        // Establece un OnClickListener para el icono home
        homeIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el icono home, inicia la ProductsActivity
                Intent intent = new Intent(CarritoActivity.this, ProductsActivity.class);
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
                Intent intent = new Intent(CarritoActivity.this, FavoritosActivity.class);
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
                Intent intent = new Intent(CarritoActivity.this, CarritoActivity.class);
                startActivity(intent);
            }
        });
    }
}