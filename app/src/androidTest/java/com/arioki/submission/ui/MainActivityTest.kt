/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/16/19 7:14 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui

import android.view.KeyEvent
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.arioki.submission.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        onView(withId(R.id.btnMenuSearch))
            .check(matches(isDisplayed()))
        Thread.sleep(1000)

        onView(withId(R.id.btnMenuSearch))
            .perform(click())
        Thread.sleep(1000)

        onView(withContentDescription("Search"))
            .check(matches(isDisplayed()))
        Thread.sleep(1000)

        onView(withContentDescription("Search"))
            .perform(click())
        Thread.sleep(1000)

        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText("Real Madrid"),
            pressKey(KeyEvent.KEYCODE_ENTER)
        )
        Thread.sleep(10000)

        onView(withId(R.id.rvSearch))
            .check(matches(isDisplayed()))
        Thread.sleep(1000)

        onView(withId(R.id.rvSearch))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(11))
        Thread.sleep(10000)

        onView(withId(R.id.rvSearch))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    11,
                    click()
                )
            )
        Thread.sleep(1000)

        onView(withId(R.id.rvDetailEvent))
            .check(matches(isDisplayed()))
        Thread.sleep(1000)
    }
}
