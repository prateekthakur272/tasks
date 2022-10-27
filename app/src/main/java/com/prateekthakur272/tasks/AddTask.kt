package com.prateekthakur272.tasks

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TimePicker
import java.util.Random

class AddTask : AppCompatActivity(),DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val imageArray:Array<Int> = arrayOf(R.drawable.cat,R.drawable.crocodile,R.drawable.elephant,R.drawable.monkey,R.drawable.sea_horse)

        val addDateTime:CheckBox =findViewById(R.id.add_date_time)
        val dateTimeLayout:LinearLayout = findViewById(R.id.date_time_layout)
        val image:ImageView = findViewById(R.id.image)
        image.setImageResource((imageArray).random())

        addDateTime.setOnCheckedChangeListener { _, b ->
            if (b)
                dateTimeLayout.visibility = View.VISIBLE
            else
                dateTimeLayout.visibility = View.GONE
        }
//        val datePickerDialog:DatePickerDialog = DatePickerDialog(this)
//        datePickerDialog.show()
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
//        val calendar = Calendar.getInstance()
//        val timePickerDialog = TimePickerDialog(this,
//            { timePicker, h, m ->  },calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),false)
//        timePickerDialog.show()

    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {

    }
}