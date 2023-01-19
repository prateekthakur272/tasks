package com.prateekthakur272.tasks

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class TaskDatabaseHelper(context:Context) : SQLiteOpenHelper(context, DB_NAME,null,1) {
    companion object{
        const val DB_NAME = "TaskDatabase.db"
        private const val TABLE_NAME = "task"
        private const val COLUMN_S_NO = "s_no"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_DESC = "description"
        private const val COLUMN_DATE = "date"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table $TABLE_NAME($COLUMN_S_NO integer primary key autoincrement,$COLUMN_TITLE varchar(20) not null,$COLUMN_DESC varchar(100))"
        db?.execSQL(query)
        if (db!!.isOpen)
            Log.d("database","Database is open")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun addTask(task:Task){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITLE,task.title)
        cv.put(COLUMN_DESC,task.description)
        db.insert(TABLE_NAME,null,cv)
    }

    fun getTasksArrayList(): ArrayList<Task> {
        val taskList = mutableListOf<Task>()
        val query = "select * from $TABLE_NAME"
        val db = this.readableDatabase
        try {
            val cursor = db.rawQuery(query,null)
            if (cursor.moveToFirst()){
                do {
                    taskList.add(Task(cursor.getString(1),cursor.getString(2)))
                    Log.d("database", cursor.getString(1))
                }while (cursor.moveToNext())
            }
        }catch (e:java.lang.RuntimeException){
            Log.d("database","$TABLE_NAME table not found")
        }
        db.close()
        return taskList as ArrayList
    }
    fun deleteALLTasks(){
        val query = "delete from $TABLE_NAME"
        val db = this.writableDatabase
        try {
            db.execSQL(query)
            Log.d("database","deleted all tasks")
        }catch (e:java.lang.RuntimeException){
            Log.d("database","$TABLE_NAME table not found")
        }
        db.close()
    }
}