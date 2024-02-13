package com.example.news.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.news.Model.Articles;
import com.example.news.Model.HeadLines;
import com.example.news.R;
import com.example.news.Utils.Detailedpage;
import com.example.news.Utils.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HeadLinesAdapter<PrettyTime> extends RecyclerView.Adapter<HeadLinesAdapter.viewHolder>{

    List<Articles> articlesList;
    Context context;


    public HeadLinesAdapter(List<Articles> articlesList, Context context) {
        this.articlesList = articlesList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.headlines_row,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadLinesAdapter.viewHolder holder, int position) {

       Articles articles=articlesList.get(position);


        String publishedAt= articles.getPublishedAt();
        if(publishedAt!=null) {
            holder.date.setText("\u2022" + Utils.DateFormat(articles.getPublishedAt()));
        }else{holder.date.setText("N/A");}
        holder.title.setText(articles.getTitle());
        holder.description.setText(articles.getDescriptions());
        holder.publisherNewsName.setText(articles.getSource().getName());
//
        String imageUrl=articles.getImageUrl();
        Glide.with(context)
                .load(imageUrl)
                .into(holder.headLineImage);


holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,Detailedpage.class);
            intent.putExtra("title",articles.getTitle());
            intent.putExtra("url",articles.getUrl());
            context.startActivity(intent);

        }
    });

}
    @Override
    public int getItemCount() {
        return articlesList.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {

        CardView cardView; // Initialize the cardView

        ImageView headLineImage;
        TextView date, title, description, publisherNewsName;



        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview); // Initialize the cardView with its ID
//           url = itemView.findViewById(R.id.url);
            date = itemView.findViewById(R.id.date);
            title = itemView.findViewById(R.id.hTitle);
            description = itemView.findViewById(R.id.description);
            publisherNewsName = itemView.findViewById(R.id.newsName);
            headLineImage = itemView.findViewById(R.id.headlineImage);
        }


    }
    public interface SearchListener {
        void onSearchQuery(String query);
    }

    private SearchListener searchListener;

    // Other fragment code

    public void setSearchListener(SearchListener listener) {
        searchListener = listener;
    }


}
