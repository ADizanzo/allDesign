package com.example.alldesign;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FavoritosActivity extends AppCompatActivity {

    private FavoritosAdapter favoritosAdapter;
    private RecyclerView recyclerView;
    private List<Product> productList;
    private SQLiteDatabase db;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        recyclerView = findViewById(R.id.recyclerViewFavoritos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();
        favoritosAdapter = new FavoritosAdapter(this, productList);
        recyclerView.setAdapter(favoritosAdapter);

        // Inicializar el DBHelper y CRUD
        databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getReadableDatabase();

        // Cargar los productos favoritos desde la base de datos y mostrarlos en RecyclerView
        cargarProductosFavoritos();

        // Obtener la referencia a los botones
        Button btnConsultar = findViewById(R.id.btnConsultar);
        Button btnEliminarFavorito = findViewById(R.id.btnEliminarFavorito);


        // OnClickListener para el botón "Ver producto"
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedPosition = favoritosAdapter.getSelectedPosition();
                if (selectedPosition != RecyclerView.NO_POSITION) {
                    Product selectedProduct = productList.get(selectedPosition);
                    // Aquí puedes abrir una nueva actividad para ver los detalles del producto
                    Intent intent = new Intent(FavoritosActivity.this, SofaDetailActivity.class);
                    intent.putExtra("productId", selectedProduct.getId());
                    startActivity(intent);
                } else {
                    Toast.makeText(FavoritosActivity.this, "Seleccione un producto para ver los detalles", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // OnClickListener para el botón "Eliminar producto favorito"
        btnEliminarFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedPosition = favoritosAdapter.getSelectedPosition();
                if (selectedPosition != RecyclerView.NO_POSITION) {
                    Product selectedProduct = productList.get(selectedPosition);
                    databaseHelper.eliminarProducto((int) selectedProduct.getId());
                    productList.remove(selectedPosition);
                    favoritosAdapter.notifyItemRemoved(selectedPosition);
                    Toast.makeText(FavoritosActivity.this, "Producto eliminado de favoritos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FavoritosActivity.this, "Seleccione un producto para eliminar de favoritos", Toast.LENGTH_SHORT).show();
                }
            }
        });



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

    private void cargarProductosFavoritos() {
        Cursor cursor = databaseHelper.obtenerProductos();
        productList.clear();
        if (cursor.moveToFirst()) {
            do {
                // int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
                // String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRODUCT_NAME));
                // String price = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRODUCT_PRICE));
                // Product product = new Product(id, name, price);
                // productList.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        favoritosAdapter.notifyDataSetChanged();
    }

    private void eliminarProductoFavorito(int productId) {
        databaseHelper.eliminarProducto(productId);
    }
}




