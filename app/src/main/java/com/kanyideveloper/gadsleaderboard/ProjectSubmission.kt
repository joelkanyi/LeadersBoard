package com.kanyideveloper.gadsleaderboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_project_submission.*

class ProjectSubmission : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_submission)

        btn_submit_project.setOnClickListener {
            showCustomDialog()
        }
    }


    private fun showCustomDialog() {
        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)

        //then we will inflate the custom alert dialog xml that we created
        val dialogView: View = LayoutInflater.from(this).inflate(R.layout.are_you_sure_dialog, viewGroup, false)


        //Now we need an AlertDialog.Builder object
        val builder = AlertDialog.Builder(this)

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView)

        //finally creating the alert dialog and displaying it
        val alertDialog = builder.create()
        alertDialog.show()
    }
}