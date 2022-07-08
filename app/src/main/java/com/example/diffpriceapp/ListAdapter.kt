package com.example.diffpriceapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val students: List<Product>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(group: ViewGroup,
                                    viewType: Int): ViewHolder {
        val view = LayoutInflater.from(group.context)
            .inflate(R.layout.layout_list_item, group, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder,
                                  position: Int) {
        val student = students[position]
        if (student != null) {
            viewHolder.bind(student)
        }
    }
    override fun getItemCount(): Int = students.size
}