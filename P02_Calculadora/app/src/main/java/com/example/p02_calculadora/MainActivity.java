package com.example.p02_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private boolean numIngresado;
    private boolean primeraOperacion;
    private double numero1;
    private double numero2;
    private double resultado;
    private String operador;
    private EditText decimales;
    private TextView display;
    private final int[] idBotones={
            R.id.bPorcentaje,R.id.bPotencia,
            R.id.b7,R.id.b8,R.id.b9,
            R.id.b4,R.id.b5,R.id.b6,R.id.bMultiplicar,R.id.bDividir,
            R.id.b1,R.id.b2,R.id.b3,R.id.bSumar,R.id.bRestar,
            R.id.b0,R.id.bPunto,R.id.bANS,R.id.bIgual};
    private final String[] valores={
            "%","^",
            "7","8","9",
            "4","5","6","X","/",
            "1","2","3","+","-",
            "0",".","ANS","="};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarValores();
    }

    private void iniciarValores(){
        numIngresado=false;
        primeraOperacion=true;
        decimales=(EditText)findViewById(R.id.txtDecimales);
        display=(TextView)findViewById(R.id.display);
    }

    public void botonPresionado(View boton){
        for(int i=0;i<idBotones.length;i++){
            if(idBotones[i]==boton.getId()){
                if(valores[i].equals("%") || valores[i].equals("^") || valores[i].equals("X") || valores[i].equals("/") || valores[i].equals("+") || valores[i].equals("-") || valores[i].equals("=")){
                    operacion(display.getText().toString(),valores[i]);
                }else{
                    if(!primeraOperacion && !numIngresado){
                        display.setText(valores[i]);
                    }else{
                        display.setText(display.getText()+valores[i]);
                    }
                    numIngresado=true;
                }
                break;
            }
        }
    }

    private void operacion(String numero,String operador){
        if(numIngresado){
            numIngresado=false;
            try{
                if(primeraOperacion){
                    numero1=Double.parseDouble(numero);
                    primeraOperacion=false;
                }else{
                    numero2=Double.parseDouble(numero);
                    operar(this.operador);
                }
            }catch (Exception e){
                mensajeEmergente("Ingrese un valor numerico");
            }
        }
        this.operador=operador;
    }

    private void operar(String operador){
        switch (operador){
            case "%":
                resultado=(numero1*numero2)/100;
                break;
            case "^":
                resultado=Math.pow(numero1,numero2);
                break;
            case "X":
                resultado=numero1*numero2;
                if(numero2==0){
                    mensajeEmergente("No se puede dividir entre 0");
                    primeraOperacion=true;
                    display.setText("");
                }
                break;
            case "/":
                resultado=numero1/numero2;
                break;
            case "+":
                resultado=numero1+numero2;
                break;
            case "-":
                resultado=numero1-numero2;
                break;
        }
        mostrarCantidadDecimales(decimales.getText().toString());
        numero1=resultado;
    }

    public void borrar(View boton){
        if(boton.getId()==R.id.bDEL){
            String texto=display.getText().toString();
            texto=texto.substring(0, texto.length()-1);
            display.setText(texto);
        }else{
            primeraOperacion=true;
            display.setText("");
        }
    }

    public void getANS(View boton){
        display.setText(resultado+"");
    }

    public void factorial(View boton){
        try{
            int n=Integer.parseInt(display.getText().toString());
            resultado=1;
            for(int i=n;i>1;i--){
                resultado*=i;
            }
            mostrarCantidadDecimales("");
        }catch(Exception e){
            mensajeEmergente("Error con el factorial");
        }
    }

    private void mostrarCantidadDecimales(String valor){
        if(valor.equals("") || valor.equals("0")){
            int temp= (int) resultado;
            display.setText(temp+"");
        }else{
            byte nDecimales=Byte.parseByte(valor);
            String cadenaFormato="#.";
            for(int i=0;i<nDecimales;i++){
                cadenaFormato+="0";
            }
            DecimalFormat df = new DecimalFormat(cadenaFormato);
            resultado=Double.parseDouble(df.format(resultado));
            display.setText(resultado+"");
        }
    }

    private void mensajeEmergente(String mensaje){
        Toast mensajeMostrar= Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG);
        mensajeMostrar.show();
    }
}