
//region Kotlin基础5-特性

import java.util.*

//data class Result<T>(val collection1:MutableCollection<T>, val collection2:MutableCollection<T>)
//
//fun <T> Collection<T>.partitionTo(collection1:MutableCollection<T>,
//                                  collection2:MutableCollection<T>,
//                                  partitionFunction: (T) -> Boolean):Result<T> {
//    for (item in this) {
//        if (partitionFunction(item)) {
//            collection1.add(item)
//        } else {
//            collection2.add(item)
//        }
//    }
//    return Result(collection1, collection2)
//}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").
    partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').
    partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}

class LazyProperty() {
    val lazyValue: Int by lazy {
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
