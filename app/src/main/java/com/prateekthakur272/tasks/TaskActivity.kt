package com.prateekthakur272.tasks

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar

class TaskActivity : AppCompatActivity() {

    lateinit var titleText:EditText
    lateinit var descriptionText:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        titleText = findViewById(R.id.title_input)
        descriptionText = findViewById(R.id.description_input)

    }
    var getMenu: Menu? = null
    private lateinit var edit:MenuItem
    private lateinit var done:MenuItem
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.task_menu, menu)
        getMenu = menu!!
        edit = menu.findItem(R.id.edit)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.edit -> {
                //menuInflater.inflate(R.menu.main_menu,menuChange)
                Snackbar.make(titleText,"Edit your task",Snackbar.LENGTH_LONG).show()
            }
            R.id.done -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }
}