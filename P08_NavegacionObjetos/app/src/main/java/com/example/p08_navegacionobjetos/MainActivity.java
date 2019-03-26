package com.example.p08_navegacionobjetos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText lN;
    private EditText lA;
    private String nombre;
    private String apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View vista){
        lN= findViewById(R.id.nombre);
        nombre=lN.getText().toString();

        lA=findViewById(R.id.apellido);
        apellido=lA.getText().toString();

        Intent intent=new Intent(this,Main2Activity.class);

        intent.putExtra("nombre","Jorge"); //Se enviarà esta información al nuevo activity
        startActivity(intent); //Se dirige al activity
    }
}
