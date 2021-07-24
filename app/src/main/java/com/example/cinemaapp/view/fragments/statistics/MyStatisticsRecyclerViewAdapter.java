package com.example.cinemaapp.view.fragments.statistics;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.cinemaapp.R;
import com.example.cinemaapp.model.Day;

import java.util.List;


public class MyStatisticsRecyclerViewAdapter extends RecyclerView.Adapter<MyStatisticsRecyclerViewAdapter.ViewHolder> {

    private List<Integer> mValues;

    public MyStatisticsRecyclerViewAdapter(List<Integer> tickets) {
        mValues = tickets;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_statistics, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        switch (position){
            case 0:
                holder.mDayView.setText(Day.MONDAY.toString());
                break;
            case 1:
                holder.mDayView.setText(Day.TUESDAY.toString());
                break;
            case 2:
                holder.mDayView.setText(Day.WEDNESDAY.toString());
                break;
            case 3:
                holder.mDayView.setText(Day.THURSDAY.toString());
                break;
            case 4:
                holder.mDayView.setText(Day.FRIDAY.toString());
            case 5:
                holder.mDayView.setText(Day.SATURDAY.toString());
                break;
            case 6:
                holder.mDayView.setText(Day.SUNDAY.toString());
                break;
            case 7:
                holder.mDayView.setText("ALL");
                break;


        }
        holder.mTicketsView.setText(mValues.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mDayView;
        public final TextView mTicketsView;
        public Integer mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mDayView = view.findViewById(R.id.statistics_fragment_day);
            mTicketsView = view.findViewById(R.id.statistics_fragment_number_of_tickets);
        }
    }
}