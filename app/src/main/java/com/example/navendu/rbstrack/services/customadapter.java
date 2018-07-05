package com.example.navendu.rbstrack.services;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.peopleonleave;

import java.util.ArrayList;

/**
 * Created by navendu on 3/7/18.
 */

public class customadapter extends ArrayAdapter<peopleonleave>  {


    private ArrayList<peopleonleave> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txt1;
        TextView txt2;
        TextView txt3;
       // ImageView info;
    }



    public customadapter(ArrayList<peopleonleave> data, Context context) {
        super(context, R.layout.item_date, data);
        this.dataSet = data;
        this.mContext=context;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        peopleonleave dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_date, parent, false);
            viewHolder.txt1 = (TextView) convertView.findViewById(R.id.one);
            viewHolder.txt2 = (TextView) convertView.findViewById(R.id.two);
            viewHolder.txt3 = (TextView) convertView.findViewById(R.id.three);
//            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.txt1.setText(dataModel.getDate());
        viewHolder.txt2.setText(dataModel.getReason());
        viewHolder.txt3.setText(dataModel.getWhat());
       // viewHolder.info.setOnClickListener(this);
       // viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }


}
