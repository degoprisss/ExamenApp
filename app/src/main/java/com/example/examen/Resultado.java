package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {
    Button regre;
    TextView text;
    Intent i, recibe;
    Bundle bolsa;
    double calificacion = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);
        regre = (Button)findViewById(R.id.nuevo);
        text = (TextView)findViewById(R.id.resulta);
        i = new Intent(Resultado.this, Inicio.class);

        try {
            recibe = getIntent();
            bolsa = recibe.getExtras();
            calificacion = bolsa.getDouble("calificacion");
            if(calificacion <= 1.45){
                text.setText("El resultado de su examen es de: " + calificacion);
            }else{
                text.setText("El resultado de su examen es de: " + calificacion);
            }

        }catch (Exception e){
            Toast.makeText(this, "Error al recibir datos...", Toast.LENGTH_LONG).show();
        }
        regre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);

            }
        });
    }
}
