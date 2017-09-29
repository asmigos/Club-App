package com.codejocks.absolutedarhk.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codejocks.absolutedarhk.MainActivity;
import com.codejocks.absolutedarhk.helper.CarouselEffectTransformer;
import com.codejocks.absolutedarhk.adapter.MyPagerAdapter;
import com.codejocks.absolutedarhk.R;


public class EventFragment extends Fragment {


    private ViewPager viewpagerTop, viewPagerBackground;
    public static final int ADAPTER_TYPE_TOP = 1;
    public static final int ADAPTER_TYPE_BOTTOM = 2;
    View view;

    private int[] listItems = {R.drawable.google, R.drawable.google, R.drawable.google};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        view = inflater.inflate(R.layout.activity_event_fragment, container, false);

        ((MainActivity) getActivity())
                .setActionBarTitle("Events");


        init();
        setupViewPager();

        return view;
    }




    /**
     * Initialize all required variables
     */
    private void init() {
        viewpagerTop = (ViewPager) view.findViewById(R.id.viewpagerTop);
        viewPagerBackground = (ViewPager) view.findViewById(R.id.viewPagerbackground);

        viewpagerTop.setClipChildren(false);
        viewpagerTop.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.pager_margin));
        viewpagerTop.setOffscreenPageLimit(3);
        viewpagerTop.setPageTransformer(false, new CarouselEffectTransformer(EventFragment.this.getActivity())); // Set transformer
    }




    /**
     * Setup viewpager and it's events
     */
    private void setupViewPager() {
        // Set Top ViewPager Adapter
        MyPagerAdapter adapter = new MyPagerAdapter(getActivity(), listItems, ADAPTER_TYPE_TOP);
        viewpagerTop.setAdapter(adapter);

        // Set Background ViewPager Adapter
        MyPagerAdapter adapterBackground = new MyPagerAdapter(getActivity(), listItems, ADAPTER_TYPE_BOTTOM);
        viewPagerBackground.setAdapter(adapterBackground);


        viewpagerTop.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int index = 0;

            @Override
            public void onPageSelected(int position) {
                //index = position;

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int width = viewPagerBackground.getWidth();
                viewPagerBackground.scrollTo((int) (width * position + width * positionOffset), 0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    viewPagerBackground.setCurrentItem(index);
                }

            }
        });
    }

    /**
     * Handle all click event of activity
     */
//    public void clickEvent(View view) {
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        Fragment selected = null;
//        switch (view.getId()) {
//            case R.id.linMain:
//                selected = InfoEvent.newInstance();
//                break;
//            transaction.setCustomAnimations(R.anim.bottom_up, 0);
//            transaction.replace(R.id.content, selected);
//            transaction.addToBackStack("frag0");
//            transaction.commit();
//
//        }
//    }

}