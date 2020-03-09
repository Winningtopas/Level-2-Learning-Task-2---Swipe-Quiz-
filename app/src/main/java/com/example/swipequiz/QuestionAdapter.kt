package com.example.swipequiz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_place.view.*

public class QuestionAdapter(private val questions: List<Question>) :
    RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(questions[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(question : Question) {
            //itemView.ivPlace.setImageResource(place.imageResId)
            itemView.tvQuestion.text = question.name
            //itemView.setOnClickListener { Toast.makeText(it.context,  question.trueOrFalse.toString(), Toast.LENGTH_SHORT).show() }

            itemView.setOnClickListener {Snackbar.make(itemView,question.trueOrFalse.toString(),Snackbar.LENGTH_LONG).show()}
        }
    }
}
