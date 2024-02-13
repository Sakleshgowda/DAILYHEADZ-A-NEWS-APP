package com.example.news.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.Adapter.HeadLinesAdapter;
import com.example.news.Model.Articles;
import com.example.news.Model.HeadLines;
import com.example.news.Network.ApiInstance;
import com.example.news.Network.ApiInterface;
import com.example.news.R;
import com.example.news.Utils.Dataholder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.news.Utils.Contants.APIKEY;
//import static com.example.news.Utils.Contants.COUNTRY;
import static com.example.news.Utils.Contants.ENTERTAINMENT;
//import static com.example.news.Utils.Contants.LANGUAGE;

public class EntertainmentFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private HeadLinesAdapter adapter;

    private List<Articles> articlesList = new ArrayList<>();
    Dataholder data=new Dataholder();
    String COUNTRY=data.getCountry();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.entertainment_fragment, container, false);


        initComponents();


        //
        Log.d("Entertainment", "COUNTRY: " + COUNTRY);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new HeadLinesAdapter(articlesList,getContext());
        recyclerView.setAdapter(adapter);
        retriveJSON(COUNTRY,ENTERTAINMENT,APIKEY);
        return view;
    }

    private void retriveJSON(String country, String categorys ,String apikey) {
        ApiInterface apiInterface= ApiInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<HeadLines> call=apiInterface.getEntertainmentData(country,categorys,apikey);

        call.enqueue(new Callback<HeadLines>() {
            @Override
            public void onResponse(Call<HeadLines> call, Response<HeadLines> response) {
                if (response.isSuccessful() && response.body().getArticlesList() != null) {
                    articlesList.clear();
                    articlesList.addAll(response.body().getArticlesList());
                    adapter.notifyDataSetChanged(); // Notify the adapter of data changes
                }
            }

            @Override
            public void onFailure(Call<HeadLines> call, Throwable t) {
                Toast.makeText(getContext(), "Check Internet Connection", Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }

    private void initComponents() {
        recyclerView=view.findViewById(R.id.entertainmentRecyclerView);
    }
}
