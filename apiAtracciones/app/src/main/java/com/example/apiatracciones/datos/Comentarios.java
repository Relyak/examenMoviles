package com.example.apiatracciones.datos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comentarios {
    @SerializedName("url")
    @Expose
    String url;
    @SerializedName("texto")
    @Expose
    String texto;
    @SerializedName("atraccion")
    @Expose
    String atraccion;

    public String getUrl() {
        return url;
    }

    public String getTexto() {
        return texto;
    }

    public String getAtraccion() {
        return atraccion;
    }
}
