package com.kanyideveloper.gadsleaderboard.retrofit

import com.kanyideveloper.gadsleaderboard.models.Learner
import com.kanyideveloper.gadsleaderboard.models.Skiller
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL = "https://gadsapi.herokuapp.com/"

interface RestAPI {

    @GET("api/hours")
    fun getTopLearner(): Call<List<Learner>>

    @GET("api/skilliq")
    fun getTopSkiller(): Call<List<Skiller>>
}