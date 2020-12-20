package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;

public class Pruebauno extends AppCompatActivity implements View.OnClickListener {
Button a, b, c, siguien;
 double calificacion = 0;

Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebauno);
        i = new Intent(Pruebauno.this, Pregunta2.class);
        a = (Button)findViewById(R.id.a1);
        b = (Button)findViewById(R.id.b1);
        c = (Button)findViewById(R.id.c1);
        siguien = (Button)findViewById(R.id.siguiente1);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        siguien.setOnClickListener(this);
        siguien.setEnabled(false);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a1:
                calificacion = 25;
                a.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.b1:
                calificacion = 25;
                b.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.c1:
                calificacion = 100;//Respuesta correcta
                c.setBackgroundColor(Color.CYAN);
                deshabilitar();
                break;
            case R.id.siguiente1:
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
