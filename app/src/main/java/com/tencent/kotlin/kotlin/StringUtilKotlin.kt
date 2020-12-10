package com.tencent.kotlin.kotlin

class StringUtilKotlin {

    companion object {
        fun getFirstWord(str: String, separator: String = "_"): String {
            val index = str.indexOf(separator)
            return if (index < 0) str else str.substring(0, index)
        }
    }

}

fun testStringUtilKotlin() {
    val firstWord = StringUtilKotlin.getFirstWord("hello_world")
    println(firstWord)
}


//扩展函数登场 => KotlinFunctions

