package com.kanyideveloper.gadsleaderboard.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import com.kanyideveloper.gadsleaderboard.R
import com.kanyideveloper.gadsleaderboard.retrofit.POST_BASE_URL
import com.kanyideveloper.gadsleaderboard.retrofit.RestAPI
import kotlinx.android.synthetic.main.activity_project_submission.*
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProjectSubmissionActivity : AppCompatActivity() {

    private val retrofit = Retrofit.Builder().baseUrl(POST_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_submission)

        //setting up my toolbar
        val myToolbar = findViewById<Toolbar>(R.id.sub_toolbar)
        setSupportActionBar(myToolbar)
        myToolbar.title = ""
        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btn_submit_project.setOnClickListener {
            showConfirmationDialog()
        }
    }

    private fun sendData(firstName:String, lastName:String, email:String, github_link:String){

        val service = retrofit.create(RestAPI::class.java)

        service.submitProject(firstName,lastName,email,github_link).enqueue(object : Callback<Void> {

            override fun onResponse(call: retrofit2.Call<Void>, response: Response<Void>) {
                showSuccessDialog()
                Toast.makeText(applicationContext,"Data posted",Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                showFailureDialog()
                Toast.makeText(applicationContext,"Data not posted",Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun showConfirmationDialog() {
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)

        val dialogView: View = LayoutInflater.from(this).inflate(R.layout.are_you_sure_dialog, viewGroup, false)

        val yes : Button = dialogView.findViewById(R.id.yes_to_submit)
        val close : ImageView = dialogView.findViewById(R.id.close_btn)

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog = builder.create()
        alertDialog.show()

        close.setOnClickListener {
            alertDialog.dismiss()
        }

        yes.setOnClickListener {
            sendData(first_name.text.toString(),last_name.text.toString(),email_address.text.toString(),project_github_link.text.toString())
            alertDialog.dismiss()
        }
    }
    private fun showSuccessDialog(){
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View = LayoutInflater.from(this).inflate(R.layout.submission_successful_dialog, viewGroup, false)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog = builder.create()
        alertDialog.show()

    }
    private fun showFailureDialog(){
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View = LayoutInflater.from(this).inflate(R.layout.submission_not_succesful_dialog, viewGroup, false)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog = builder.create()
        alertDialog.show()
    }

    //setting navigate up button
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}