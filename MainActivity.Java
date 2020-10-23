package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapter.MovieAdapter;
import model.Movie;
import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    public static final String URL_PLAYING_NOW = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed ";
    public static final String TAG = "MainActivity";

    List<Movie> m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv_movies = findViewById(R.id.rv_movies);
        m = new ArrayList<>();
        // Create the adapter
        final MovieAdapter movieAdapter = new MovieAdapter(this, m);
        // Set the adapter on the recycler view
        rv_movies.setAdapter(movieAdapter);
        // Set a Layout Manager on the recycler view
        rv_movies.setLayoutManager(new LinearLayoutManager(this));


                //Create the new activity



        AsyncHttpClient c = new AsyncHttpClient();
        c.get(URL_PLAYING_NOW, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                     JSONArray results = jsonObject.getJSONArray("results");
                    Log.i(TAG, "Results: " + results.toString());
                    m.addAll(Movie.FJsonArray(results));
                    movieAdapter.notifyDataSetChanged();
                    Log.i(TAG, "Movies: " + m.size());
                } catch (JSONException e) {
                    Log.e(TAG, "Hit json exception", e);
                }
            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}
