package com.kanyideveloper.gadsleaderboard.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kanyideveloper.gadsleaderboard.models.Learners
import com.kanyideveloper.gadsleaderboard.repository.LearningRepository

class LearningViewModel(application : Application) : AndroidViewModel(application){



    private val learningRepository = LearningRepository(application)
    val showProgress : LiveData<Boolean>
    val topLearnersList : LiveData<List<Learners>>

    init {
        this.showProgress = learningRepository.showProgress
        this.topLearnersList = learningRepository.LearnersList
    }

    fun changeState(){
        learningRepository.changeState()
    }

    fun getTopLearner(){
        learningRepository.getTopLearners()
    }
}