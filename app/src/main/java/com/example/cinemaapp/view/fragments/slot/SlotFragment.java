package com.example.cinemaapp.view.fragments.slot;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.view.customer.CustomerSelectSlot.CustomerSelectSlotActivity;
import com.example.cinemaapp.view.staff.addMovie.AddMovieActivity;
import com.example.cinemaapp.view.staff.clearProgram.ClearProgramActivity;

import java.util.Calendar;

/**
 * A fragment representing a list of Items.
 */
public class SlotFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    public static final String MOVIE_THEATER_NAME = "Movie theater name";
    private int mColumnCount = 1;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SlotFragment() {
    }

    @SuppressWarnings("unused")
    public static SlotFragment newInstance(int columnCount) {
        SlotFragment fragment = new SlotFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slot_list, container, false);




        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
            if (day > 1) {
                day -= 2;
            }
            else{
                day = 6;
            }
            if(getActivity() instanceof AddMovieActivity){
                String movieTheaterName = ((AddMovieActivity) getActivity()).getMovieTheater();
                recyclerView.setAdapter(new MySlotRecyclerViewAdapter(movieTheaterName, new MovieTheaterDAOMemory().find(movieTheaterName).getDailySchedules().get(day).getAvailableSlots()));
            }else if(getActivity() instanceof ClearProgramActivity){
                String movieTheaterName = ((ClearProgramActivity) getActivity()).getMovieTheater();
                recyclerView.setAdapter(new MySlotRecyclerViewAdapter(movieTheaterName, new MovieTheaterDAOMemory().find(movieTheaterName).getDailySchedules().get(day).getNonAvailableSlots()));
            }
//            else if(getActivity() instanceof CustomerSelectSlotActivity){
//                String movieTheaterName = ((CustomerSelectSlotActivity) getActivity()).getMovieTheaterTitle();
//                recyclerView.setAdapter(new MySlotRecyclerViewAdapter(movieTheaterName, ((CustomerSelectSlotActivity) getActivity()).onFindMovieSlots()));
//
//            }
        }
        return view;
    }
}