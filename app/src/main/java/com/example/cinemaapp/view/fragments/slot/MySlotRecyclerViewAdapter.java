package com.example.cinemaapp.view.fragments.slot;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cinemaapp.R;
import com.example.cinemaapp.model.Slot;
import com.example.cinemaapp.view.staff.addMovie.AddMovieActivity;
import com.example.cinemaapp.view.staff.clearProgram.ClearProgramActivity;

import java.util.Calendar;
import java.util.List;

public class MySlotRecyclerViewAdapter extends RecyclerView.Adapter<MySlotRecyclerViewAdapter.ViewHolder> {

    private final String movieTheaterName;
    private List<Slot> slots;
    private int day;

    public MySlotRecyclerViewAdapter(String movieTheaterName, List<Slot> slots) {
        this.movieTheaterName = movieTheaterName;
        this.slots = slots;
        Calendar calendar = Calendar.getInstance();
        this.day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (day > 1) {
            day -= 2;
        }
        else{
            day = 6;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_slot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Slot slot = slots.get(position);
        holder.mSlotStartView.setText(String.valueOf(slot.getStart()) + ":00");
        holder.mSlotAuditoriumView.setText(String.valueOf(slot.getAuditorium().getId()));
        holder.mSlotDayView.setText(getTextDay(day));
        holder.mAddButtonView.setOnClickListener(v -> {
            if(v.getContext() instanceof AddMovieActivity) {
                ((AddMovieActivity) v.getContext()).onAddMovie(day, slot.getStart(), slot.getAuditorium(), movieTheaterName);
                ((AddMovieActivity) v.getContext()).showMessage("Movie added successfully!");

            }else if(v.getContext() instanceof ClearProgramActivity){
                ((ClearProgramActivity) v.getContext()).onClearSlot(day, slot.getStart(), slot.getAuditorium(), movieTheaterName);
            }

        });
    }

    @Override
    public int getItemCount() {
        return slots.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mSlotStartView;
        public final TextView mSlotAuditoriumView;
        public final TextView mSlotDayView;
        public final Button mAddButtonView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mSlotDayView = view.findViewById(R.id.fragment_slot_day);
            mSlotAuditoriumView = view.findViewById(R.id.fragment_slot_auditorium_id);
            mSlotStartView = view.findViewById(R.id.fragment_slot_movie_start);
            mAddButtonView = view.findViewById(R.id.fragment_slot_select_button);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mSlotStartView.getText() + "'";
        }
    }


    private String getTextDay(int day){
        switch (day){
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5 :
                return "Saturday";
            case 6:
                return "Sunday";
        }
        return null;
    }

}