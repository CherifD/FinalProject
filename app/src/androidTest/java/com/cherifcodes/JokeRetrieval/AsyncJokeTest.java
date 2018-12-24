package com.cherifcodes.JokeRetrieval;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class AsyncJokeTest {
    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testJobkeButtonIsDisplayed() {
        onView(withId(R.id.btn_joke)).check(matches(isDisplayed()));
    }

    @Test
    public void testAsyncTaskRetrievesCorrectJoke() {

            //In MainActivity, click on "tell joke" button
            onView(withId(R.id.btn_joke))
                    .perform(click());

            //Ensure that the joke TextView (id = tv_joke) is displayed with the correct content
            // retrieved from the Endpoints
            onView(withId(R.id.tv_joke))
                    .check(matches(isDisplayed()))
                    .check(matches(withText(
                            "Last year I was sitting in a bar when a gentlemen worked in, wearing a nice suit. " +
                                    "He asked for a drink, and suddenly the bar-tender passed out. Everyone else held their " +
                                    "nosed and looked for a skunk.  Frustrated, the man yelled, 'What's wrong with people " +
                                    "in this town?!!' Then everybody passed out."
                    )));

            //Return to the MainActivity
            Espresso.pressBack();
    }
}
