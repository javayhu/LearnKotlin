/**
 * https://kotlinlang.org/docs/reference/basic-types.html
 *
 * basic types used in Kotlin: numbers, characters, booleans, arrays, and strings
 */

//region Kotlin基础1-基本类型

//region 数字类型、字符类型、布尔类型

val a: Byte = 1          //1
val b: Short = 2
val c: Int = 3
val d: Long = 4L
val e: Float = 2.718f
val f: Double = 3.14
val g: Char = 'g'
val h: Boolean = false

val i = d.toInt()        //2
val j = a + b            //3

//d = 5                  //4 Val cannot be reassigned
//i = f                  //5 Type mismatch: inferred type is Double but Int was expected

//1：在Kotlin中任何东西都是对象，函数也是对象
//2：显式转换，数值类型(Number)的子类都支持toByte/toInt/toLong等显式转换
//3：数值类型都支持基本的数值运算操作(+ - * / %)，其他类型通过运算符函数重载也能支持
//4：Kotlin是静态类型编程语言，var表示变量(variable)，val表示常量(value)
//5：Kotlin支持自动类型推断，可以自动推断变量的类型，也可以自动推断函数返回值

//endregion

//NOTICE：切到Null Safety

//region 数组类型

//Array类型
val numbers = arrayOf(0, 2, 4, 6, 8, 10)
println("first element in numbers:${numbers[0]}")
numbers.forEach { println(it) } //高阶函数

//基本类型数组及其初始化：ByteArray, ShortArray, IntArray...
val numbers2 = IntArray(5)
val numbers3 = IntArray(5) { 32 }
val numbers4 = IntArray(6, { it * 2 })
numbers4.forEach { println(it) }

//endregion


//region 字符串
//第一种字符串：转义字符串，它里面可以有转义字符
var message = "hello world\nfrom kotlin"
println("short message is $message")

//第二种字符串：原始字符串，原始字符串可以包含换行以及任意文本，类似Python的长字符串定义方式
message = """
    hello world from kotlin
    hope you have fun with kotlin
"""
println("long message is $message")

//直接在字符串上调用方法 (扩展函数 extension fun)
message = "hello java".replace("java", "kotlin")
println(message)

//直接获取字符串特定位置的字符 (操作符重载函数 operator fun：operator fun get(index: Int):Char)
println("first element in message is ${message[0]}")

//endregion


//endregion
