package com.example.navendu.rbstrack.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Auth;
import com.example.navendu.rbstrack.services.apiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class addemployee extends Fragment {

    View v;
    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;
    EditText e5;
    EditText e6;
    EditText e7;


    public addemployee() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_addemployee, container, false);
  Button sendBtn2 = (Button) v.findViewById(R.id.pp);

        sendBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                e1=v.findViewById(R.id.racf);
                e2=v.findViewById(R.id.name);
                e3=v.findViewById(R.id.phoneno);
                e4=v.findViewById(R.id.password);
                e5=v.findViewById(R.id.leaves);
                e6=v.findViewById(R.id.contacts);
                e7=v.findViewById(R.id.contactnames);



                String s1=e1.getText().toString();

                String s2=e2.getText().toString();

                String s3=e3.getText().toString();

                String s4=e4.getText().toString();

                String s5=e5.getText().toString();

                String s6=e6.getText().toString();

                String s7=e7.getText().toString();




            //    final String BASE_URL = "http://192.168.43.154:8081/";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(apiService.base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                apiService api=retrofit.create(apiService.class);
                Call<Auth> call=api.getadd(s1,s2,s3,s4,s5,s6,s7);
                call.enqueue(new Callback<Auth>() {
                    @Override
                    public void onResponse(Call<Auth> call, Response<Auth> response) {



                        Auth b=response.body();

                        String ss=b.getValue();

                        if(ss.equals("true"))
                        {

                            Toast.makeText(v.getContext(), "added",
                                    Toast.LENGTH_LONG).show();


                            e1.setText("");
                            e2.setText("");
                            e3.setText("");
                            e4.setText("");
                            e5.setText("");
                            e6.setText("");
                            e7.setText("");



                            //finish();
                        }
                        else
                        {           Toast.makeText(v.getContext(), "can't add",
                                Toast.LENGTH_LONG).show();

                        }




                    }

                    @Override
                    public void onFailure(Call<Auth> call, Throwable t) {




                        Toast.makeText(v.getContext(), "No Internet Connection",
                                Toast.LENGTH_SHORT).show();

                    }
                });
            }

        });






        return v;

    }

}
