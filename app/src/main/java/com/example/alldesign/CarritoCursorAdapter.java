package com.example.alldesign;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CarritoCursorAdapter extends CursorAdapter {

    private final CarritoHelper carritoHelper;

    public CarritoCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.carritoHelper = new CarritoHelper(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_carrito, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView productNameTextView = view.findViewById(R.id.productName);
        TextView productPriceTextView = view.findViewById(R.id.productPrice);
        Button btnEliminar = view.findViewById(R.id.btnEliminar);
        Button btnComprar = view.findViewById(R.id.btnComprar);

        final long productId = cursor.getLong(cursor.getColumnIndexOrThrow(CarritoHelper.COLUMN_ID));
        final String productName = cursor.getString(cursor.getColumnIndexOrThrow(CarritoHelper.COLUMN_PRODUCT_NAME));
        final String productPrice = cursor.getString(cursor.getColumnIndexOrThrow(CarritoHelper.COLUMN_PRODUCT_PRICE));

        productNameTextView.setText(productName);
        productPriceTextView.setText(productPrice);

        // Acción para el botón Eliminar
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Eliminar el producto de la base de datos
                carritoHelper.eliminarProductoFavorito((int) productId);
                // Actualizar el cursor
                swapCursor(carritoHelper.obtenerProductosFavoritos());
            }
        });

        // Acción para el botón Comprar
        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes implementar la lógica para realizar la compra del producto
                // Por ejemplo, puedes abrir una nueva actividad para el proceso de compra
            }
        });
    }
}