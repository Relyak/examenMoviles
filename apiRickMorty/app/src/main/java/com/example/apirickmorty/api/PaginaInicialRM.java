package com.example.apirickmorty.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaginaInicialRM {
    @SerializedName("info")
    @Expose
    InfoPagRM infoPag;
    @SerializedName("results")
    @Expose
    List<DatosPersonajesRM> personajes;

    public InfoPagRM getInfoPag() {
        return infoPag;
    }

    public List<DatosPersonajesRM> getPersonajes() {
        return personajes;
    }
}
