package com.tencent.kotlin

import android.nfc.Tag
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

//region data classes

data class User(val id:Int, val name:String)

fun createUser(id: Int, name: String) = User(id, name)

fun testDataClass() {
    val (id, name) = createUser(1, "javayhu")
    println("user id:$id, name:$name")
}

//endregion


//region sealed classes

sealed class Mammal(val name: String)
class Cat(val catName: String) : Mammal(catName)
class Human(val humanName: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    when (mammal) {
        is Human -> return "Hello ${mammal.name}"
        is Cat -> return "Hello ${mammal.name}"
    }
}

//endregion


//region Object Expression

fun testObjectExpression() {
    val anObject = object {
        val value = 1
        val otherValue = 2
        val someOtherValue = 3
    }
    println("object values:${anObject.value}, ${anObject.otherValue}, ${anObject.someOtherValue}")
}
//TODO：为什么将object声明从function中提出来就不行了? 匿名对象不能在top-level声明

//endregion


//region inline functions

inline fun lock(lock:Lock, body: () -> Unit) {                            // 1、2
    lock.lock()
    try {
        body()
    } finally {
        lock.unlock()
    }
}

fun testInlineFunction() {
    lock(ReentrantLock(), { println("lock function body") })
}

inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {     // 3
    inlined()
    //testNoInlineFunction(inlined)                                        // 4

    notInlined()
    testNoInlineFunction(notInlined)                                       // 4
}

fun testNoInlineFunction(body: () -> Unit) {
    body()
}

//1、inline修饰符一般跟着高阶函数一起使用(非高阶函数使用会提示使用inline没有意义)，用于减少程序运行时的开销
//2、inline修饰符的作用是告诉编译器：将函数的实现代码直接复制到函数调用的地方而不要创建多余的Function类对象
//3、如果你的inline function中有某个参数是不希望inline的，那么可以将其声明为noinline
//4、noinline的函数可以随便使用，而inline函数只能被调用不能被传递

//endregion


//region  Kotlin-Java Interoperability

val javaDemo = JavaDemo(1, "javayhu")

fun testCallJavaFromKotlin() {
    println("java demo id:${javaDemo.id}, name:${javaDemo.name}")

    //调用参数可以为空的Java函数
    javaDemo.testParamNullableFunction("kotlin")
    javaDemo.testParamNullableFunction(null)

    //调用参数不可以为空的Java函数
    javaDemo.testParamNotNullFunction("kotlin")
    //javaDemo.testParamNotNullFunction(null)

    //调用Java类中的静态方法(Kotlin代码中只能通过类来调用)
    JavaDemo.testStaticFunction()
}

class KotlinDemo(val id:Int, val name:String) {

    companion object {
        val TAG = "KotlinDemo"

        fun testStaticFunction() {
            //do nothing
        }
    }

}

//endregion


//region Lambda Functions

// All examples create a function object that performs upper-casing. it's a function from String to String

val upperCase1: (String) -> String = { str: String -> str.toUpperCase() } // 1

val upperCase2: (String) -> String = { str -> str.toUpperCase() }         // 2

val upperCase3 = { str: String -> str.toUpperCase() }                     // 3

// val upperCase4 = { str -> str.toUpperCase() }                          // 4

val upperCase5: (String) -> String = { it.toUpperCase() }                 // 5

val upperCase6: (String) -> String = String::toUpperCase                  // 6

fun testLambdaFunctions() {
    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    println(upperCase6("hello"))
}

//endregion
