package com.example.navendu.rbstrack.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.navendu.rbstrack.Adapters.customadapter;
import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.Main3Activity;
import com.example.navendu.rbstrack.model.Datesss;
import com.example.navendu.rbstrack.model.peopleonleave;
import com.example.navendu.rbstrack.services.apiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowPeoplOnLeaves extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    CalendarView g;
    Context jj;
    ArrayList<peopleonleave>arr;
    View v;
    String str;
    customadapter adapter;
    public ShowPeoplOnLeaves() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         v= inflater.inflate(R.layout.fragment_show_peopl_on_leaves, container, false);

        g=v.findViewById(R.id.callp);
        jj=v.getContext();



        g.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {


                int f=1+i1;
                 str=i2+"-"+f+"-"+i;

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(apiService.base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                apiService api=retrofit.create(apiService.class);
                Call<Datesss> call=api.getdetailsondate(str);
                call.enqueue(new Callback<Datesss>() {
                    @Override
                    public void onResponse(Call<Datesss> call, Response<Datesss> response) {



                        Datesss b=response.body();
                        arr=new ArrayList<peopleonleave>();




                        if(b.getRacf()=="")
                        {


                        }
                        else {

                            String[] h1 = b.getRacf().split(",");
                            String[] h2 = b.getReason().split(",");
                            String[] h3 = b.getWL().split(",");


                            for (int i = 0; i < h1.length; ++i) {
                                arr.add(new peopleonleave(h1[i], h2[i], h3[i]));

                            }


                        }


                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());
                        LayoutInflater inflater = getLayoutInflater();
                        View convertView = (View) inflater.inflate(R.layout.activity_main3, null);
                        alertDialog.setView(convertView);
                        alertDialog.setTitle(str);
                        ListView lv = (ListView)convertView.findViewById(R.id.kk);
                         adapter = new customadapter(arr,v.getContext());
                        lv.setAdapter(adapter);
                        alertDialog.show();


                    }

                    @Override
                    public void onFailure(Call<Datesss> call, Throwable t) {


                        Toast.makeText(v.getContext(), "No Internet Connection",
                                Toast.LENGTH_LONG).show();

                    }
                });



            }
        });





    return v;
    }

}
