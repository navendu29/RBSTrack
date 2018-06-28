package com.example.navendu.rbstrack.services;

import com.example.navendu.rbstrack.model.Datesss;
import com.example.navendu.rbstrack.model.Employee;
import com.example.navendu.rbstrack.model.posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by navendu on 27/6/18.
 */

public interface apiService {



    String base_url="http://192.168.1.7:8081/";


    @GET("getprofile")
    Call<Employee> getProfilehero(@Query("racf") String id,@Query("password") String pass);

    @GET("getpeopleonleave")
    Call<Datesss> getdetailsondate(@Query("date") String d);


}
