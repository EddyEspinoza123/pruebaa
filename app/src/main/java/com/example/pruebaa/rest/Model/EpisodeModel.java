package com.example.pruebaa.rest.Model;

import com.google.gson.annotations.SerializedName;

public class EpisodeModel {

    @SerializedName("id")
    public String id;

    @SerializedName("title")
    public String title;

    //duda si ponerlo
    @SerializedName("air_date")
    public String air_date;
}
