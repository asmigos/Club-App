package com.codejocks.absolutedarhk.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.codejocks.absolutedarhk.MainActivity;
import com.codejocks.absolutedarhk.R;
import com.codejocks.absolutedarhk.adapter.GalleryAdapter;
import com.codejocks.absolutedarhk.adapter.Hall_of_fame_Adapter;
import com.codejocks.absolutedarhk.helper.AppController;
import com.codejocks.absolutedarhk.model.HallOfFame;
import com.codejocks.absolutedarhk.model.Image;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Hall_of_fame_fragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<HallOfFame> hallOfFamesList;
    private static final String endpoint = "https://api.androidhive.info/json/glide.json";
    private Hall_of_fame_Adapter mAdapter;

    public static Hall_of_fame_fragment newInstance() {
        Hall_of_fame_fragment fragment = new Hall_of_fame_fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_hall_of_fame_fragment, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Hall Of Fame");

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_Hall_of_fame);

//        pDialog = new ProgressDialog(getActivity());
        hallOfFamesList = new ArrayList<>();
        mAdapter = new Hall_of_fame_Adapter(getContext(), hallOfFamesList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        preparePersonData();
//        fetchImages();
        return view;
    }

//


        private void preparePersonData () {
            JsonArrayRequest req = new JsonArrayRequest(endpoint,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            hallOfFamesList.clear();
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject object = response.getJSONObject(i);
                                    JSONObject url = object.getJSONObject("url");
                                    HallOfFame hallOfFame = new HallOfFame("Mad Max: Fury Road", "Action & Adventure", "2015", "ghdu", url.getString("small"), url.getString("medium"),url.getString("large"));
                                    hallOfFamesList.add(hallOfFame);

                                    hallOfFame = new HallOfFame("Mad Max: Fury Road", "Action & Adventure", "2015", "ghdu", url.getString("small"), url.getString("medium"),url.getString("large"));
                                    hallOfFamesList.add(hallOfFame);
                                    hallOfFame = new HallOfFame("Mad Max: Fury Road", "Action & Adventure", "2015", "ghdu",  url.getString("small"), url.getString("medium"),url.getString("large"));
                                    hallOfFamesList.add(hallOfFame);

                                    hallOfFame = new HallOfFame("Mad Max: Fury Road", "Action & Adventure", "2015", "ghdu", url.getString("small"), url.getString("medium"),url.getString("large"));
                                    hallOfFamesList.add(hallOfFame);

                                    hallOfFame = new HallOfFame("Mad Max: Fury Road", "Action & Adventure", "2015", "ghdu",  url.getString("small"), url.getString("medium"),url.getString("large"));
                                    hallOfFamesList.add(hallOfFame);

                                    hallOfFame = new HallOfFame("Mad Max: Fury Road", "Action & Adventure", "2015", "ghdu", url.getString("small"), url.getString("medium"),url.getString("large"));
                                    hallOfFamesList.add(hallOfFame);

                                    hallOfFame = new HallOfFame("Mad Max: Fury Road", "Action & Adventure", "2015", "ghdu",  url.getString("small"), url.getString("medium"),url.getString("large"));
                                    hallOfFamesList.add(hallOfFame);

                                    hallOfFame = new HallOfFame("Mad Max: Fury Road", "Action & Adventure", "2015", "ghdu",  url.getString("small"), url.getString("medium"),url.getString("large"));
                                    hallOfFamesList.add(hallOfFame);

                                    hallOfFame = new HallOfFame("Mad Max: Fury Road", "Action & Adventure", "2015", "ghdu",  url.getString("small"), url.getString("medium"),url.getString("large"));
                                    hallOfFamesList.add(hallOfFame);

                                    hallOfFame = new HallOfFame("Mad Max: Fury Road", "Action & Adventure", "2015", "ghdu",  url.getString("small"), url.getString("medium"),url.getString("large"));
                                    hallOfFamesList.add(hallOfFame);
                                } catch (JSONException e) {
                                }
                            }


                            mAdapter.notifyDataSetChanged();
                        }

                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });

            // Adding request to request queue
            AppController.getInstance().addToRequestQueue(req);
        }
    }

