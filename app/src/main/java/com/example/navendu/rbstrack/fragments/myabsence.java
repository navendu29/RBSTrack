package com.example.navendu.rbstrack.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Contacts;
import com.example.navendu.rbstrack.model.leaves;
import com.example.navendu.rbstrack.services.apiService;
import com.example.navendu.rbstrack.Adapters.contactadapter;

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
contactadapter cc;

ArrayList<Contacts> pop;
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

        jj=v.getContext();

        Intent i=  getActivity().getIntent();

        racf=i.getStringExtra("rr");

        password=i.getStringExtra("rrr");










         retrofit = new Retrofit.Builder()
                .baseUrl(apiService.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();







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

                        String aa=b.getReason();


                        pop=new ArrayList<Contacts>();

                        String[] p=  dd.split(",");
                        String[] jjj=aa.split(",");





                        String ans="";
                        for(int i=1;i<p.length;++i)
                        {
                            //
                            // ans+=p[i]+"\n";

                            pop.add(new Contacts(p[i],jjj[i]));

                        }

                        //  t3.setText(ans);


                        cc = new contactadapter(pop,jj);
                        hh.setAdapter(cc);


                    }

                    @Override
                    public void onFailure(Call<leaves> call, Throwable t) {
                        Toast.makeText(jj, "No Internet Connection",
                                Toast.LENGTH_LONG).show();

                    }
                });





        return v;
    }

}
