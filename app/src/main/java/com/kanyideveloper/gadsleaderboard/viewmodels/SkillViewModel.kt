package com.kanyideveloper.gadsleaderboard.viewmodels

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kanyideveloper.gadsleaderboard.models.Skiller
import com.kanyideveloper.gadsleaderboard.repository.SkillRepository

class SkillViewModel(application: Application) : AndroidViewModel(application){
    val skillRepository = SkillRepository(application)
    val showProgress: LiveData<Boolean>
    val topSkillersList : LiveData<List<Skiller>>

   init {
       this.showProgress = skillRepository.showProgess
       this.topSkillersList = skillRepository.topSkillersList
   }

    fun getTopSkillers(){
        skillRepository.getTopSkiller()
    }

}