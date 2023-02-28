package com.example.apijorgeprimos.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.apijorgeprimos.datos.Numeros;
import com.example.apijorgeprimos.servicioYrepositorio.PrimoRepositorio;

import java.util.List;

public class PrimosViewModel extends AndroidViewModel {

    PrimoRepositorio repositorio;
    private MutableLiveData<Numeros> obtenerPrimosLD;

    public PrimosViewModel(@NonNull Application application) {
        super(application);
    }



    public void init(){
        repositorio= PrimoRepositorio.getInstance();
        obtenerPrimosLD =  repositorio.getObtenerPrimos();
    }
    public void obtenerPrimos(int inicio, int fin){
        repositorio.cogerPrimos(inicio,fin);
    }
    public MutableLiveData<Numeros> getObtenerPrimosLD() {
        return obtenerPrimosLD;
    }
}
