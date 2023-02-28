package com.example.chucknorrisapi.servicioYresponse;

import com.example.chucknorrisapi.data.Info;

import retrofit2.Call;
import retrofit2.http.GET;


public interface NorrisService {
    @GET("/jokes/random")
    Call<Info> obtenerJoke();
}
