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
import java.util.Map;

public class WebService {
    private static String servlet = "https://powerful-bastion-16516.herokuapp.com/restaurant";
    private static String servdish = "https://powerful-bastion-16516.herokuapp.com/dish";
//    default restaurant names
    static private List<String> restaurants = new ArrayList<String>(){{
        add("Restaurant1"); add("Restaurant2"); add("Restaurant3");
        add("Restaurant4"); add("Restaurant5"); add("Restaurant6");
    }};

    public static InputStream executeHttpGet(Map<String, String> info){
        String path = servlet + "?";
        for(Map.Entry<String, String> entry : info.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            path = path + key + "=" + value + "&";
        }
        path = path.substring(0, path.length() - 1);
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
                return is;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.e("WebService Error", "do not get message from sever or an exception");
        return null;
    }

    public static InputStream executeHttpGetdish(Map<String, String> info){
        String path = servdish + "?";
        for(Map.Entry<String, String> entry : info.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            path = path + key + "=" + value + "&";
        }
        path = path.substring(0, path.length() - 1);
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
                return is;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.e("WebService Error", "do not get message from sever or an exception");
        return null;
    }

    public static List<String> executeHttpGetDish(Map<String, String> info) {
        try {
            InputStream res = executeHttpGetdish(info);
            JSONParser jsonParser = new JSONParser();
            org.json.simple.JSONArray array = (org.json.simple.JSONArray) jsonParser.parse(new InputStreamReader(res, "UTF-8"));
            Log.e("res in WebService", "jsonArray is" + array);
            List<String> restaurantGet = new ArrayList<>(); //list of restaurant names from backend
            for (Object obj : array) {
                org.json.simple.JSONObject jsObj = (org.json.simple.JSONObject) obj;
                Log.e("get name from sever", (String) jsObj.get("name"));
                restaurantGet.add((String) jsObj.get("name"));
            }
            //                String res = IOUtils.toString(is, "utf-8");
            //                Log.e("res in WebService", res);
            if (!restaurantGet.isEmpty())
                restaurants = restaurantGet;
            return restaurants;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    public static List<String> executeHttpGetRestaurants(Map<String, String> info) {
        try {
            InputStream res = executeHttpGet(info);
            JSONParser jsonParser = new JSONParser();
            org.json.simple.JSONArray array = (org.json.simple.JSONArray) jsonParser.parse(new InputStreamReader(res, "UTF-8"));
            Log.e("res in WebService", "jsonArray is" + array);
            List<String> restaurantGet = new ArrayList<>(); //list of restaurant names from backend
            for (Object obj : array) {
                org.json.simple.JSONObject jsObj = (org.json.simple.JSONObject) obj;
                Log.e("get name from sever", (String) jsObj.get("name"));
                restaurantGet.add((String) jsObj.get("name"));
            }
            //                String res = IOUtils.toString(is, "utf-8");
            //                Log.e("res in WebService", res);
            if (!restaurantGet.isEmpty())
                restaurants = restaurantGet;
            return restaurants;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    public static boolean executeHTTPGetLogin(Map<String, String> info){
        InputStream res = executeHttpGet(info);
//        need more processing about res
        User.setUsername("zhangsan");
        User.addMeal("2019.3.16", "noddles");
        return true;
    }

    public static boolean executeHTTPGetRegister(Map<String, String> info){
        InputStream res = executeHttpGet(info);
//      need more processing
        return true;
    }

    public static boolean executeHTTPGetAddRecord(Map<String, String> info){
        InputStream res = executeHttpGet(info);
//        need more operation
        return true;
    }
}
