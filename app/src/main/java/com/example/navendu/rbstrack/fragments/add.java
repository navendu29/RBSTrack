package com.example.navendu.rbstrack.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

public class add extends AppCompatActivity {
    EditText e;
    EditText e1;
   Retrofit retrofit;
    apiService api;
    String racf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        Button sendBtn = (Button) findViewById(R.id.rr);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                retrofit = new Retrofit.Builder()
                        .baseUrl(apiService.base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                e=findViewById(R.id.editText1);
                e1=findViewById(R.id.editText2);

                String str1=e.getText().toString()+"";
                String str2=e1.getText().toString()+"";

                Intent i=getIntent();


                racf=i.getStringExtra("rr");

                api=retrofit.create(apiService.class);
                Call<Auth> call1=api.updating(racf,str1,str2);
                call1.enqueue(new Callback<Auth>() {
                    @Override
                    public void onResponse(Call<Auth> call1, Response<Auth> response) {



                        Auth b=response.body();

                        String ss=b.getValue();

                        if(ss.equals("true"))
                        {

                            Toast.makeText(getApplicationContext(), "contact added",
                                    Toast.LENGTH_LONG).show();
                            e.setText("");
                            e1.setText("");

                        }
                        else
                        {           Toast.makeText(getApplicationContext(), "invalid credentials.",
                                Toast.LENGTH_LONG).show();

                        }

                    }

                    @Override
                    public void onFailure(Call<Auth> call1, Throwable t) {
                        Toast.makeText(getApplicationContext(), "invalid credentials or net is not working",
                                Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

}
