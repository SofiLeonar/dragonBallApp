package com.example.leonardellidragonball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bienvenida extends AppCompatActivity {

    private TextView textViewData;
    private Button comencemosBoton;
    private Button volverAlInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activaity_bienvenida);


        textViewData = findViewById(R.id.bienvenidaText);
        comencemosBoton = findViewById(R.id.comencemosBoton);
        volverAlInicio = findViewById(R.id.volverAlInicio);


        String nombre = getIntent().getStringExtra("nombre_key");
            String data = "Hola, " + nombre +
                    "\nNecesitamos tu ayuda para conseguir las esferas y revivir a Krillin. " ;
            textViewData.setText(data);

        volverAlInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bienvenida.this, Inicio.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void comencemos(View view) {
        Intent intent = new Intent(Bienvenida.this, Preguntas.class);
        String nombre = getIntent().getStringExtra("nombre_key");
        intent.putExtra("nombre_key", nombre);
        startActivity(intent);
    }


    }
