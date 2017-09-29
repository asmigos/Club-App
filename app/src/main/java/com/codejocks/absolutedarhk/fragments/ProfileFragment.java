package com.codejocks.absolutedarhk.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.codejocks.absolutedarhk.MainActivity;
import com.codejocks.absolutedarhk.R;
import com.codejocks.absolutedarhk.helper.BlurBuilder;


public class ProfileFragment extends Fragment {
    ImageView profileLinearLayout;
    public static ShareFragment newInstance() {
        ShareFragment fragment = new ShareFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile_fragment, container, false);
        profileLinearLayout = (ImageView)view.findViewById(R.id.profileLinearLayout);
        ((MainActivity) getActivity())
                .setActionBarTitle("Profile");


        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sardar);
        Bitmap blurredBitmap = BlurBuilder.blur( getActivity(), originalBitmap );
        profileLinearLayout.setBackground(new BitmapDrawable(getResources(), blurredBitmap));
        return view;
    }
}
