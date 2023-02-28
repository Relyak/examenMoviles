package com.example.apirickmorty.ServiceYResponse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apirickmorty.api.PaginaInicialRM;
import com.example.apirickmorty.api.DatosPersonajesRM;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositorioRM {
    //Url de la api
    private static final String URL_BASE = "https://rickandmortyapi.com";
    //Objeto de la interfaz servicio y mutable live data
    private ServicioRM servicioRM;
    private MutableLiveData<PaginaInicialRM> paginaMLD;
    private MutableLiveData<DatosPersonajesRM> personajeMLD;
    public RepositorioRM(){
        personajeMLD=new MutableLiveData<>();
        paginaMLD=new MutableLiveData<>();
        servicioRM = new retrofit2.Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()
                .create(ServicioRM.class);
    }
    //Metodo para obtener las pagina
    public void obtenerPagina(String pagina){
        servicioRM.obtenerPagina(pagina).enqueue(new Callback<PaginaInicialRM>() {
            @Override
            public void onResponse(Call<PaginaInicialRM> call, Response<PaginaInicialRM> response) {
                if (response.body() != null) {
                    paginaMLD.postValue(response.body());
                }
            }
            @Override
            public void onFailure(retrofit2.Call<PaginaInicialRM> call, Throwable t) {
                paginaMLD.postValue(null);
            }
        });
    }
    //Metodo para obtener un personaje
    public void obtenerPersonaje(String id){
        servicioRM.obtenerPersonaje(id).enqueue(new Callback<DatosPersonajesRM>() {
            @Override
            public void onResponse(Call<DatosPersonajesRM> call, Response<DatosPersonajesRM> response) {
                if (response.body() != null) {
                    personajeMLD.postValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<DatosPersonajesRM> call, Throwable t) {
                    personajeMLD.postValue(null);
            }
        });
    }
    public void volverPagina(String volverPeticion) {
        servicioRM.volverPagina(volverPeticion).enqueue(new Callback<PaginaInicialRM>() {
            @Override
            public void onResponse(Call<PaginaInicialRM> call, Response<PaginaInicialRM> response) {
                if (response.body() != null) {
                    paginaMLD.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PaginaInicialRM> call, Throwable t) {
                paginaMLD.postValue(null);
            }
        });
    }

    public void siguientePagina(String peticionSiguiente) {
        servicioRM.siguientePagina(peticionSiguiente).enqueue(new Callback<PaginaInicialRM>() {
            @Override
            public void onResponse(Call<PaginaInicialRM> call, Response<PaginaInicialRM> response) {
                if (response.body() != null) {
                    paginaMLD.postValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<PaginaInicialRM> call, Throwable t) {
                paginaMLD.postValue(null);
            }
        });

    }
    public LiveData<PaginaInicialRM> getPaginaInicialLD(){
        return paginaMLD;
    }
    public LiveData<DatosPersonajesRM> getPersonajesLD(){
        return personajeMLD;
    }


}
