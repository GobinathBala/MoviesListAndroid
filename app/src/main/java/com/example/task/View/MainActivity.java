package com.example.task.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.task.Model.Movie;
import com.example.task.ViewModel.MoviesViewModel;
import com.example.task.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MovesAdapter adapter;
    Toolbar toolbar;
    String title="Movies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declareToolbar();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        MoviesViewModel model = ViewModelProviders.of(this).get(MoviesViewModel.class);

        model.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movieList) {
                adapter = new MovesAdapter(MainActivity.this, movieList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
    private void declareToolbar() {
        toolbar=findViewById(R.id.toolbar);
        if (title!=null) {
            toolbar.setTitle(title);
        }
        setSupportActionBar(toolbar);

    }

}
