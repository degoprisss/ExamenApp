package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View .OnClickListener{
    EditText us, pas, nom, ap;
    Button reg, can;
    daousuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        us=(EditText)findViewById(R.id.reguser);
        pas=(EditText)findViewById(R.id.regpass);
        nom=(EditText)findViewById(R.id.regnom);
        ap=(EditText)findViewById(R.id.regape);
        reg=(Button)findViewById(R.id.registro);
        can=(Button)findViewById(R.id.cancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);

        dao = new daousuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registro:
                usuario u= new usuario();
                u.setUsuario(us.getText().toString());
                u.setPassword(pas.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setApellido(ap.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this, "Error: Campos vacíos", Toast.LENGTH_LONG).show();
                }else if(dao.insertUsuario(u)){
                    Toast.makeText(this, "Tu registro ha sido exitoso", Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(Registrar.this, MainActivity.class);
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.cancelar:
                Intent i=new Intent(Registrar.this, MainActivity.class);
                startActivity(i);
                finish();
                break;
        }

    }
}
