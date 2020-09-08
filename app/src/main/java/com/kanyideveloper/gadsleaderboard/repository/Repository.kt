package com.kanyideveloper.gadsleaderboard.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.kanyideveloper.gadsleaderboard.models.Learners
import com.kanyideveloper.gadsleaderboard.models.SkillIQ
import com.kanyideveloper.gadsleaderboard.retrofit.BASE_URL
import com.kanyideveloper.gadsleaderboard.retrofit.RestAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository() {

    private  val TAG = "Repository"
    val showProgress = MutableLiveData<Boolean>()
    val learnersList = MutableLiveData<List<Learners>>()
    val showSkillsProgress = MutableLiveData<Boolean>()
    val skillIQList = MutableLiveData<List<SkillIQ>>()

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    private val service = retrofit.create(RestAPI::class.java)


    fun getTopLearners() {
        showProgress.value = true

        service.getTopLearningLeaders().enqueue(object : Callback<List<Learners>> {
            override fun onFailure(call: Call<List<Learners>>, t: Throwable) {
                showProgress.value = false
            }

            override fun onResponse(
                    call: Call<List<Learners>>,
                    response: Response<List<Learners>>
            ) {
                learnersList.value = response.body()
                showProgress.value = false
            }

        })
    }

    fun getTopSkill() {
        showSkillsProgress.value = true

        service.getTopSkill().enqueue(object : Callback<List<SkillIQ>> {
            override fun onFailure(call: Call<List<SkillIQ>>, t: Throwable) {
                showSkillsProgress.value = false
            }

            override fun onResponse(
                    call: Call<List<SkillIQ>>,
                    response: Response<List<SkillIQ>>
            ) {
                skillIQList.value = response.body()
                showSkillsProgress.value = false
            }
        })
    }
}
