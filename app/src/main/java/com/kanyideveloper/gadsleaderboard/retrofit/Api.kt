package com.kanyideveloper.gadsleaderboard.retrofit

import com.kanyideveloper.gadsleaderboard.models.Learners
import com.kanyideveloper.gadsleaderboard.models.SkillIQ
import retrofit2.Call
import retrofit2.http.GET
const val BASE_UR = "https://gadsapi.herokuapp.com/"

interface Api {
    @GET("api/skilliq")
    fun getTopSkillIQLeaders(): Call<List<SkillIQ>>

    @GET("api/hours")
    fun getTopLearningLeaders(): Call<List<Learners>>
}