package com.example.cinemaapp.view.fragments.movieTheater;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cinemaapp.R;
import com.example.cinemaapp.model.MovieTheater;
import com.example.cinemaapp.view.customer.selectMovieTheater.CustomerSelectMovieTheaterActivity;
import com.example.cinemaapp.view.owner.manageMovieTheaters.remove.ManageMovieTheatersRemoveActivity;

import java.util.List;


public class MyMovieTheaterRecyclerViewAdapter extends RecyclerView.Adapter<MyMovieTheaterRecyclerViewAdapter.ViewHolder> {

    private final List<MovieTheater> mValues;

    public MyMovieTheaterRecyclerViewAdapter(List<MovieTheater> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_movie_theater, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        MovieTheater movieTheater = mValues.get(position);
        holder.mMovieTheaterNameView.setText(movieTheater.getName());
        holder.mButtonView.setOnClickListener(v -> {
            if(v.getContext() instanceof ManageMovieTheatersRemoveActivity){
                ((ManageMovieTheatersRemoveActivity) v.getContext()).onRemoveMovieTheater(holder.mMovieTheaterNameView.getText().toString());
            }else if(v.getContext() instanceof CustomerSelectMovieTheaterActivity){
                ((CustomerSelectMovieTheaterActivity) v.getContext()).onSelectMovieTheater(holder.mMovieTheaterNameView.getText().toString());
            }


        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mMovieTheaterNameView;
        public final Button mButtonView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mMovieTheaterNameView = view.findViewById(R.id.fragment_movie_theater_name);
            mButtonView = view.findViewById(R.id.fragment_movie_theater_select_button);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMovieTheaterNameView.getText() + "'";
        }
    }
}