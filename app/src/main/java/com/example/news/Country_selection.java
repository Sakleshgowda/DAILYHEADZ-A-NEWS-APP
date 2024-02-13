package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.news.Utils.Contants;
import com.example.news.Utils.Dataholder;
import com.example.news.Utils.Mapping;

import java.util.ArrayList;
import java.util.List;

public class Country_selection extends AppCompatActivity {
    Spinner spinner_country,spinner_language;
    Button submit;
    private String country_selected,language_selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_selection);


        spinner_country=findViewById(R.id.spinner_country);
        List<String> country=new ArrayList<>();
        country.add(0,"Choose your country");
        country.add(1, "United Arab Emirates");
        country.add(2, "Argentina");
        country.add(3, "Austria");
        country.add(4, "Australia");
        country.add(5, "Belgium");
        country.add(6, "Bulgaria");
        country.add(7, "Brazil");
        country.add(8, "Canada");
        country.add(9, "Switzerland");
        country.add(10, "China");
        country.add(11, "Colombia");
        country.add(12, "Cuba");
        country.add(13, "Czech Republic");
        country.add(14, "Germany");
        country.add(15, "Egypt");
        country.add(16, "France");
        country.add(17, "United Kingdom");
        country.add(18, "Greece");
        country.add(19, "Hong Kong");
        country.add(20, "Hungary");
        country.add(21, "Indonesia");
        country.add(22, "Ireland");
        country.add(23, "Israel");
        country.add(24, "INDIA");
        country.add(25, "Italy");
        country.add(26, "Japan");
        country.add(27, "South Korea");
        country.add(28, "Lithuania");
        country.add(29, "Latvia");
        country.add(30, "Morocco");
        country.add(31, "Mexico");
        country.add(32, "Malaysia");
        country.add(33, "Nigeria");
        country.add(34, "Netherlands");
        country.add(35, "Norway");
        country.add(36, "New Zealand");
        country.add(37, "Philippines");
        country.add(38, "Poland");
        country.add(39, "Portugal");
        country.add(40, "Romania");
        country.add(41, "Serbia");
        country.add(42, "Russia");
        country.add(43, "Saudi Arabia");
        country.add(44, "Sweden");
        country.add(45, "Singapore");
        country.add(46, "Slovenia");
        country.add(47, "Slovakia");
        country.add(48, "Thailand");
        country.add(49, "Turkey");
        country.add(50, "Taiwan");
        country.add(51, "Ukraine");
        country.add(52, "United States");
        country.add(53, "Venezuela");
        country.add(54, "South Africa");

        ArrayAdapter<String> dataadapter;
        dataadapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_country.setAdapter(dataadapter);
        spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                if(parent.getItemAtPosition(i).equals("Choose your country"))
                {

                }
                else {
                   country_selected=parent.getItemAtPosition(i).toString();
                    Toast.makeText(parent.getContext(),"Selected:"+country_selected,Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        spinner_language=findViewById(R.id.spinner_language);
//        List<String> language=new ArrayList<>();
//        language.add(0,"Choose your language");
//        language.add(1, "Arabic");
//        language.add(2, "German");
//        language.add(3, "English");
//        language.add(4, "Spanish");
//        language.add(5, "French");
//        language.add(6, "Hebrew");
//        language.add(7, "Italian");
//        language.add(8, "Dutch");
//        language.add(9, "Norwegian");
//        language.add(10, "Portuguese");
//        language.add(11, "Russian");
//        language.add(12, "Swedish");
//        language.add(13, "Chinese");


//
//        ArrayAdapter<String> dataadapter_lang;
//        dataadapter_lang=new ArrayAdapter(this,android.R.layout.simple_spinner_item,language);
//        dataadapter_lang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_language.setAdapter(dataadapter_lang);
//        spinner_language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
//                if(parent.getItemAtPosition(i).equals("Choose your language"))
//                {
//
//                }
//                else {
//                   language_selected=parent.getSelectedItem().toString();
//                    Toast.makeText(parent.getContext(),"Selected:"+language_selected,Toast.LENGTH_SHORT).show();
//
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        submit=findViewById(R.id.submit_clicked);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String country_selected_code = Mapping.getCountryCode(country_selected);
//                String language_selected_code = Mapping.getLanguageCode(language_selected);

//                 Store the chosen country and language in the Dataholder class
                Dataholder country_lang = new Dataholder();
                country_lang.setCountry(country_selected_code);
//                country_lang.setLanguage(language_selected_code);
                Log.d("Country selection", "COUNTRY: " + country_selected_code);

                // Create an Intent to start the MainActivity
                Intent intent = new Intent(Country_selection.this, MainActivity.class);
                intent.putExtra("country",country_selected_code);
//                intent.putExtra("language",language_selected_code);
                startActivity(intent);
            }
        });
    }
}