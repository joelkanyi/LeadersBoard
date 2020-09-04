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

class LearningRepository(val application: Application) {

    private  val TAG = "LearningRepository"
    val showProgress = MutableLiveData<Boolean>()
    val LearnersList = MutableLiveData<List<Learners>>()


    fun changeState() {
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }


    fun getTopLearners() {
        showProgress.value = true
        // Networkcall

        val retrofit =
                Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                        .build()


        val service = retrofit.create(RestAPI::class.java)

        service.getTopLearningLeaders().enqueue(object : Callback<List<Learners>> {
            override fun onFailure(call: Call<List<Learners>>, t: Throwable) {
                showProgress.value = true
                // Toast.makeText(application,"Error wile accessing the API",Toast.LENGTH_SHORT).show()
                Log.d(TAG, "onFailure: failure")
            }

            override fun onResponse(
                    call: Call<List<Learners>>,
                    response: Response<List<Learners>>
            ) {
                Log.d("LearningRepository", "Response : ${Gson().toJson(response.body())}")
                LearnersList.value = response.body()
                showProgress.value = false
            }

        })
    }
}
