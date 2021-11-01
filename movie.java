package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class movie {
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating
    public void Movie(){

    }

public movie(JSONObject jsonObject) throws JSONException {
    backdropPath=JSONObject.getString("backdrop_path");
    posterPath= jsonObject.getString("poster_path");
    title= jsonObject.getString("title");
    overview=jsonObject.getString("overview");
    rating=jsonObject.getDouble("vote_average");
}
public static List<movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
    List<movie> movies = new ArrayList<>();
    for(int i = 0; i < movieJsonArray.length();i++){
        movies.add(new movie(movieJsonArray.getJSONObject(i)));
    }
    return movies;
}
public String getPosterPath(){
    return posterPath;
}
public String getTitle(){
        return title;
    }

public String getOverview() {
    return overview;
}

}
public double getRating(){
    return rating;

}