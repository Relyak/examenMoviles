package com.example.apirickmorty;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.apirickmorty.api.DatosPersonajesRM;
import com.example.apirickmorty.api.PaginaInicialRM;
import com.example.apirickmorty.mutableLiveData.PersonajesViewModel;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.apirickmorty.databinding.DetalleImagenBinding;

import java.util.ArrayList;
import java.util.List;

public class DetalleImagen extends AppCompatActivity {

    ImageView imgImagen;
    TextView nombre,estado,especie;
    PersonajesViewModel vm;
    LiveData<DatosPersonajesRM> data;

    private List<DatosPersonajesRM> results= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_imagen);
        imgImagen=findViewById(R.id.Dimag);
        nombre=findViewById(R.id.Dnombre);
        estado=findViewById(R.id.Destado);
        especie=findViewById(R.id.Despecie);

        String id =getIntent().getStringExtra("id");
        //Log.d("bkoaekmg",id);
        vm = new ViewModelProvider(this).get(PersonajesViewModel.class);
        vm.init();
        data = vm.getPersonajesLD();

        vm.buscarPersonaje(id);

        data.observe(this,(data)->{


            Log.d("14541",data.getName());
            nombre.setText(data.getName());
            especie.setText(data.getSpecies());
            estado.setText(data.getStatus());

            if (data.getImagen() != null) {
                String imageUrl = data.getImagen();

                Glide.with(this).load(imageUrl).into(imgImagen);
            }
        });
    }

}