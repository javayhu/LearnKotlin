
//region Kotlin基础1-基本类型

//region 数字类型、字符类型、布尔类型
//NOTICE：在Kotlin中，任何东西都是对象，包括函数也是对象
val a: Byte = 1
val b: Short = 2
val c: Int = 3
val d: Long = 4L
val e: Float = 2.718f
val f: Double = 3.14
val g: Char = 'g'
val h: Boolean = false

println("a is $a, b is ${b.toInt()}, a+b is ${a+b}")

//endregion

//region 自动类型推断
//NOTICE：Kotlin支持自动类型推断
val i = 5
val j = 6.7
val k = 8L
val l = 8.toLong()

//endregion

//region val和var
//NOTICE：var表示变量，val表示常量
var number = d.toInt()
println("number is $number")

//Kotlin依然是静态类型变成语言
//number = f
number = f.toInt()
println("number is $number")

//endregion

//region 字符串
//第一种字符串：转义字符串，它可以有转义字符
var message = "hello world\nfrom kotlin"
println("short message is $message")

//第二种字符串：原始字符串，原始字符串可以包含换行以及任意文本，类似Python的长字符串定义方式
message = """
    hello world from kotlin
    hope you have fun with kotlin
"""
println("long message is $message")

//直接在字符串上调用方法
message = "hello java".replace("java", "kotlin")
println(message)

//直接获取字符串特定位置的字符
println("first element in message is ${message[0]}")

//endregion

//region 数组类型
//Array类型
val numbers = arrayOf(0, 2, 4, 6, 8, 10)
println("first element in numbers:${numbers[0]}")
numbers.forEach { println(it) }

//基本类型数组及其初始化
val numbers2 = IntArray(5)
val numbers3 = IntArray(5) { 32 }
val numbers4 = IntArray(6, { it * 2 })
numbers4.forEach { println(it) }

//endregion

//endregion
