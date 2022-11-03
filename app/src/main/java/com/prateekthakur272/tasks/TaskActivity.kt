package com.prateekthakur272.tasks

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class TaskActivity : AppCompatActivity() {

    private lateinit var titleText:EditText
    private lateinit var descriptionText:EditText
    private lateinit var markAsDoneButton: Button
    private lateinit var deleteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        supportActionBar?.title = "Task"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        titleText = findViewById(R.id.title_input)
        descriptionText = findViewById(R.id.description_input)
        markAsDoneButton = findViewById(R.id.mark_done_button)
        deleteButton = findViewById(R.id.delete_task_button)

    }

    private lateinit var edit:MenuItem
    private lateinit var done:MenuItem

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.task_menu, menu)
        edit = menu!!.findItem(R.id.edit)
        done = menu.findItem(R.id.done)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.edit -> {
                titleText.isEnabled = true
                descriptionText.isEnabled = true
                markAsDoneButton.visibility = View.GONE
                edit.isVisible = false
                done.isVisible = true
                Snackbar.make(titleText,"Edit your task",Snackbar.LENGTH_LONG).show()
            }
            R.id.done -> {
                if (titleText.text.isNotBlank()) {
                    titleText.isEnabled = false
                    descriptionText.isEnabled = false
                    markAsDoneButton.visibility = View.VISIBLE
                    edit.isVisible = true
                    done.isVisible = false
                    Snackbar.make(titleText,"Changes Saved",Snackbar.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext,"Title can not be blank",Toast.LENGTH_SHORT).show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}