package com.kanyideveloper.gadsleaderboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.gadsleaderboard.R
import com.kanyideveloper.gadsleaderboard.models.Learners
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.learning_recyclerview_row.view.*

class LearningAdapter( private val context: Context) : RecyclerView.Adapter<LearningAdapter.ViewHolder>() {
    private var list: List<Learners> = ArrayList()

    fun setTopLeanersList(list: List<Learners>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
        Picasso.get().load(list[position].badgeUrl).into(holder.image_url)
        holder.hours_country.text = "${list[position].hours} learning hours, ${list[position].country}"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.learning_recyclerview_row, parent, false))
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name = v.top_learner_name!!
        val image_url = v.top_learner_badge!!
        val hours_country = v.top_learner_hours_country!!
    }
}
