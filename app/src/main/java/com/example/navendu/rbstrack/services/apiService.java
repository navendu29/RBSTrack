package com.example.navendu.rbstrack.services;

import com.example.navendu.rbstrack.model.Auth;
import com.example.navendu.rbstrack.model.Datesss;
import com.example.navendu.rbstrack.model.Employee;
import com.example.navendu.rbstrack.model.WorkFromHome;
import com.example.navendu.rbstrack.model.cont;
import com.example.navendu.rbstrack.model.leaves;
import com.example.navendu.rbstrack.model.posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by navendu on 27/6/18.
 */

public interface apiService {



  public  String base_url= "http://192.168.43.81:8081/";

    @GET("getprofile")
    Call<Employee> getProfilehero(@Query("racf") String id,@Query("password") String pass);

    @GET("getpeopleonleave")
    Call<Datesss> getdetailsondate(@Query("date") String d);

    @GET("authentication")
    Call<Auth> getAuth(@Query("racf") String d,@Query("password") String dd);

    @GET("getleavedates")
    Call<leaves> getleavedates(@Query("racf") String d);

    @GET("getwfhdates")
    Call<WorkFromHome> getwfhdates(@Query("racf") String dd);

    @GET("updateno")
    Call<Auth> updating(@Query("racf") String d,@Query("contacts") String dd,@Query("contactnames") String ddd);

    @GET("updateworkfromhome")
    Call<Auth> updatingwfh(@Query("racf") String d,@Query("dates") String dd,@Query("reasons") String ddd);

    @GET("updateonleave")
    Call<Auth> updatingleave(@Query("racf") String d,@Query("date") String dd,@Query("reason") String ddd);

    @GET("updatestatus")
    Call<Auth> updatestatus(@Query("racf") String d,@Query("status") String dd);



    @GET("getstatus")
    Call<Auth> getstatus(@Query("racf") String d);

    @GET("admin")
    Call<Auth> getadminauth(@Query("id") String d,@Query("pass") String dd);


    @GET("delemployee")
    Call<Auth> getdel(@Query("racf") String d);

    @GET("addemployee")
    Call<Auth> getadd(@Query("racf") String a,@Query("name") String b,@Query("phoneno") String c,@Query("password") String d,@Query("leaves") String e,@Query("contacts") String f,@Query("contactnames") String g);



  @GET("updatepassword")
  Call<Auth> getd(@Query("racf") String a,@Query("password") String b);


}
