package com.example.e01_introduccion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaración de elementos
    private EditText inp_numero;
    private Button btn_action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculando input
        inp_numero=(EditText) findViewById(R.id.inp_numero);
        inp_numero.setText("Jorge"); //Define el texto que se mostrará
    }

    //Sirve para detectar cuando se pulse el botón
    public void botonPresionado(View elementoVista){
        String texto=inp_numero.getText().toString();
        Toast mensajeMostrar= Toast.makeText(getApplicationContext(),texto,Toast.LENGTH_LONG);//Sirve para mostrar mensajes en el dispositivo.
        mensajeMostrar.show(); //Muestra el mensaje
    }
}
