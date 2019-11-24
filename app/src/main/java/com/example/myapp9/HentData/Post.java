package com.example.myapp9.HentData;

import com.google.gson.annotations.SerializedName;

/**
 *
 * Build from example: https://codinginflow.com/tutorials/android/retrofit/part-1-simple-get-request
 */

public class Post {

    private int userId;

    private int id;

    private String title;

    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}