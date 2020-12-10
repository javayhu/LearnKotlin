/**
 * https://kotlinlang.org/docs/reference/basic-types.html
 *
 * basic types used in Kotlin: numbers, characters, booleans, arrays, and strings
 */

//region Kotlin基础1-基本类型、集合

//region 数字类型、字符类型、布尔类型

val a: Byte = 1          // 1
val b: Short = 2
val c: Int = 3
val d: Long = 4L
val e: Float = 2.718f
val f: Double = 3.14
val g: Char = 'g'
val h: Boolean = false


println(a)
//a = 2                  // 4 Val cannot be reassigned

var va: Byte = 1         // 4
va = 2
println(va)


val i = 9f.toInt()       // 2、5
println(i)
//i = f                  // 5 Type mismatch: inferred type is Double but Int was expected


//1：在Kotlin中任何东西都是对象，函数也是对象
//2：显式转换，数值类型(Number)的子类都支持toByte/toInt/toLong等显式转换
//3：数值类型都支持基本的数值运算操作(+ - * / %)，其他类型通过运算符函数重载也能支持
//4：Kotlin是静态类型编程语言，var表示变量(variable)，val表示常量(value)
//5：Kotlin支持自动类型推断，可以自动推断变量的类型，也可以自动推断函数返回值

//endregion


//NOTICE：切到Null Safety


//region 字符串
//第一种字符串：转义字符串，它里面可以有转义字符
var message = "hello world\nfrom kotlin"
println("short message is $message")  //字符串模板

//第二种字符串：原始字符串，原始字符串可以包含换行以及任意文本，类似Python的长字符串定义方式
message = """
    hello world from kotlin
    hope you have fun with kotlin
"""
println("long message is $message")

//直接获取字符串特定位置的字符 (操作符重载函数 operator fun)
println("first element in message is ${message[0]}")

//endregion


//region 数组类型

//Array类型
val numbers = arrayOf(0, 2, 4, 6, 8, 10)
println("first element in numbers:${numbers[0]}")
numbers.forEach { println(it) }    //高阶函数

//基本类型数组及其初始化：ByteArray, ShortArray, IntArray...
val numbers2 = IntArray(5)
val numbers3 = IntArray(5) { 32 }
val numbers4 = IntArray(6, { it * 2 })
numbers4.forEach { println(it) }

//endregion


//region 集合 (演示过程先跳过)

//List
val mutableList = mutableListOf(1, 2, 3)
mutableList.add(4)
println(mutableList)

val list = listOf(4, 3, 2, 1)
//list.add(5)      //compilation error
println(list)

println(mutableList == list)

//Set
val mutableSet = mutableSetOf(1, 2, 3)
mutableSet.add(4)
println(mutableSet)

val set = setOf(4, 3, 2, 1)
//set.add(5)      //compilation error
println(set)

println(mutableSet == set)

//Map
val mutableMap = mutableMapOf("id" to "1", "name" to "kotlin")
mutableMap.put("company", "JetBrains")
println(mutableMap)

val map = mapOf("id" to "1", "company" to "JetBrains", "name" to "kotlin")
//map.put("company" to "JetBrains")        //compilation error
println(map)

println(mutableMap == map)

//Collection operations

//filter
val evenList = list.filter { it % 2 == 0 }
println(evenList)

//map
val doubleSet = set.map { it * 2 }
println(doubleSet)

//max、min
val max = list.maxOrNull()
println(max)

val min = list.minOrNull()
println(min)

//sorted、sortedDescending
val sortedList = list.sorted()
println(sortedList)

val sortedDescendingList = list.sortedDescending()
println(sortedDescendingList)

//还有count、all、any、find、distinct、groupBy等等操作

//endregion (


//endregion
