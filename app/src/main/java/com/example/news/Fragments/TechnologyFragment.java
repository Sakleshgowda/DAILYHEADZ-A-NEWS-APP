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
//import static com.example.news.Utils.Contants.LANGUAGE;
import static com.example.news.Utils.Contants.TECHNOLOGY;

public class TechnologyFragment extends Fragment {
    private View view;
    private List<Articles> articlesList=new ArrayList<>();;
    private RecyclerView recyclerView;
    private HeadLinesAdapter adapter;

    Dataholder data=new Dataholder();
    String COUNTRY= data.getCountry();


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.technology_fragment, container, false);

        initComponents();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new HeadLinesAdapter(articlesList,getContext());
        recyclerView.setAdapter(adapter);
        retriveJSON(COUNTRY,TECHNOLOGY,APIKEY);
        return view;

    }

    private void retriveJSON(String country, String business, String apikey) {

        ApiInterface apiInterface= ApiInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<HeadLines> call=apiInterface.getEntertainmentData(country,business, apikey);

        call.enqueue(new Callback<HeadLines>() {
            @Override
            public void onResponse(Call<HeadLines> call, Response<HeadLines> response) {
                if (response.isSuccessful() && response.body().getArticlesList() !=null){
                    articlesList.clear();
                    articlesList.addAll(response.body().getArticlesList());
//                    adapter=new HeadLinesAdapter(articlesList,getContext());
//                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                else {
                    // Handle unsuccessful response (e.g., non-2xx status codes)
                    int statusCode = response.code();
                    String errorBody = response.errorBody() != null ? response.errorBody().toString() : "Unknown error";
                    Log.e("NetworkError", "Error: " + statusCode + " - " + errorBody);
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
        recyclerView=view.findViewById(R.id.technologyRecycler);
    }
}
