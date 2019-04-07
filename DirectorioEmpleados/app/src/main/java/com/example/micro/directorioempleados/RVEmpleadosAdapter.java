package com.example.micro.directorioempleados;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVEmpleadosAdapter extends RecyclerView.Adapter<RVEmpleadosAdapter.RVMessageAdapterViewHolder>{
    private Context context;
    private List<Empleados> listaEmpleados;


    public RVEmpleadosAdapter(Context context, List<Empleados> listaEmpleados) {
        this.context = context;
        this.listaEmpleados = listaEmpleados;
    }

    //Creamos el item principal que se reciclara en cada uno de los elementos
    @NonNull
    @Override
    public RVMessageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Inflamos nuestra vista de item
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_rv_message,
                viewGroup,
                false);

        //Retornamos una instancia del viewholder pasandole como parametro la vista anteriormente creada
        return new RVMessageAdapterViewHolder(view);
    }

    //Se ejecutara por cada elemento de la lista
    @Override
    public void onBindViewHolder(@NonNull RVMessageAdapterViewHolder rvMessageAdapterViewHolder, int i) {
        //Creamos una instancia de tipo "Message" dependiendo del lugar de la lista en el que este
        final Empleados emp = listaEmpleados.get(i);

        //Asignamos a las vistas del viewholder los textos del mensaje en esa posicion
        rvMessageAdapterViewHolder.textViewNonima.setText(emp.getNumNomina());
        rvMessageAdapterViewHolder.textViewNombre.setText(emp.getNombre());
        rvMessageAdapterViewHolder.textViewApellidos.setText(emp.getApellidos());
        rvMessageAdapterViewHolder.textPuesto.setText(emp.getPuesto());

        //Asignamos a ese item en particular un listener para cuando el usuario haga click en el

        rvMessageAdapterViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              
            }
        });
    }

    //Retornamos el tamaño de la lista
    @Override
    public int getItemCount() {
        return listaEmpleados.size();
    }


    public class RVMessageAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNonima;
        TextView textViewNombre;
        TextView textViewApellidos;
        TextView textPuesto;

        public RVMessageAdapterViewHolder(View view) {
            super(view);

            //Instanciamos nuestros objetos que seran buscados segun si id en la vista pasada por el constructor
            textViewNonima = view.findViewById(R.id.tv_nomina);
            textViewNombre = view.findViewById(R.id.tv_nombre);
            textViewApellidos = view.findViewById(R.id.tv_apellidos);
            textPuesto = view.findViewById(R.id.tv_puesto);
        }
    }
}
