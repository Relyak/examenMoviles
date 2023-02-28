package com.example.apijorgeprimos.vm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apijorgeprimos.R;
import com.example.apijorgeprimos.datos.Numeros;

import java.util.ArrayList;
import java.util.List;

public class PrimosAdapter extends RecyclerView.Adapter<PrimosAdapter.PrimosViewHolder> {
    private List<Integer> primos=new ArrayList<>();

    @NonNull
    @Override
    public PrimosAdapter.PrimosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.primo_row,parent,false);
        return new PrimosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PrimosAdapter.PrimosViewHolder holder, int position) {
        Integer primo=primos.get(position);
        holder.tvPrimo.setText(primo.toString());
    }

    @Override
    public int getItemCount() {
        return primos.size();
    }
    public void setResults(List<Integer>primos){
        this.primos=primos;
        notifyDataSetChanged();
    }

    public class PrimosViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPrimo;

        public PrimosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPrimo=itemView.findViewById(R.id.tvPrimo);
        }
    }
}
