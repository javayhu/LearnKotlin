/**
 * https://kotlinlang.org/docs/reference/basic-types.html
 *
 * basic types used in Kotlin: numbers, characters, booleans, arrays, and strings
 */

//region Kotlin基础1-基本类型、集合

//region 数字类型、字符类型、布尔类型

var a: Byte = 1          // 1
var b: Short = 2
var c: Int = 3
var d: Long = 4L
var e: Float = 2.718f
var f: Double = 3.14
var g: Char = 'g'
var h: Boolean = false


println(a)
a = 2

val vala: Int = 1
//vala = 2               // 2 Val cannot be reassigned
println(vala)


val i = 9                // 3
println(i)
//i = f                  // Type mismatch: inferred type is Double but Int was expected


//1：在Kotlin中任何东西都是对象，函数也是对象
//2：Kotlin是静态类型编程语言，var表示变量(variable)，val表示常量(value)
//3：Kotlin支持自动类型推断，可以自动推断变量的类型，也可以自动推断函数返回值

//endregion


//region 字符串

//第一种字符串：转义字符串，它里面可以有转义字符
var message: String = "hello world\nfrom kotlin"
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
val numbers = arrayOf(0, "china")
println("first element in numbers:${numbers[0]}")
numbers.forEach { println(it) }

//基本类型数组及其初始化：ByteArray, ShortArray, IntArray...
val numbers2 = IntArray(5)
val numbers3 = IntArray(5) { 32 }
val numbers4 = IntArray(6, { it * 2 })
numbers4.forEach { println(it) }

//endregion


//region Null Safety

//Kotlin的类型系统为了消除NPE特意将非空类型(例如String)和可空类型(例如String?)进行了区分

var a: String = "abc"           // 普通的初始化意味着不为null
//a = null                      // 编译时报错
println(a)

var b: String? = "abc"          // b可以为null
b = null                        // 编译时不报错
println(b)

val la = a.length
//val lb = b.length             //编译时报错

val vb: String? = "abc"

//在Kotlin中，对于可空类型要想进行调用的话有三种方式 (同Swift)

//1、判空
//val lbInJava = (null != vb) ? vb.length : -1  //Kotlin不支持
val lb = if (vb != null) vb.length else -1   //Kotlin的if表达式
println("lb:$lb")

//2、使用 ?. 操作符
val lb2 = vb?.length              //编译时不报错，如果b是null那么返回为null，如果b不是null那么返回长度
val lb3 = vb?.length ?: -1        //如果我们希望在可空类型为空的时候返回一个非null的结果，可以使用 ?: 操作符
println("lb2:$lb2, lb3:$lb3")

//3、使用 !! 操作符
val lb4 = vb!!.length             //!!操作符强制将可空类型转成非空类型，但是当b是null的时候就会抛出NPE，谨慎使用
println("lb4:$lb4")

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
