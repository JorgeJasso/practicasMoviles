package com.example.p11_documentacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayList lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=new ArrayList();
    }

    /*
    * Método utilizado para asignar n valores aleatorios a una lista entre 1 y 10.
    * @autor: Jasso Torres Jorge Alberto
    * @param:
    * */
    public void asignarValores(View view){
        Random aleatorio=new Random();
        int random;
        for(int i=0;i<10;i++){
            random=aleatorio.nextInt(10)+1;
            lista.add(random);
        }
    }

    public void mostrar(View view,ArrayList lista){
        System.out.println("Valores");
        for(int i=0;i<lista.size();i++){
            System.out.println((i+1)+"="+lista.get(i));
        }
    }
}
