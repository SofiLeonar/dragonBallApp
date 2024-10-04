package com.example.leonardellidragonball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Preguntas extends AppCompatActivity {
    private TextView textPregunta;
    private RadioButton respuesta1, respuesta2, respuesta3, respuesta4;
    private ImageView enemigo;
    private Button preguntaBoton;
    private String nombre;
    private RadioGroup opcionesGroup;

    private String[] preguntas={
            "¿Cómo murió el rey Vegetta?",
            "¿Quién entrenó a Goku en el otro mundo después de su muerte en la saga de los Saiyans?",
            "¿Cuál fue el primer opening?",
            "¿Cuál fue la técnica que derrotó a Majin Buu definitivamente?",
            "¿Quién le enseñó a Goku la técnica del Kamehameha?",
            "¿Cómo obtiene Trunks del futuro su espada?",
            "¿Quién creó las primeras esferas del dragón en la tierra?"
    };

    private String[][] opciones = {
            {"En una explosión accidental", "Luchando contra Goku", "A manos de Freezer", "A manos de Cell"},
            {"Shenron", "Mr. Popo", "Kaiosama del norte", "El maestro Roshi"},
            {"Fantastica aventura", "El poder nuestro es", "Blue Bird", "Cha-La Head-Cha-La"},
            {"Kamehameha", "Super Genkidama", "Makankosappo", "Fusión Potara"},
            {"Kaiosama del norte", "Krillin", "El maestro Roshi", "Vegetta"},
            {"Se la quita a un oponente", "La encuentra en una cueva", "Se la da Bulma", "Se la da Tapion"},
            {"El gran patriarca Namekiano", "Shenron", "El maestro Karin", "Kami-Sama"}
    };

    private int[] respuestasCorrectas = {2, 2, 0, 1, 2, 3, 3};


    private int[] imagenesEnemigos = {
            R.drawable.enemigo1,
            R.drawable.enemigo2,
            R.drawable.enemigo3,
            R.drawable.enemigo4,
            R.drawable.enemigo5,
            R.drawable.enemigo6,
            R.drawable.enemigo7
    };

    private int preguntaActual = 0;
    private int correctas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preguntas);

        nombre = getIntent().getStringExtra("nombre_key");
        textPregunta = findViewById(R.id.textPregunta);
        respuesta1 = findViewById(R.id.respuesta1);
        respuesta2 = findViewById(R.id.respuesta2);
        respuesta3 = findViewById(R.id.respuesta3);
        respuesta4 = findViewById(R.id.respuesta4);
        enemigo = findViewById(R.id.enemigo);
        preguntaBoton = findViewById(R.id.preguntaBoton);
        opcionesGroup = findViewById(R.id.opcionesGroup);

        actualizarPregunta();

        preguntaBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!respuesta1.isChecked() && !respuesta2.isChecked() && !respuesta3.isChecked() && !respuesta4.isChecked()) {
                    Toast.makeText(Preguntas.this, "Por favor, selecciona una respuesta.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (respuestaCorrectaSeleccionada()) {
                    correctas++;
                    Toast.makeText(Preguntas.this, "Respuesta correcta.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Preguntas.this, "Respuesta incorrecta.", Toast.LENGTH_SHORT).show();

                }if (preguntaActual < preguntas.length - 1){
                    preguntaActual++;
                    actualizarPregunta();
                } else {
                    mostrarResultado();
                }
            }
        });

    }
    private void actualizarPregunta(){
        textPregunta.setText(preguntas[preguntaActual]);
        respuesta1.setText(opciones[preguntaActual][0]);
        respuesta2.setText(opciones[preguntaActual][1]);
        respuesta3.setText(opciones[preguntaActual][2]);
        respuesta4.setText(opciones[preguntaActual][3]);
        enemigo.setImageResource(imagenesEnemigos[preguntaActual]);

        opcionesGroup.clearCheck();
    }


    private boolean respuestaCorrectaSeleccionada() {
        if (respuesta1.isChecked() && respuestasCorrectas[preguntaActual] == 0) {
            return true;
        } else if (respuesta2.isChecked() && respuestasCorrectas[preguntaActual] == 1) {
            return true;
        } else if (respuesta3.isChecked() && respuestasCorrectas[preguntaActual] == 2) {
            return true;
        } else return respuesta4.isChecked() && respuestasCorrectas[preguntaActual] == 3;
    }

    private void mostrarResultado() {
        Intent intent = new Intent(Preguntas.this, Resultado.class);
        intent.putExtra("correctas", correctas);
        intent.putExtra("nombre_key", nombre);
        boolean gano = correctas == preguntas.length;
        intent.putExtra("gano", gano);
        startActivity(intent);
        finish();
    }

}