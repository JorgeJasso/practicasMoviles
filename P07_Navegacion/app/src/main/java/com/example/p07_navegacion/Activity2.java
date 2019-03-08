package com.example.p07_navegacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String nombre=getIntent().getExtras().getString("nombre"); //Obtiene el valor que fue enviado
        Toast mensajeMostrar= Toast.makeText(getApplicationContext(),nombre,Toast.LENGTH_LONG);
        mensajeMostrar.show();
    }

    public void activity(View vista){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
