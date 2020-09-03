package com.kanyideveloper.gadsleaderboard.ui.view

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.kanyideveloper.gadsleaderboard.R
import com.kanyideveloper.gadsleaderboard.adapters.ViewPagerAdapter


class LeaderboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)

        /*val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabs: TabLayout = findViewById(R.id.tabs)

        //setSupportActionBar(toolbar)
        val adapter = ViewPagerAdapter(supportFragmentManager)

        if()
        adapter.addFragment(LearningLeaders(),"Learning Leaders")
        adapter.addFragment(SkillIQLeaders(),"Skill IQ Leaders")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)*/


        /*val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.tabs)


        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        // It is used to join TabLayout with ViewPager.
        tabLayout.setupWithViewPager(viewPager)*/

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)


        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        // It is used to join TabLayout with ViewPager.
        tabLayout.setupWithViewPager(viewPager)
    }
}