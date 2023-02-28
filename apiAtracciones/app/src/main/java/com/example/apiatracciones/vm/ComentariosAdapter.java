package com.example.apiatracciones.vm;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.apiatracciones.R;
import com.example.apiatracciones.datos.Comentarios;
import com.example.apiatracciones.datos.DatosConComentario;

import java.util.ArrayList;
import java.util.List;

public class ComentariosAdapter extends RecyclerView.Adapter<ComentariosAdapter.ComentariosViewHolder> {
    private List<Comentarios> results = new ArrayList<>();



    @NonNull
    @Override
    public ComentariosAdapter.ComentariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comentarios_holder, parent, false);
        return new ComentariosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentariosAdapter.ComentariosViewHolder holder, int position) {
        Comentarios datosConComentario = results.get(position);
        holder.textoComentario.setText(datosConComentario.getTexto());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<Comentarios> data) {
        this.results = data;
        notifyDataSetChanged();
    }
    public List<Comentarios> getResults() {
        return results;
    }

    public class ComentariosViewHolder extends RecyclerView.ViewHolder {
        private TextView urlComentario;
        private TextView textoComentario;
        private TextView atraccionComentario;

        public ComentariosViewHolder(@NonNull View itemView) {
            super(itemView);
            urlComentario = itemView.findViewById(R.id.tvUrlComentario);
            textoComentario = itemView.findViewById(R.id.tvTextoComentario);
            atraccionComentario = itemView.findViewById(R.id.tvAtraccionComentario);

        }
    }

}
