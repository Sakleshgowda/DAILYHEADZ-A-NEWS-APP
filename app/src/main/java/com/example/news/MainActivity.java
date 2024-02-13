package com.example.news;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.news.Adapter.HeadLinesAdapter;
import com.example.news.Fragments.BusinessFragment;
import com.example.news.Fragments.EntertainmentFragment;
import com.example.news.Fragments.HeadLinesFragment;
import com.example.news.Fragments.HealthFragment;
import com.example.news.Fragments.ScienceFragment;
import com.example.news.Fragments.SportsFragment;
import com.example.news.Fragments.TechnologyFragment;
import com.example.news.Model.Articles;
import com.example.news.Model.HeadLines;
import com.example.news.Network.ApiInstance;
import com.example.news.Network.ApiInterface;
import com.example.news.Utils.Dataholder;
import com.example.news.Utils.SearchListener;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchListener {
private TabLayout tabLayout;
private ViewPager viewPager;
private MainAdapter adapter;
EditText etQuery;
Button btnSearch;
RecyclerView recyclerView;

HeadLinesAdapter adapter_2;
    private List<Articles> articles=new ArrayList<>();
//    final String API_KEY = "ffae75d85e034f32be1690ee4ec021fe";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();


        adapter=new MainAdapter(getSupportFragmentManager());
        adapter.AddFragment(new HeadLinesFragment(),"Headlines");
        adapter.AddFragment(new EntertainmentFragment(),"Entertainment");
        adapter.AddFragment(new BusinessFragment(),"Business");
        adapter.AddFragment(new HealthFragment(),"Health");
        adapter.AddFragment(new ScienceFragment(),"Science");
        adapter.AddFragment(new SportsFragment(),"Sports");
        adapter.AddFragment(new TechnologyFragment(),"Technology");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        etQuery = findViewById(R.id.etQuery);
        btnSearch = findViewById(R.id.btnSearch);

//
     btnSearch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Find the HeadLinesFragment instance
            HeadLinesFragment fragment = (HeadLinesFragment) adapter.getItem(viewPager.getCurrentItem());
            if (fragment != null) {
                fragment.onSearchQuery(etQuery.getText().toString()); // Call the search query method
            }
        }
    });
}
    HeadLinesFragment headLinesFragment=new HeadLinesFragment();
@Override
public void onSearchQuery(String query)
{
    headLinesFragment.onSearchQuery(query);
}


//
    private void initComponents() {
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        recyclerView=findViewById(R.id.recyclerView);

    }





    private class MainAdapter extends FragmentPagerAdapter {

        ArrayList<Fragment> fragmentArrayList =new ArrayList<>();
        ArrayList<String> stringArrayList=new ArrayList<>();

        public void AddFragment(Fragment fragment,String s){
            fragmentArrayList.add(fragment);
            stringArrayList.add(s);
        }

        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Nullable
        @org.jetbrains.annotations.Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return stringArrayList.get(position);
        }
    }
}