package com.kanyideveloper.gadsleaderboard.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.kanyideveloper.gadsleaderboard.R
import com.kanyideveloper.gadsleaderboard.adapters.ViewPagerAdapter


class LeaderboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)


        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        val submit_btn: Button = findViewById(R.id.action_bar_submit)


        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        // It is used to join TabLayout with ViewPager.
        tabLayout.setupWithViewPager(viewPager)

        submit_btn.setOnClickListener {
            //startActivity(Intent(applicationContext, ProjectSubmission::class.java))
        }
    }


}