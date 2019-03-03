package com.example.olivia.weat;



import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebService {
    private static String servlet = "https://powerful-bastion-16516.herokuapp.com/restaurant?Category=Korean";

    static private List<String> restaurants = new ArrayList<String>(){{
        add("Restaurant1"); add("Restaurant2"); add("Restaurant3");
        add("Restaurant4"); add("Restaurant5"); add("Restaurant6");
    }};

    public static List<String> executeHttpGet(List<String> Info){
//        String path = servlet + "?";
//        for(String str : Info){
//            path = path + str + "&";
//        }
//        path = path.substring(0, path.length() - 1);
        String path = servlet;
        Log.e("path is :", path);
        try {
            Log.d("url", path);
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                Log.e("get", "get response");
                InputStream is = conn.getInputStream();
                JSONParser jsonParser = new JSONParser();
                org.json.simple.JSONArray array = (org.json.simple.JSONArray)jsonParser.parse(new InputStreamReader(is, "UTF-8"));
                for(Object obj : array){
                    org.json.simple.JSONObject jsObj = (org.json.simple.JSONObject) obj;
                    Log.e("get name from sever", (String)jsObj.get("name"));
                }
//                String res = IOUtils.toString(is, "utf-8");
                Log.e("res in WebService", "jsonObject is :"+array);
//                Log.e("res in WebService", res);
                return restaurants;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.e("WebService Error", "do not get message from sever");
        return restaurants;
    }
}
