package com.tencent.kotlin.kotlin

object SingletonKotlin {

    const val property: String = "kotlin"

    init {
        println("SingletonKotlin object init")
    }

    fun init() {
        println("SingletonKotlin call init")
    }

}

fun testSingletonKotlin() {
    SingletonKotlin.init()
    SingletonKotlin.init()
}

//consts are compile time constants. Meaning that their value has to be assigned during compile time, unlike vals, where it can be done at runtime.
//This means, that consts can never be assigned to a function or any class constructor, but only to a String or primitive.
