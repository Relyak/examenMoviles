package com.example.chucknorrisapi.mv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chucknorrisapi.R;
import com.example.chucknorrisapi.data.Info;

import java.util.ArrayList;
import java.util.List;

public class NorrisAdapter extends RecyclerView.Adapter<NorrisAdapter.NorrisViewHolder> {
    private List<Info> results =new ArrayList<>();
    @NonNull
    @Override
    public NorrisAdapter.NorrisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.norris_holder,parent,false);
        return new NorrisViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NorrisAdapter.NorrisViewHolder holder, int position) {
        holder.getTvJoke().setText(results.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
    public void setResults(List<Info>data){
        this.results =data;
        notifyDataSetChanged();
    }
    public List<Info> getResults(){
        return results;
    }
    public class NorrisViewHolder extends RecyclerView.ViewHolder{
        TextView tvJoke;

        public NorrisViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJoke=itemView.findViewById(R.id.tvJoke);
        }
        public TextView getTvJoke() {
            return tvJoke;
        }
    }
}
