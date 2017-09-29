package com.codejocks.absolutedarhk.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codejocks.absolutedarhk.MainActivity;
import com.codejocks.absolutedarhk.R;

public class Bookings_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_bookings__fragment, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Bookings");

        return view;
    }
}

