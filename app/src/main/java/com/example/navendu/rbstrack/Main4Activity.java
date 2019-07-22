package com.example.navendu.rbstrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.navendu.rbstrack.fragments.ProfileFragment;
import com.example.navendu.rbstrack.fragments.addemployee;
import com.example.navendu.rbstrack.fragments.deleteemployee;

public class Main4Activity extends AppCompatActivity {


String racf;
String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    //    getSupportActionBar().hide();




        Intent i= getIntent();

        racf=i.getStringExtra("rr");

        password=i.getStringExtra("rrr");


        Button sendBtn = (Button) findViewById(R.id.b1);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //         sendSMSMessage();



                Fragment fragment = new addemployee();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.ff, fragment);
                transaction.commit();




            }

        });





        Button sendBtn1 = (Button) findViewById(R.id.b2);

        sendBtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //         sendSMSMessage();


                Fragment fragment = new deleteemployee();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.ff, fragment);
                transaction.commit();



            }

        });













    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.newGame){


            Intent i = new Intent(getApplicationContext(),Main2Activity.class);

            i.putExtra("rr",racf);

            i.putExtra("rrr",password);


            startActivity(i);
            finish();




            //  resetBoard();
        }
        return true;
    }

}
