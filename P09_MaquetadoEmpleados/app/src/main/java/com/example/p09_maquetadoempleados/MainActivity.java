package com.example.p09_maquetadoempleados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView inpBuscar;
    private TextView txtEmpleados;
    private ArrayList<Empleados> listaEmpleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vincular();
    }

    private void vincular() {
        inpBuscar = findViewById(R.id.inpBusqueda);
        txtEmpleados = findViewById(R.id.txtEmpleados);
        listaEmpleados = new ArrayList<>();

        if (getIntent().hasExtra("listaEmpleados")) {
            //vincularlo con la lista
            this.listaEmpleados = (ArrayList<Empleados>) getIntent().getExtras().getSerializable("listaEmpleados");
        }
        this.muestraEmpleados();
    }

    private void muestraEmpleados() {
        //Validar si hay personas registradas
        if (this.listaEmpleados.isEmpty()) { //Si esta vacio
            txtEmpleados.setText("No hay empleados registrados");
        } else {
            String lista = "";
            for (Empleados empleado : this.listaEmpleados) {
                lista += empleado.getNombre() + " " + empleado.getApellidoP() + " " + empleado.getApellidoM() + " " + empleado.getEdad() + "\n";
            }
            txtEmpleados.setText(lista);
        }
    }

    public void registrar(View vista) {
        Intent registro = new Intent(this, registros.class);
        registro.putExtra("listaEmpleados", this.listaEmpleados);
        startActivity(registro);
    }

    public void buscar(View vista){
        if(this.listaEmpleados.isEmpty()){
            Toast.makeText(this,"No hay elementos en la lista",Toast.LENGTH_LONG).show();
        }else{
            String encontrados=this.filtrarPersonas();
            if(encontrados.length()>0){
                txtEmpleados.setText(encontrados);
            }else{
                Toast.makeText(this,"No se encontraron coincidencias",Toast.LENGTH_LONG).show();
                this.muestraEmpleados();
            }
        }
    }

    private String filtrarPersonas(){
        String coincidencias="";
        return coincidencias;
    }
}
