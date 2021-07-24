package com.example.cinemaapp.view.fragments.customerSlot;

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
import com.example.cinemaapp.view.customer.CustomerSelectSlot.CustomerSelectSlotActivity;
/**
 * A fragment representing a list of Items.
 */
public class SlotCustomerFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SlotCustomerFragment() {
    }

    @SuppressWarnings("unused")
    public static SlotCustomerFragment newInstance(int columnCount) {
        SlotCustomerFragment fragment = new SlotCustomerFragment();
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
        View view = inflater.inflate(R.layout.fragment_slot_customer_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            if(getActivity() instanceof CustomerSelectSlotActivity){
                String movieTheaterName = ((CustomerSelectSlotActivity) getActivity()).getMovieTheaterTitle();
                recyclerView.setAdapter(new MySlotCustomerRecyclerViewAdapter(movieTheaterName, ((CustomerSelectSlotActivity) getActivity()).onFindMovieSlots()));

            }
        }
        return view;
    }
}