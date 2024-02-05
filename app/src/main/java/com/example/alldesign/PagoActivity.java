package com.example.alldesign;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PagoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);


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
                Intent intent = new Intent(PagoActivity.this, ProductsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Obtén la referencia al ImageView del ícono del corazón en la barra de navegación inferior
        ImageView heartIconImageView = findViewById(R.id.heart);

        // Establece un OnClickListener para el ícono del corazón
        heartIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el ícono del corazón, inicia la FavoritosActivity
                Intent intent = new Intent(PagoActivity.this, FavoritosActivity.class);
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
                Intent intent = new Intent(PagoActivity.this,CarritoActivity.class);
                startActivity(intent);
            }
        });



        // Obtén referencias a los elementos de la interfaz de usuario
        EditText etCardNumber = findViewById(R.id.etCardNumber);
        EditText etCardHolderName = findViewById(R.id.etCardHolderName);
        EditText etExpDate = findViewById(R.id.etExpDate);
        EditText etCVV = findViewById(R.id.etCVV);
        Button btnPay = findViewById(R.id.btnPay);

        // Configura el OnClickListener para el botón de pago
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene la información ingresada por el usuario
                String cardNumber = etCardNumber.getText().toString().replaceAll("-", "");
                String cardHolderName = etCardHolderName.getText().toString();
                String expDate = etExpDate.getText().toString();
                String cvv = etCVV.getText().toString();

                // Realiza la validación de la información de la tarjeta
                if (isValidCardInfo(cardNumber, cardHolderName, expDate, cvv)) {
                    // Si la información de la tarjeta es válida, simula una transacción exitosa
                    simulatePayment();
                } else {
                    // Muestra un mensaje de error si la información de la tarjeta no es válida
                    Toast.makeText(PagoActivity.this, "Error: Información de tarjeta no válida", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Agrega un TextWatcher para formatear automáticamente el número de tarjeta con guiones
        etCardNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No es necesario realizar acciones antes del cambio de texto
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No es necesario realizar acciones durante el cambio de texto
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Formatea el número de tarjeta con guiones cada cuatro dígitos y limita la longitud a 16
                String cardNumber = editable.toString().replaceAll("-", "");
                if (cardNumber.length() > 16) {
                    cardNumber = cardNumber.substring(0, 16);
                }

                StringBuilder formattedCardNumber = new StringBuilder();
                for (int i = 0; i < cardNumber.length(); i++) {
                    if (i > 0 && i % 4 == 0) {
                        formattedCardNumber.append("-");
                    }
                    formattedCardNumber.append(cardNumber.charAt(i));
                }
                etCardNumber.removeTextChangedListener(this);
                etCardNumber.setText(formattedCardNumber.toString());
                etCardNumber.setSelection(etCardNumber.getText().length());
                etCardNumber.addTextChangedListener(this);
            }
        });

        // Agrega un TextWatcher para formatear automáticamente la fecha de expiración con "MM/YY"
        etExpDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No es necesario realizar acciones antes del cambio de texto
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No es necesario realizar acciones durante el cambio de texto
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Formatea la fecha de expiración con "MM/YY" y limita la longitud a 5
                String expDate = editable.toString();
                if (expDate.length() > 5) {
                    expDate = expDate.substring(0, 5);
                }

                StringBuilder formattedExpDate = new StringBuilder();
                for (int i = 0; i < expDate.length(); i++) {
                    if (i == 2 && expDate.charAt(i) != '/') {
                        formattedExpDate.append("/");
                    }
                    formattedExpDate.append(expDate.charAt(i));
                }
                etExpDate.removeTextChangedListener(this);
                etExpDate.setText(formattedExpDate.toString());
                etExpDate.setSelection(etExpDate.getText().length());
                etExpDate.addTextChangedListener(this);
            }
        });

        // Agrega un TextWatcher para limitar la longitud del CVV a 3
        etCVV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No es necesario realizar acciones antes del cambio de texto
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No es necesario realizar acciones durante el cambio de texto
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Limita la longitud del CVV a 3
                if (editable.length() > 3) {
                    editable.delete(3, editable.length());
                }
            }
        });

        // Recupera la información del producto del Intent
        Intent intent = getIntent();
        String productName = intent.getStringExtra("productName");
        int productImage = intent.getIntExtra("productImage", 0);
        String productPrice = intent.getStringExtra("productPrice");

        // Actualiza la interfaz de usuario con los detalles del producto
        ImageView productImageView = findViewById(R.id.productImage);
        TextView productTitleTextView = findViewById(R.id.productTitle);
        TextView productPriceTextView = findViewById(R.id.productPrice);

        productImageView.setImageResource(productImage);
        productTitleTextView.setText(productName);
        productPriceTextView.setText(productPrice);

    }


    // Método para validar la información de la tarjeta
    private boolean isValidCardInfo(String cardNumber, String cardHolderName, String expDate, String cvv) {
        // Verifica la longitud del número de tarjeta
        return cardNumber.length() == 16 &&
                // Verifica el formato de la fecha de expiración
                expDate.matches("\\d{2}/\\d{2}") &&
                // Verifica la longitud del CVV
                cvv.length() == 3;
    }

    // Método para simular una transacción exitosa
    private void simulatePayment() {
        // Aquí puedes implementar la lógica para procesar el pago
        // En este ejemplo, simplemente mostraremos un mensaje de pago exitoso
        Toast.makeText(PagoActivity.this, "¡Pago exitoso!", Toast.LENGTH_SHORT).show();
    }
}







