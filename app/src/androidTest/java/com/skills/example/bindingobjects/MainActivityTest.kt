package com.skills.example.bindingobjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @JvmField
    @Rule
    val mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkViewsIsDisplayed() {
        onView(withId(R.id.tv_name)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_email)).check(matches(isDisplayed()))
    }

    @Test
    fun studentInfoIsDisplayed() {
        val student = Student(1, "Jhon Doe", "jhon@example.com")

        mainActivityRule.scenario.onActivity {
            it.bindStudentToView(student)
        }

        onView(withId(R.id.tv_name)).check(matches(withText("Jhon Doe")))
        onView(withId(R.id.tv_email)).check(matches(withText("jhon@example.com")))

    }
}