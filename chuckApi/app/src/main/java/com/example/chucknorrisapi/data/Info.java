package com.example.chucknorrisapi.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("created_at")
    @Expose
    String created_at;
    @SerializedName("updated_at")
    @Expose
    String updated_at;
    @SerializedName("value")
    @Expose
    String value;

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getValue() {
        return value;
    }
}
