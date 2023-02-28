package com.example.apiatracciones.servicioYresponse;

import com.example.apiatracciones.datos.DatosAtracciones;
import com.example.apiatracciones.datos.DatosConComentario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface AtraccionesService {
    @GET("pmdm/api/atracciones/")
    Call<List<DatosAtracciones>> obtenerPagina();
    @GET
    Call<DatosConComentario> obtenerComentarios(@Url String url);
}
