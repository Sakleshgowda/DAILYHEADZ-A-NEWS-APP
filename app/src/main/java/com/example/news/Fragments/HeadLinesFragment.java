package com.example.news.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.Adapter.HeadLinesAdapter;
import com.example.news.MainActivity;
import com.example.news.Model.Articles;
import com.example.news.Model.HeadLines;
import com.example.news.Network.ApiInstance;
import com.example.news.Network.ApiInterface;
import com.example.news.R;
import com.example.news.Utils.Dataholder;
import com.example.news.Utils.SearchListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.news.Utils.Contants.APIKEY;
import static com.example.news.Utils.Contants.BUSINESS;
//import static com.example.news.Utils.Contants.COUNTRY;
//import static com.example.news.Utils.Contants.LANGUAGE;

public class HeadLinesFragment extends Fragment implements SearchListener {
    private View view;
    private RecyclerView recyclerView_by_me;
    private HeadLinesAdapter adapter;
    private List<Articles> articlesList = new ArrayList<>();
  Dataholder data=new Dataholder();
    String COUNTRY= data.getCountry();

    private RecyclerView recyclerView;
private String currentQuery="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.head_lines_fragment, container, false);

        initComponents();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HeadLinesAdapter(articlesList, getContext());
        recyclerView.setAdapter(adapter);

        retriveJSON(currentQuery,COUNTRY,APIKEY);
        return view;
    }



    private void retriveJSON(String query, String country, String apikey) {
        ApiInterface apiInterface = ApiInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<HeadLines> call;
        if (query.isEmpty()) {
            call = apiInterface.getData(country, apikey);
        } else {
            call = apiInterface.getSpecificData(query, apikey);
        }

        call.enqueue(new Callback<HeadLines>() {
            @Override
            public void onResponse(Call<HeadLines> call, Response<HeadLines> response) {
                if (response.isSuccessful()) {
                    HeadLines headlines = response.body();

                    if (headlines != null) {
                        String status = headlines.getStatus();
                        if ("error".equals(status)) {
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
                            if (adapter != null) {
                                adapter.notifyDataSetChanged(); // Notify the adapter of data changes
                            }
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

    public void onSearchQuery(String query)
    {
        currentQuery=query;
        retriveJSON(currentQuery,COUNTRY,APIKEY);
    }



    private void initComponents() {
        recyclerView_by_me = view.findViewById(R.id.recyclerView);
    }



}


