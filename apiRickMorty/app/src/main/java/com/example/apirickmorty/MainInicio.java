package com.example.apirickmorty;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apirickmorty.api.DatosPersonajesRM;
import com.example.apirickmorty.api.PaginaInicialRM;
import com.example.apirickmorty.mutableLiveData.PersonajesAdapter;
import com.example.apirickmorty.mutableLiveData.PersonajesViewModel;

public class MainInicio extends AppCompatActivity implements PersonajesAdapter.OnItemClickListener {
    Button btnNext,btnBack;
    RecyclerView personajesRecycler;
    PersonajesViewModel pVm;
    LiveData<PaginaInicialRM> data;
    public static String siguientePagina,volverPagina;
    public static ActivityResultLauncher resultadoLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_inicio);
        btnNext=findViewById(R.id.btnNext);
        btnBack=findViewById(R.id.btnBack);
        personajesRecycler=findViewById(R.id.PersonajesRecycler);

        PersonajesAdapter adapter= new PersonajesAdapter(this);
        personajesRecycler.setLayoutManager(new LinearLayoutManager(this));
        personajesRecycler.setAdapter(adapter);

        adapter.setOnItemClickListener(this);

        pVm = new ViewModelProvider(this).get(PersonajesViewModel.class);
        pVm.init();
        data = pVm.getPaginaInicialLD();


        //Observador MutableLiveData
        data.observe(this, (data) ->{
            adapter.setResults(data.getPersonajes());
            //Obtiene la siguiente pagina
            siguientePagina = data.getInfoPag().getNext();

            //Obtiene la url para volver
            volverPagina = data.getInfoPag().getPrev();
        });
        //Launcher Results
        pVm.buscarPagina("1");

        resultadoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result ->{
                });
        //Siguiente página
        btnNext.setOnClickListener(view -> {
            //Hace una nueva petición
            pVm.siguientePagina(siguientePagina);
        });
        //Volver página
        btnBack.setOnClickListener(view -> {
            //Hace una nueva peticion
            if (volverPagina != null) {
                pVm.volverPagina(volverPagina);
            }
        });

    }
    @Override
    public void onItemClick(int position) {

    }

}