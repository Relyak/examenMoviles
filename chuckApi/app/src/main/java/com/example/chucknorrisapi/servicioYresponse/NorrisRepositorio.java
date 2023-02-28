package com.example.chucknorrisapi.servicioYresponse;

import androidx.lifecycle.MutableLiveData;

import com.example.chucknorrisapi.data.Info;

import retrofit2.Retrofit;

public class NorrisRepositorio {
    //url api
    private static final String URL_BASE = "https://api.chucknorris.io";
    //instancia de la clase NorrisService
    private NorrisService norrisService;
    //live data
    private MutableLiveData<Info> infoMLD;
    public static NorrisRepositorio instance;
    public static NorrisRepositorio getInstance() {
        if (instance == null) {
            instance = new NorrisRepositorio();
        }
        return instance;
    }
    public NorrisRepositorio(){
        infoMLD=new MutableLiveData<>();
        norrisService = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()
                .create(NorrisService.class);
    }
    public void obtenerJoke(){
        norrisService.obtenerJoke().enqueue(new retrofit2.Callback<Info>() {
            @Override
            public void onResponse(retrofit2.Call<Info> call, retrofit2.Response<Info> response) {
                if (response.body() != null) {
                    infoMLD.postValue(response.body());
                }
            }
            @Override
            public void onFailure(retrofit2.Call<Info> call, Throwable t) {

            }
        });
    }
    public MutableLiveData<Info> getInfoMLD() {
        return infoMLD;
    }
}
