package com.prateekthakur272.tasks

import android.app.Application
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.CalendarAlerts
import android.view.View
import android.widget.*
import java.util.*

class AddTask : AppCompatActivity(){
    private val calendar: Calendar = Calendar.getInstance()
    private lateinit var datePickerDialog:DatePickerDialog
    private lateinit var timePickerDialog: TimePickerDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val titleInputView:EditText = findViewById(R.id.title_input)
        val descriptionInput:EditText = findViewById(R.id.description_input)
        val addDateTime:CheckBox =findViewById(R.id.add_date_time)
        val dateTimeLayout:LinearLayout = findViewById(R.id.date_time_layout)
        val dateView:TextView = findViewById(R.id.date)
        val timeView:TextView = findViewById(R.id.time)
        val addTaskButton: Button = findViewById(R.id.add_task_button)

        val taskAddedDialog = Dialog(this)
        taskAddedDialog.setContentView(R.layout.task_added_dialog_layout)

        val doneButton:Button = taskAddedDialog.findViewById(R.id.done_button)
        doneButton.setOnClickListener {
            taskAddedDialog.dismiss()
            finish()
        }

        datePickerDialog = DatePickerDialog(this)
        timePickerDialog = TimePickerDialog(this,
            { _, hour, minute ->
                "$hour:$minute".also{ timeView.text = it}
            },calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),false)

        addDateTime.setOnCheckedChangeListener { _, b ->
            if (b){
                datePickerDialog.show()
                dateTimeLayout.visibility = View.VISIBLE
            }
            else
                dateTimeLayout.visibility = View.GONE
        }
        datePickerDialog.setOnDateSetListener { _, year, month, day ->
            "$year/$month/$day".also { dateView.text = it }
            println(Calendar.HOUR)
            timePickerDialog.show()
        }
        dateView.setOnClickListener {
            datePickerDialog.show()
        }
        timeView.setOnClickListener {
            timePickerDialog.show()
        }
        addTaskButton.setOnClickListener {
            if (titleInputView.text.isNotEmpty()){
                taskAddedDialog.show()
            }else{
                Toast.makeText(this,"Title field can not be empty!",Toast.LENGTH_LONG).show()
            }
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}