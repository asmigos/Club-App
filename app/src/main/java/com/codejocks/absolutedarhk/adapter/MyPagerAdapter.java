package com.codejocks.absolutedarhk.adapter;

/**
 * Created by hp on 26-07-2017.
 */
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codejocks.absolutedarhk.R;
import com.codejocks.absolutedarhk.fragments.EventFragment;
import com.codejocks.absolutedarhk.model.Event;
import com.codejocks.absolutedarhk.model.Image;

import java.util.ArrayList;


public class MyPagerAdapter extends PagerAdapter{

    Context context;
    int[] listItems;
    int adapterType;
//    private ArrayList<Event> events;

    public MyPagerAdapter(Context context, int[] listItems, int adapterType) {
        this.context = context;
        this.listItems = listItems;
        this.adapterType=adapterType;

//        events = (ArrayList<Event>) getArguments().getSerializable("images");
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cover, null);
        try {

            LinearLayout linMain = (LinearLayout) view.findViewById(R.id.linMain);
            ImageView imageCover = (ImageView) view.findViewById(R.id.imageCover);
//            TextView eventName = (TextView) view.findViewById(R.id.eventName);
//            TextView eventDescription = (TextView) view.findViewById(R.id.eventDescription);
            linMain.setTag(position);

            switch (adapterType)
            {
                case EventFragment.ADAPTER_TYPE_TOP:
                   // linMain.setBackgroundResource(R.drawable.bg_main);
                    break;
                case EventFragment.ADAPTER_TYPE_BOTTOM:
                    //linMain.setBackgroundResource(0);
                    break;
            }

            Glide.with(context)
                    .load(listItems[position])
                    .into(imageCover);

//            eventName.setText(events.getName());
//            eventDescription.setText(events.getTimestamp());

            container.addView(view);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return listItems.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

}
