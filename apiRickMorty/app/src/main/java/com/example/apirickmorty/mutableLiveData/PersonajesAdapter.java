package com.example.apirickmorty.mutableLiveData;


import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.apirickmorty.DetalleImagen;
import com.example.apirickmorty.R;
import com.example.apirickmorty.api.DatosPersonajesRM;

import java.util.ArrayList;
import java.util.List;

public class PersonajesAdapter extends RecyclerView.Adapter <PersonajesAdapter.PersonajesAdapterResultHolder> {
    List<DatosPersonajesRM> results=new ArrayList<>();
    private OnItemClickListener mListener;
    Context mContext;
    @NonNull
    @Override
    public PersonajesAdapterResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detalle, parent, false);
        return new PersonajesAdapterResultHolder(itemView);
    }
    public PersonajesAdapter(Context context){
        this.mContext=context;
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    @Override
    public void onBindViewHolder(@NonNull PersonajesAdapterResultHolder holder, int position) {
        //cojo mi clase pagina inicial
        DatosPersonajesRM personajes=results.get(position);
        //se la meto al recycler
        holder.tvNombre.setText(personajes.getName());
        holder.tvEstatus.setText(personajes.getStatus());
        holder.tvGender.setText(personajes.getGender());
        holder.tvEspecie.setText(personajes.getSpecies());
        holder.tvId.setText(personajes.getId());
        if (personajes.getImagen() != null) {
            //No hace falta hacer replace ya que es HTTPS
            String imgURL = personajes.getImagen();
            Glide.with(holder.itemView)
                    .load(imgURL)
                    .into(holder.imgPersonaje);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener!=null){
                    Intent intent=new Intent(mContext, DetalleImagen.class);
                    intent.putExtra("id",personajes.getId());
                    Log.d("AAAAAAAAAAAAAAAAAAA",personajes.getId());
                    mContext.startActivity(intent);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return results.size();
    }
    public void setResults(List<DatosPersonajesRM>results){
        this.results=results;
        notifyDataSetChanged();//esto es lo que cambia
    }
    class PersonajesAdapterResultHolder extends RecyclerView.ViewHolder{
        private TextView tvNombre,tvEstatus,tvGender,tvEspecie,tvId;
        private ImageView imgPersonaje;
        public PersonajesAdapterResultHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre= itemView.findViewById(R.id.tvNombre);
            tvEstatus= itemView.findViewById(R.id.tvEstatus);
            tvGender= itemView.findViewById(R.id.tvGender);
            tvId= itemView.findViewById(R.id.tvId);
            tvEspecie= itemView.findViewById(R.id.tvEspecie);
            imgPersonaje= itemView.findViewById(R.id.imgPersonaje);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
