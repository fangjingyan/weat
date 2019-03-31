package com.example.olivia.weat;

import androidx.test.runner.AndroidJUnit4;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.base.MainThread;
import androidx.test.filters.LargeTest;
import android.widget.EditText;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static com.example.olivia.weat.RegisterActivity.flag;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterActivityInstrumentationTest {
    //当前Activity初始化
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(RegisterActivity.class);
    public RegisterActivity registerActivity;
    private EditText username;
    private EditText password;
    private EditText email;
    private final Integer LOCK = 1;

    @MainThread
    @Test
    public void testRegister() {
        registerActivity = (RegisterActivity) mActivityRule.getActivity();
        //初始化控件
        username = (EditText) registerActivity.findViewById(R.id.username);
        password = (EditText) registerActivity.findViewById(R.id.password);
        email = (EditText) registerActivity.findViewById(R.id.email);
        //模拟人为向输入框中输入
        onView(withId(R.id.username)).perform(typeText("olivia"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("123"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("123@gmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.register)).perform(click());
        //进行网络请求
        Map<String, String> test = new HashMap<>();
        test.put("Username", "olivia");
        test.put("Password", "123");
        test.put("Email", "123@gmail.com");

        assertEquals(flag, true);


    }
}