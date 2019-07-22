package com.example.navendu.rbstrack.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navendu.rbstrack.Main2Activity;
import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Auth;
import com.example.navendu.rbstrack.services.apiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class deleteemployee extends Fragment {

   EditText e1;
   String id;
   View v;
    public deleteemployee() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v= inflater.inflate(R.layout.fragment_deleteemployee, container, false);

        Button sendBtn2 = (Button) v.findViewById(R.id.pp);

        sendBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //         sendSMSMessage();






//                final String BASE_URL = "http://192.168.43.154:8081/";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(apiService.base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

e1=v.findViewById(R.id.e1);
                id=e1.getText().toString();


                // TextView k=findViewById(R.id.oo);


                //if(racf.equals("true")) {
                //   k.setText(racf + "=>" + pass);





                apiService api=retrofit.create(apiService.class);
                Call<Auth> call=api.getdel(id);
                call.enqueue(new Callback<Auth>() {
                    @Override
                    public void onResponse(Call<Auth> call, Response<Auth> response) {



                        Auth b=response.body();

                        String ss=b.getValue();

                        if(ss.equals("true"))
                        {

                            Toast.makeText(v.getContext(), "deleted",
                                    Toast.LENGTH_LONG).show();

                            e1.setText("");


                            //finish();
                        }
                        else
                        {           Toast.makeText(v.getContext(), "invalid racf",
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
