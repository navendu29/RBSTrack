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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Auth;
import com.example.navendu.rbstrack.services.apiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class changepassFragment extends Fragment {


    Retrofit retrofit;
    EditText edittext;
    EditText edittext3;
    apiService api;
    View v;
    String racf;

    public changepassFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v= inflater.inflate(R.layout.fragment_changepass, container, false);


        Button sendBtn = (Button) v.findViewById(R.id.bbh);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                edittext=v.findViewById(R.id.editText);
                edittext3=v.findViewById(R.id.editText3);

                if(!edittext.getText().toString().equals(edittext3.getText().toString()))
                {

                    Toast.makeText(v.getContext(), "Password don't match",
                            Toast.LENGTH_SHORT).show();


                }
                else
                {

                    retrofit = new Retrofit.Builder()
                            .baseUrl(apiService.base_url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    Intent i=  getActivity().getIntent();

                    racf=i.getStringExtra("rr");


                    api=retrofit.create(apiService.class);
                    Call<Auth> call1=api.getd(racf,edittext.getText().toString());
                    call1.enqueue(new Callback<Auth>() {
                        @Override
                        public void onResponse(Call<Auth> call1, Response<Auth> response) {



                            Auth b=response.body();

                            String ss=b.getValue();

                            if(ss.equals("true"))
                            {

                                Toast.makeText(v.getContext(), "updated successfully",
                                        Toast.LENGTH_LONG).show();


                                edittext.setText("");
                                edittext3.setText("");

                                //  studentadapter.notifyDataSetChanged();


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





            }




        });




                return v;
    }

}
