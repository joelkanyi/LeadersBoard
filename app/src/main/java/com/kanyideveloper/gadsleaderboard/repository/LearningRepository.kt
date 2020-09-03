package com.kanyideveloper.gadsleaderboard.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.kanyideveloper.gadsleaderboard.models.Learner
import com.kanyideveloper.gadsleaderboard.retrofit.BASE_URL
import com.kanyideveloper.gadsleaderboard.retrofit.RestAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LearningRepository(val application: Application) {

    val showProgress = MutableLiveData<Boolean>()
    val LearnersList = MutableLiveData<List<Learner>>()


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

        service.getTopLearner().enqueue(object  : Callback<List<Learner>>{
            override fun onFailure(call: Call<List<Learner>>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application,"Error wile accessing the API",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                    call: Call<List<Learner>>,
                    response: Response<List<Learner>>
            ) {
                Log.d("SearchRepository" , "Response : ${Gson().toJson(response.body())}")
                LearnersList.value = response.body()
                showProgress.value = false
            }

        })
    }
}
