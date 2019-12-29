package com.example.task.View;

import com.example.task.Model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://api.simplifiedcoding.in/course-apis/recyclerview/";
    //https://api.simplifiedcoding.in/course-apis/recyclerview/movies
    @GET("movies")
    Call<List<Movie>> getMovies();
}
