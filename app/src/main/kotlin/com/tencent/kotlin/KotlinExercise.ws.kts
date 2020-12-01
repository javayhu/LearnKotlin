

val a: Int = 127
val boxedA: Int? = a
val anotherBoxedA: Int? = a

val b: Int = 128
val boxedB: Int? = b
val anotherBoxedB: Int? = b

println(boxedA === anotherBoxedA) // true
println(boxedB === anotherBoxedB) // false
