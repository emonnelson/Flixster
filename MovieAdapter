package adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;

import java.util.List;

import model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    List<Movie> m;

    public MovieAdapter(Context context, List<Movie> m) {
        this.context = context;
        this.m = m;
    }
    //this involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.movie_items,parent, false);
        return new ViewHolder(movieView);
    }

    //Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the movie at the passed in position
        Movie movie = m.get(position);
        // Bind the movie data into VH
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return m.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

            TextView txtMovies;
            TextView txtOverview;
            ImageView imPoster;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                txtMovies = itemView.findViewById(R.id.txtMovies);
                txtOverview = itemView.findViewById(R.id.txtOverview);
                imPoster = itemView.findViewById(R.id.imPoster);
            }


        public void bind(Movie movie) {
             txtMovies.setText(movie.getTitle());
             txtOverview.setText(movie.getOverView());
             String iURL;
             //if phone is in landscape
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                // then iURL = backdrop image
                iURL = movie.getBackdropPath();
            }
            else {
                // else iURL = poster image
                iURL = movie.getpPath();
            }
            Glide.with(context).load(iURL).into(imPoster);
        }
    }
    }
