package com.alireza.eliqtask.utils.extention

import java.text.SimpleDateFormat
import java.util.Date

fun Date?.toFormattedDateTime():String{
    if (this == null) return ""
    return SimpleDateFormat("yyyy-MM-dd HH:mm").format(this)
}

fun Date?.toFormattedTime():String{
    if (this == null) return ""
    return SimpleDateFormat("HH:mm").format(this)
}

fun Date?.toFormattedDate():String{
    if (this == null) return ""
    return SimpleDateFormat("yyyy-MM-dd").format(this)
}