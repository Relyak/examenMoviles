package com.example.apirickmorty.ServiceYResponse;

import com.example.apirickmorty.api.PaginaInicialRM;
import com.example.apirickmorty.api.DatosPersonajesRM;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ServicioRM {
    @GET("/api/character")
    Call<PaginaInicialRM> obtenerPagina(
            @Query("page") String pagina
    );
    @GET("/api/character/{id}")
    Call<DatosPersonajesRM> obtenerPersonaje(
            @Path("id") String id
    );

    @GET
    Call<PaginaInicialRM> siguientePagina(@Url String urlSiguiente);

    @GET
    Call<PaginaInicialRM> volverPagina(@Url String urlVolver);


}
