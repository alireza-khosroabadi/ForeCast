package com.alireza.eliqtask.base.utils.extension

import java.text.SimpleDateFormat
import java.util.Date

/**
 * Use this extension functions to convert Date to string models
 * */

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