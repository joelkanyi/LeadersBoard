package com.kanyideveloper.gadsleaderboard.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.kanyideveloper.gadsleaderboard.models.Learner
import com.kanyideveloper.gadsleaderboard.models.SkillIQ
import com.kanyideveloper.gadsleaderboard.retrofit.BASE_URL
import com.kanyideveloper.gadsleaderboard.retrofit.RestAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SkillRepository (val application: Application){

    val showProgess = MutableLiveData<Boolean>()
    val topSkillIQLeadersList = MutableLiveData<List<SkillIQ>>()

    fun getTopSkillIQ(){
        showProgess.value = true

        //Network call
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(RestAPI::class.java)
        service.getTopSkillIQLeaders().enqueue(object : Callback<List<SkillIQ>>{
            override fun onResponse(call: Call<List<SkillIQ>>, response: Response<List<SkillIQ>>) {
                topSkillIQLeadersList.value = response.body()
                showProgess.value = false
            }

            override fun onFailure(call: Call<List<SkillIQ>>, t: Throwable) {
                showProgess.value = false
                Toast.makeText(application, "Failed to load data, check your internet connection",
                        Toast.LENGTH_SHORT).show()
            }
        })
    }
}