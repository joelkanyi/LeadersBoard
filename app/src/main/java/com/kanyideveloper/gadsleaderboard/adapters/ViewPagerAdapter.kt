package com.kanyideveloper.gadsleaderboard.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kanyideveloper.gadsleaderboard.ui.view.FragmentLearningLeaders
import com.kanyideveloper.gadsleaderboard.ui.view.FragmentSkillIQLeaders

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> {
                FragmentLearningLeaders()
            }
            else->{
                return FragmentSkillIQLeaders()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Learning Leaders"
            else -> return "Skill IQ Leaders"
        }
    }
}
