package com.prateekthakur272.tasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {

    private lateinit var taskRecyclerView:RecyclerView
    private lateinit var adapter: TaskRecyclerViewAdapter
    private lateinit var taskDatabaseHelper: TaskDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        supportActionBar?.title = "History"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        taskDatabaseHelper = TaskDatabaseHelper(this)
        taskRecyclerView = findViewById(R.id.task_list_recycler_view)
        adapter = TaskRecyclerViewAdapter(this,taskDatabaseHelper.getFinishedTaskList())
        taskRecyclerView.adapter = adapter
        taskRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.history_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.delete_history -> {
                taskDatabaseHelper.deleteAllFinishedTask()
                onRestart()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRestart() {
        super.onRestart()
        adapter.items = taskDatabaseHelper.getFinishedTaskList()
        taskRecyclerView.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}