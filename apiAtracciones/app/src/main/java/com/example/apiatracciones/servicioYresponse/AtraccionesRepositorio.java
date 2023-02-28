package com.example.apiatracciones.servicioYresponse;

import androidx.lifecycle.MutableLiveData;

import com.example.apiatracciones.datos.DatosAtracciones;
import com.example.apiatracciones.datos.DatosConComentario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class AtraccionesRepositorio {
    //url api
    private static final String URL_BASE = "http://192.168.1.135:8000/";
    //Objeto interfaz servicio y mutable live data
    private AtraccionesService servicio;
    private static AtraccionesRepositorio instance;


    private MutableLiveData<List<DatosAtracciones>> datosLD;
    private MutableLiveData<DatosConComentario> datosComentarioLD;
    List <DatosAtracciones> listaAtracciones;

    public AtraccionesRepositorio(){
        datosLD=new MutableLiveData<>();
        datosComentarioLD=new MutableLiveData<>();

        servicio=new retrofit2.Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AtraccionesService.class);
    }
    public static AtraccionesRepositorio getInstance() {
        if (instance == null) {
            instance = new AtraccionesRepositorio();
        }
        return instance;
    }
    //Obtener los datos
    public void obtenerDatos(){
        servicio.obtenerPagina().enqueue(new Callback<List<DatosAtracciones>>() {
            @Override
            public void onResponse(Call<List<DatosAtracciones>> call, Response<List<DatosAtracciones>> response) {
                if (response.body() != null) {
                    List<DatosAtracciones> listaAtracciones = response.body();
                    datosLD.postValue(listaAtracciones);
                }
            }
            @Override
            public void onFailure(Call<List<DatosAtracciones>> call, Throwable t) {
                List<DatosAtracciones> listaAtracciones = new ArrayList<>();
                datosLD.postValue(listaAtracciones);
            }
        });
    }
    public void obtenerComentarios(String url){
        servicio.obtenerComentarios(url).enqueue(new Callback<DatosConComentario>() {
            @Override
            public void onResponse(Call<DatosConComentario> call, Response<DatosConComentario> response) {
                if (response.body() != null) {
                    datosComentarioLD.postValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<DatosConComentario> call, Throwable t) {
                datosComentarioLD.postValue(null);
            }
        });
    }
    public MutableLiveData<List<DatosAtracciones>> getDatosAtracciones(){
        return datosLD;
    }
    public MutableLiveData<DatosConComentario> getDatosComentario(){return datosComentarioLD;}
}
