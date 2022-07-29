package com.example.pruebaa.rest.Service;

import com.example.pruebaa.rest.Model.EpisodeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Episode {

    @GET("episodes")
    Call<List<EpisodeModel>> getEpisode();
}
