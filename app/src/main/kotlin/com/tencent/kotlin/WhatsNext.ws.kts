/**
 * Understand Kotlin Coroutines on Android
 *
 * Jetpack
 *
 * https://www.youtube.com/watch?v=BOHK_w09pVA&t=7s
 */

import kotlin.concurrent.thread


//region Dream Code

val user = fetchUserData()          // NetworkOnMainThreadException
textView.text = user.name

//endregion


//region Dream Code V2

thread {
    val user = fetchUserData()      // CalledFromWrongThreadException
    textView.text = user.name
}

//endregion


//region OK Code

fetchUserData { user ->             // callback, OOM
    textView.text = user.name
}

//endregion


//region The Unmaintainable Code

val subscription = fetchUserData { user ->            // callback
    textView.text = user.name
}

override fun onStop() {
    subscription.cancel()
    subscription1.cancel()
    subscription2.cancel()
    subscription3.cancel()
    subscription4.cancel()
    subscription5.cancel()
}

//endregion


//region the LiveData way

fun fetchUserData(): LiveData<User> {

}

fetchUserData().observe(viewLifeCycleOwner) { user ->
    textView.text = user.name
}


//endregion


//LiveData is an observable value holder for UI

//LiveData with coroutines


//Infamouse roration problem

//Coroutines run "in" a scope

//Scopes can cancel all coroutines

//Scoped get uncaught exceptions

//Use scopes to avoid leaks


