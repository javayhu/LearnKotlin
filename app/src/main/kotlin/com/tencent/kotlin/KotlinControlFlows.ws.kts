
//region Kotlin基础2-控制流

//region if表达式
//NOTICE：在Kotlin中if表达式是有返回值的
//传统写法
var a = 1
var b = 2
var max = a
if (b > a) max = b

//Kotlin写法
var max2 = if (b > a) b else a

//语句块的最后一个表达式即为返回值
var max3 = if (b > a) {
    println("b is bigger")
    b
} else {
    println("a is bigger")
    a
}

println("max is $max, max2 is $max2, max3 is $max3")

//endregion

//region when表达式
//NOTICE：在Kotlin中when表达式也是具有返回值的，when类似Java中的switch
var c = 9

//when表达式可以作用于任何对象
val message = when(c) {
    0,1 -> "c is 0 or 1"
    2,3 -> "c is 2 or 3"
    in 4..9 -> "c is in 4 to 9"
    else -> "invalid value"
}
println(message)

//endregion

//region for循环
val numbers = IntArray(6, { it * 2 })

//通过数字区间进行迭代
for (k in 0..numbers.size-1) {
    println("[1] the element at $k is ${numbers[k]}")
}

//通过索引进行迭代
for (k in numbers.indices) {
    println("[2] the element at $k is ${numbers[k]}")
}

for ((index, value) in numbers.withIndex()) {
    println("[3] the element at $index is $value")
}

//endregion

//region while循环和do-while循环
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