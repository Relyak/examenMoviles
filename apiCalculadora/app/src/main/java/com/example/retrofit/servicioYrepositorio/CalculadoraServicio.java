package com.example.retrofit.servicioYrepositorio;

import com.example.retrofit.Resultado;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CalculadoraServicio {
    @GET("/")
    Call<Resultado> raiz();

    @GET("suma/{n1}/{n2}/")
    Call<Resultado> suma(@Path("n1") int n1, @Path("n2") int n2);

    @GET("resta/{n1}/{n2}/")
    Call<Resultado> resta(@Path("n1") int n1, @Path("n2") int n2);

    @GET("multi/{n1}/{n2}/")
    Call<Resultado> multi(@Path("n1") int n1, @Path("n2") int n2);

    @GET("div/{n1}/{n2}/")
    Call<Resultado> div(@Path("n1") int n1, @Path("n2") int n2);
}
