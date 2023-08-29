package com.alireza.eliqtask.utils.extention

import java.text.SimpleDateFormat
import java.util.Date

fun Date?.toFormattedString():String{
    if (this == null) return ""
    return SimpleDateFormat("yyyy-MM-dd HH:mm").format(this)
}