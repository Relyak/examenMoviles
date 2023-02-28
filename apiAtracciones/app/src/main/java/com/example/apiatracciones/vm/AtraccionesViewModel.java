package com.example.apiatracciones.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.apiatracciones.datos.DatosAtracciones;
import com.example.apiatracciones.datos.DatosConComentario;
import com.example.apiatracciones.servicioYresponse.AtraccionesRepositorio;

import java.util.List;

public class AtraccionesViewModel extends ViewModel{
    private AtraccionesRepositorio repositorio;
    private MutableLiveData<List<DatosAtracciones>> data;
    private MutableLiveData<DatosConComentario> dataComentarios;

    public void init(){
        repositorio= AtraccionesRepositorio.getInstance();
        data=repositorio.getDatosAtracciones();
        dataComentarios=repositorio.getDatosComentario();
    }
    public void getAtracciones(){
        repositorio.obtenerDatos();
    }
    public void getComentarios(String url){
        repositorio.obtenerComentarios(url);
    }
    public MutableLiveData<List<DatosAtracciones>> getAtraccionesResponse(){
        return data;
    }
    public MutableLiveData<DatosConComentario> getComentariosResponse(){
        return dataComentarios;
    }


}
