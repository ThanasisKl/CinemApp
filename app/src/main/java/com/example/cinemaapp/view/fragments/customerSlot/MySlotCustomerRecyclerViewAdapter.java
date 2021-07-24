package com.example.cinemaapp.view.fragments.customerSlot;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cinemaapp.R;
import com.example.cinemaapp.model.Day;
import com.example.cinemaapp.util.Slot_Day;
import com.example.cinemaapp.view.customer.CustomerSelectSlot.CustomerSelectSlotActivity;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Slot_Day}.

 */
public class MySlotCustomerRecyclerViewAdapter extends RecyclerView.Adapter<MySlotCustomerRecyclerViewAdapter.ViewHolder> {

    private final List<Slot_Day> slot_days;
    private String movieTheaterName;
    private int auditoriumId;
    private int availableSeats;
    private Day day;

    public MySlotCustomerRecyclerViewAdapter(String movieTheaterName,List<Slot_Day> slot_days) {
        this.slot_days = slot_days;
        this.movieTheaterName = movieTheaterName;
    }

    @Override
    public MySlotCustomerRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_slot_customer, parent, false);
        return new MySlotCustomerRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MySlotCustomerRecyclerViewAdapter.ViewHolder holder, int position) {
        Slot_Day slotDay = slot_days.get(position);
        holder.mSlotStartView.setText(String.valueOf(slotDay.getSlot().getStart()) + ":00");
        holder.mSlotAuditoriumView.setText(String.valueOf(slotDay.getSlot().getAuditorium().getId()));
        holder.mDay.setText(String.valueOf(slotDay.getDay()));
        holder.mAvailableSeats.setText(String.valueOf(slotDay.getSlot().getAvailable() + slotDay.getSlot().getAvailablePremium()));
        holder.mButtonSelect.setOnClickListener(v -> {
            if(v.getContext() instanceof CustomerSelectSlotActivity){
                ((CustomerSelectSlotActivity) v.getContext()).onSelectMovie(slotDay);
            }
        });

    }

    @Override
    public int getItemCount() {
        return slot_days.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mSlotStartView;
        public final TextView mSlotAuditoriumView;
        public final TextView mDay;
        public final Button mButtonSelect;
        public final TextView mAvailableSeats;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            mSlotStartView =view.findViewById(R.id.txtSlotStart);
            mSlotAuditoriumView = view.findViewById(R.id.customer_slot_day);
            mButtonSelect = view.findViewById(R.id.customer_slot_select);
            mDay = view.findViewById(R.id.customer_slot_dayy);
            mAvailableSeats = view.findViewById(R.id.customer_slot_seats);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mSlotAuditoriumView.getText() + "'";
        }
    }
}