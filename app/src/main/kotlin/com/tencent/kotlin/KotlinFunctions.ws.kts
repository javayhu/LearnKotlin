
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


//region 扩展函数

//NOTICE：Kotlin 能够扩展一个类的新功能而无需继承该类或者使用像装饰者这样的设计模式
//例如，你可以为一个你不能修改的、来自第三方库中的类编写一个新的函数。这个新增的函数就像那个原始类本来就有的函数一样，可以用普通的方法调用

//传统的写法(Java语言版本对应的Kotlin直译版)
class StringUtil {
    companion object {
        fun getFirstWord(str: String, seperator: String = "_"): String {
            val index = str.indexOf(seperator)
            return if (index < 0) str else str.substring(0, index)
        }
    }
}

var firstWord = StringUtil.getFirstWord("hello_world")
println(firstWord)

//扩展函数的写法
//扩展函数定义的内部可以直接调用被扩展类内部定义的方法
fun String.getFirstWord(seperator: String = "_"): String {
    val index = indexOf(seperator)
    return if (index < 0) this else substring(0, index)
}

firstWord = "hello_world".getFirstWord()
println(firstWord)

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


//region 内部函数

//在Kotlin中函数内部可以定义内部函数，局部函数可以访问外部函数的局部变量
class Graph {
    val vertices: List<Vertex> = emptyList()
}

class Vertex {
    val neighbors: List<Vertex> = emptyList()
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


//region 高阶函数

//在Kotlin中，一个函数可以作为另一个函数的参数或者返回值


//endregion


//region scope functions

//https://kotlinlang.org/docs/reference/scope-functions.html
// The Kotlin standard library contains several functions whose sole purpose is to execute a block of code within the context of an object.
// When you call such a function on an object with a lambda expression provided, it forms a temporary scope.
// In this scope, you can access the object without its name. Such functions are called scope functions.
// There are five of them: let, run, with, apply, and also.

// these functions do the same: execute a block of code on an object.
// What's different is how this object becomes available inside the block and what is the result of the whole expression.
apply {  }


//endregion
