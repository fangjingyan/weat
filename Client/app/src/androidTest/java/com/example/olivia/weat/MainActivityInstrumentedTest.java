package com.example.olivia.weat;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    @Rule
    public IntentsTestRule<MainActivity> activityRule = new IntentsTestRule<>(MainActivity.class);
//    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);
//    public MainActivity mainActivity;

    @Test
    public void testNavigation(){
//        onView(withId(R.id.navigation)).perform(NavigationViewActions.navigateTo(R.id.navigation_selectrestaurant));
        onView(withId(R.id.navigation_selectrestaurant)).perform(click());
        onView(withId(R.id.navigation_cookyourself)).perform(click());
        onView(withId(R.id.navigation_blog)).perform(click());
    }

}
