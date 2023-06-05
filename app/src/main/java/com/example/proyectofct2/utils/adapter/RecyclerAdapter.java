package com.example.proyectofct2.utils.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofct2.R;
import com.example.proyectofct2.utils.InformationPatient;
import com.example.proyectofct2.utils.modelo.Paciente;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
    Context context;
    public List<Paciente> listaPacientes;


    public void setFilterPaciente(List<Paciente> filterPacientes){
        this.listaPacientes = filterPacientes;
        notifyDataSetChanged();
    }

    public RecyclerAdapter(Context context, List<Paciente> listaPacientes) {
        this.context = context;
        this.listaPacientes = listaPacientes;
    }



    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_myadapter,parent,false);
        RecyclerHolder recyclerHolder = new RecyclerHolder(view);
        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerHolder holder, int position) {
        Paciente paciente = listaPacientes.get(position);
        holder.name.setText(paciente.getName());
        holder.surname.setText(paciente.getSurname());

        //Una vez que pinches en uno de los CardView te lleva directamente a la actividad solicitada
        holder.contenedorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cambiar luego tengo Information y PerfilActivity repetido cambiar
                Intent intent = new Intent(context, InformationPatient.class);
                intent.putExtra("Name",listaPacientes.get(holder.getBindingAdapterPosition()).getName());
                intent.putExtra("Surname",listaPacientes.get(holder.getBindingAdapterPosition()).getName());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPacientes.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        TextView name , surname;
        CardView contenedorCard;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            //los datos
            name = itemView.findViewById(R.id.recName);
            surname = itemView.findViewById(R.id.recSurname);

            //el contenedor CardView
            contenedorCard = itemView.findViewById(R.id.recCargV);
        }
    }
}
