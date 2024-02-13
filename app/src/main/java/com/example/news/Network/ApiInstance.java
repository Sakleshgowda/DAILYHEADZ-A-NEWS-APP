package com.example.news.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.news.Utils.Contants.CORONA_API_URL;
import static com.example.news.Utils.Contants.NEWS_API_URL;

public class ApiInstance {

    public static Retrofit retrofit=null;

    public  static Retrofit getRetrofitInstance(){

        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(NEWS_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
