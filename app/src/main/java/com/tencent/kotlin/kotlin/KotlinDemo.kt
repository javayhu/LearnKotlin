package com.tencent.kotlin.kotlin

import com.tencent.kotlin.java.JavaDemo
import kotlinx.android.parcel.Parcelize
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock


//region  Kotlin-Java互操作 (先)

val javaDemo = JavaDemo(1, "kotlin")

//在Kotlin中调用Java
fun testCallJavaFromKotlin() {
    println("java demo id:${javaDemo.id}, name:${javaDemo.name}")

    //调用Java类中的静态方法(Kotlin代码中只能通过类来调用)
    JavaDemo.testStaticFunction()

    //调用参数可以为空的Java函数
    javaDemo.testParamNullableFunction("kotlin")
    javaDemo.testParamNullableFunction(null)

    //调用参数不可以为空的Java函数
    javaDemo.testParamNotNullFunction("kotlin")
    //javaDemo.testParamNotNullFunction(null)

    //创建KotlinDemo对象，可以不传入默认参数name
    val kotlinDemo1 = KotlinDemo(1)
    val kotlinDemo2 = KotlinDemo(2, "java")
}

//演示几个注解的作用
class KotlinDemo @JvmOverloads constructor(
    @JvmField var id: Int,
    val name: String = "kotlin"
) {

    companion object {
        @JvmStatic
        fun testStaticFunction() {
            //do nothing
        }

        fun testNonStaticFunction() {

        }
    }
}

//endregion


//region sealed classes

sealed class Response  //换成open试下
class Success(val message: String) : Response()
class Failure(val error: Int) : Response()

fun handleResponse(response: Response) {
    when (response) {
        is Success -> {
            println("success message:${response.message}")
        }
        is Failure -> {
            println("failure error:${response.error}")
        }
    }
}
//sealed classed搭配when表达式可以在编译时就知道条件语句是否完整，Java的switch语句是做不到的

//endregion


//region inline functions (演示过程先跳过)

inline fun lock(lock: Lock, body: () -> Unit) {                            // 1、2
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


//region Lambda Functions (演示过程先跳过)

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

