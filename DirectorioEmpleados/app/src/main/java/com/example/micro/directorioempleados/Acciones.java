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
    Conexion conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acciones);

        conexion = new Conexion(this, "empleadosDB", null, 1);
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
        if (validarLlenado()) {
            if (!validarExistencia()) {
                SQLiteDatabase db = conexion.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(Utilidades.CAMPO_IMAGEN, "a");
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

                db.insert(Utilidades.TABLA_EMPLEADO, Utilidades.CAMPO_NUM_NOMINA, values);
                limpiar();
                Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_LONG).show();
                db.close();
            } else {
                Toast.makeText(this, "El número de nomina ya existe", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Debes ingresar todos los campos", Toast.LENGTH_LONG).show();
        }
    }

    public void modificarEmpleado(View view) {
        if (validarLlenado()) {
            if (validarExistencia()) {
                SQLiteDatabase db = conexion.getWritableDatabase();
                String[] parametros = {inpNumNomina.getText().toString()};

                ContentValues values = new ContentValues();
                values.put(Utilidades.CAMPO_IMAGEN, "a");
                values.put(Utilidades.CAMPO_NOMBRE, inpNombre.getText().toString());
                values.put(Utilidades.CAMPO_APELLIDOS, inpApellidos.getText().toString());
                values.put(Utilidades.CAMPO_DIRECCION, inpDireccion.getText().toString());
                values.put(Utilidades.CAMPO_TELEFONO, inpTelefono.getText().toString());
                values.put(Utilidades.CAMPO_CORREO, inpCorreo.getText().toString());
                values.put(Utilidades.CAMPO_NACIONALIDAD, inpNacionalidad.getText().toString());
                values.put(Utilidades.CAMPO_ESTADO_CIVIL, inpEstadoCivil.getText().toString());
                values.put(Utilidades.CAMPO_ENFERMEDADES, inpEnfermedades.getText().toString());
                values.put(Utilidades.CAMPO_AREA, inpArea.getText().toString());
                values.put(Utilidades.CAMPO_PUESTO, inpPuesto.getText().toString());
                values.put(Utilidades.CAMPO_RFC, inpRFC.getText().toString());
                values.put(Utilidades.CAMPO_NSS, inpNSS.getText().toString());
                values.put(Utilidades.CAMPO_CONTACTO_EMERGENCIA, inpEmergencia.getText().toString());
                values.put(Utilidades.CAMPO_ESCOLARIDAD, inpEscolaridad.getText().toString());
                values.put(Utilidades.CAMPO_STATUS, inpStatus.getText().toString());

                db.update(Utilidades.TABLA_EMPLEADO, values, Utilidades.CAMPO_NUM_NOMINA + "=?", parametros);
                limpiar();
                Toast.makeText(getApplicationContext(), "Empleado actualizado", Toast.LENGTH_LONG).show();
                db.close();
            } else {
                Toast.makeText(this, "El empleado no existe", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Debes ingresar todos los campos", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarEmpleado(View view) {
        if (inpNumNomina.getText().toString().trim().length() > 0) {
            if(validarExistencia()){
                SQLiteDatabase db = conexion.getWritableDatabase();
                String[] parametros = {inpNumNomina.getText().toString()};

                db.delete(Utilidades.TABLA_EMPLEADO, Utilidades.CAMPO_NUM_NOMINA + "?", parametros);
                limpiar();
                Toast.makeText(getApplicationContext(), "Empleado eliminado", Toast.LENGTH_LONG).show();
                db.close();
            }else{
                Toast.makeText(this, "El empleado no existe", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Ingresa el numero de nomina del empleado", Toast.LENGTH_LONG).show();
        }
    }

    public void irInicio(View vista) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void limpiar() {
        inpNombre.setText("");
        inpApellidos.setText("");
        inpDireccion.setText("");
        inpTelefono.setText("");
        inpCorreo.setText("");
        inpNacionalidad.setText("");
        inpEstadoCivil.setText("");
        inpEnfermedades.setText("");
        inpNumNomina.setText("");
        inpArea.setText("");
        inpPuesto.setText("");
        inpRFC.setText("");
        inpNSS.setText("");
        inpEmergencia.setText("");
        inpEscolaridad.setText("");
        inpStatus.setText("");
    }

    private boolean validarLlenado() {
        return inpNombre.getText().toString().trim().length() > 0 &&
                inpApellidos.getText().toString().trim().length() > 0 &&
                inpDireccion.getText().toString().trim().length() > 0 &&
                inpTelefono.getText().toString().trim().length() > 0 &&
                inpCorreo.getText().toString().trim().length() > 0 &&
                inpNacionalidad.getText().toString().trim().length() > 0 &&
                inpEstadoCivil.getText().toString().trim().length() > 0 &&
                inpEnfermedades.getText().toString().trim().length() > 0 &&
                inpNumNomina.getText().toString().trim().length() > 0 &&
                inpArea.getText().toString().trim().length() > 0 &&
                inpPuesto.getText().toString().trim().length() > 0 &&
                inpRFC.getText().toString().trim().length() > 0 &&
                inpNSS.getText().toString().trim().length() > 0 &&
                inpEmergencia.getText().toString().trim().length() > 0 &&
                inpEscolaridad.getText().toString().trim().length() > 0 &&
                inpStatus.getText().toString().trim().length() > 0;
    }

    private boolean validarExistencia() {
        return true;
    }
}
