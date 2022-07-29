package com.example.pruebaa.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pruebaa.Adapter.AdapterEpisode;
import com.example.pruebaa.Class.EpisodeClass;
import com.example.pruebaa.R;
import com.example.pruebaa.rest.ConfigAPI;
import com.example.pruebaa.rest.Model.EpisodeModel;
import com.example.pruebaa.rest.Service.Episode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public Episode gatosPeticion;
    public RecyclerView recyclerViewCats;

    public ArrayList<EpisodeClass> listEpisode = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gatosPeticion = ConfigAPI.client().create(Episode.class);
        recyclerViewCats = findViewById(R.id.recyclerView_cats);//layout main ir a cambiar recycler e id
        peticionesGatos();
    }

    private void peticionesGatos() {
        Call<List<EpisodeModel>> call = gatosPeticion.getEpisode();
        call.enqueue(new Callback<List<EpisodeModel>>() {
            @Override
            public void onResponse(Call<List<EpisodeModel>> call, Response<List<EpisodeModel>> response) {
                Log.d("responseCats", response.code() + "");

                List<EpisodeModel> responseData = response.body();

                for (EpisodeModel itemList : responseData) {
                    listEpisode.add(new EpisodeClass(itemList.air_date));
                    listEpisode.add(new EpisodeClass(itemList.title));
                    listEpisode.add(new EpisodeClass(itemList.id));
                }

                AdapterEpisode adapterEpisode = new AdapterEpisode(listEpisode);
                recyclerViewCats.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                recyclerViewCats.setAdapter(adapterEpisode);
            }

            @Override
            public void onFailure(Call<List<EpisodeModel>> call, Throwable t) {
                Log.d("responseCats", t.getMessage());
                call.cancel();
            }
        });
    }
}