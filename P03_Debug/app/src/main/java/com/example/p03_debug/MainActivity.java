package com.example.p03_debug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

/*
Tipos de pruebas
     * unitarias = Esta orientado a funciones o métodos.
     * integración = Se desarrolla pruebas para juntar partes del individuales de un programa.
     * interoperabilidad = Para modulos.
     * componente = Son las pruebas realizadas para comprobar el funcionamiento de los componentes (botones,txt,listas,etc).
     * caja blanca = Esta muy ligada a todos los conceptos anteriores, ya que se realizan pruebas para el código (entradas, resultados esperados).
     * caja negra = Se verifica si hace lo que tiene que hacer el programa, no importa el código (importa si funciona o no).
     * funcionales = Se realizan pruebas a las funciones.
*/

public class MainActivity extends AppCompatActivity {

    private int nCalificaciones=10;
    private int calificaciones[]=new int[nCalificaciones];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random aleatorio=new Random();
        for(int i=0;i<nCalificaciones;i++){
            calificaciones[i]=aleatorio.nextInt(10)+1;
        }
    }
}
