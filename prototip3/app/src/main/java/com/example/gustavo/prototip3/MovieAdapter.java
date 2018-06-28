package com.example.gustavo.prototip3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    public static final String KEY_NAME = "title";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";
    public static final String KEY_SINOPSE = "sinopse";

    private List<MovieList> moviesLists;
    private Context context;

    public MovieAdapter(List<MovieList> moviesLists, Context context){
        this.moviesLists = moviesLists;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movies_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // this method will bind the data to the ViewHolder from whence it'll be shown to other Views

        final MovieList moviesList = moviesLists.get(position);
        holder.title.setText(moviesList.getTitle());

        Picasso.with(context)
                .load(moviesList.getAvatar_url())
                .into(holder.avatar_url);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieList movieList1 = moviesLists.get(position);
                Intent skipIntent = new Intent(v.getContext(), TitleActivity.class);
                skipIntent.putExtra(KEY_NAME, movieList1.getTitle());
                skipIntent.putExtra(KEY_URL, movieList1.getAvatar_url());
                skipIntent.putExtra(KEY_IMAGE, movieList1.getHtml_url());
                skipIntent.putExtra(KEY_SINOPSE, movieList1.getSinopse());
                v.getContext().startActivity(skipIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesLists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {

        // define the View objects

        public TextView title;
        public ImageView avatar_url;
        public TextView html_url;
        public TextView sinopse;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            // initialize the View objects

            title = itemView.findViewById(R.id.title);
            avatar_url = itemView.findViewById(R.id.imageView);
            html_url =  itemView.findViewById(R.id.htmUrl);
            sinopse = itemView.findViewById(R.id.sinopse);
            linearLayout =  itemView.findViewById(R.id.linearLayout);
        }

    }
}
