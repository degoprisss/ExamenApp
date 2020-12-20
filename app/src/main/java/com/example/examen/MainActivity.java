package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText user, pass;
Button btnEntrar, btnRegistrar;
daousuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.correo);
        pass=(EditText)findViewById(R.id.pass);
        btnEntrar=(Button)findViewById(R.id.incio);
        btnRegistrar=(Button)findViewById(R.id.regis);
        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao = new daousuario(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.incio:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this, "Error: campos vacíos", Toast.LENGTH_LONG).show();
                }else if(dao.login(u,p)==1){
                    usuario ux = dao.gerUsuario(u, p);
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(MainActivity.this, Inicio.class);
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.regis:
            Intent i=new Intent(MainActivity.this, Registrar.class);
            startActivity(i);
            break;

        }
    }
}
