package com.kanyideveloper.gadsleaderboard.retrofit

import com.kanyideveloper.gadsleaderboard.models.Learners
import com.kanyideveloper.gadsleaderboard.models.SkillIQ
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

const val BASE_URL = "https://gadsapi.herokuapp.com/"
const val POST_BASE_URL = "https://docs.google.com/forms/d/e/"

interface RestAPI {

    @GET("api/hours")
    fun getTopLearningLeaders(): Call<List<Learners>>

    @GET("api/skilliq")
    fun getTopSkill(): Call<List<SkillIQ>>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProject(@Field("entry.1877115667") firstName: String,
                      @Field("entry.2006916086") lastName: String,
                      @Field("entry.1824927963") emailAddress: String,
                      @Field("entry.284483984") githubLink: String): Call<Void>


}