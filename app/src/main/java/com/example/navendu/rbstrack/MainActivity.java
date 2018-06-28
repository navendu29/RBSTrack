package com.example.navendu.rbstrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }
    public  void navigate(View view)
    {
        Intent i = new Intent(view.getContext(),Main2Activity.class);
        startActivity(i);
        finish();

    }
}
