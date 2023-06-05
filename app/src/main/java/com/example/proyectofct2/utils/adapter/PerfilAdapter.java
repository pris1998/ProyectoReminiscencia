package com.example.proyectofct2.utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofct2.R;
import com.example.proyectofct2.utils.modelo.Paciente;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PerfilAdapter extends FirestoreRecyclerAdapter<Paciente, PerfilAdapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PerfilAdapter(@NonNull FirestoreRecyclerOptions<Paciente> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Paciente paciente) {
        holder.name.setText(paciente.getName());
        holder.surname.setText(paciente.getSurname());
        holder.fecha_nacimiento.setText(paciente.getFecha_nacimiento());
        holder.genero.setText(paciente.getGenero());
        holder.direccion.setText(paciente.getDireccion());
        holder.telContacto.setText(paciente.getTelContacto());


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myadapter_paciente,parent,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView surname;
        TextView fecha_nacimiento;
        TextView genero;
        TextView direccion;
        TextView telContacto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtNamePaciente);
            surname = itemView.findViewById(R.id.txtApellidoPaciente);
            fecha_nacimiento = itemView.findViewById(R.id.txtfecha_nacimientoPaciente);
            genero = itemView.findViewById(R.id.txtgenero);
            direccion = itemView.findViewById(R.id.txtdireccionPaciente);
            telContacto = itemView.findViewById(R.id.txttelfContactoPaciente);

        }
    }
}
