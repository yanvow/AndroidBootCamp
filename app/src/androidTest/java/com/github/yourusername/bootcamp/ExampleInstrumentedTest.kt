package com.github.yourusername.bootcamp

import android.content.Intent
import android.system.Os.close
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    var testRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun openGreetingActivityOnButtonPressed() {
        onView(withId(R.id.mainGoButton)).perform(click())
        Intents.init()
        Intents.intended(hasComponent(GreetingActivity::class.java.name))
        Intents.release()
    }
}

class GreetingActivityTest {
    @Rule
    var testRule = ActivityScenarioRule(
        GreetingActivity::class.java
    )

    @Test
    fun openGreetingActivityOnButtonPressed() {
        val intent = Intent(ApplicationProvider.getApplicationContext())
        ActivityScenario.launch(intent)
        try {
            onView(withId(R.id.greetingMessage)).check(matches(withText("Hello, World!")))
        } finally {
            ActivityScenario.close()
        }
    }
}