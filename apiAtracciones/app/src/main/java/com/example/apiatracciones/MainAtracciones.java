package com.example.apiatracciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.apiatracciones.vm.AtraccionesAdapter;
import com.example.apiatracciones.vm.AtraccionesViewModel;

public class MainAtracciones extends AppCompatActivity implements AtraccionesAdapter.OnItemClickListener {
    RecyclerView rv;
    AtraccionesViewModel aVm;
    AtraccionesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atracciones);
        rv=findViewById(R.id.recycler);

        adapter= new AtraccionesAdapter();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        //metodo click
        adapter.setmListener(this);
        //view model
        aVm=new ViewModelProvider(this).get(AtraccionesViewModel.class);
        aVm.init();
        aVm.getAtraccionesResponse().observe(this,(dato)->{
            adapter.setResults(dato);
        });
        aVm.getAtracciones();



    }

    @Override
    public void onItemClick(int position) {
        String url=adapter.getResults().get(position).getUrl();
        envio(url);

    }
    public void envio(String url){
       Intent intent = new Intent(this, MainComentario.class);
       intent.putExtra("url",url);
       startActivity(intent);
    }
}