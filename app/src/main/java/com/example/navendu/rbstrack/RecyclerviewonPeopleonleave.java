package com.example.navendu.rbstrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RecyclerviewonPeopleonleave extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerviewon_peopleonleave);




  //      call.enqueue(new Callback<ImageDisplay>() {
//                @Override
//                public void onResponse(Call<ImageDisplay> call, Response<ImageDisplay> response) {
//
//
//                   ImageDisplay g= response.body();
//
//
//           List<Worldpopulation>  hd=(ArrayList<Worldpopulation>) g.getWorldpopulation();
//
//
//           ww=new ArrayList<Worldpopulation>();
//           for(Worldpopulation k:hd)
//           {
//               ww.add(k);
//
//           }
//
//
//
//
//
//                    recyclerView = findViewById(R.id.recycler_view);
//
//
//                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
//
//                    ImageAdapter studentsAdapter = new ImageAdapter(ww,getApplicationContext());
//                    recyclerView.setAdapter(studentsAdapter);
//
//
//
//
//
//                }
//
//
//
//
//
//
//                @Override
//                public void onFailure(Call<ImageDisplay> call, Throwable t) {
//                    Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
//
//                }
//            });



        }
}
