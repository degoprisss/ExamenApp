package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Pregunta5 extends AppCompatActivity implements View.OnClickListener {
    Button a, b, c, siguien;
    double calificacion = 0;
    Intent i, recibe;
    Bundle bolsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta5);
        i = new Intent(Pregunta5.this, Pregunta6.class);
        a = (Button)findViewById(R.id.a5);
        b = (Button)findViewById(R.id.b5);
        c = (Button)findViewById(R.id.c5);
        siguien = (Button)findViewById(R.id.siguiente5);
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
            case R.id.a5:
                calificacion -= 25;
                a.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.b5:
                calificacion += 100;//Respuesta correcta
                b.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.c5:
                calificacion -= 25;
                c.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.siguiente5:
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
