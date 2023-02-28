package com.example.apirickmorty.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoPagRM {
    @SerializedName("count")
    @Expose
    String count;
    @SerializedName("pages")
    @Expose
    String page;
    @SerializedName("next")
    @Expose
    String next;
    @SerializedName("prev")
    @Expose
    String prev;

    public String getCount() {
        return count;
    }
    public String getPage() {
        return page;
    }
    public String getNext() {
        return next;
    }
    public String getPrev() {
        return prev;
    }
}
