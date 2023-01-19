package com.prateekthakur272.tasks
class Task {
    var taskId = -1
    var title:String
    var description: String? = null
    var status = Status.PENDING

    constructor(id:Int,title:String, description:String,status:Status){
        this.title = title
        this.description = description
        this.taskId = id
        this.status = status
    }
    constructor(title: String, description: String){
        this.title = title
        this.description = description
        this.status = Status.PENDING
    }
    enum class Status{
        PENDING,
        FINISHED;
    }
}