package com.codejocks.absolutedarhk.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codejocks.absolutedarhk.MainActivity;
import com.codejocks.absolutedarhk.R;

public class NotificationFragment extends Fragment {

    public static NotificationFragment newInstance() {
        NotificationFragment fragment = new NotificationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_home, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Notifications");

        return view;
    }
}
