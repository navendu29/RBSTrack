package com.example.navendu.rbstrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        ImageView i2 = (ImageView) findViewById(R.id.im1);
        Picasso.with(this)
                .load(R.drawable.r1)
                .into(i2);

        Thread myth = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();

                } catch (InterruptedException e) {


                }


            }

        };

        myth.start();
    }

}