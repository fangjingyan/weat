package com.example.olivia.weat;

import android.widget.EditText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.base.MainThread;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.example.olivia.weat.RecordActivity.flag;
import static org.junit.Assert.assertFalse;



@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecordActivityInstrumentationTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(RecordActivity.class);
    public RecordActivity recordActivity;
    private EditText date;
    private EditText day;
    private EditText sort;
    private EditText content;
    private final Integer LOCK = 1;

    @MainThread
    @Test
    public void testRegister() {
        recordActivity = (RecordActivity) mActivityRule.getActivity();
        //初始化控件
        date = (EditText) recordActivity.findViewById(R.id.date);
        day = (EditText) recordActivity.findViewById(R.id.day);
        sort = (EditText) recordActivity.findViewById(R.id.sort);
        content = (EditText) recordActivity.findViewById(R.id.content);
        //模拟人为向输入框中输入
        onView(withId(R.id.date)).perform(typeText("2019.04.26"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.day)).perform(typeText("Tuesday"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.sort)).perform(typeText("lunch"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.content)).perform(typeText("rice"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.OK)).perform(click());
        //进行网络请求
        Map<String, String> test = new HashMap<>();
        test.put("Uid", "15");
        test.put("Date", "2019.03.26");
        test.put("Day", "Tuesday");
        test.put("Meal", "lunch");
        test.put("Content", "rice");
        assertFalse(flag);
    }

}
