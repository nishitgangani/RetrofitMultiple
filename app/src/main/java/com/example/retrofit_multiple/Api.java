package com.example.retrofit_multiple;

import com.example.retrofit_multiple.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
//    http://jsonplaceholder.typicode.com/users
    String BASE_URL = "https://jsonplaceholder.typicode.com/";
    @GET("users")
    Call<List<Model>> getmodel();

}