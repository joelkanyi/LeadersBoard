package com.kanyideveloper.gadsleaderboard.viewmodels

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kanyideveloper.gadsleaderboard.repository.SkillRepository

class SkillViewModel(application: Application) : AndroidViewModel(application){
    val skillRepository = SkillRepository(application)
    val showProgress: LiveData<Boolean>

   init {
       this.showProgress = skillRepository.showProgess
   }
/*
    fun getTopSkillers(){
        skillRepository.getTopSkiller()
    }
*/

}