package com.prateekthakur272.tasks

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.prateekthakur272.tasks.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity(){
    private val calendar: Calendar = Calendar.getInstance()
    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var timePickerDialog: TimePickerDialog
    private lateinit var binding: ActivityAddTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_add_task)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Add task"

        val titleInputView:EditText = findViewById(R.id.title_input)
        val descriptionInput:EditText = findViewById(R.id.description_input)

        val addTaskButton: Button = findViewById(R.id.add_task_button)

        val taskAddedDialog = Dialog(this)
        taskAddedDialog.setContentView(R.layout.task_added_dialog_layout)

        val doneButton:Button = taskAddedDialog.findViewById(R.id.done_button)
        doneButton.setOnClickListener {
            taskAddedDialog.dismiss()
            finish()
        }
        datePickerDialog = DatePickerDialog(this,{ _, year, month, day ->
            "$year/$month/$day".also { binding.date.text = it }
            println(Calendar.HOUR)
            timePickerDialog.show()
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH))

        timePickerDialog = TimePickerDialog(this,
            { _, hour, minute ->
                "$hour:$minute".also{ binding.time.text = it}
            },calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),false)

        binding.addDateTime.setOnCheckedChangeListener { _, b ->
            if (b){
                datePickerDialog.show()
                binding.dateTimeLayout.visibility = View.VISIBLE
            }
            else
                binding.dateTimeLayout.visibility = View.GONE
        }
        
        binding.date.setOnClickListener {
            datePickerDialog.show()
        }
        binding.time.setOnClickListener {
            timePickerDialog.show()
        }
        addTaskButton.setOnClickListener {
            if (titleInputView.text.isNotBlank()){
                val taskDatabaseHelper = TaskDatabaseHelper(this)
                taskDatabaseHelper.addTask(Task(titleInputView.text.toString().trim(),descriptionInput.text.toString().trim()))
                taskAddedDialog.show()
            }else{
                Toast.makeText(this,"Title field can not be empty!",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}