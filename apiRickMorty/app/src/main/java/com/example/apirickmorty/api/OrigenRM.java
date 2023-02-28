package com.example.apirickmorty.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrigenRM {
    @SerializedName("name")
    @Expose
    String nombre;
    @SerializedName("url")
    @Expose
    String url;

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }
}
