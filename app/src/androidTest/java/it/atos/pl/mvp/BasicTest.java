package it.atos.pl.mvp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import it.atos.pl.mvp.R;
import it.atos.pl.mvp.activity.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class BasicTest {

    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
    }

    @Test
    public void test_changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.buttonTwo)).perform(click());
        /*
        onView(withId(R.id.inputText))
                .perform(clearText(), closeSoftKeyboard());
        onView(withId(R.id.inputText))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.mainButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.mainText))
                .check(matches(withText(mStringToBetyped)));
                */
    }
}
