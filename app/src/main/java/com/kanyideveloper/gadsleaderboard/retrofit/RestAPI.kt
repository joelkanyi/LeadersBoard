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

    @POST("1FAIpQLSeXIlMI9J-BQXCBE3yYUykNxlyQbXS0LXUGgq2n_9cK7nuFJQ/formResponse")
    @FormUrlEncoded
    fun submitProject(@Field("entry.28453499") firstName: String,
                      @Field("entry.28453499") lastName: String,
                      @Field("entry.703248609") emailAddress: String,
                      @Field("entry.703248609") githubLink: String): Call<Void>


}