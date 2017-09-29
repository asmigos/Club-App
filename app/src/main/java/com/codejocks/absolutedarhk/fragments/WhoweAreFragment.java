package com.codejocks.absolutedarhk.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codejocks.absolutedarhk.MainActivity;
import com.codejocks.absolutedarhk.R;

public class WhoweAreFragment extends Fragment {
            TextView infoTextView, headingTextView, info2TextView, subheadingTextView;
        public static WhoweAreFragment newInstance() {
            WhoweAreFragment fragment = new WhoweAreFragment();
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.activity_whowe_are_fragment, container, false);
            ((MainActivity) getActivity())
                    .setActionBarTitle("About Us");
            infoTextView = (TextView)view.findViewById(R.id.infoTextView);
            headingTextView = (TextView)view.findViewById(R.id.headingTextView);
            subheadingTextView = (TextView)view.findViewById(R.id.subheadingTextView);
            info2TextView = (TextView)view.findViewById(R.id.info2TextView);
            infoTextView.setText("Absolute Darhk is the ultimate nightclub sensory experience " +
                    "involving state of the art technology, visual effects, intense sound and sensuous " +
                    "décor with rich textures, vibrant lighting and brilliant colors. Featuring some of the biggest and " +
                    "best DJs, performers, and celebrities in the world, Absolute Darhk has established itself as the premier" +
                    " institution of Allahabad’s nightlife.");
            headingTextView.setText("THE BEST NIGHT CLUB EVER");
            subheadingTextView.setText("We Live To Party");
            info2TextView.setText(" The quintessential nightspot, fashioned by Absolute Darhk, fuses the appeal of an ultra" +
                    " exclusive lounge and a high-energy nightclub. With over 11,500 square feet of striking a" +
                    "rchitectural design and lavish decor, Absolute Darhk sets the stage for the ultimate nightlife experience. " +
                    "A voyeuristic design throughout the nightclub gives guests a bird’s eye view of the celebrities, VIPs and " +
                    "Allahabad’s most beautiful crowd. Absolute Darhk features a variety of music formats during its music nights," +
                    " and offers VIP tables, private party bookings, full-service bar and a lavish main dance floor.");

            return view;
        }
    }


