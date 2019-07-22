package com.example.navendu.rbstrack.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Auth;
import com.example.navendu.rbstrack.model.Employee;
import com.example.navendu.rbstrack.services.apiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplyForWorkFromHome extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    CalendarView  calendarView;
    View v;
    Button b;
    EditText e;
    apiService api;
    Retrofit retrofit;
    ArrayList<String> arr;
    Button j;
    //CalendarView g;
String racf;

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
String password;
    String dy;
    CalendarView g;
    String du;
    public ApplyForWorkFromHome() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_apply_for_work_from_home, container, false);
        calendarView =  v.findViewById(R.id.call1);

       // getActivity().getActionBar().setTitle("WORK FROM HOME");


      //  sendSMSMessage();

       // calendarView.setMarkedStyle(MarkStyle.BACKGROUND, Color.parseColor("#ffb6b9"));
        final String BASE_URL = "http://192.168.43.81:8081/";

         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Intent i=  getActivity().getIntent();

        racf=i.getStringExtra("rr");

        password=i.getStringExtra("rrr");


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {


                int f=1+i1;
                dy=i2+"-"+f+"-"+i;


            }
        });


        api=retrofit.create(apiService.class);
//        Call<WorkFromHome> call=api.getwfhdates(racf);
//        call.enqueue(new Callback<WorkFromHome>() {
//            @Override
//            public void onResponse(Call<WorkFromHome> call, Response<WorkFromHome> response) {
//                WorkFromHome b=response.body();
//                String dd=b.getDates();
//
//                String[] p=  dd.split(",");
//                for(int i=0;i<p.length;++i)
//                {
//
//                    String[]kk= p[i].split("-");
//
//                    calendarView.markDate(Integer.parseInt(kk[2]),Integer.parseInt(kk[1]) , Integer.parseInt(kk[0]));
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<WorkFromHome> call, Throwable t) {
//
//
//                Toast.makeText(getContext(), "not connecting sent.",
//                        Toast.LENGTH_LONG).show();
//
//            }
//        });


//       g=v.findViewById(R.id.call1);
//
//        g.setOnDateClickListener(new OnDateClickListener() {
//            @Override
//            public void onDateClick(View view, DateData date) {
//               // Toast.makeText(v.getContext(), String.format("%d-%d", date.getMonth(), date.getDay()), Toast.LENGTH_SHORT).show();
//
//                calendarView.setMarkedStyle(MarkStyle.BACKGROUND, Color.parseColor("#ffb6b9"));
//
//                g.markDate(date.getYear(),date.getMonth() , date.getDay());
//
//
//                dy=date.getDay()+"-"+date.getMonth()+"-"+date.getYear();
//
//            }
//        });


        b=v.findViewById(R.id.buttonb);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //         sendSMSMessage();





//                Log.i("hello",du);

                    EditText e=v.findViewById(R.id.editText2);

                String h=e.getText().toString()+"";


                Call<Auth> call1=api.updatingwfh(racf,dy+"",h+"");
                call1.enqueue(new Callback<Auth>() {
                    @Override
                    public void onResponse(Call<Auth> call1, Response<Auth> response) {



                        Auth b=response.body();

                        String ss=b.getValue();

                        if(ss.equals("true"))
                        {

                            Toast.makeText(v.getContext(), "success credentials.",
                                    Toast.LENGTH_LONG).show();



                        }
                        else
                        {           Toast.makeText(v.getContext(), "invalid credentials.",
                                Toast.LENGTH_LONG).show();


                        }



                    }

                    @Override
                    public void onFailure(Call<Auth> call1, Throwable t) {


                        Toast.makeText(v.getContext(), "invalid credentials or net is not working",
                                Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });




        j=v.findViewById(R.id.nnt);
        j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //         sendSMSMessage();

                Call<Employee> call=api.getProfilehero(racf,password);


                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {



                        Employee b=response.body();

                        //console.log();


                        String names= b.getContacts();


                        String[] sp=names.split(",");
//                        for(int i=0;i<sp.length;++i)
//                        {
//
//                            SmsManager smsManager = SmsManager.getDefault();
//                  smsManager.sendTextMessage("91"+sp[i]+"", null, "navendu will be on leave today", null, null);
//
//
//                        }


                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:"+names));
                        smsIntent.putExtra("sms_body", racf+" willl be working from home"+dy);
                        startActivity(smsIntent);


                        // hh.setLayoutManager(new LinearLayoutManager(jj, LinearLayoutManager.VERTICAL, false));






                        //vv.setText(b.getRacf()+"hello"+b.getContactnames()+""+b.getPhoneno());


                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {


                        Toast.makeText(getContext(), "not connecting sent.",
                                Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });












        return v;
    }

    protected void sendSMSMessage() {

        if (ContextCompat.checkSelfPermission(this.getContext(),
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(),
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this.getActivity(),
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    SmsManager smsManager = SmsManager.getDefault();
//                    smsManager.sendTextMessage("918447180858", null, "navendu will be on leave today", null, null);
           Toast.makeText(getContext(), "SMS ready sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }
}





















