package com.example.navendu.rbstrack.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.WorkFromHome;
import com.example.navendu.rbstrack.model.leaves;
import com.example.navendu.rbstrack.services.apiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class myabsence extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
apiService api;
String racf;
String password;
TextView t4;
View v;
    ArrayList<String>sample1;

ArrayList<String>sample;
TextView t3;
Context jj;
    ArrayAdapter<String> studentadapter;
    ArrayAdapter<String> studentadapter1;

    Retrofit retrofit;

    ListView hh;
    ListView hh1;
    public myabsence() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v= inflater.inflate(R.layout.fragment_myabsence, container, false);


     //   getActivity().getActionBar().setTitle("MY ABSENCE");


        jj=v.getContext();
        final String BASE_URL = "http://192.168.43.154:8081/";


        Intent i=  getActivity().getIntent();

        racf=i.getStringExtra("rr");

        password=i.getStringExtra("rrr");










         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();





        Button sendBtn = (Button) v.findViewById(R.id.m);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                api=retrofit.create(apiService.class);
                Call<leaves> call=api.getleavedates(racf);

                t4=v.findViewById(R.id.textView2);

                t4.setText("leaves taken");

                sample=new ArrayList<String>();

                hh=v.findViewById(R.id.ll1);

                call.enqueue(new Callback<leaves>() {
                    @Override
                    public void onResponse(Call<leaves> call, Response<leaves> response) {
                        leaves b=response.body();
                        String dd=b.getDate();

                        String[] p=  dd.split(",");



                        String ans="";
                        for(int i=0;i<p.length;++i)
                        {
                            //
                            // ans+=p[i]+"\n";

                            sample.add(p[i]);

                        }

                        //  t3.setText(ans);

                        studentadapter = new ArrayAdapter<String>(jj,android.R.layout.simple_list_item_1,sample);
                        hh.setAdapter(studentadapter);


                    }

                    @Override
                    public void onFailure(Call<leaves> call, Throwable t) {
                        Toast.makeText(jj, "not connecting sent.",
                                Toast.LENGTH_LONG).show();

                    }
                });



            }});





        Button sendBt = (Button) v.findViewById(R.id.n);

        sendBt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {



                api=retrofit.create(apiService.class);
                sample1 = new ArrayList<String>();
                Call<WorkFromHome> call1 = api.getwfhdates(racf);
                call1.enqueue(new Callback<WorkFromHome>() {
                    @Override
                    public void onResponse(Call<WorkFromHome> call1, Response<WorkFromHome> response) {
                        WorkFromHome b = response.body();
                        String dd = b.getDates();





                        t4=v.findViewById(R.id.textView2);

                        t4.setText("wfh taken");


                        hh = v.findViewById(R.id.ll1);

                        String[] p = dd.split(",");

                        String ans = "";
                        for (int i = 0; i < p.length; ++i) {
                            //          ans+=p[i]+"\n";

                            sample1.add(p[i]);


                        }


                        studentadapter1 = new ArrayAdapter<String>(jj, android.R.layout.simple_list_item_1, sample1);
                        hh.setAdapter(studentadapter1);

//                t4.setText(ans);


                    }

                    @Override
                    public void onFailure(Call<WorkFromHome> call1, Throwable t) {


                        Toast.makeText(jj, "not connecting sent.",
                                Toast.LENGTH_LONG).show();

                    }
                });
            }
            });




        return v;
    }

}
