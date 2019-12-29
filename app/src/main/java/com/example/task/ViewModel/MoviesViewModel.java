package com.example.task.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.task.Model.Movie;
import com.example.task.View.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesViewModel extends ViewModel {

    private MutableLiveData<List<Movie>> movieList;

    //we will call this method to get the data
    public LiveData<List<Movie>> getMovies() {
        //if the list is null
        if (movieList == null) {
            movieList = new MutableLiveData<List<Movie>>();
            //we will load it asynchronously from server in this method
            loadHeroes();
        }

        //finally we will return the list
        return movieList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Movie>> call = api.getMovies();


        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {

                //finally we are setting the list to our MutableLiveData
                movieList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }
}
