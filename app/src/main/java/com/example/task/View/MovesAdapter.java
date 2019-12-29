package com.example.task.View;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.task.Model.Movie;
import com.example.task.R;

import java.util.List;

public class MovesAdapter extends RecyclerView.Adapter<MovesAdapter.HeroViewHolder> {

    Context mCtx;
    List<Movie> movieList;

    public MovesAdapter(Context mCtx, List<Movie> movieList) {
        this.mCtx = mCtx;
        this.movieList = movieList;

    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        final Movie movie = movieList.get(position);

        Glide.with(mCtx)
                .load(movie.getImage())
                .into(holder.imageView);

        holder.textView.setText(movie.getTitle());
        String like= String.valueOf(movie.getLikePercent());
        holder.like_percent.setText(String.valueOf(movie.getLikePercent())+"%");
        holder.Id_parent_constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mCtx,MoviesDetail.class);
                intent.putExtra("image",movie.getImage());
                intent.putExtra("rating",movie.getRating());
                intent.putExtra("like_percent",String.valueOf(movie.getLikePercent()));
                intent.putExtra("vote_count",String.valueOf(movie.getVoteCount()));
                intent.putExtra("title",movie.getTitle());
                intent.putExtra("language",movie.getLanguage());
                intent.putExtra("type",movie.getType());
                mCtx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        AppCompatTextView textView,like_percent;
        ConstraintLayout Id_parent_constraint;

        public HeroViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.Id_movie_list_Img);
            textView = itemView.findViewById(R.id.Id_movie_list_txt_title);
            Id_parent_constraint=itemView.findViewById(R.id.Id_parent_constraint);
            like_percent=itemView.findViewById(R.id.like_percent);
        }
    }
}
