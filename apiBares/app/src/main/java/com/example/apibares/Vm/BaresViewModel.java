package com.example.apibares.Vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apibares.datos.DatosBares;
import com.example.apibares.servicioYresponse.BaresRepositorio;

import java.util.List;

public class BaresViewModel extends ViewModel {
    private BaresRepositorio repositorio;
    private MutableLiveData<List<DatosBares>> data;


    public void init(){
        repositorio= BaresRepositorio.getInstance();
        data=repositorio.getDatosBares();
    }
    public void buscarEstrellas(int estrellas){
        repositorio.obtenerEstrellas(estrellas);
    }
    public void getBares(){
        repositorio.obtenerPagina();
    }
    public LiveData<List<DatosBares>> getBaresResponse(){
        return data;
    }
}
