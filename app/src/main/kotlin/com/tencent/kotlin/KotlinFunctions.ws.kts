
//region Kotlin基础3-函数

//region 函数的声明方式

//NOTICE：函数是Kotlin中的"一等公民"，函数可以直接在文件顶层声明，不用写在类中
fun add(a: Int, b: Int): Int {
    return a + b
}

var c = add(1, 2)

//NOTICE：Kotlin 1.3之后main函数可以不用写参数了
fun main() {
    println("hello world")
}

//endregion


//region 默认参数，具名参数，可变数量的参数

//NOTICE：Kotlin支持具名参数，所以可变数量的参数可以不是函数的最后一个参数
fun format(
    str: String,
    vararg suffix: String,
    upperCase: Boolean = false
): String {
    var res = str
    suffix.forEach { res = res.plus(it) }
    res = if (upperCase) res.toUpperCase() else res
    return res
}

format("hello")
format("hello", upperCase = true)
format("hello", "kotlin", "world")
format("hello", "kotlin", "world", upperCase = true)
format("hello", suffix = *arrayOf("kotlin", "world"))

//endregion


//region 函数类型

//1、不带接收者的函数类型：例如(A, B) -> C 表示 接收类型分别为 A 与 B 两个参数并返回一个 C 类型值的函数
val printStringNTimesFun1: (String, Int) -> String = { str, times -> str.repeat(times)}

println("printStringNTimesFun1:" + printStringNTimesFun1("hello", 3))
//println("printStringNTimesFun1:" + "hello".printStringNTimesFun1(3))

//2、带接收者的函数类型：例如A.(B) -> C 表示 可以在 A 的接收者对象上调用输入类型为 B 的参数的方法并返回一个 C 类型值的函数
val printStringNTimesFun2: String.(Int) -> String = { times -> this.repeat(times) }

println("printStringNTimesFun2:" + "hello".printStringNTimesFun2(3))

//带接收者的函数类型可以作为不带接收者的函数类型被调用，只需要将接收者作为第一个参数即可
println("printStringNTimesFun2:" + printStringNTimesFun2("hello", 3))

//3、suspend函数类型：例如suspend (A, B) -> C，用于协程场景 (暂时不表)

//endregion


//region 特殊函数1：extension functions (扩展函数)

//NOTICE：Kotlin 能够扩展一个类的新功能而无需继承该类或者使用像装饰者这样的设计模式
//例如，你可以为一个你不能修改的、来自第三方库中的类编写一个新的函数。这个新增的函数就像那个原始类本来就有的函数一样，可以用普通的方法调用

//扩展函数的写法，扩展函数定义的内部可以直接调用被扩展类内部定义的方法
fun String.getFirstWord(seperator: String = " "): String {
    val index = indexOf(seperator)
    return if (index < 0) this else substring(0, index)
}

val firstWord = "hello world".getFirstWord()
println(firstWord)

//endregion


//region 特殊函数2：inner functions (内部函数)

//在Kotlin中函数内部可以定义内部函数，局部函数可以访问外部函数的局部变量
class Vertex {
    val neighbors: List<Vertex> = emptyList()
}

class Graph {
    val vertices: List<Vertex> = emptyList()
}

fun dfs(graph: Graph) {
    val visited = HashSet<Vertex>()

    fun dfs(current: Vertex) {
        if (!visited.add(current)) return
        for (v in current.neighbors)
            dfs(v)
    }

    dfs(graph.vertices[0])
}

//endregion


//region 特殊函数3：high order functions (高阶函数)

//在Kotlin中，一个函数可以作为另一个函数的参数或者返回值
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

val sumResult = calculate(4, 5, { a, b -> a + b })

//当lambda表达式作为函数调用的最后一个参数的时候，可以将它挪出来
val mulResult = calculate(4, 5) { a, b -> a * b }

println("sumResult $sumResult, mulResult $mulResult")

//将函数作为返回值的函数
fun operation(): (Int, Int) -> Int {
    return { a, b -> a + b }
}

val result1 = operation()(3, 4)
val result2 = calculate(3, 4, operation())

println("result1 $result1, result2 $result2")

//endregion


//region 特殊函数4：infix functions
//https://kotlinlang.org/docs/reference/functions.html#infix-notation
//Functions marked with the infix keyword can also be called using the infix notation (omitting the dot and the parentheses for the call)

infix fun Int.times(str: String) = str.repeat(this)
println(2 times "Bye ")

infix fun String.times(number: Int) = this.repeat(number)
println("Bye " times 2)

val kvPair = "name" to "javayhu"
val map = mapOf(kvPair, "company" to "tencent")
println(map)

//endregion


//region 特殊函数5：operator functions

operator fun Int.times(str: String) = str.repeat(this)
println(2 * "Bye ")

operator fun String.times(number: Int) = this.repeat(number)
println("Bye " * 2)

//endregion


//region 特殊函数6：scope functions
//https://kotlinlang.org/docs/reference/scope-functions.html

//1、Kotlin标准库中包含了一些这样的函数，它们的目的是针对某个对象创建一个"临时空间"(lambda语句块)，然后执行这段代码，在这个临时空间内可以不用使用变量名来访问这个对象
//2、这些函数的共同点是都是在一个对象上执行一段代码，不同点是这个对象在代码块中如何引用以及这个代码块的返回值是什么
//3、这样的函数主要有5个，分别是 let, run, with, apply, also

//① let：内部使用it引用对象，返回值是lambda表达式的结果，常用于需要非空判断的场景
fun printNonNull(str: String?) {
    str?.let {
        print("string is $it")
    }
}
printNonNull(null)
printNonNull("string for let function")

//② run：跟let类似，但是它内部使用this引用对象，返回值是lambda表达式的结果
fun getNullableLength(ns: String?) {
    ns?.run {
        println("$this length = $length")
        length
    }
}
getNullableLength(null)
getNullableLength("")
getNullableLength("string for run function")

//③ with：内部使用this引用对象，返回值是lambda表达式的结果
data class Configuration(var host:String, var port:Int)
val configuration = Configuration("127.0.0.1", 12345)

val pair = "first" to "second"
//println("${pair.host}:${pair.port}")
val withPair = with(pair) {
    println("$first:$second")
}

//④ apply：内部使用this引用对象，返回值是调用对象本身，常用于需要给对象的多个属性赋值的场景
val applyConfiguration = pair.apply {
    first = "new first"
    second = "new second"
}

//⑤ also：内部使用it引用对象，返回值是调用者本身，常用于需要做些side effect的场景(例如打日志)
val alsoConfiguration = pair.also {
    println("${it.first}:${it.second}")
}

//链起来
val chainConfiguration = configuration.apply {
    host = "127.0.0.1"
    port = 88888
}.also {
    println("${it.host}:${it.port}")
}.let {
    it.port++
    it
}
println("${chainConfiguration.host}:${chainConfiguration.port}")

//endregion


//endregion
