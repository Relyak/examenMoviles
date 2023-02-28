package com.example.apirickmorty.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DatosPersonajesRM {
    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("species")
    @Expose
    String species;
    @SerializedName("type")
    @Expose
    String type;
    @SerializedName("gender")
    @Expose
    String gender;
    @SerializedName("origin")
    @Expose
    OrigenRM origin;
    @SerializedName("location")
    @Expose
    LocationRM location;
    @SerializedName("image")
    @Expose
    String imagen;
    @SerializedName("episode")
    @Expose
    List<String> episode;
    @SerializedName("url")
    @Expose
    String url;
    @SerializedName("created")
    @Expose
    String created;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public OrigenRM getOrigin() {
        return origin;
    }

    public LocationRM getLocation() {
        return location;
    }

    public String getImagen() {
        return imagen;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }
}
