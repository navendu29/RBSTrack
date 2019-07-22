package com.example.navendu.rbstrack.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navendu.rbstrack.Main2Activity;
import com.example.navendu.rbstrack.Main4Activity;
import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Auth;
import com.example.navendu.rbstrack.services.apiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdminFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
   EditText e1;
   EditText e2;
    View v;

    public AdminFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v= inflater.inflate(R.layout.fragment_admin, container, false);
       Button sendBtn = (Button) v.findViewById(R.id.pp);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                e1=v.findViewById(R.id.e1);
                e2=v.findViewById(R.id.e3);

                String id = e1.getText().toString();
                String pass = e2.getText().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(apiService.base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                apiService api = retrofit.create(apiService.class);
                Call<Auth> call = api.getadminauth(id, pass);
                call.enqueue(new Callback<Auth>() {
                    @Override
                    public void onResponse(Call<Auth> call, Response<Auth> response) {


                        Auth b = response.body();

                        String ss = b.getValue();

                        if (ss.equals("true")) {


                            Intent i = new Intent(v.getContext(), Main4Activity.class);


                            i.putExtra("rr",getActivity().getIntent().getStringExtra("rr"));
                            i.putExtra("rrr",getActivity().getIntent().getStringExtra("rrr"));


                            startActivity(i);


                        } else {
                            Toast.makeText(getContext(), "invalid credentials.",
                                    Toast.LENGTH_LONG).show();
                            e1.setError("invalid");
                            e2.setError("invalid");
                            Log.i("hello", e1.toString());
                            Log.i("hello", e2.toString());


                        }
                    }

                    @Override
                    public void onFailure(Call<Auth> call, Throwable t) {


                        e1.setError("invalid");
                        e2.setError("invalid");


                        Toast.makeText(getContext(), "No Internet Connection",
                                Toast.LENGTH_SHORT).show();

                    }
                });

            }

        });
        return v;
    }

}
