//region Kotlin基础5-特性


//region Null Safety

//Kotlin的类型系统为了消除NPE将非空类型(例如String)和可空类型(例如String?)进行了区分

var a: String = "abc"           // 普通的初始化意味着不为null
//a = null                      // 编译时报错

var b: String? = "abc"          // b可以为null
b = null                        // 编译时不报错
println(b)

val la = a.length
//val lb = b.length             //编译时报错

//在Kotlin中，对于可空类型要想进行调用的话有三种方式
//1、判空
val lb = if (b != null) b.length else -1
println("lb:$lb")

//2、使用 ?. 操作符
val lb2 = b?.length              //编译时不报错，如果b是null那么返回为null，如果b不是null那么返回长度
val lb3 = b?.length ?: -1        //如果我们希望在可空类型为空的时候返回一个非null的结果，可以使用 ?: 操作符
println("lb2:$lb2, lb3:$lb3")

//3、使用 !! 操作符
val lb4 = b!!.length             //!!操作符强制将可空类型转成非空类型，但是当b是null的时候就会抛出NPE，谨慎使用
println("lb4:$lb4")

//endregion


//region Delegated Properties

//Kotlin provides a mechanism of delegated properties that allows delegating the calls of the property set and get methods to a certain object.

import kotlin.reflect.KProperty

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

class Example {

    var str: String by Delegate() //将str的get/set调用委托给Delegate()对象去实现，关键词by

    override fun toString() = "Example Class"
}

//Kotlin标准库中内置了一些delegates，最常用的就是lazy，用于实现懒初始化

class LazyProperty() {
    val lazyValue: Int by lazy { //这里lazy其实就是一个 top-level high order function
        println("call lazy function")
        initializer()
    }

    fun initializer(): Int {
        return 3
    }
}

val lazyProperty = LazyProperty()
println(lazyProperty.lazyValue)
println(lazyProperty.lazyValue)

//endregion


//endregion
