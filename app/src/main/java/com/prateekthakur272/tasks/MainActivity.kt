package com.prateekthakur272.tasks

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var parentView:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskRecyclerView:RecyclerView = findViewById(R.id.task_list_recycler_view)
        parentView = findViewById(R.id.linear_layout_main)
        val adapter:TaskRecyclerViewAdapter = TaskRecyclerViewAdapter(this, arrayListOf(
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
            Task("Task","Description"),
        ))
        taskRecyclerView.adapter = adapter
        taskRecyclerView.layoutManager = LinearLayoutManager(this)

        val addTaskButton:ImageButton = findViewById(R.id.add_task_button)
        addTaskButton.setOnClickListener {
            startActivity(Intent(this,AddTaskActivity::class.java))
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mark_all_tasks_done -> {
                val clearAllTasksDialog = Dialog(this)
                clearAllTasksDialog.setContentView(R.layout.clear_all_tasks_dialog_layout)
                val yesButton:Button = clearAllTasksDialog.findViewById(R.id.yes_button)
                val noButton:Button = clearAllTasksDialog.findViewById(R.id.no_button)
                yesButton.setOnClickListener {
                    Snackbar.make(parentView,"Marked all as done",Snackbar.LENGTH_SHORT).show()
                    clearAllTasksDialog.dismiss()
                }
                noButton.setOnClickListener {
                    clearAllTasksDialog.dismiss()
                }
                clearAllTasksDialog.show()
                return true
            }
            R.id.delete_all_tasks -> {
                val deleteAllTasksDialog = Dialog(this)
                deleteAllTasksDialog.setContentView(R.layout.delete_all_tasks_dialog_layout)
                val yesButton:Button = deleteAllTasksDialog.findViewById(R.id.yes_button)
                val noButton:Button = deleteAllTasksDialog.findViewById(R.id.no_button)
                yesButton.setOnClickListener {
                    Snackbar.make(parentView,"Deleted all tasks",Snackbar.LENGTH_SHORT).show()
                    deleteAllTasksDialog.dismiss()
                }
                noButton.setOnClickListener {
                    deleteAllTasksDialog.dismiss()
                }
                deleteAllTasksDialog.show()
                return true
            }
            R.id.about -> {
                startActivity(Intent(this,AboutActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}