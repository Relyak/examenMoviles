package com.example.apiatracciones.vm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiatracciones.R;
import com.example.apiatracciones.datos.DatosAtracciones;

import java.util.ArrayList;
import java.util.List;


public class AtraccionesAdapter extends RecyclerView.Adapter<AtraccionesAdapter.AtraccionesViewHolder> {
    private List<DatosAtracciones> results =new ArrayList<>();
    private OnItemClickListener mListener;

    public void setmListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }
    @NonNull
    @Override
    public AtraccionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.atracciones_holder,parent,false);
        return new AtraccionesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AtraccionesAdapter.AtraccionesViewHolder holder, int position) {
        holder.getUrl().setText(results.get(position).getUrl());
        holder.getNombre().setText(results.get(position).getNombre());
        holder.getDescripcion().setText(results.get(position).getDescripcion());
        holder.getOcupantes().setText(String.valueOf(results.get(position).getOcupantes()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    int position=holder.getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION){
                        mListener.onItemClick(position);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
    public void setResults(List<DatosAtracciones>data){
        this.results =data;
        notifyDataSetChanged();
    }
    public List<DatosAtracciones> getResults(){
        return results;
    }
    public class AtraccionesViewHolder extends RecyclerView.ViewHolder{
        private TextView url;
        private TextView nombre;
        private TextView descripcion;
        private TextView ocupantes;


        public AtraccionesViewHolder(@NonNull View itemView) {
            super(itemView);
            url=itemView.findViewById(R.id.tvUrl);
            nombre=itemView.findViewById(R.id.tvNombre);
            descripcion=itemView.findViewById(R.id.tvDesc);
            ocupantes=itemView.findViewById(R.id.tvOcupantes);
        }
        public TextView getUrl() {
            return url;
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getDescripcion() {
            return descripcion;
        }

        public TextView getOcupantes() {
            return ocupantes;
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
