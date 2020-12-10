import kotlin.reflect.KProperty

//region Kotlin基础6-其他特性


//region Equality Checks (结构相等 还是 引用相等)

//Kotlin uses == for structural comparison and === for referential comparison.

val authors = setOf("Shakespeare", "Hemingway", "Twain")
val writers = setOf("Twain", "Shakespeare", "Hemingway")

println(authors == writers)   // 1 sets ignore element order
println(authors === writers)  // 2 authors and writers are distinct references

//Andrey Breslav
//Collections are compared structurally, while arrays are not.
//for arrays, equals() simply resorts to referential equality: this === other.

val array1 = arrayOf(1, 2, 3, 4, 5)
val array2 = arrayOf(5, 4, 3, 2, 1)

println(array1 == array2)     // false
println(array1 === array2)    // false

//endregion


//region 属性代理(Delegated Properties)

//Kotlin provides a mechanism of delegated properties that allows delegating the calls of the property set and get methods to a certain object.

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


// region IntegerCache

val a: Int = 127
val boxedA: Int? = a
val anotherBoxedA: Int? = a

val b: Int = 128
val boxedB: Int? = b
val anotherBoxedB: Int? = b

println(boxedA === anotherBoxedA) // true
println(boxedB === anotherBoxedB) // false

//endregion


//endregion
