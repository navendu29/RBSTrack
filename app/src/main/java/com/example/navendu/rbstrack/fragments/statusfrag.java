package com.example.navendu.rbstrack.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Auth;
import com.example.navendu.rbstrack.services.apiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class statusfrag extends Fragment {


    Retrofit retrofit;
    apiService api;
    String racf;
    String name;
    Button h;
    View v;
    RadioGroup r;
    TextView po;

    public statusfrag() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_statusfrag, container, false);
      Intent i=getActivity().getIntent();


        racf=i.getStringExtra("rr");
        Button sendBtn = (Button) v.findViewById(R.id.buttr);

         h = (Button) v.findViewById(R.id.buttr1);


        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(apiService.base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                r=(RadioGroup) v.findViewById(R.id.pp);


                String status =
                        ((RadioButton)v.findViewById(r.getCheckedRadioButtonId()))
                                .getText().toString();
                api=retrofit.create(apiService.class);
                Call<Auth> call1=api.updatestatus(racf,status);
                call1.enqueue(new Callback<Auth>() {
                    @Override
                    public void onResponse(Call<Auth> call1, Response<Auth> response) {



                        Auth b=response.body();

                        String ss=b.getValue();

                        if(ss.equals("true"))
                        {

                            Toast.makeText(v.getContext(), "updated successfully",
                                    Toast.LENGTH_LONG).show();

                        }
                        else
                        {           Toast.makeText(v.getContext(), "Cannot update",
                                Toast.LENGTH_LONG).show();


                        }


                    }

                    @Override
                    public void onFailure(Call<Auth> call1, Throwable t) {


                        Toast.makeText(v.getContext(), "No INternet Connection",
                                Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });


        h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                retrofit = new Retrofit.Builder()
                        .baseUrl(apiService.base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                SearchView st=v.findViewById(R.id.ss);


                name= st.getQuery().toString();

                api=retrofit.create(apiService.class);
                Call<Auth> call1=api.getstatus(name);
                call1.enqueue(new Callback<Auth>() {
                    @Override
                    public void onResponse(Call<Auth> call1, Response<Auth> response) {



                        Auth b=response.body();

                        String ss=b.getValue();




 po= v.findViewById(R.id.jjk);

                       po.setText(ss+"");
                    }

                    @Override
                    public void onFailure(Call<Auth> call1, Throwable t) {


                        Toast.makeText(v.getContext(), "(cannot find racf) No Internet Connection"+name,
                                Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });


        return v;
    }

}
