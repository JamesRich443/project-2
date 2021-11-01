package com.example.flixster.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.DetailActivity2;
import com.example.flixster.R;
import com.example.flixster.adapters.MovieAdapter;

import java.util.List;

import movie.GetTitle;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    Context context;
    List<Movie> movies;
     public MovieAdapter(Context context, List<Movie> movies){
         this.context=context;
         this.movies=movies;
     }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View movieView=LayoutInflater.from(context).inflate(R.layout.item_movie,parent, false);
         return new ViewHolder(movieView) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie =movies.get(position);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         RelativeLayout container;
        TextView textView2;
        TextView textView3;
        ImageView ivposter;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView2=itemView.findViewById(R.id.textView2);
            textView3=itemView.findViewById(R.id.textView3);
            ivposter=itemView.findViewById(R.id.ivposter);
            container=itemView.findViewById(R.id.container);
        }
        public void bind(Movie movie){
            textView2.setText(movie.getTitle());
            textView3.setText(movie.getOverview());
            String imageURL;
            if(context.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                imageURL=movie.getBackdropPath():

            }else{
                imageURL=movie.getPosterPath():
            }
            Glide.with(context).load(imageURL).into((ivposter));
            textView2.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onClick(View v) {
                    Toast.makeText(context, movie.getTitle(), Toast.LENGTH_SHORT).show();

                    Intent i= new Intent(context, DetailActivity2.class);
                    i.putExtra("title",movie.getTitle());
                    i.putExtra("movie",parcels.wrap(movie));
                    context.startActivity(i);
                    return false;
                }
            });
        }

    }
}
