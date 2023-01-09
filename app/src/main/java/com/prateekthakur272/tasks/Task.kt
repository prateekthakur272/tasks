package com.prateekthakur272.tasks
class Task {
    var title:String
    var description: String? = null
    var dateTime:DateTime? = null
    var status = Status.PENDING

    constructor(title:String, description:String, dateTime: DateTime?){
        this.title = title
        this.description = description
        this.dateTime = dateTime
        this.status = Status.PENDING
    }
    constructor(title: String, description: String){
        this.title = title
        this.description = description
        this.dateTime = null
        this.status = Status.PENDING
    }
    fun markAsFinished(){
        this.status = Status.FINISHED
    }
    fun markAsPending(){
        this.status = Status.PENDING
    }

    enum class Status{
        PENDING,
        FINISHED;

        override fun toString(): String {
            return when(this){
                Status.PENDING -> "Pending"
                Status.FINISHED -> "Finished"
            }
        }
    }
}