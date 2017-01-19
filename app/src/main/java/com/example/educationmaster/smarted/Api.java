package com.example.educationmaster.smarted;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Vinit on 2017-01-19.
 */

public interface Api {
    @POST("/student-details/{new}.json")
    Call<Student> setData(@Path("new") String s1, @Body Student student);

    @GET("/upload/{name}.json")
    Call<Student> getData(@Path("name") String s2);

    @PUT("/student-details/{new}.json")
    Call<Student> setDataWithoutRandomness(@Path("new") String s1, @Body Student student);


}
