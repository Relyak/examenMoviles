package com.example.apijorgeprimos.servicioYrepositorio;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.apijorgeprimos.datos.Numeros;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrimoRepositorio {
    private static String URL_API="http://192.168.1.138:8000";
    private MutableLiveData<Numeros> obtenerPrimos;
    PrimoService service;


    private static PrimoRepositorio instancia;
    public static PrimoRepositorio getInstance(){
        if (instancia == null ) {
            instancia = new PrimoRepositorio();
        }
        return instancia;
    };

    private PrimoRepositorio(){
        obtenerPrimos=new MutableLiveData<>();
        service = new retrofit2.Retrofit.Builder()
                .baseUrl(URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PrimoService.class);
    }
    public void cogerPrimos(int inicio, int fin){
        service.obtenerPrimos(inicio,fin).enqueue(new Callback<Numeros>() {
            @Override
            public void onResponse(Call<Numeros> call, Response<Numeros> response) {
                if (response.body() != null) {
                    Log.d("Primos", "entré aqui aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    obtenerPrimos.postValue(response.body());
                }
            }
            @Override
            public void onFailure(retrofit2.Call<Numeros> call, Throwable t) {
                Log.d("Primos", "NOOOOOOOOOOOOentré aqui aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        });
    }
    public MutableLiveData<Numeros> getObtenerPrimos() {
        return obtenerPrimos;
    }
}
