package com.kanyideveloper.gadsleaderboard.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kanyideveloper.gadsleaderboard.models.Learners
import com.kanyideveloper.gadsleaderboard.models.SkillIQ
import com.kanyideveloper.gadsleaderboard.repository.Repository

class MainViewModel() : ViewModel(){
    val showProgress : LiveData<Boolean>
    val showSkillProgress : LiveData<Boolean>
    val topLearnersList : LiveData<List<Learners>>
    val topSkillIQLeadersList : LiveData<List<SkillIQ>>
    private val repository = Repository()

    init {
        this.showProgress = repository.showProgress
        this.showSkillProgress = repository.showSkillsProgress
        this.topLearnersList = repository.learnersList
        this.topSkillIQLeadersList = repository.skillIQList

    }

    fun getTopLearner(){
        repository.getTopLearners()
    }

    fun getTopSkillIQLeaders(){
        repository.getTopSkill()
    }
}