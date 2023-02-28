package com.example.apibares.servicioYresponse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apibares.datos.DatosBares;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import retrofit2.converter.gson.GsonConverterFactory;

public class BaresRepositorio {
    //url de la api
    private static final String URL_BASE = "http://192.168.1.135:8000/";
    //Objeto interfaz servicio y mutable live data
    private BaresService servicio;
    private static BaresRepositorio instance;


    private MutableLiveData<List<DatosBares>> datosLD;


    public BaresRepositorio(){
        datosLD=new MutableLiveData<>();
        servicio= new retrofit2.Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BaresService.class);
    }
    public static BaresRepositorio getInstance() {
        if (instance == null) {
            instance = new BaresRepositorio();
        }
        return instance;
    }
    //Obtener los datos
    public void obtenerPagina(){
        servicio.obtenerPagina().enqueue(new Callback<List<DatosBares>>() {
            @Override
            public void onResponse(Call<List<DatosBares>> call, Response<List<DatosBares>> response) {
                if (response.body() != null) {
                    List<DatosBares> listaBares = response.body();
                    datosLD.postValue(listaBares);
                }
            }
            @Override
            public void onFailure(Call<List<DatosBares>> call, Throwable t) {
                List<DatosBares> listaBares = new ArrayList<>();
                datosLD.postValue(listaBares);
            }
        });
    }
    public void obtenerEstrellas(int estrellas){
        servicio.obtenerEstrellas(estrellas).enqueue(new Callback<List<DatosBares>>() {
            @Override
            public void onResponse(Call<List<DatosBares>> call, Response<List<DatosBares>> response) {
                if(response.body()!=null){
                List<DatosBares> listaBares = response.body();
                datosLD.postValue(listaBares);
                }
            }
            @Override
            public void onFailure(Call<List<DatosBares>> call, Throwable t) {

                    List<DatosBares> listaBares = new ArrayList<>();
                    datosLD.postValue(listaBares);

            }
        });
    }
    public MutableLiveData<List<DatosBares>> getDatosBares(){
        return datosLD;
    }
}
