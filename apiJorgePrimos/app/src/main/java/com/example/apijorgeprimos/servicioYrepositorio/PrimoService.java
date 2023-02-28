package com.example.apijorgeprimos.servicioYrepositorio;

import com.example.apijorgeprimos.datos.Numeros;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PrimoService {
    @GET("/primos/{inicio}/{fin}")
    Call<Numeros> obtenerPrimos(
            @Path("inicio") int inicio,@Path("fin") int fin
    );
}
