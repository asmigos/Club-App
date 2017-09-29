package com.codejocks.absolutedarhk.fragments;


import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.codejocks.absolutedarhk.MainActivity;
import com.codejocks.absolutedarhk.R;

public class ShareFragment extends Fragment {
    LinearLayout hiddenShareFragment;

    public static ShareFragment newInstance() {
        ShareFragment fragment = new ShareFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_share_fragment, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Share");

        hiddenShareFragment = (LinearLayout)view.findViewById(R.id.hiddenShareFragment);
        return view;

    }



}
