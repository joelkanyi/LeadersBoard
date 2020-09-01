package com.kanyideveloper.gadsleaderboard.data

import android.app.Application
import androidx.lifecycle.MutableLiveData

class LearningRepository (application: Application) {

    var showProgress = MutableLiveData<Boolean>
}