package com.prateekthakur272.tasks

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskRecyclerView:ListView = findViewById(R.id.task_list_recycler_view)
        val tasksArrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,
            arrayOf("Task"))
        taskRecyclerView.adapter = tasksArrayAdapter

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
                    Toast.makeText(this,"Marked all as done",Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(this,"Deleted all tasks",Toast.LENGTH_SHORT).show()
                    deleteAllTasksDialog.dismiss()
                }
                noButton.setOnClickListener {
                    deleteAllTasksDialog.dismiss()
                }
                deleteAllTasksDialog.show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}