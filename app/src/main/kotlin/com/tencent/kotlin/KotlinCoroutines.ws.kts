import kotlin.concurrent.thread

/**
 * Kotlin Coroutines
 *
 * https://www.youtube.com/watch?v=BOHK_w09pVA&t=7s
 */

//region Kotlin基础-协程


//Coroutines simplify async code by replacing callbacks

data class User(val id:Int, val name:String)

fun fetchUserData():User {
    thread {
        //
    }
}


//region Dream Code

val user = fetchUserData()
textView.text = user.name


//endregion


//endregion


