package com.example.proyectofct2.utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofct2.R;
import com.example.proyectofct2.informacion_doctores.Medicacion;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class RecyclerMedicacion extends FirestoreRecyclerAdapter<Medicacion,RecyclerMedicacion.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public RecyclerMedicacion(@NonNull FirestoreRecyclerOptions<Medicacion> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Medicacion medicina) {
        holder.name_medicamento.setText(medicina.getName_medicamento());
        holder.dosis.setText(medicina.getDosis());
        holder.frecuencia.setText(medicina.getFrecuencia());
        holder.via_administracion.setText(medicina.getVia_administracion());
        holder.duracion.setText(medicina.getDuracion());
        holder.intrucciones.setText(medicina.getIntrucciones());

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_medicinas,parent,false);

        return new ViewHolder(v);
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView name_medicamento;
        TextView dosis;
        TextView frecuencia;
        TextView via_administracion;
        TextView duracion;
        TextView intrucciones;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_medicamento = itemView.findViewById(R.id.txtName_medicamento);
            dosis = itemView.findViewById(R.id.txtdosis);
            frecuencia = itemView.findViewById(R.id.txtfrecuencia);
            via_administracion = itemView.findViewById(R.id.txtvia_administracion);
            duracion = itemView.findViewById(R.id.txtduracion);
            intrucciones = itemView.findViewById(R.id.txtintrucciones);

        }
    }
}

