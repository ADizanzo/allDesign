package com.example.alldesign;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CarritoHelper extends SQLiteOpenHelper {


    // Nombre de la base de datos
    private static final String DATABASE_NAME = "carrito.db";

    // Versión de la base de datos
    private static final int DATABASE_VERSION = 1;

    // Nombre de la tabla
    public static final String TABLE_NAME = "carrito";

    // Nombres de las columnas
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCT_NAME = "product_name";
    public static final String COLUMN_PRODUCT_PRICE = "product_price";

    // Sentencia SQL para crear la tabla
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PRODUCT_NAME + " TEXT, " +
                    COLUMN_PRODUCT_PRICE + " TEXT);";

    public CarritoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crea la tabla del carrito al crear la base de datos
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Elimina la tabla existente si hay una actualización de la base de datos
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Vuelve a crear la tabla
        onCreate(db);
    }


    public long agregarProductoFavorito(String productName, String productPrice) {
        return 0;
    }

    public void eliminarProductoFavorito(int productId) {
    }

    public Cursor obtenerProductosFavoritos() {
        return null;
    }



}