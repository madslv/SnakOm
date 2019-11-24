package com.example.myapp9.HentData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * Build from example: https://codinginflow.com/tutorials/android/retrofit/part-1-simple-get-request
 */

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();
}
