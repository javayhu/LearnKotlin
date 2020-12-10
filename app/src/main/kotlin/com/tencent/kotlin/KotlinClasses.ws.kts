/**
 * https://kotlinlang.org/docs/reference/classes.html
 */

//region Kotlin基础4-类与对象

//region 类的声明方式

//在 Kotlin 中，类声明由访问修饰符、类名、类头（指定其类型参数、主构造函数等）以及由花括号包围的类体构成
public class Empty constructor() {               // 1、2、3、4
}

//class Empty

//1、如果一个类没有类体，可以省略花括号
//2、如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字
//3、在 Kotlin 中有这四个可见性修饰符：public、 private、 protected 和 internal
//4、internal指的是模块内可见，如果没有显式指定修饰符的话，默认可见性是 public

//一个类可以有一个 主构造函数 以及一个或多个 次构造函数
class Person(val name: String) {
    val children: MutableList<Person> = mutableListOf()

    //每个次构造函数需要委托给主构造函数
    constructor(name: String, parent: Person?) : this(name) {
        parent?.children?.add(this)
    }
}

//endregion


//region 类的继承

//NOTICE：Kotlin力求清晰显式，所以 允许被继承的类 和 允许被重写的方法 需要使用 open 修饰(默认是final)，重写的方法也一定要有 override 修饰
open class Shape { //父类声明为open
    open fun draw() { //父类方法声明为open
    }
}

class Rectangle : Shape() {
    override fun draw() {
        super.draw()
    }
}

class Triangle : Shape() {
    override fun draw() {
        super.draw()
    }
}

//endregion


//region 单例模式（对象声明）

//NOTICE：切到Singleton类

//1、在Kotlin中实现单例模式极其简单，将类声明改为对象声明即可
//2、对象声明的初始化过程是线程安全的并且在首次访问时执行
//3、object可以理解为 "只有一个实例对象的类"

//endregion


//region 伴生对象

//NOTICE：Java中类可以有静态成员，Kotlin中没有static如何实现类似功能？
class MyClass {

    companion object Factory {               // 2
        fun create(): MyClass = MyClass()
    }

    object MyObject {                        // 1
        fun create(): MyClass = MyClass()
    }
}

//通过 类名 来调用
myClass = MyClass.create()                    // 3
println("myClass $myClass")

//通过 类的伴生对象 来调用
var myClass = MyClass.Factory.create()
println("myClass $myClass")

//通过 类内部的对象 来调用
val myObject = MyClass.MyObject.create()
println("myObject $myObject")

//1、类内部的 对象声明 可以用 companion 关键字标记成为伴生对象，伴生对象可以设置名称，默认是Companion
//2、类内部可以有多个对象声明，但是只能有一个伴生对象("伴侣唯一制")，伴生对象也一定要在class内部声明才行
//3、伴生对象的方法和属性可以直接通过类名来调用，这种情况下看起来就像Java中的静态成员，但在运行时它们仍然是真实对象的实例成员

//endregion


//region 特殊类

//region 特殊类1：data classes

//Kotlin中的数据类(data class)类似Java中的POJO => Customer类对比

data class Result(val code: Int, val message: String)

fun handle() = Result(1, "kotlin")

val (code, message) = handle()   //析构表达式
println("result code:$code, message:$message")

//endregion


//region 特殊类2：sealed classes

//Kotlin中可以将一个类声明为sealed，那么这个类是可以被继承的，而且继承它的子类都在这个sealed类声明的文件里面
//Once you declare a class sealed, it can only be subclassed from inside the same file where the sealed class is declared.

sealed class Response
class Success(val message: String) : Response()
class Failure(val error: Int) : Response()

//FIXME：脚本文件内没法演示sealed classes => KotlinDemo.kt

//endregion

//endregion


//region 对象表达式 (演示过程先跳过)

//NOTICE：当我们需要创建一个继承自某个（或某些）类型的 匿名类的对象 时可以使用 对象表达式 (类似Java中的匿名内部类)
/*fun*/ interface OnClickListener {
    fun onClick()
}

class Button {
    var listener: OnClickListener? = null
    fun addOnClickListener(listener: OnClickListener?) {
        this.listener = listener
    }

    fun triggerClick() {
        listener?.onClick()
    }
}

val button = Button()
button.addOnClickListener(object : OnClickListener {
    override fun onClick() {
        println("on button clicked 1")
    }
})
button.triggerClick()

//NOTICE：Kotlin 1.4 新特性 SAM conversions for Kotlin interfaces
//https://kotlinlang.org/docs/reference/whatsnew14.html#sam-conversions-for-kotlin-interfaces
//Type mismatch: inferred type is () -> Unit but KotlinClasses_ws.OnClickListener? was expected
/*button.addOnClickListener {
    println("on button clicked 2")
}
button.triggerClick()*/


//NOTICE：对象表达式还可以用于直接创建一个匿名类
//FIXME：脚本文件内没法演示sealed classes => KotlinDemo.kt

val anObject = object {
    val value = 1
    val otherValue = 2
    val someOtherValue = 3
}
println("object values:${anObject.value}, ${anObject.otherValue}, ${anObject.someOtherValue}")

//endregion


//endregion
