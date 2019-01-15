package com.example.drg.ubuntuaudiobot;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public  ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private String mName = "testStr";

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPositives(){
        Espresso.onView(withId(R.id.texta)).perform(typeText("2"));
        Espresso.onView(withId(R.id.textb)).perform(typeText("3"));
        Espresso.onView(withId(R.id.texta)).perform(click());

        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.result)).check(matches(withText("Result : 5")));

    }
}
