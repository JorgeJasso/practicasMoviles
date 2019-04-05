 package com.example.micro.directorioempleados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irAdministrar(View vista){
        Intent intent=new Intent(this,Acciones.class);
        startActivity(intent);
    }

     public void irVistas(View vista){
         Intent intent=new Intent(this,Vistas.class);
         startActivity(intent);
     }
}
