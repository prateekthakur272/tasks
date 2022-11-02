package com.prateekthakur272.tasks
enum class Status{
    PENDING,
    FINISHED
}
class Task {
    lateinit var title:String
    var description: String? = null
    var dateTime:DateTime? = null
    var status = Status.PENDING
}