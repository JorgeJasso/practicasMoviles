 package com.example.micro.directorioempleados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {
     private RecyclerView recyclerView;
     private RVEmpleadosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Conexion conexion=new Conexion(this,"empleadosDB",null,1);

        List<Empleados> emp = new ArrayList<>();
        Empleados emp1=new Empleados();
        emp1.setImagen("a");
        emp1.setNombre("Jorge");
        emp1.setApellidos("Jasso");
        emp1.setDireccion("a");
        emp1.setTelefono("a");
        emp1.setCorreo("a");
        emp1.setNacionalidad("a");
        emp1.setEstadoCivil("a");
        emp1.setEnfermedades("a");
        emp1.setNumNomina("jj123");
        emp1.setArea("a");
        emp1.setPuesto("Programador");
        emp1.setRFC("a");
        emp1.setNSS("a");
        emp1.setContactoEmergencia("a");
        emp1.setEscolaridad("a");
        emp1.setStatus("a");
        emp.add(emp1);

        emp1=new Empleados();
        emp1.setImagen("a");
        emp1.setNombre("Araceli");
        emp1.setApellidos("Guzman");
        emp1.setDireccion("a");
        emp1.setTelefono("a");
        emp1.setCorreo("a");
        emp1.setNacionalidad("a");
        emp1.setEstadoCivil("a");
        emp1.setEnfermedades("a");
        emp1.setNumNomina("ag123");
        emp1.setArea("a");
        emp1.setPuesto("Diseñadora");
        emp1.setRFC("a");
        emp1.setNSS("a");
        emp1.setContactoEmergencia("a");
        emp1.setEscolaridad("a");
        emp1.setStatus("a");
        emp.add(emp1);
        recyclerView = findViewById(R.id.rv_empleados);
        adapter = new RVEmpleadosAdapter(this, emp);
        recyclerView.setAdapter(adapter);

        //Asignamos el tipo de layout que queramos a nuestro recyclerview, linear, o cuadricula
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false));*/

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    public void irAdministrar(View vista){
        Intent intent=new Intent(this,Acciones.class);
        startActivity(intent);
    }

     public void irVistas(View vista){
         Intent intent=new Intent(this,Vistas.class);
         startActivity(intent);
     }


}
