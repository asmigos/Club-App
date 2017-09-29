package com.codejocks.absolutedarhk.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codejocks.absolutedarhk.MainActivity;
import com.codejocks.absolutedarhk.R;

public class FeedsFragment extends Fragment {
    View view;

    public static FeedsFragment newInstance() {
        FeedsFragment fragment = new FeedsFragment();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_event_fragment, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Feeds");
            return view;
    }
}
