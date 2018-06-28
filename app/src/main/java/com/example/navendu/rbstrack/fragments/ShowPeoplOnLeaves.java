package com.example.navendu.rbstrack.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.navendu.rbstrack.MainActivity;
import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.services.Main3Activity;

public class ShowPeoplOnLeaves extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    CalendarView g;
    Context jj;
    public ShowPeoplOnLeaves() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View v= inflater.inflate(R.layout.fragment_show_peopl_on_leaves, container, false);

        g=v.findViewById(R.id.callp);
        jj=v.getContext();

        g.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {


                int f=1+i1;
                String str=i2+"-"+f+"-"+i;
                Intent k = new Intent(jj, Main3Activity.class);

                k.putExtra("hehe",str);

                startActivity(k);
               // finish();


            }
        });





    return v;
    }

}
