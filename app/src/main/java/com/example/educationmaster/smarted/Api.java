package com.example.educationmaster.smarted;

import java.util.List;

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

    @GET("/student-details/{name}.json")
    Call<List<Student>> getData(@Path("name") String s2);

    @PUT("/student-details/{new}.json")
    Call<Student> setDataWithoutRandomness(@Path("new") String s1, @Body Student student);


}
