package com.example.alldesign;

import android.content.Context;

public class UserManager {
    private final UsuariosHelper dbHelper;

    public UserManager(Context context) {
        dbHelper = new UsuariosHelper(context);
    }

    public boolean registerUser(String username, String password) {
        // Aquí deberías verificar si el usuario ya existe en la base de datos
        // y realizar la inserción si no existe.
        return dbHelper.addUser(username, password);
    }

    public boolean loginUser(String username, String password) {
        // Verificar si usuario y contraseña coinciden en la base de datos.
        return dbHelper.checkUserCredentials(username, password);
    }
}
