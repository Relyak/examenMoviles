package com.example.apiatracciones.datos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatosAtracciones {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("ocupantes")
    @Expose
    private int ocupantes;

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getOcupantes() {
        return ocupantes;
    }
}
