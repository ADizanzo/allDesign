package com.example.alldesign;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class FavoritosAdapter extends CursorAdapter {

    private final DatabaseHelper databaseHelper;

    // Constructor
    public FavoritosAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.databaseHelper = new DatabaseHelper(context);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_favorito, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView productNameTextView = view.findViewById(R.id.productName);
        TextView productPriceTextView = view.findViewById(R.id.productPrice);
        Button btnEliminar = view.findViewById(R.id.btnEliminar);
        Button btnConsultar = view.findViewById(R.id.btnConsultar);

        final long productId = cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID));
        final String productName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRODUCT_NAME));
        final String productPrice = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRODUCT_PRICE));

        productNameTextView.setText(productName);
        productPriceTextView.setText(productPrice);

        // Acción para el botón Eliminar
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Eliminar el producto de la base de datos
                databaseHelper.eliminarProducto((int) productId);
                // Actualizar el cursor
                swapCursor(databaseHelper.obtenerProductos());
            }
        });

        // Acción para el botón Ver
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Eliminar el producto de la base de datos
                databaseHelper.obtenerProductos();
                // Actualizar el cursor
                swapCursor(databaseHelper.obtenerProductos());
            }
        });
    }

        // Método para agregar un nuevo producto a la base de datos y actualizar la vista
        public void insertarProducto (String name, String price){
            long id = databaseHelper.insertarProducto(name, price);
            if (id != -1) {
                // Si la inserción fue exitosa, actualiza la vista
                swapCursor(databaseHelper.obtenerProductos());
            }
        }
}