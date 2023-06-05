package com.example.proyectofct2.utils.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofct2.R;
import com.example.proyectofct2.informacion_doctores.Dieta;
import com.example.proyectofct2.informacion_doctores.EditActivity;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class RecyclerDieta extends FirestoreRecyclerAdapter<Dieta,RecyclerDieta.ViewHolder> {
    Activity activity;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public RecyclerDieta(@NonNull FirestoreRecyclerOptions<Dieta> options, Activity activity) {

        super(options);
        this.activity = activity;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Dieta dieta) {

        DocumentSnapshot documentReference = getSnapshots().getSnapshot(holder.getBindingAdapterPosition());
        String idDieta = documentReference.getId();

        holder.tipo.setText(dieta.getTipo());
        //holder.alimentos.setText((CharSequence) dieta.getAlimento());
        holder.peso.setText(dieta.getPeso());
        holder.estatura.setText(dieta.getEstatura());

        holder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, EditActivity.class);
                intent.putExtra("dietaId",idDieta);
                activity.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_dieta,parent,false);

        return new ViewHolder(v);
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView tipo;
        TextView alimentos;
        TextView peso;
        TextView estatura;
        Button btnEditar;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tipo = itemView.findViewById(R.id.txtTipoDieta);
            //alimentos = itemView.findViewById(R.id.txtAlimentosDieta);
            peso = itemView.findViewById(R.id.txtPesoDieta);
            estatura = itemView.findViewById(R.id.txtEstaturaDieta);
            btnEditar = itemView.findViewById(R.id.btnEditar);
        }
    }
}
