package com.example.navendu.rbstrack.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Employee;
import com.example.navendu.rbstrack.model.posts;
import com.example.navendu.rbstrack.services.apiService;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Employee> ww;
      TextView v1;
      TextView v2;

    TextView v3;
    TextView v4;
    TextView v5;
    TextView v6;
    Context f;
    private RecyclerView recyclerView;
View v;

String racf;
String password;
    // private OnFragmentInteractionListener mListener;

    public ProfileFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileFragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v= inflater.inflate(R.layout.fragment_profile, container, false);

       //  getActivity().getActionBar().setTitle("PROFILE");

//         getActivity().getIntent();
       v1= v.findViewById(R.id.t1);

        v2= v.findViewById(R.id.t2);

        v3= v.findViewById(R.id.t3);

        v4= v.findViewById(R.id.t4);

        v5= v.findViewById(R.id.t5);

        v6= v.findViewById(R.id.t6);

        f=v.getContext();

        Intent i=  getActivity().getIntent();

         racf=i.getStringExtra("rr");

         password=i.getStringExtra("rrr");


        final String BASE_URL = "http://192.168.43.154:8081/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

apiService api=retrofit.create(apiService.class);
        Call<Employee> call=api.getProfilehero(racf,password);
        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {



                Employee b=response.body();

                //console.log();




                v1.setText(b.getName()+"");
                v2.setText(b.getRacf()+"");
                v3.setText(b.getPhoneno()+"");
                v4.setText(b.getLeaves()+"");
               v5.setText(b.getLeavestaken()+"");
                v6.setText(b.getWorkfromhome()+"");



            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {


                Toast.makeText(f, "not connecting sent.",
                        Toast.LENGTH_LONG).show();

            }
        });


//        ArrayList<Employee> arr=new ArrayList<>();
//        arr.add(new Employee("navendu","helo","hehkhke","sajgcjab",42,0,0,"contacts","names"));
//        arr.add(new Employee("akshay","helo","hehkhke","sajgcjab",42,0,0,"contacts","names"));
//
//
//                    recyclerView = v.findViewById(R.id.recyclerView);
//
//
//                    recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext(), LinearLayoutManager.VERTICAL, false));
//
//                    ProfileAdapter studentsAdapter = new ProfileAdapter(arr, v.getContext());
//                    recyclerView.setAdapter(studentsAdapter);





                    return v;
                }




}
