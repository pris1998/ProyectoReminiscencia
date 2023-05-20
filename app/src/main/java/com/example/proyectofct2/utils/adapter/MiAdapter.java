package com.example.proyectofct2.utils.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofct2.R;
import com.example.proyectofct2.utils.modelo.Paciente;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class MiAdapter extends FirestoreRecyclerAdapter<Paciente,MiAdapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MiAdapter(@NonNull FirestoreRecyclerOptions<Paciente> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Paciente paciente) {
        //Aqui llamamos a los elementos a mostrar (name,surname)
        //lo están cogiendo de la base da datos
        holder.name.setText(paciente.getName());
        holder.surname.setText(paciente.getSurname());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Enseñe los datos (Esta conectado con la vista y su formato)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_myadapter,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name ,surname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //pasamos cada uno de ellos Y ESTÁN VINCULADOS AL LUGAR DONDE SE MUESTRAN
            name = itemView.findViewById(R.id.recName);
            surname = itemView.findViewById(R.id.recSurname);

        }
    }
}
