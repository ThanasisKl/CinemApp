package com.example.cinemaapp.view.fragments.rating;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.cinemaapp.R;
import com.example.cinemaapp.model.Rating;

import java.util.List;


public class MyReservationRecyclerViewAdapter extends RecyclerView.Adapter<MyReservationRecyclerViewAdapter.ViewHolder> {

    private final String movieTitle;
    private final List<Rating> mValues;

    public MyReservationRecyclerViewAdapter(String movieTitle, List<Rating> ratings) {
        this.movieTitle = movieTitle;
        this.mValues = ratings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_rating, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mNameView.setText(mValues.get(position).getFirstName() + " " + mValues.get(position).getLastName());
        holder.mRatingView.setRating(mValues.get(position).getScore());
        if(mValues.get(position).getText() != null){
            holder.mCommentsView.setText(mValues.get(position).getText());
        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNameView;
        public final TextView mCommentsView;
        public final RatingBar mRatingView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = view.findViewById(R.id.rating_fragment_name);
            mCommentsView = view.findViewById(R.id.rating_fragment_comments);
            mRatingView = view.findViewById(R.id.rating_fragment_rating);
        }

    }
}