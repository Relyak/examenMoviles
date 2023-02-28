package com.example.chucknorrisapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.chucknorrisapi.data.Info;
import com.example.chucknorrisapi.mv.NorrisAdapter;
import com.example.chucknorrisapi.mv.NorrisViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    NorrisViewModel nVm;
    NorrisAdapter adapter;
    Button btnNuevo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycler);
        btnNuevo=findViewById(R.id.btnNuevo);
        //coge mi adaptador y carga los datos del adaptador en el recycler
        adapter= new NorrisAdapter();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        //view model
        nVm=new ViewModelProvider(this).get(NorrisViewModel.class);
        //doy sentido a todo, view model entra a mi clase viewmodel
        nVm.init();//le da valor a objetos que usare mas adelante
        btnNuevo.setOnClickListener((v)->{
            //ejecutaPeticion
            nVm.obtenerJoke();
        });
        nVm.getJokeMLD().observe(this,(dato)->{
            ArrayList <Info> lista = new ArrayList<>();
            lista.add(dato);
            adapter.setResults(lista);
        });


    }
}