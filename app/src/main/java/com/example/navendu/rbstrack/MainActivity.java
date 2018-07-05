package com.example.navendu.rbstrack;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navendu.rbstrack.model.Auth;
import com.example.navendu.rbstrack.model.Employee;
import com.example.navendu.rbstrack.services.apiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    EditText e3;
    String racf;
    String pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }
    public  void navigate(final View view)
    {




    e1=findViewById(R.id.e1);
    e3=findViewById(R.id.e3);






        final String BASE_URL = "http://192.168.43.154:8081/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         racf=e1.getText().toString();
         pass=e3.getText().toString();


       // TextView k=findViewById(R.id.oo);


        //if(racf.equals("true")) {
         //   k.setText(racf + "=>" + pass);





        apiService api=retrofit.create(apiService.class);
        Call<Auth> call=api.getAuth(racf,pass);
        call.enqueue(new Callback<Auth>() {
            @Override
            public void onResponse(Call<Auth> call, Response<Auth> response) {



                Auth b=response.body();

                String ss=b.getValue();

             if(ss.equals("true"))
             {


                 Intent i = new Intent(getApplicationContext(),Main2Activity.class);

                i.putExtra("rr",racf);
                 i.putExtra("rrr",pass);


                 startActivity(i);


                 finish();
             }
             else
             {           Toast.makeText(getApplicationContext(), "invalid credentials.",
                     Toast.LENGTH_LONG).show();
                 e1.setError("invalid");
                 e3.setError("invalid");
                 Log.i("hello",e1.toString());
                 Log.i("hello",e3.toString());



             }


                //console.log();

//  v4.setText(b.getLeaves());
                //  v5.setText(b.getLeavestaken());
                //   v6.setText(b.getWorkfromhome());



            }

            @Override
            public void onFailure(Call<Auth> call, Throwable t) {


                e1.setError("invalid");
                e3.setError("invalid");


                Toast.makeText(getApplicationContext(), "invalid credentials or net is not working",
                        Toast.LENGTH_SHORT).show();

            }
        });





    }
}
