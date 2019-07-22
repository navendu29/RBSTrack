package com.example.navendu.rbstrack.fragments;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
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

public class ApplyForLeave extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    CalendarView  calendarView;
String dy;
Button b;
Button j;
String racf;
String password;
Spinner mySpinner;
String text;
apiService api;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    View v;

Spinner dropdown;
    ArrayList<String>pp;
    // TODO: Rename and change types of parameters
    public ApplyForLeave() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v= inflater.inflate(R.layout.fragment_apply_for_leave, container, false);



 dropdown = v.findViewById(R.id.spp);
//create a list of items for the spinner.
        String[] items = new String[]{"Sick Leave", "Travel Leave", "WFH"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

      //  getActivity().getActionBar().setTitle("LEAVES");


        calendarView =  v.findViewById(R.id.call);



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {


                int f=1+i1;
                dy=i2+"-"+f+"-"+i;


            }
        });




        //calendarView.setMarkedStyle(MarkStyle.BACKGROUND, Color.parseColor("#ffb6b9"));






      //  final String BASE_URL = "http://192.168.43.154:8081/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiService.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        Intent i=  getActivity().getIntent();

        racf=i.getStringExtra("rr");

        password=i.getStringExtra("rrr");


        api=retrofit.create(apiService.class);
//        Call<leaves> call=api.getleavedates(racf);
//        call.enqueue(new Callback<leaves>() {
//            @Override
//            public void onResponse(Call<leaves> call, Response<leaves> response) {
//                leaves b=response.body();
//                String dd=b.getDate();
//
//                 String[] p=  dd.split(",");
//
//                 for(int i=0;i<p.length;++i)
//                 {
//                    String[]kk= p[i].split("-");
//
//                     calendarView.markDate(Integer.parseInt(kk[2]),Integer.parseInt(kk[1]) , Integer.parseInt(kk[0]));
//                 }
//
//            }
//
//            @Override
//            public void onFailure(Call<leaves> call, Throwable t) {
//                Toast.makeText(getContext(), "not connecting sent.",
//                        Toast.LENGTH_LONG).show();
//
//            }
//        });
//





 //       calendarView=v.findViewById(R.id.call);
//
//        calendarView.setOnDateClickListener(new OnDateClickListener() {
//            @Override
//            public void onDateClick(View view, DateData date) {
//                // Toast.makeText(v.getContext(), String.format("%d-%d", date.getMonth(), date.getDay()), Toast.LENGTH_SHORT).show();
//
//                calendarView.setMarkedStyle(MarkStyle.BACKGROUND, Color.parseColor("#ffb6b9"));
//
//                calendarView.markDate(date.getYear(),date.getMonth() , date.getDay());
//
//
//                dy=date.getDay()+"-"+date.getMonth()+"-"+date.getYear();
//
//            }
//        });


        b=v.findViewById(R.id.buttonn);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //         sendSMSMessage();





//                Log.i("hello",du);

//                EditText e=v.findViewById(R.id.editText4);



                mySpinner=v.findViewById(R.id.spp);
                 text = mySpinner.getSelectedItem().toString();

                //String h=e.getText().toString()+"";


                Call<Auth> call1=api.updatingleave(racf,dy+"",text+"");
                call1.enqueue(new Callback<Auth>() {
                    @Override
                    public void onResponse(Call<Auth> call1, Response<Auth> response) {



                        Auth b=response.body();

                        String ss=b.getValue();

                        if(ss.equals("true"))
                        {

                            Toast.makeText(v.getContext(), "leave saved",
                                    Toast.LENGTH_LONG).show();



                        }
                        else
                        {           Toast.makeText(v.getContext(), "can't apply",
                                Toast.LENGTH_LONG).show();


                        }



                    }

                    @Override
                    public void onFailure(Call<Auth> call1, Throwable t) {


                        Toast.makeText(v.getContext(), "No Internet Connection",
                                Toast.LENGTH_SHORT).show();

                    }
                });



                Call<Employee> call=api.getProfilehero(racf,password);


                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {



                        Employee b=response.body();

                        //console.log();


                        String names= b.getContacts();


                        String[] sp=names.split(",");

                        names= names.replace(",",";");
//                        for(int i=0;i<sp.length;++i)
//                        {
//
//                            SmsManager smsManager = SmsManager.getDefault();
//                            smsManager.sendTextMessage("91"+sp[i]+"", null, "navendu will be on leave today", null, null);
//
//
//                        }

                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:"+names));
                        smsIntent.putExtra("sms_body", racf+" willl be on"+text+ "on "+dy);
                        startActivity(smsIntent);



                        // hh.setLayoutManager(new LinearLayoutManager(jj, LinearLayoutManager.VERTICAL, false));






                        //vv.setText(b.getRacf()+"hello"+b.getContactnames()+""+b.getPhoneno());


                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {


                        Toast.makeText(getContext(), "No Internet Connection",
                                Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });


        return v;
    }


}