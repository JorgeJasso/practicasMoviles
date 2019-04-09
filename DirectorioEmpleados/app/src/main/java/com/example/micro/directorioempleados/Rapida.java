package com.example.micro.directorioempleados;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class Rapida extends Fragment {

    private ImageView img;
    private TextView txtNombre;
    private TextView txtApellidos;
    private TextView txtTelefono;
    private TextView txtNumNomina;
    private TextView txtPuesto;
    private TextView txtStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rapida, container, false);
        asignarDatos(view);
        return view;
    }


    private void asignarDatos(View view) {
        img = view.findViewById(R.id.imagen);



        txtNombre = view.findViewById(R.id.txtNombre);
        txtNombre.setText(Vistas.empleado.get(0).toString());
        txtApellidos = view.findViewById(R.id.txtApellidos);
        txtApellidos.setText(Vistas.empleado.get(2).toString());
        txtTelefono = view.findViewById(R.id.txtTelefono);
        txtTelefono.setText(Vistas.empleado.get(4).toString());
        txtNumNomina = view.findViewById(R.id.txtNumNomina);
        txtNumNomina.setText(Vistas.empleado.get(9).toString());
        txtPuesto = view.findViewById(R.id.txtPuesto);
        txtPuesto.setText(Vistas.empleado.get(11).toString());
        txtStatus = view.findViewById(R.id.txtStatus);
        txtStatus.setText(Vistas.empleado.get(16).toString());
    }
}