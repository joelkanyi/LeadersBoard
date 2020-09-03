package com.kanyideveloper.gadsleaderboard.retrofit

import com.kanyideveloper.gadsleaderboard.models.Learner
import com.kanyideveloper.gadsleaderboard.models.SkillIQ
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL = "https://gadsapi.herokuapp.com/"

interface RestAPI {

    @GET("api/hours")
    fun getTopLearningLeaders(): Call<List<Learner>>

    @GET("api/skilliq")
    fun getTopSkillIQLeaders(): Call<List<SkillIQ>>
}