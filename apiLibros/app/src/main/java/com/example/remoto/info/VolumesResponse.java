package com.example.remoto.info;

import com.example.remoto.info.Volume;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VolumesResponse {
    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("items")
    @Expose
    List<Volume> items = null;

    @SerializedName("totalItems")
    @Expose
    int totalItems;

    public String getKind() {
        return kind;
    }

    public List<Volume> getItems() {
        return items;
    }

    public int getTotalItems() {
        return totalItems;
    }
}