package com.prateekthakur272.tasks

import android.inputmethodservice.KeyboardView
import android.os.Bundle
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class TaskActivity : AppCompatActivity() {

    private lateinit var titleText:EditText
    private lateinit var descriptionText:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        titleText = findViewById(R.id.title_input)
        descriptionText = findViewById(R.id.description_input)


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
                edit.isVisible = false
                done.isVisible = true
                titleText.isEnabled = true
                descriptionText.isEnabled = true
                Snackbar.make(titleText,"Edit your task",Snackbar.LENGTH_LONG).show()
            }
            R.id.done -> {
                if (titleText.text.isNotBlank()) {
                    titleText.isEnabled = false
                    descriptionText.isEnabled = false
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
}