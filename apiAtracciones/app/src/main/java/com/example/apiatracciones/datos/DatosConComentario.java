package com.example.apiatracciones.datos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DatosConComentario {
    @SerializedName("comentarios")
    @Expose
    List<Comentarios> comentarios;
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

    public List<Comentarios> getComentarios() {
        return comentarios;
    }
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
