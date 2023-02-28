package com.example.apiatracciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.apiatracciones.vm.AtraccionesAdapter;
import com.example.apiatracciones.vm.AtraccionesViewModel;
import com.example.apiatracciones.vm.ComentariosAdapter;

public class MainComentario extends AppCompatActivity {
    TextView SNombre, SDescripcion, SOcupantes;
    private RecyclerView lista;
    AtraccionesViewModel vm;
    ComentariosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_comentario);

        lista = findViewById(R.id.recyclerC);
        SNombre = findViewById(R.id.tvNomC);
        SDescripcion = findViewById(R.id.tvDescC);
        SOcupantes = findViewById(R.id.tvOcuC);

        String urlApi = getIntent().getStringExtra("url");

        lista.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ComentariosAdapter();
        lista.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(AtraccionesViewModel.class);
        vm.init();

        vm.getComentariosResponse().observe(this,(data) -> {

            SNombre.setText(data.getNombre());
            SDescripcion.setText(data.getDescripcion());
            SOcupantes.setText(String.valueOf(data.getOcupantes()));
            adapter.setResults(data.getComentarios());

        });

        vm.getComentarios(urlApi);

    }


}