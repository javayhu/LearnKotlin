//region Kotlin基础5-特性


//region Null Safety

//Kotlin的类型系统为了消除NPE特意将非空类型(例如String)和可空类型(例如String?)进行了区分

var a: String = "abc"           // 普通的初始化意味着不为null
//a = null                      // 编译时报错
println(a)

var b: String? = "abc"          // b可以为null
b = null                        // 编译时不报错
b = "abc"
println(b)


val la = a.length
//val lb = b.length             //编译时报错

val vb: String? = "abc"
//在Kotlin中，对于可空类型要想进行调用的话有三种方式 (同Swift)
//1、判空
//val lbInJava = (null != vb) ? vb.length : -1  //Kotlin不支持
val lb = if (vb != null) vb.length else -1   //Kotlin的if表达式
println("lb:$lb")

//2、使用 ?. 操作符
val lb2 = vb?.length              //编译时不报错，如果b是null那么返回为null，如果b不是null那么返回长度
val lb3 = vb?.length ?: -1        //如果我们希望在可空类型为空的时候返回一个非null的结果，可以使用 ?: 操作符
println("lb2:$lb2, lb3:$lb3")

//3、使用 !! 操作符
val lb4 = vb!!.length             //!!操作符强制将可空类型转成非空类型，但是当b是null的时候就会抛出NPE，谨慎使用
println("lb4:$lb4")

//endregion


//NOTICE：Kotlin-Java互操作


//NOTICE：特殊类


//NOTICE：特殊函数


//endregion
