package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String backdropPath;
    String pPath;
    String title;
    String overView;

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        pPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overView = jsonObject.getString("overview");
    }

    public static List<Movie> FJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> m= new ArrayList<>();
        for (int k = 0; k < movieJsonArray.length(); k++){
            m.add(new Movie(movieJsonArray.getJSONObject(k)));
        }
        return m;
    }

    public String getpPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",pPath);
    }

    public String getBackdropPath() {
        return  String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }
}
