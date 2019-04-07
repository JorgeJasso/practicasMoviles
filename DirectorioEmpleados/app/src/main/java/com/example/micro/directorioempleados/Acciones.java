package com.example.micro.directorioempleados;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Acciones extends AppCompatActivity {

    EditText inpNombre, inpApellidos, inpDireccion, inpTelefono, inpCorreo, inpNacionalidad, inpEstadoCivil,
            inpEnfermedades, inpNumNomina, inpArea, inpPuesto, inpRFC, inpNSS, inpEmergencia, inpEscolaridad, inpStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acciones);
        vincularElementos();
    }

    private void vincularElementos() {
        inpNombre = (EditText) findViewById(R.id.inpNombre);
        inpApellidos = (EditText) findViewById(R.id.inpApellidos);
        inpDireccion = (EditText) findViewById(R.id.inpDireccion);
        inpTelefono = (EditText) findViewById(R.id.inpTelefono);
        inpCorreo = (EditText) findViewById(R.id.inpCorreo);
        inpNacionalidad = (EditText) findViewById(R.id.inpNacionalidad);
        inpEstadoCivil = (EditText) findViewById(R.id.inpEstadoCivil);
        inpEnfermedades = (EditText) findViewById(R.id.inpEnfermedades);
        inpNumNomina = (EditText) findViewById(R.id.inpNumNomina);
        inpArea = (EditText) findViewById(R.id.inpArea);
        inpPuesto = (EditText) findViewById(R.id.inpPuesto);
        inpRFC = (EditText) findViewById(R.id.inpRFC);
        inpNSS = (EditText) findViewById(R.id.inpNSS);
        inpEmergencia = (EditText) findViewById(R.id.inpEmergencia);
        inpEscolaridad = (EditText) findViewById(R.id.inpEscolaridad);
        inpStatus = (EditText) findViewById(R.id.inpStatus);
    }

    public void registrarEmpleado(View view) {
        Conexion conexion = new Conexion(this, "empleadosDB", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_IMAGEN,"a");
        values.put(Utilidades.CAMPO_NOMBRE, inpNombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOS, inpApellidos.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCION, inpDireccion.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, inpTelefono.getText().toString());
        values.put(Utilidades.CAMPO_CORREO, inpCorreo.getText().toString());
        values.put(Utilidades.CAMPO_NACIONALIDAD, inpNacionalidad.getText().toString());
        values.put(Utilidades.CAMPO_ESTADO_CIVIL, inpEstadoCivil.getText().toString());
        values.put(Utilidades.CAMPO_ENFERMEDADES, inpEnfermedades.getText().toString());
        values.put(Utilidades.CAMPO_NUM_NOMINA, inpNumNomina.getText().toString());
        values.put(Utilidades.CAMPO_AREA, inpArea.getText().toString());
        values.put(Utilidades.CAMPO_PUESTO, inpPuesto.getText().toString());
        values.put(Utilidades.CAMPO_RFC, inpRFC.getText().toString());
        values.put(Utilidades.CAMPO_NSS, inpNSS.getText().toString());
        values.put(Utilidades.CAMPO_CONTACTO_EMERGENCIA, inpEmergencia.getText().toString());
        values.put(Utilidades.CAMPO_ESCOLARIDAD, inpEscolaridad.getText().toString());
        values.put(Utilidades.CAMPO_STATUS, inpStatus.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_EMPLEADO,Utilidades.CAMPO_NUM_NOMINA,values);
        Toast.makeText(getApplicationContext(),"Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }

    public void modificarEmpleado(View view) {

    }

    public void eliminarEmpleado(View view) {

    }

    public void irInicio(View vista) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
