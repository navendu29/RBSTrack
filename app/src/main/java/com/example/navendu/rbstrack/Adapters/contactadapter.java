package com.example.navendu.rbstrack.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Contacts;

import java.util.ArrayList;

/**
 * Created by navendu on 5/7/18.
 */

public class contactadapter extends ArrayAdapter<Contacts> {

    private ArrayList<Contacts> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txt1;
        TextView txt2;
        // ImageView info;
    }



    public contactadapter(ArrayList<Contacts> data, Context context) {
        super(context, R.layout.contact_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Contacts dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        contactadapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new contactadapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.contact_item, parent, false);
            viewHolder.txt1 = (TextView) convertView.findViewById(R.id.yy);
            viewHolder.txt2 = (TextView) convertView.findViewById(R.id.yy1);
//            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (contactadapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.txt1.setText(dataModel.getName());
        viewHolder.txt2.setText(dataModel.getPhone());
        // viewHolder.info.setOnClickListener(this);
        // viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }

}
