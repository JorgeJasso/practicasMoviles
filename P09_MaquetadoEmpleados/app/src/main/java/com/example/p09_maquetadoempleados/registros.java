package com.example.p09_maquetadoempleados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class registros extends AppCompatActivity {

    private ArrayList<Empleados> listaEmpleados;
    private EditText nombre;
    private EditText apellidoP;
    private EditText apellidoM;
    private EditText edad;
    private Intent main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        iniciar();
    }

    private void iniciar() {
        nombre = findViewById(R.id.inpNombre);
        apellidoP = findViewById(R.id.inpApellidoP);
        apellidoM = findViewById(R.id.inpApellidoM);
        edad = findViewById(R.id.inpEdad);
        main = new Intent(this, MainActivity.class);
        if (getIntent().hasExtra("listaEmpleados")) {
            //vincularlo con la lista
            this.listaEmpleados = (ArrayList<Empleados>) getIntent().getExtras().getSerializable("listaEmpleados");
        }
    }

    public void crearRegistro(View vista) {
        if (this.validarVacios()) {
            Toast.makeText(this, "Debes ingresar todos los campos", Toast.LENGTH_LONG).show();
        } else {
            Empleados empleado = new Empleados();
            empleado.setNombre(nombre.getText().toString().trim());
            empleado.setApellidoP(apellidoP.getText().toString().trim());
            empleado.setApellidoM(apellidoM.getText().toString().trim());
            empleado.setEdad(Integer.valueOf(edad.getText().toString().trim()));
            listaEmpleados.add(empleado);
            //Después de que se agrega al registro se envia al main
            main.putExtra("listaEmpleado",this.listaEmpleados);
            startActivity(main);
        }
    }

    private boolean validarVacios() {
        if (nombre.getText().toString().trim().length() > 0
                && apellidoP.getText().toString().trim().length() > 0
                && apellidoM.getText().toString().trim().length() > 0
                && edad.getText().toString().trim().length() > 0) {
            return false;
        }
        return  true;
    }

    public void cancelar(View vista) {
        main.putExtra("listaEmpleados", this.listaEmpleados);
        startActivity(main);
    }
}
