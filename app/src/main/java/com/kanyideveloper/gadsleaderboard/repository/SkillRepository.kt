package com.kanyideveloper.gadsleaderboard.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.kanyideveloper.gadsleaderboard.models.SkillIQ
import com.kanyideveloper.gadsleaderboard.retrofit.BASE_URL
import com.kanyideveloper.gadsleaderboard.retrofit.RestAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SkillRepository(val application: Application) {

    private val TAG = "SkillRepository"
    val showProgress = MutableLiveData<Boolean>()
    val skillIQList = MutableLiveData<List<SkillIQ>>()


    fun changeState() {
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }


    fun getTopSkill() {
        showProgress.value = true
        // Networkccall

        val retrofit =
                Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                        .build()


        val service = retrofit.create(RestAPI::class.java)

        service.getTopSkill().enqueue(object : Callback<List<SkillIQ>> {
            override fun onFailure(call: Call<List<SkillIQ>>, t: Throwable) {
                showProgress.value = false
                ///Toast.makeText(application,"Error wile accessing the API",Toast.LENGTH_SHORT).show()
                Log.d(TAG, "onFailure: failure")
            }

            override fun onResponse(
                    call: Call<List<SkillIQ>>,
                    response: Response<List<SkillIQ>>
            ) {
                Log.d("SkillRepository", "Response : ${Gson().toJson(response.body())}")
                skillIQList.value = response.body()
                showProgress.value = false
            }

        })
    }
}