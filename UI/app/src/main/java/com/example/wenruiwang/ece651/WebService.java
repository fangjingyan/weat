package com.example.wenruiwang.ece651;

import android.util.Log;

import org.apache.commons.io.IOUtils;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WebService {
    private static String servlet = "https://powerful-bastion-16516.herokuapp.com/";

    public static String executeHttpGet(List<String> Info){
        String path = servlet + "?";
        for(String str : Info){
            path = path + str + "&";
        }
        path = path.substring(0, path.length() - 1);
        try {
            Log.d("url", path);
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                InputStream is = conn.getInputStream();
                String res = IOUtils.toString(is, "utf-8");
                Log.d("res in WebService", res);
                return res;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
