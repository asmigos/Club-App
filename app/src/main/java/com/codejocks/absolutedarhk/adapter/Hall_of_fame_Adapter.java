package com.codejocks.absolutedarhk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.codejocks.absolutedarhk.R;
import com.codejocks.absolutedarhk.model.HallOfFame;
import com.codejocks.absolutedarhk.model.Image;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hp on 14-08-2017.
 */

public class Hall_of_fame_Adapter extends RecyclerView.Adapter<Hall_of_fame_Adapter.MyViewHolder> {

    private List<HallOfFame> hallOfFames;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView person1image,person2image;
        TextView person1TextView, person2TextView, person1DescriptionTextView, person2DescriptionTextView;

        public MyViewHolder(View view) {
            super(view);
            person1image = (CircleImageView) view.findViewById(R.id.person1image);
            person1TextView = (TextView)view.findViewById(R.id.textViewPerson1);
            person1DescriptionTextView = (TextView)view.findViewById(R.id.textViewPerson1Description);

            person2image = (CircleImageView) view.findViewById(R.id.person2image);
            person2TextView = (TextView)view.findViewById(R.id.textViewPerson2);
            person2DescriptionTextView = (TextView)view.findViewById(R.id.textViewPerson2Description);

        }
    }


    public Hall_of_fame_Adapter(Context context, List<com.codejocks.absolutedarhk.model.HallOfFame> hallOfFames) {
        mContext = context;
        this.hallOfFames = hallOfFames;
    }

    @Override
    public Hall_of_fame_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hallof_fame_card, parent, false);

        return new Hall_of_fame_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HallOfFame hallOfFame = hallOfFames.get(position);
        holder.person1TextView.setText(hallOfFame.getPerson1name());
        holder.person2TextView.setText(hallOfFame.getPerson2name());
        holder.person1DescriptionTextView.setText(hallOfFame.getPerson1description());
        holder.person2DescriptionTextView.setText(hallOfFame.getPerson2description());
        Glide.with(mContext).load(hallOfFame.getMedium())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.person1image);
        Glide.with(mContext).load(hallOfFame.getMedium())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.person2image);


    }


    @Override
    public int getItemCount() {
        return hallOfFames.size();
    }
}
