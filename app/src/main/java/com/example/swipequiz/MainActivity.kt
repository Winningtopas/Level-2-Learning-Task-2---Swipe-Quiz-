package com.example.swipequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

 //   override fun onCreate(savedInstanceState: Bundle?) {
 //       super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
        private val questions = arrayListOf<Question>()
        private val questionAdapter = QuestionAdapter(questions)

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            initViews()
        }

        private fun initViews() {
            rvPlaces.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            rvPlaces.adapter = questionAdapter

            // Populate the places list and notify the data set has changed.

            for (i in Question.Questions.indices){
                questions.add(Question(Question.Questions[i], Question.TRUE_FALSE[i]))
            }


            questionAdapter.notifyDataSetChanged()
            createItemTouchHelper().attachToRecyclerView(rvPlaces)
        }



    private fun createItemTouchHelper(): ItemTouchHelper {

        // Callback which is used to create the ItemTouch helper. Only enables left swipe.
        // Use ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) to also enable right swipe.
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                questions.removeAt(position)
                questionAdapter.notifyDataSetChanged()
            }
        }
        return ItemTouchHelper(callback)
    }

    }

