/**
 * https://kotlinlang.org/docs/reference/control-flow.html
 *
 * Control Flow: if, when, for, while
 */

//region Kotlin基础2-控制流

//region if表达式

//NOTICE：在Java中if是条件语句，没有返回值；在Kotlin中if是表达式，有返回值的
val a = 1
val b = 2
var max = if (b > a) b else a

//表达式的最后一行语句的值即为表达式的返回值
var max2 = if (b > a) {
    println("b is bigger")
    b
} else {
    println("a is bigger")
    a
}

println("max is $max, max2 is $max2")

//endregion


//region when表达式

//NOTICE：在Kotlin中when表达式也是具有返回值的，when的作用类似Java中的switch
var c = 9

//when表达式可以作用于任何对象，判断条件可以是比较复杂的判断逻辑
val message = when (c) {
    0, 1 -> "c is 0 or 1"
    2, 3 -> "c is 2 or 3"
    in 4..9 -> "c is in 4 to 9"        //in是operator fun
    else -> "invalid value"
}
println(message)

//endregion


//region for循环

val numbers = IntArray(6, { it * 2 })

//通过 数字区间 进行迭代
for (k in 0..numbers.size - 1) {
    println("[2] the element at $k is ${numbers[k]}")
}

//通过 数组索引 进行迭代
for (k in numbers.indices) {
    println("[1] the element at $k is ${numbers[k]}")
}

//迭代时同时获取索引和值 (Destructuring Declarations：operator fuc componentN)
for ((index, value) in numbers.withIndex()) {
    println("[3] the element at $index is $value")
}

//endregion


//region while循环和do-while循环

//跟Java中一样，没有区别
var k = 3
while (k > 0) {
    k--
}
println(k)

k = 3
do {
    k--
} while (k > 0)
println(k)

//endregion


//endregion
