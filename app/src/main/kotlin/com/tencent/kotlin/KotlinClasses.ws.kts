
//region Kotlin基础4-类与对象

//region 类的生命方式
//NOTICE：类声明由类名、类头（指定其类型参数、主构造函数等）以及由花括号包围的类体构成
class Animal public constructor(name: String) {
}

//1、如果一个类没有类体，可以省略花括号
//2、如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字

//在 Kotlin 中的一个类可以有一个主构造函数以及一个或多个次构造函数
class Person(val name: String) {
    val children: MutableList<Person> = mutableListOf()

    //如果类有一个主构造函数，每个次构造函数需要委托给主构造函数
    constructor(name: String, parent: Person?) : this(name) {
        parent?.children?.add(this)
    }
}

//endregion

//region 可见性修饰符
//NOTICE：在 Kotlin 中有这四个可见性修饰符：private、 protected、 internal 和 public
//internal指的是模块内可见，如果没有显式指定修饰符的话，默认可见性是 public


//region 类的继承
//NOTICE：Kotlin力求清晰显式，所以允许被继承的类和允许被重写的方法需要使用open修饰(默认是final)
open class Shape {
    open fun draw() {
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

//region 单例模式、对象声明、对象表达式、伴生对象
//NOTICE：在Kotlin中实现单例模式极其简单，将类声明改为对象声明即可，对象声明的初始化过程是线程安全的并且在首次访问时执行
object DatabaseManager {
    init {
        println("DatabaseManager object init")
    }
    fun init() {
        println("DatabaseManager call init ")
    }

    fun destroy() {
        println("DatabaseManager call destroy")
    }
}

DatabaseManager.init()

//NOTICE：当我们需要创建一个继承自某个（或某些）类型的匿名类的对象时可以使用对象表达式
interface OnClickListener {
    fun onClick()
}

class Button {
    var listener: OnClickListener? = null
    fun addOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }
}

val button = Button()
button.addOnClickListener(object : OnClickListener {
    override fun onClick() {
        println("on button clicked")
    }
})

//TODO Kotlin 1.4 新特性

//NOTICE：类内部的对象声明可以用 companion 关键字标记，并且可以给这个伴生对象取名
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}

//通过类的伴生对象来调用
var myClass = MyClass.Factory.create()

//通过类名来调用，这种情况下看起来就像Java中的静态成员，但在运行时它们仍然是真实对象的实例成员
myClass = MyClass.create()

//伴生对象的名称可以省略，这种情况下将使用默认名称 Companion
//myClass = MyClass.Companion.create()

//endregion

//endregion
