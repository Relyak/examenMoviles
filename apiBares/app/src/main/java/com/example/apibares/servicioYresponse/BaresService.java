package com.example.apibares.servicioYresponse;

import com.example.apibares.datos.DatosBares;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BaresService {
    @GET("pmdm/api/bares/")
    Call<List<DatosBares>>obtenerPagina();
    @GET("pmdm/api/bares/")
    Call<List<DatosBares>>obtenerEstrellas(
            @Query("estrellas") int estrellas
    );



}
