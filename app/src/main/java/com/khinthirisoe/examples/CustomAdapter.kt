package com.khinthirisoe.examples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val blogList: ArrayList<Blog>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(blogList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return blogList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(blog: Blog) {
            val textViewTitle = itemView.findViewById(R.id.textViewTitle) as TextView
            val textViewDesc  = itemView.findViewById(R.id.textViewDesc) as TextView
            textViewTitle.text = blog.title
            textViewDesc.text = blog.desc
        }
    }
}
