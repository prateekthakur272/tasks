package com.prateekthakur272.tasks

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast
import java.util.*

class AddTask : AppCompatActivity(){
    private val calendar:Calendar = Calendar.getInstance()
    private lateinit var datePickerDialog:DatePickerDialog
    private lateinit var timePickerDialog: TimePickerDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val addDateTime:CheckBox =findViewById(R.id.add_date_time)
        val dateTimeLayout:LinearLayout = findViewById(R.id.date_time_layout)

        datePickerDialog = DatePickerDialog(this)
        timePickerDialog = TimePickerDialog(this,
            { _, h, m ->
                Toast.makeText(this,"Time",Toast.LENGTH_SHORT).show()
            },calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),false)

        addDateTime.setOnCheckedChangeListener { _, b ->
            if (b){
                datePickerDialog.show()
                dateTimeLayout.visibility = View.VISIBLE
            }
            else
                dateTimeLayout.visibility = View.GONE
        }
        datePickerDialog.setOnDateSetListener { datePicker, i, i2, i3 ->
            timePickerDialog.show()
        }
    }
}