package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Movie;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailActivity2 extends AppCompatActivity {
    private static final String YOUTUBE_API_KEY="AIzaSyDMlHPhn9-W_ftGtHlhLA9bgywJUUh3_JQ"
    TextView tvTitle;
    TextView tvOverview;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvTitle=findViewById(R.id.textView2);
        tvOverview=findViewById(R.id.textView3)  ;
        ratingBar=findViewById(R.id.ratingBar);

        String title=getIntent().getStringExtra("title");
        String title=getIntent().getStringExtra("title");
        Movie movie =getIntent().getParcelableExtra("movie")
        tvTitle.setText(title);
        tvOverview.setText(movie.getOverview());
        ratingBar.setRating(float)movie.getRating());


    }
}