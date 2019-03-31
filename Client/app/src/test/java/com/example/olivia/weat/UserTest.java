package com.example.olivia.weat;


import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTest {

    private User mUser;

    @Before
    public void setUp() throws Exception {
        mUser = new User();
    }

    @Test
    public void addMeal() {
        mUser.addMeal("2019.03.01", "bread");
    }

    @Test
    public void setUsername() {
        mUser.setUsername("olivia");
    }

    @Test
    public void setUserID() {
        mUser.setUserID("1");
    }

    @Test
    public void getUsername() {
        assertEquals("olivia", mUser.getUsername());
    }

    @Test
    public void getMeals() {


        Iterator<String> iter = mUser.getMeals().keySet().iterator();
        while(iter.hasNext()){
            String key = iter.next();
            String value = mUser.getMeals().get(key);
            assertEquals("2019.03.01", key);
            assertEquals("bread", value);
        }

    }

    @Test
    public void getUserID() {

        assertEquals("1", mUser.getUserID());
    }

    @Test
    public void clearUsername(){
        mUser.clearUsername();
        assertEquals(null, mUser.getUsername());
    }

    @Test
    public void clearMap(){
        mUser.clearMap();
        assertEquals(0, mUser.getMeals().size());

    }

}