package com.example.apijorgeprimos.datos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Numeros {
    @SerializedName("primos")
    @Expose
    List<Integer> primos;

    public List<Integer> getPrimos() {
        return primos;
    }
}
