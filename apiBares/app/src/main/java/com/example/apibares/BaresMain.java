package com.example.apibares;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.apibares.Vm.BaresAdapter;
import com.example.apibares.Vm.BaresViewModel;
import com.example.apibares.datos.DatosBares;

import java.util.List;

public class BaresMain extends AppCompatActivity {
    RecyclerView rv;
    Button btnBusca;
    EditText etEstrellas;
    BaresViewModel bVm;
    BaresAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_bares);
        btnBusca=findViewById(R.id.btnBusca);
        etEstrellas=findViewById(R.id.etEstrellas);
        rv=findViewById(R.id.recyclerBares);
        adapter= new BaresAdapter();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);




        bVm=new ViewModelProvider(this).get(BaresViewModel.class);
        bVm.init();
        //observador
        bVm.getBaresResponse().observe(this,(dato)->{
            adapter.setResults(dato);
        });
        btnBusca.setOnClickListener(view ->{
            int estrellas = Integer.parseInt(String.valueOf(etEstrellas.getText()));
            bVm.buscarEstrellas(estrellas);
        });
        bVm.getBares();


    }
}