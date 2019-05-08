package com.example.p12_conexionbasedatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.p12_conexionbasedatos.Modelo.Categoria;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Categoria c1=new Categoria();
        c1.setID(1);
        c1.setCategoria("Refresco");
        c1.save(this);

    }
}
