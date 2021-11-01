package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flixster.adapters.MovieAdapter;
import com.example.flixster.models.movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {
    public static final String NOW_PLAYING_URL="https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG="MainActivity";
    List<movie>movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.rvmovies);
        AsyncHttpClient client = new AsyncHttpClient ();
        MovieAdapter movieAdapter=new
        client.get(NOW_PLAYING_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "On success");
                JSONObject jsonObject = json.jsonObject;
                try {
                    jsonObject.getJSONArray("results");
                    JSONArray results = null;
                    Log.i(TAG, " results :" + results.toString());
                    List<movie> movies = movie.fromJsonArray(results);
                } catch (JSONException e){
                    Log.e(TAG, "hit json exception",e );
                }

                }

                @Override
                public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                    Log.d(TAG, "On Fail");
                }
            });

        }
    }