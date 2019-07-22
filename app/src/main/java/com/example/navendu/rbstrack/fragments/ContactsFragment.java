package com.example.navendu.rbstrack.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.navendu.rbstrack.R;
import com.example.navendu.rbstrack.model.Contacts;
import com.example.navendu.rbstrack.model.Employee;
import com.example.navendu.rbstrack.services.apiService;
import com.example.navendu.rbstrack.Adapters.contactadapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ContactsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    Retrofit retrofit;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<String> arr;

    ArrayList<Contacts> nav;
    contactadapter g;


    ListView hh;
    Context jj;
    String racf;
    Context f;

    String password;
    EditText e;
    EditText e1;
    ArrayAdapter<String> studentadapter;
//    final String BASE_URL = "http://192.168.43.154:8081/";

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    View v;
    apiService api;
    public ContactsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




         v= inflater.inflate(R.layout.fragment_contacts, container, false);

    //    getActivity().getSupportActionBar().setTitle("CONTACTS");


        f=v.getContext();

         retrofit = new Retrofit.Builder()
                .baseUrl(apiService.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Intent i=  getActivity().getIntent();

        racf=i.getStringExtra("rr");

        password=i.getStringExtra("rrr");


        arr=new ArrayList<String>();

jj=v.getContext();

        hh = v.findViewById(R.id.recyclerView);
//

        nav=new ArrayList<Contacts>();
         api=retrofit.create(apiService.class);
        Call<Employee> call=api.getProfilehero(racf,password);


        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {



                Employee b=response.body();

                //console.log();


            String names= b.getContactnames();

            String con=b.getContacts();


            String[] sp=names.split(",");
            String[] sp1=con.split(",");
                for(int i=0;i<sp.length;++i)
                {


                    nav.add(new Contacts(sp[i],sp1[i]));



                }

                    g = new contactadapter(nav,jj);
                    hh.setAdapter(g);

            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {


                Toast.makeText(f, "No Internet Connection",
                        Toast.LENGTH_SHORT).show();

            }
        });


        Button sendBtn = (Button) v.findViewById(R.id.rr);

        sendBtn.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View view) {
                                           //         sendSMSMessage();





                                           Intent i = new Intent(getActivity().getApplicationContext(),add.class);

                                           i.putExtra("rr",racf);


                                           startActivity(i);


                                          // finish();



                                       }
                                   });






return v;

    }


}
