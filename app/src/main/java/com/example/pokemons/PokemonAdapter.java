package com.example.pokemons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pokemons.models.Pokemon;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder>{

    private ArrayList<Pokemon> dataPokemons;
    private Context context;

    public PokemonAdapter(Context context){
        this.context = context;
        dataPokemons = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.ViewHolder holder, int position) {
        Pokemon poke = dataPokemons.get(position);
        holder.namePoke.setText(poke.getName());
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/" + poke.getNumber() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imagePoke);
    }

    @Override
    public int getItemCount() {
        return dataPokemons.size();
    }

    public void addListPokemons(ArrayList<Pokemon> listPokemon) {
        dataPokemons.addAll(listPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagePoke;
        private TextView namePoke;

        public ViewHolder(View itemView){
            super(itemView);
            imagePoke = itemView.findViewById(R.id.image_poke);
            namePoke = itemView.findViewById(R.id.name_poke);
        }

    }

}
