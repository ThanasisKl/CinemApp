package com.example.cinemaapp.view.fragments.movie;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cinemaapp.R;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.view.customer.rating.addRatings.main.AddRatingsActivity;
import com.example.cinemaapp.view.customer.rating.readRatings.main.ReadRatingsActivity;
import com.example.cinemaapp.view.customer.selectMovie.CustomerSelectMovieActivity;
import com.example.cinemaapp.view.owner.manageMovies.remove.ManageMoviesRemoveActivity;
import com.example.cinemaapp.view.owner.seeStatistics.main.SeeStatisticsMainActivity;
import com.example.cinemaapp.view.staff.selectMovie.StaffSelectMovieActivity;

import java.util.List;

public class MyMovieRecyclerViewAdapter extends RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder> {


    private final List<Movie> mValues;
    private FragmentActivity c;

    public MyMovieRecyclerViewAdapter(List<Movie> items) {
        this.c = c;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Movie movie = mValues.get(position);
        holder.mMovieTitleView.setText(movie.getTitle());
        holder.mAddButtonView.setOnClickListener(v -> {
            if(v.getContext() instanceof StaffSelectMovieActivity){
                ((StaffSelectMovieActivity) v.getContext()).onSelectMovie(holder.mMovieTitleView.getText().toString());
            }else if(v.getContext() instanceof ManageMoviesRemoveActivity){
                ((ManageMoviesRemoveActivity) v.getContext()).onRemoveMovie(holder.mMovieTitleView.getText().toString());
            }else if(v.getContext() instanceof CustomerSelectMovieActivity){
                ((CustomerSelectMovieActivity) v.getContext()).onSelectMovie(holder.mMovieTitleView.getText().toString());
            }else if(v.getContext() instanceof SeeStatisticsMainActivity){
                ((SeeStatisticsMainActivity) v.getContext()).onSelectMovie(holder.mMovieTitleView.getText().toString());
            }else if(v.getContext() instanceof AddRatingsActivity){
                //when customer wants to add rating
                ((AddRatingsActivity) v.getContext()).onSelectMovie(holder.mMovieTitleView.getText().toString());
            }else if(v.getContext() instanceof ReadRatingsActivity){
                //when customer wants to read rating
                ((ReadRatingsActivity) v.getContext()).onSelectMovie(holder.mMovieTitleView.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mMovieTitleView;
        public final Button mAddButtonView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mMovieTitleView = view.findViewById(R.id.movie_fragment_title);
            mAddButtonView = view.findViewById(R.id.movie_fragment_select);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMovieTitleView.getText() + "'";
        }
    }

}