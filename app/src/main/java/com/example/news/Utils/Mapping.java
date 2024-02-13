package com.example.news.Utils;

import java.util.HashMap;
import java.util.Map;

public class Mapping {
    private static final Map<String, String> countryNameToCodeMap = new HashMap<>();
    private static final Map<String, String> languageNameToCodeMap = new HashMap<>();

    static {
        // Country code
        countryNameToCodeMap.put("United Arab Emirates", "ae");
        countryNameToCodeMap.put("Argentina", "ar");
        countryNameToCodeMap.put("Austria", "at");
        countryNameToCodeMap.put("Australia", "au");
        countryNameToCodeMap.put("Belgium", "be");
        countryNameToCodeMap.put("Bulgaria", "bg");
        countryNameToCodeMap.put("Brazil", "br");
        countryNameToCodeMap.put("Canada", "ca");
        countryNameToCodeMap.put("Switzerland", "ch");
        countryNameToCodeMap.put("China", "cn");
        countryNameToCodeMap.put("Colombia", "co");
        countryNameToCodeMap.put("Cuba", "cu");
        countryNameToCodeMap.put("Czech republic", "cz");
        countryNameToCodeMap.put("Germany", "de");
        countryNameToCodeMap.put("Egypt", "eg");
        countryNameToCodeMap.put("France", "fr");
        countryNameToCodeMap.put("United Kingdom", "gb");
        countryNameToCodeMap.put("Greece", "gr");
        countryNameToCodeMap.put("Hong Kong", "hk");
        countryNameToCodeMap.put("Hungary", "hu");
        countryNameToCodeMap.put("Indonesia", "id");
        countryNameToCodeMap.put("Ireland", "ie");
        countryNameToCodeMap.put("Israel", "il");
        countryNameToCodeMap.put("INDIA", "in");
        countryNameToCodeMap.put("Italy", "it");
        countryNameToCodeMap.put("Japan", "jp");
        countryNameToCodeMap.put("South Korea", "kr");
        countryNameToCodeMap.put("Lithuania", "lt");
        countryNameToCodeMap.put("Latvia", "lv");
        countryNameToCodeMap.put("Morocco", "ma");
        countryNameToCodeMap.put("Mexico", "mx");
        countryNameToCodeMap.put("Malaysia", "my");
        countryNameToCodeMap.put("Nigeria", "ng");
        countryNameToCodeMap.put("Netherlands", "nl");
        countryNameToCodeMap.put("Norway", "no");
        countryNameToCodeMap.put("New zealand", "nz");
        countryNameToCodeMap.put("Philippines", "ph");
        countryNameToCodeMap.put("Poland", "pl");
        countryNameToCodeMap.put("Portugal", "pt");
        countryNameToCodeMap.put("Romania", "ro");
        countryNameToCodeMap.put("Serbia", "rs");
        countryNameToCodeMap.put("Russia", "ru");
        countryNameToCodeMap.put("Saudi Arabia", "sa");
        countryNameToCodeMap.put("Sweden", "se");
        countryNameToCodeMap.put("Singapore", "sg");
        countryNameToCodeMap.put("Slovenia", "si");
        countryNameToCodeMap.put("Slovakia", "sk");
        countryNameToCodeMap.put("Thailand", "th");
        countryNameToCodeMap.put("Turkey", "tr");
        countryNameToCodeMap.put("Taiwan", "tw");
        countryNameToCodeMap.put("Ukraine", "ua");
        countryNameToCodeMap.put("United States", "us");
        countryNameToCodeMap.put("Venezuela", "ve");
        countryNameToCodeMap.put("South africa", "za");


//        // Languages codess
//        languageNameToCodeMap.put("Arabic", "ar");
//        languageNameToCodeMap.put("German", "de");
//        languageNameToCodeMap.put("English", "en");
//        languageNameToCodeMap.put("Spanish", "es");
//        languageNameToCodeMap.put("French", "fr");
//        languageNameToCodeMap.put("Hebrew", "he");
//        languageNameToCodeMap.put("Italian", "it");
//        languageNameToCodeMap.put("Dutch", "nl");
//        languageNameToCodeMap.put("Norwegian", "no");
//        languageNameToCodeMap.put("Portuguese", "pt");
//        languageNameToCodeMap.put("Russian", "ru");
//        languageNameToCodeMap.put("Swedish", "sv");
//
//        languageNameToCodeMap.put("Chinese", "zh");

    }

    public static String getCountryCode(String countryName) {
        return countryNameToCodeMap.get(countryName);
    }

    public static String getLanguageCode(String languageName) {
        return languageNameToCodeMap.get(languageName);
    }
}


