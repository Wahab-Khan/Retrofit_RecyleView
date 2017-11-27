package com.example.khan.retrorecyleviewtest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KHAN on 11/15/2017.
 */

public class ApiClient {
    public static final String URL = "https://androidtutorialpoint.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){

        if (retrofit == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }


}
