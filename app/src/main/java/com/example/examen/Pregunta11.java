package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Pregunta11 extends AppCompatActivity implements View.OnClickListener {
    Button a, b, c, siguien;
    double calificacion = 0;
    Intent i, recibe;
    Bundle bolsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta11);
        i = new Intent(Pregunta11.this, Pregunta12.class);
        a = (Button)findViewById(R.id.a11);
        b = (Button)findViewById(R.id.b11);
        c = (Button)findViewById(R.id.c11);
        siguien = (Button)findViewById(R.id.siguiente11);
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
            case R.id.a11:
                calificacion -= 25;
                a.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.b11:
                calificacion -= 25;
                b.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.c11:
                calificacion += 100;//Respuesta correcta
                c.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.siguiente11:
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
