package com.example.alldesign;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class FavoritosActivity extends AppCompatActivity {

    private FavoritosAdapter cursorAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        databaseHelper = new DatabaseHelper(this);
        ListView listView = findViewById(R.id.listViewfavorito);

        // Obtén los productos del carrito de la base de datos
        Cursor cursor = databaseHelper.obtenerProductos();
        cursorAdapter = new FavoritosAdapter(this, cursor, 0);
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
                Intent intent = new Intent(FavoritosActivity.this, ProductsActivity.class);
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
                Intent intent = new Intent(FavoritosActivity.this, CarritoActivity.class);
                startActivity(intent);
            }
        });


    }
}