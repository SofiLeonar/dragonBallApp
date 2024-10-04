package com.example.leonardellidragonball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Inicio extends AppCompatActivity {
    private EditText editTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        editTextNombre = findViewById(R.id.nombreUsuario);
    }
    public void adelante(View view){
        String nombre = editTextNombre.getText().toString();
        Intent intent = new Intent(this, Bienvenida.class);
        intent.putExtra("nombre_key", nombre);
        startActivity(intent);
    }

}
