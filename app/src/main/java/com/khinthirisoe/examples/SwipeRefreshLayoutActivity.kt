package com.khinthirisoe.examples

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class SwipeRefreshLayoutActivity : AppCompatActivity() {

    //counting the number of swipes
    var swipeCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_refresh_layout)

        //getting recyclerview from xml
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        //getting swipeRefreshLayput from xml
        val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout)

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val blogs = ArrayList<Blog>()
        val adapter = CustomAdapter(blogs)

        recyclerView.adapter = adapter;
        swipeRefreshLayout.setOnRefreshListener {

            swipeCount += 1;
            if (swipeCount > 0) {
                blogs.add(Blog("Blog Title $swipeCount", "Description : Blog description goes here"))
                Toast.makeText(this, "Swipe called", Toast.LENGTH_SHORT).show()
            }
            adapter.notifyDataSetChanged()

            swipeRefreshLayout.isRefreshing = false
        }

    }
}
