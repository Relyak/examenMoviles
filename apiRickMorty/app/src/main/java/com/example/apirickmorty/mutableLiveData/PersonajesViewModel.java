package com.example.apirickmorty.mutableLiveData;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.apirickmorty.ServiceYResponse.RepositorioRM;
import com.example.apirickmorty.api.PaginaInicialRM;
import com.example.apirickmorty.api.DatosPersonajesRM;

public class PersonajesViewModel extends AndroidViewModel {
    private RepositorioRM repositorioRM;
    private LiveData<PaginaInicialRM> paginaInicialLD;
    private LiveData<DatosPersonajesRM> personajesLD;

    //lo creo solo extendiendo del android view model
    public PersonajesViewModel(@NonNull Application application) {
        super(application);
    }
    public void init() {
        repositorioRM = new RepositorioRM();
        paginaInicialLD = repositorioRM.getPaginaInicialLD();
        personajesLD = repositorioRM.getPersonajesLD();
    }
    //Métodos que actualizan el Mutable
    public void buscarPersonaje(String id) {
        repositorioRM.obtenerPersonaje(id);
    }
    //métodos que actualizan el Mutable
    public void buscarPagina (String page) {
        repositorioRM.obtenerPagina(page);
    }
    //Hace nueva petición, siguiente pagina
    public void siguientePagina(String peticionSiguiente) {repositorioRM.siguientePagina(peticionSiguiente);};

    //Hace nueva petición volver a la anterior
    public void volverPagina(String peticionVolver) {repositorioRM.volverPagina(peticionVolver);};
    //Getter
    public LiveData<PaginaInicialRM> getPaginaInicialLD () {
        return paginaInicialLD;
    }

    public LiveData<DatosPersonajesRM> getPersonajesLD() {
        return personajesLD;
    }


}
