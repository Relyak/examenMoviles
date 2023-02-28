package com.example.apibares.datos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatosBares {

    @SerializedName("url")
    @Expose
    String url;
    @SerializedName("nombre")
    @Expose
    String nombre;
    @SerializedName("descripcion")
    @Expose
    String descripcion;
    @SerializedName("cierre")
    @Expose
    String cierre;
    @SerializedName("apertura")
    @Expose
    String apertura;
    @SerializedName("estrellas")
    @Expose
    String estrellas;

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCierre() {
        return cierre;
    }

    public String getApertura() {
        return apertura;
    }

    public String getEstrellas() {
        return estrellas;
    }
}
