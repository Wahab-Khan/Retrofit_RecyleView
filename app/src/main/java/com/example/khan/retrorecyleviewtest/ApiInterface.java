package com.example.khan.retrorecyleviewtest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by KHAN on 11/15/2017.
 */

public interface ApiInterface {

    @GET("api/RetrofitAndroidArrayResponse")
    Call<List<Student>> getStudentData();
}
