package com.example.pruebaa.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebaa.Class.EpisodeClass;
import com.example.pruebaa.R;

import java.util.ArrayList;

public class AdapterEpisode  extends RecyclerView.Adapter<AdapterEpisode.ViewHolderAdapterCats> {

    ArrayList<EpisodeClass> listEpisode;

    public AdapterEpisode(ArrayList<EpisodeClass> listEpisode){
        this.listEpisode = listEpisode;
    }

    @NonNull
    @Override
    public AdapterEpisode.ViewHolderAdapterCats onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_episode, null, false);
        return new ViewHolderAdapterCats(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEpisode.ViewHolderAdapterCats holder, int position) {
            holder.createTextView.setText(listEpisode.get(position).getCreate());
    }

    @Override
    public int getItemCount() {
        return listEpisode.size();
    }

    public class ViewHolderAdapterCats extends RecyclerView.ViewHolder {
        TextView createTextView;
        public ViewHolderAdapterCats(@NonNull View itemView) {
            super(itemView);
            createTextView = itemView.findViewById(R.id.created_at_textview);
        }
    }
}
