package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Pregunta16 extends AppCompatActivity implements View.OnClickListener {
    Button a, b, c, siguien;
    double calificacion = 0;
    Intent i, recibe;
    Bundle bolsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta16);
        i = new Intent(Pregunta16.this, Pergunta17.class);
        a = (Button)findViewById(R.id.a16);
        b = (Button)findViewById(R.id.b16);
        c = (Button)findViewById(R.id.c16);
        siguien = (Button)findViewById(R.id.siguiente16);
        try {
            recibe = getIntent();
            bolsa = recibe.getExtras();
            calificacion = bolsa.getDouble("calificacion");
        }catch (Exception e){
            Toast.makeText(this, "Error al recibir datos...", Toast.LENGTH_LONG).show();

        }
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        siguien.setOnClickListener(this);
        siguien.setEnabled(false);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a16:
                calificacion -= 25;
                a.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.b16://Respuesta correcta
                calificacion += 100;
                b.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.c16:
                calificacion -= 25;
                c.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.siguiente16:
                startActivity(i);
                break;
            default:
                break;
        }
        i.putExtra("calificacion", calificacion);
    }
    public void deshabilitar(){
        //a.setBackgroundColor(Color.CYAN);
        //b.setBackgroundColor(BackgroundColorSpan.PARCELABLE_WRITE_RETURN_VALUE);
        //c.setBackgroundColor(BackgroundColorSpan.PARCELABLE_WRITE_RETURN_VALUE);
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        siguien.setEnabled(true);
    }
    @Override
    public void onBackPressed(){

    }
}
