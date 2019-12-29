package com.example.task.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.task.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MoviesDetail extends AppCompatActivity {
    String image,rating,like_percent,vote_count,title,language,type;
    Toolbar toolbar;
    AppCompatImageView img_poster,favourite;
    AppCompatTextView movieTitle,movielanguage,movietype,movieslike_percent,movesvotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_detail);

        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().getString("image") != null) {
                image = getIntent().getExtras().getString("image");
            }
            if (getIntent().getExtras().getString("rating") != null) {
                rating = getIntent().getExtras().getString("rating");
            }
            if (getIntent().getExtras().getString("like_percent") != null) {
                like_percent = getIntent().getExtras().getString("like_percent");
            }
            if (getIntent().getExtras().getString("vote_count") != null) {
                vote_count = getIntent().getExtras().getString("vote_count");
            }
            if (getIntent().getExtras().getString("title") != null) {
                title = getIntent().getExtras().getString("title");
            }
            if (getIntent().getExtras().getString("language") != null) {
                language = getIntent().getExtras().getString("language");
            }
            if (getIntent().getExtras().getString("type") != null) {
                type = getIntent().getExtras().getString("type");
            }

            declare();
            declareToolbar();
        }
    }

    private void declare() {
        img_poster=findViewById(R.id.Id_movDetail_img);
        movieTitle=findViewById(R.id.movie_title);
        movielanguage=findViewById(R.id.language);
        movietype=findViewById(R.id.type);
        movieslike_percent=findViewById(R.id.like_percent);
        movesvotes=findViewById(R.id.votes);
        if(image!=null) {
            Glide.with(getApplicationContext())
                    .load(image)
                    .into(img_poster);
        }
        if(title!=null){
            movieTitle.setText(title);
        }
        if(language!=null){
            movielanguage.setText(rating+" | "+language);
        }
        if(type!=null){
            movietype.setText(type);
        }
        if(like_percent!=null){
            movieslike_percent.setText(like_percent+"%");
        }
        if(vote_count!=null){
            movesvotes.setText(vote_count+" votes");
        }
    }


    private void declareToolbar() {
        toolbar=findViewById(R.id.toolbar);
        if (title!=null) {
            toolbar.setTitle(title);
        }
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }


    }

}
