package com.example.navendu.rbstrack.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Datesss;
import com.example.navendu.rbstrack.model.Employee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main3Activity extends AppCompatActivity {


    TextView kk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent i=getIntent();

        String datek=i.getStringExtra("hehe");

    kk=findViewById(R.id.lll);
    kk.setText(datek);


        final String BASE_URL = "http://192.168.1.7:8081/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService api=retrofit.create(apiService.class);
        Call<Datesss> call=api.getdetailsondate(datek);
        call.enqueue(new Callback<Datesss>() {
            @Override
            public void onResponse(Call<Datesss> call, Response<Datesss> response) {



                Datesss b=response.body();

                kk.setText(b.getRacf()+""+b.getReason()+"");





            }

            @Override
            public void onFailure(Call<Datesss> call, Throwable t) {


                Toast.makeText(getApplicationContext(), "not connecting sent.",
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}
