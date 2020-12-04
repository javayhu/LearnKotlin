package com.tencent.kotlin.kotlin

class KotlinNulls {

    fun validateNullableCustomer(customer: CustomerKotlin?) {
        if (customer?.name?.startsWith("A") == true) {
            throw Exception("Names are not allowed to start with A")
        }
    }

    fun validateNonNullCustomer(customer: CustomerKotlin) {
        if (customer.name.startsWith("A")) {
            throw Exception("Names are not allowed to start with A")
        }
    }

}

//在Kotlin中需要明确 类型是否是可空类型，可空类型和非空类型的处理方式不同

//那Java中的代码没有 可空类型 和 非空类型 的区分，怎么做到Java和Kotlin代码的互操作呢？
//答案是注解！(先留下这个问题，待讲完Kotlin的函数和类之后再来解答)
