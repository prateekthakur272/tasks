package com.prateekthakur272.tasks

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

@SuppressLint("NotifyDataSetChanged")
class TaskRecyclerViewAdapter(val context: Context, var items:ArrayList<Task>) :RecyclerView.Adapter<TaskRecyclerViewAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val titleTextView:TextView = itemView.findViewById(R.id.title_text)
        val descriptionTextView:TextView = itemView.findViewById(R.id.description_text)
        val parentLayout:MaterialCardView = itemView.findViewById(R.id.parent_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.task_list_item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = items[position].title
        holder.descriptionTextView.text = items[position].description

        holder.parentLayout.setOnClickListener {
            val taskIntent = Intent(context,TaskActivity::class.java)
            with(items[position]){
                taskIntent.putExtra("task_id",this.taskId)
                taskIntent.putExtra("title",this.title)
                taskIntent.putExtra("desc",this.description)
                taskIntent.putExtra("status",this.status.name)
            }
            context.startActivity(taskIntent)
        }
    }
    override fun getItemCount() = items.size
}