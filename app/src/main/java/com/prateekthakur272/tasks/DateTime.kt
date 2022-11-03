package com.prateekthakur272.tasks
enum class MonthName(val month: Int,val monthName:String){
    January(1,"January"),
    February(2,"February"),
    March(3,"March"),
    April(4,"April"),
    May(5,"May"),
    June(6,"June"),
    July(7,"July"),
    August(8,"August"),
    September(9,"September"),
    October(10,"October"),
    November(11,"November"),
    December(12,"December");

    override fun toString(): String {
        return this.monthName
    }
}
class DateTime(var day:Int, var month:Int, var year:Int, var hour:Int, var minute:Int) {
    override fun toString(): String {
        return ""
    }
}