package com.prateekthakur272.tasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {

    private lateinit var taskRecyclerView:RecyclerView
    private lateinit var adapter: TaskRecyclerViewAdapter
    private lateinit var taskDatabaseHelper: TaskDatabaseHelper
    private lateinit var noHistoryMsg:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        supportActionBar?.title = "History"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        noHistoryMsg = findViewById(R.id.no_history)
        taskDatabaseHelper = TaskDatabaseHelper(this)
        taskRecyclerView = findViewById(R.id.task_list_recycler_view)
        adapter = TaskRecyclerViewAdapter(this,taskDatabaseHelper.getFinishedTaskList())
        taskRecyclerView.adapter = adapter
        taskRecyclerView.layoutManager = LinearLayoutManager(this)

        if (adapter.itemCount==0)
            noHistoryMsg.visibility = View.VISIBLE
        else
            noHistoryMsg.visibility = View.GONE
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
        if (adapter.itemCount==0)
            noHistoryMsg.visibility = View.VISIBLE
        else
            noHistoryMsg.visibility = View.GONE
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}