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
import static com.example.news.Utils.Contants.BUSINESS;


public class BusinessFragment extends Fragment {
    private View view;
    private List<Articles> articlesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private HeadLinesAdapter adapter;

    Dataholder data = new Dataholder();
    String COUNTRY = data.getCountry();
//    String LANGUAGE="en";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.business_fragment, container, false);




        recyclerView = view.findViewById(R.id.businessRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HeadLinesAdapter(articlesList, getContext());
        recyclerView.setAdapter(adapter);
        retriveJSON(COUNTRY, BUSINESS, APIKEY);
        return view;
    }



    private void retriveJSON(String country, String business, String apikey) {

        ApiInterface apiInterface = ApiInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<HeadLines> call = apiInterface.getEntertainmentData(country, business, apikey);

        call.enqueue(new Callback<HeadLines>() {
            @Override
            public void onResponse(Call<HeadLines> call, Response<HeadLines> response) {
                if (response.isSuccessful()) {
                    HeadLines headlines = response.body();

                    if (headlines != null) {
                        String status = headlines.getStatus();
                        Log.d("api erro","apilimit:"+ status);
                        if (headlines.getStatus()=="error") {

                            // Handle the error status here
                            String message = headlines.getMessage();
                            Toast.makeText(getContext(), "API Error: " + message, Toast.LENGTH_SHORT).show();
                        }
                        else if (headlines.getTotalResults()==0)
                        {
                            Toast.makeText(getContext(), "No results Found" , Toast.LENGTH_SHORT).show();

                        } else {
                            // Request was successful, and the data is available
                            articlesList.clear();
                            articlesList.addAll(headlines.getArticlesList());
                            adapter.notifyDataSetChanged(); // Notify the adapter of data changes
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<HeadLines> call, Throwable t) {
                // Handle network failures here
                Toast.makeText(getContext(), "Check Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });
    }

}


