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
        private const val COLUMN_STATUS = "status"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table $TABLE_NAME($COLUMN_S_NO integer primary key autoincrement,$COLUMN_TITLE varchar(20) not null,$COLUMN_DESC varchar(100),$COLUMN_STATUS varchar(10))"
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
        cv.put(COLUMN_STATUS,task.status.name)
        db.insert(TABLE_NAME,null,cv)
    }
    fun deleteTask(id:Int){
        val query = "delete from $TABLE_NAME where $COLUMN_S_NO = $id"
        val db = this.writableDatabase
        try {
            db.execSQL(query)
            Log.d("database","deleted all tasks")
        }catch (e:java.lang.RuntimeException){
            Log.d("database","$TABLE_NAME table not found")
        }
        db.close()
    }
    fun markAsDone(id: Int){
        val query = "update $TABLE_NAME set $COLUMN_STATUS = '${Task.Status.FINISHED.name}' where $COLUMN_S_NO = $id"
        val db = this.writableDatabase
        try {
            db.execSQL(query)
            Log.d("database","deleted all tasks")
        }catch (e:java.lang.RuntimeException){
            Log.d("database","$TABLE_NAME table not found")
        }
        db.close()
    }
    fun updateTask(id: Int,title:String,desc:String){
        val query = "update $TABLE_NAME set $COLUMN_TITLE = '$title',$COLUMN_DESC = '$desc' where $COLUMN_S_NO = $id"
        val db = this.writableDatabase
        db.execSQL(query)
    }
    fun getTasksArrayList(): ArrayList<Task> {
        val taskList = mutableListOf<Task>()
        val query = "select * from $TABLE_NAME where $COLUMN_STATUS = '${Task.Status.PENDING.name}'"
        val db = this.readableDatabase
        try {
            val cursor = db.rawQuery(query,null)
            if (cursor.moveToFirst()){
                do {
                    taskList.add(Task(cursor.getString(0).toInt(),cursor.getString(1),cursor.getString(2),Task.Status.valueOf(cursor.getString(3))))
                    Log.d("database", cursor.getString(1))
                }while (cursor.moveToNext())
            }
            cursor.close()
        }catch (e:java.lang.RuntimeException){
            Log.d("database","$TABLE_NAME table not found")
        }
        db.close()
        return taskList as ArrayList
    }
    fun deleteALLTasks(){
        val query = "delete from $TABLE_NAME where $COLUMN_STATUS = '${Task.Status.PENDING.name}'"
        val db = this.writableDatabase
        try {
            db.execSQL(query)
            Log.d("database","deleted all tasks")
        }catch (e:java.lang.RuntimeException){
            Log.d("database","$TABLE_NAME table not found")
        }
        db.close()
    }
    fun markAllDone(){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_STATUS,Task.Status.FINISHED.name)
        db.update(TABLE_NAME,cv,"",Array(0){""})
    }
    fun getFinishedTaskList(): java.util.ArrayList<Task> {
        val taskList = mutableListOf<Task>()
        val query = "select * from $TABLE_NAME where $COLUMN_STATUS = '${Task.Status.FINISHED.name}'"
        val db = this.readableDatabase
        try {
            val cursor = db.rawQuery(query,null)
            if (cursor.moveToFirst()){
                do {
                    taskList.add(Task(cursor.getString(0).toInt(),cursor.getString(1),cursor.getString(2),Task.Status.valueOf(cursor.getString(3))))
                    Log.d("database", cursor.getString(1))
                }while (cursor.moveToNext())
            }
            cursor.close()
        }catch (e:java.lang.RuntimeException){
            Log.d("database","$TABLE_NAME table not found")
        }
        db.close()
        return taskList as ArrayList
    }
    fun deleteAllFinishedTask(){
        val query = "delete from $TABLE_NAME where $COLUMN_STATUS = '${Task.Status.FINISHED.name}'"
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