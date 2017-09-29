package com.codejocks.absolutedarhk.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.codejocks.absolutedarhk.MainActivity;
import com.codejocks.absolutedarhk.R;

import pl.droidsonroids.gif.GifImageView;

public class HomeActivity extends Fragment {
    FragmentManager manager;
    LinearLayout musicLibrary, gallery, events, bookTable,about, hallof_fame, profile, settings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub



        View view=inflater.inflate(R.layout.activity_home, container, false);
        gallery= (LinearLayout) view.findViewById(R.id.gallery);
        musicLibrary= (LinearLayout) view.findViewById(R.id.music_library);
        events= (LinearLayout) view.findViewById(R.id.events);
        bookTable=(LinearLayout)view.findViewById(R.id.book_table);
        about=(LinearLayout)view.findViewById(R.id.about);
        hallof_fame=(LinearLayout)view.findViewById(R.id.hall_of_fame);
        profile=(LinearLayout)view.findViewById(R.id.profile);
        manager = getFragmentManager();


        ((MainActivity) getActivity())
                .setActionBarTitle("Absolute Darhk");



        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            FragmentTransaction ft1 = manager.beginTransaction();
                ft1.setCustomAnimations(R.anim.bottom_up,0, 0,R.anim.bottom_down);
                ft1.add(R.id.content, new GalleryFragment());
                ft1.addToBackStack("frag1");
                ft1.commit();

          }
        });


        musicLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft2 = manager.beginTransaction();
                ft2.setCustomAnimations(R.anim.bottom_up, 0, 0,R.anim.bottom_down);
                ft2.add(R.id.content, new BillboardsFragment());
                ft2.addToBackStack("frag2");
                ft2.commit();

            }
        });


        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft2 = manager.beginTransaction();
                ft2.setCustomAnimations(R.anim.bottom_up,0, 0,R.anim.bottom_down);
                ft2.add(R.id.content, new EventFragment());
                ft2.addToBackStack("frag3");
                ft2.commit();

            }
        });


        bookTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft2 = manager.beginTransaction();
                ft2.setCustomAnimations(R.anim.bottom_up, 0,0,R.anim.bottom_down);
                ft2.add(R.id.content, new Bookings_Fragment());
                ft2.addToBackStack("frag4");
                ft2.commit();

            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft2 = manager.beginTransaction();
                ft2.setCustomAnimations(R.anim.bottom_up,0,0, R.anim.bottom_down);
                ft2.add(R.id.content, new WhoweAreFragment());
                ft2.addToBackStack("frag4");
                ft2.commit();

            }
        });

        hallof_fame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft2 = manager.beginTransaction();
                ft2.setCustomAnimations(R.anim.bottom_up,0,0, R.anim.bottom_down);
                ft2.add(R.id.content, new Hall_of_fame_fragment());
                ft2.addToBackStack("frag4");
                ft2.commit();

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft1 = manager.beginTransaction();
                ft1.setCustomAnimations(R.anim.bottom_up,0, 0,R.anim.bottom_down);
                ft1.add(R.id.content, new ProfileFragment());
                ft1.addToBackStack("frag1");
                ft1.commit();

            }
        });
        return view;
    }



    public static HomeActivity newInstance() {
        HomeActivity fragment = new HomeActivity();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
