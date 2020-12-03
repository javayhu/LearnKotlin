//region Kotlin基础6-其他特性

//region Equality Checks

//Kotlin uses == for structural comparison and === for referential comparison.

val authors = setOf("Shakespeare", "Hemingway", "Twain")
val writers = setOf("Twain", "Shakespeare", "Hemingway")

println(authors == writers)   // 1 sets ignore element order
println(authors === writers)  // 2 authors and writers are distinct references

//Andrey Breslav
//Collections are compared structurally, while arrays are not.
//for arrarys, equals() simply resorts to referential equality: this === other.

val array1 = arrayOf(1, 2, 3, 4, 5)
val array2 = arrayOf(5, 4, 3, 2, 1)

println(array1 == array2)     // false
println(array1 === array2)    // false

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

