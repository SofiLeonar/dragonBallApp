package com.example.leonardellidragonball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resultado extends AppCompatActivity {

    private TextView textMensajeFinal;
    private TextView cantidadCorrectas;
    private ImageView krillin;
    private Button volverJugar;
    private int aciertos;
    private String nombre;
    private Button volverAlInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        textMensajeFinal = findViewById(R.id.textMensajeFinal);
        cantidadCorrectas = findViewById(R.id.cantidadCorrectas);
        krillin = findViewById(R.id.krillin);
        volverJugar = findViewById(R.id.volverJugar);
        aciertos = getIntent().getIntExtra("correctas", 0);
        nombre = getIntent().getStringExtra("nombre_key");
        volverAlInicio = findViewById(R.id.volverAlInicio); // Inicializar el botón



        actualizarResultados();

        volverJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resultado.this, Preguntas.class);
                intent.putExtra("nombre_key", nombre); // Pasar el nombre a la actividad de preguntas
                startActivity(intent);
                finish();
            }
        });

        volverAlInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resultado.this, Inicio.class); // Volver a la pantalla de inicio
                startActivity(intent);
                finish();
            }
        });
    }

    private void actualizarResultados(){
        if (aciertos == 7) {
            textMensajeFinal.setText("¡Felicitaciones, " + nombre +"! Has conseguido todas las esferas y revivido a Krillin. ¡Gracias por tu ayuda!");
            krillin.setImageResource(R.drawable.krillinfeliz);
        } else {
            textMensajeFinal.setText(nombre + ", no hemos conseguido todas las esferas y Krillin sigue esperando su oportunidad de volver... ¡Pero no te preocupes! Puedes intentarlo de nuevo y salvarlo. ¡No te rindas!");
            krillin.setImageResource(R.drawable.krillintriste);
        }
        cantidadCorrectas.setText("Juntaste " + aciertos + " esferas.");
    }

}