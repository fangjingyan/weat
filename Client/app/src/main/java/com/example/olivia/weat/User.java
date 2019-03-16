package com.example.olivia.weat;

import java.util.HashMap;
import java.util.Map;

public class User {
    static private String username = null;
    static private Map<String, String> meals = new HashMap<>();
<<<<<<< HEAD
    static private String userID = null;
=======
>>>>>>> 2019.3.16 3:49PM prototype of third page

    static public String getUsername(){
        return username;
    }

    static public Map<String, String> getMeals(){
        return meals;
    }

<<<<<<< HEAD
    static public String getUserID() { return userID; }

=======
>>>>>>> 2019.3.16 3:49PM prototype of third page
    static public void addMeal(String time, String content){
        meals.put(time, content);
    }

    static public void setUsername(String user){
        username = user;
    }
<<<<<<< HEAD

    static public void setUserID(String uID) {userID = uID; }

    static public void clearUsername() {username = null;}

    static public void clearMap() {meals.clear();}

=======
>>>>>>> 2019.3.16 3:49PM prototype of third page
}
