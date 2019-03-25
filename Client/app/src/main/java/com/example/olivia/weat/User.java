package com.example.olivia.weat;

import java.util.HashMap;
import java.util.Map;

public class User {
    static private String username = null;
    static private Map<String, String> meals = new HashMap<>();


    static public String getUsername(){
        return username;
    }

    static public Map<String, String> getMeals(){
        return meals;
    }

    static public void addMeal(String time, String content){
        meals.put(time, content);
    }

    static public void setUsername(String user){
        username = user;
    }

    static public void clearUsername() {username = null;}

    static public void clearMap() {meals.clear();}

}
