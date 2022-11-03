package com.prateekthakur272.tasks

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var parentView:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskRecyclerView:ListView = findViewById(R.id.task_list_recycler_view)
        parentView = findViewById(R.id.linear_layout_main)

        val tasksArrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,
            arrayOf("Task","Task","Task"))
        taskRecyclerView.adapter = tasksArrayAdapter

        taskRecyclerView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,"$i selected",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,TaskActivity::class.java))
        }

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