package com.prateekthakur272.tasks

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class TaskActivity : AppCompatActivity() {

    private lateinit var titleText:EditText
    private lateinit var descriptionText:EditText
    private lateinit var markAsDoneButton: Button
    private lateinit var deleteButton: Button
    private lateinit var taskDatabaseHelper: TaskDatabaseHelper

    private var title:String? = null
    private var desc:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        supportActionBar?.title = "Task"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        titleText = findViewById(R.id.title_input)
        descriptionText = findViewById(R.id.description_input)
        markAsDoneButton = findViewById(R.id.mark_done_button)
        deleteButton = findViewById(R.id.delete_task_button)
        taskDatabaseHelper = TaskDatabaseHelper(this)
        title = intent.getStringExtra("title")
        desc = intent.getStringExtra("desc")

        (titleText as TextView).text = title
        (descriptionText as TextView).text = desc

        if (intent.getStringExtra("status")==Task.Status.FINISHED.name){
            markAsDoneButton.visibility = View.GONE
            titleText.isEnabled = false
            descriptionText.isEnabled = false
        }

        markAsDoneButton.setOnClickListener {
            taskDatabaseHelper.markAsDone(intent.getIntExtra("task_id",-1))
            finish()
        }
        deleteButton.setOnClickListener {
            taskDatabaseHelper.deleteTask(intent.getIntExtra("task_id",-1))
            finish()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        update()
        finish()
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        update()
    }
    private fun update(){
        if (title!=titleText.text.toString()||desc!=descriptionText.text.toString()){
            Log.d("task","Updated")
            taskDatabaseHelper.updateTask(intent.getIntExtra("task_id",-1),titleText.text.toString().trim(),descriptionText.text.toString().trim())
        }
    }
}