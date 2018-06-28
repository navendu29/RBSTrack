package com.example.navendu.rbstrack.fragments;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navendu.rbstrack.R;

import java.util.Calendar;

import sun.bob.mcalendarview.MarkStyle;
import sun.bob.mcalendarview.vo.DateData;

public class ApplyForLeave extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    public ApplyForLeave() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View v= inflater.inflate(R.layout.fragment_apply_for_leave, container, false);

    sun.bob.mcalendarview.MCalendarView  calendarView =  v.findViewById(R.id.call);
     calendarView.markDate(2018, 10, 7);
     calendarView.setMarkedStyle(MarkStyle.BACKGROUND, Color.parseColor("#ffb6b9"));
    return v;
    }
}