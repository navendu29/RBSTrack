package com.example.navendu.rbstrack.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Employee;

import java.util.ArrayList;

/**
 * Created by navendu on 25/6/18.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ImageViewHolder>{
    public ArrayList<Employee> mList;
    Context mContext;



    public ProfileAdapter(ArrayList<Employee> arrayList, Context c) {
        this.mList = arrayList;
        this.mContext = c;
    }



    @Override
    public ProfileAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_item, parent, false);

        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProfileAdapter.ImageViewHolder holder, int position) {
        final Employee item = mList.get(position);
        holder.country.setText(item.getName());
        holder.rank.setText(item.getRacf()+"");
        holder.population.setText(item.getContacts());

        Resources resources = mContext.getResources();


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView country,rank,population;
        //public ImageView flag;

        public ImageViewHolder(View view) {
            super(view);
            country = (TextView)view.findViewById(R.id.t1);
            rank=(TextView) view.findViewById(R.id.t2);
            population=(TextView) view.findViewById(R.id.t3);

     //       flag=(ImageView) view.findViewById(R.id.t4);

        }
    }
}
